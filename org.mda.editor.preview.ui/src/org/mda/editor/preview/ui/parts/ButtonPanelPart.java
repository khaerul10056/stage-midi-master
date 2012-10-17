package org.mda.editor.preview.ui.parts;

import static org.mda.Utils.ICON_ADD_PART;
import static org.mda.Utils.ICON_CLONE_PART;
import static org.mda.Utils.ICON_MERGE_PART;
import static org.mda.Utils.ICON_MOVE_PART_DOWN;
import static org.mda.Utils.ICON_MOVE_PART_UP;
import static org.mda.Utils.ICON_PARTPROPERTIES;
import static org.mda.Utils.ICON_PROPERTIES;
import static org.mda.Utils.ICON_REMOVE_PART;
import static org.mda.Utils.ICON_SPLIT_PART;
import static org.mda.Utils.ICON_TRANSPOSE;
import static org.mda.Utils.loadImageFromProject;

import javax.inject.Inject;

import mda.MidiFilePart;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.mda.MidiPlayerService;
import org.mda.commons.ui.transpose.TransposeShell;
import org.mda.editor.preview.ui.AbstractPart;
import org.mda.editor.preview.ui.PreviewEditorComposite;
import org.mda.editor.preview.ui.details.MidiFileDetailsShell;
import org.mda.editor.preview.ui.details.MidiPartDetailsShell;
import org.mda.editor.preview.ui.newpart.NewPartShell;

@Creatable
public class ButtonPanelPart extends AbstractPart implements SelectionListener {

  private Button btnSplit;

  private Button btnMerge;

  private Button btnSongDetails;
  private Button btnTranspose;
  private Button btnNewPart;

  private Button btnClonePart;
  private Button btnRemovePart;

  private Button btnUp;

  private Button btnDown;

  private Button btnPartDetails;

  private Button btnNewSlideToggle;
  
  @Inject
  private MidiFileDetailsShell detailsshell;
  
  @Inject
  private MidiPartDetailsShell partdetailsshell;


  public Composite build  (PreviewEditorComposite parent) {
	this.comp = new Composite(parent.getComp(), SWT.NONE);
	setEditorComposite(parent);

    comp.setLayout(new RowLayout(SWT.HORIZONTAL));

    btnSongDetails = addButton("Song-Details...", SWT.NONE, "Edit properties of the complete song");
    btnSongDetails.setImage(loadImageFromProject(ICON_PROPERTIES));

    btnTranspose = addButton("Transpose...", SWT.NONE, "Transpose song to another key");
    btnTranspose.setImage(loadImageFromProject(ICON_TRANSPOSE));

    Label lblFiller = new Label (comp, SWT.NONE);
    lblFiller.setText("     ");

    btnNewPart = addButton("Add", SWT.NONE, "Add a new part after selected part");
    btnNewPart.setImage(loadImageFromProject(ICON_ADD_PART));

    btnClonePart = addButton("Clone", SWT.NONE, "Clone selected part");
    btnClonePart.setImage(loadImageFromProject(ICON_CLONE_PART));

    btnRemovePart = addButton("Remove", SWT.NONE, "Removes the selected part");
    btnRemovePart.setImage(loadImageFromProject(ICON_REMOVE_PART));

    btnSplit = addButton("Split", SWT.NONE, "Splits this part at current line");
    btnSplit.setImage(loadImageFromProject(ICON_SPLIT_PART));

    btnMerge = addButton("Merge", SWT.NONE, "Merges this part with previous part");
    btnMerge.setImage(loadImageFromProject(ICON_MERGE_PART));

    btnUp = addButton("Up", SWT.NONE, "Moves a part up");
    btnUp.setImage(loadImageFromProject(ICON_MOVE_PART_UP));

    btnDown = addButton("Down", SWT.NONE, "Moves a part down");
    btnDown.setImage(loadImageFromProject(ICON_MOVE_PART_DOWN));

    btnPartDetails = addButton("Part-Properties...", SWT.NONE, "Edit properties of the current part");
    btnPartDetails.setImage(loadImageFromProject(ICON_PARTPROPERTIES));


    btnNewSlideToggle = addButton("New slide", SWT.NONE, "If you want to split a part in seperate slides, add a <NewSlide-Marker>");
    btnNewSlideToggle.setImage(loadImageFromProject(ICON_PARTPROPERTIES));
    
    return comp;


  }

  public Button addButton (final String text, int style, final String tooltip) {
    Button button = new Button (comp, style);
    button.setText(text);
    if (tooltip != null)
      button.setToolTipText(tooltip);
    button.addSelectionListener(this);
    return button;
  }

  @Override
  public void widgetDefaultSelected (SelectionEvent arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void widgetSelected (SelectionEvent arg0) {
    if (arg0.widget.equals(btnNewPart)) {
      NewPartShell shell = new NewPartShell(comp.getShell(), getMidifile(), getEditorComposite().getSlidelistpanel().getCurrentPart());
      shell.addDisposeListener(new DisposeListener() {

        @Override
        public void widgetDisposed (DisposeEvent arg0) {
         getEditorComposite().redrawSlidelist();
        }
      });
    }

    if (arg0.widget.equals(btnNewSlideToggle)) {
      MidiFilePart currentPart = getEditorComposite().getSlidelistpanel().getCurrentPart();
      int focusedLine = getEditorComposite().getContentpanel().getCurrentFocusedLine();
      boolean isSet = currentPart.getTextlines().get(focusedLine).isNewSlide();
      currentPart.getTextlines().get(focusedLine).setNewSlide(!isSet);
      getEditorComposite().setCurrentPart(currentPart);
    }

    if (arg0.widget.equals(btnClonePart)) {
      MidiPlayerService.clonePart(getMidifile(), getEditorComposite().getSlidelistpanel().getCurrentPart());
      getEditorComposite().redrawSlidelist();
    }

    if (arg0.widget.equals(btnTranspose)) {
      TransposeShell transposeShell = new TransposeShell(comp.getShell(), getMidifile());
      transposeShell.addDisposeListener(new DisposeListener() {
        @Override
        public void widgetDisposed (DisposeEvent arg0) {
         getEditorComposite().redrawSlidelist();
        }
      });
    }

    if (arg0.widget.equals(btnRemovePart)) {
      MidiFilePart nextPart = MidiPlayerService.removePart(getMidifile(), getEditorComposite().getSlidelistpanel().getCurrentPart());
      getEditorComposite().setCurrentPart(nextPart);
      getEditorComposite().redrawSlidelist();
    }
    if (arg0.widget.equals(btnSongDetails)) {
      detailsshell.build(comp.getShell(), getMidifile());
      detailsshell.getShell().addDisposeListener(new DisposeListener() {

        @Override
        public void widgetDisposed (DisposeEvent arg0) {
          //if (getCurrentPart() != null)
            //getEditorComposite().getPreviewpanel().setCurrentPart(getCurrentPart());

        }
      });

    }

    if (arg0.widget.equals(btnPartDetails)) {
      partdetailsshell.build(comp.getShell(), getCurrentPart());
      partdetailsshell.getShell().addDisposeListener(new DisposeListener() {

        @Override
        public void widgetDisposed (DisposeEvent arg0) {
          getEditorComposite().setCurrentPart(getCurrentPart());
          getEditorComposite().redrawSlidelist();

        }
      });

    }
    if (arg0.widget.equals(btnMerge))
      getEditorComposite().getContentpanel().mergeWithPreviousPart();

    if (arg0.widget.equals(btnSplit))
    	getEditorComposite().getContentpanel().splitPart();

    if (arg0.widget.equals(btnUp)) {
      MidiFilePart nextPart = MidiPlayerService.movePartUp(getMidifile(), getEditorComposite().getSlidelistpanel().getCurrentPart());
      getEditorComposite().setCurrentPart(nextPart);
      getEditorComposite().redrawSlidelist();
    }

    if (arg0.widget.equals(btnDown)) {
      MidiFilePart nextPart = MidiPlayerService.movePartDown(getMidifile(), getEditorComposite().getSlidelistpanel().getCurrentPart());
      getEditorComposite().setCurrentPart(nextPart);
      getEditorComposite().redrawSlidelist();
    }


  }
}
