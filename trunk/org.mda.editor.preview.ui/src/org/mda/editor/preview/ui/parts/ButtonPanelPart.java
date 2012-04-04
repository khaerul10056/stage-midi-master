package org.mda.editor.preview.ui.parts;

import static org.mda.Utils.ICON_ADD_PART;
import static org.mda.Utils.ICON_MERGE_PART;
import static org.mda.Utils.ICON_MOVE_PART_DOWN;
import static org.mda.Utils.ICON_MOVE_PART_UP;
import static org.mda.Utils.ICON_PROPERTIES;
import static org.mda.Utils.ICON_REMOVE_PART;
import static org.mda.Utils.ICON_SPLIT_PART;
import static org.mda.Utils.loadImageFromProject;
import mda.MidiFilePart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.mda.MidiPlayerService;
import org.mda.editor.preview.ui.AbstractPart;
import org.mda.editor.preview.ui.PreviewEditorContent;
import org.mda.editor.preview.ui.details.MidiFileDetailsShell;
import org.mda.editor.preview.ui.newpart.NewPartShell;


public class ButtonPanelPart extends AbstractPart implements SelectionListener {

  private PreviewEditorContent previewEditor;

  private Button btnSplit;

  private Button btnMerge;

  private Button btnEditTheme;
  private Button btnNewPart;
  private Button btnRemovePart;

  private Button btnUp;

  private Button btnDown;


  public ButtonPanelPart (PreviewEditorContent parent) {
    super(parent);
    this.previewEditor = parent;

    setLayout(new RowLayout(SWT.HORIZONTAL));

    btnNewPart = addButton("Add", SWT.NONE, "Add a new part after selected part");
    btnNewPart.setImage(loadImageFromProject(ICON_ADD_PART));

    btnRemovePart = addButton("Remove", SWT.NONE, "Removes the selected part");
    btnRemovePart.setImage(loadImageFromProject(ICON_REMOVE_PART));
    btnEditTheme = addButton("Details...", SWT.NONE, "Edit properties like fontcolor or background");
    btnEditTheme.setImage(loadImageFromProject(ICON_PROPERTIES));
    btnSplit = addButton("Split", SWT.NONE, "Splits this part at current line");
    btnSplit.setImage(loadImageFromProject(ICON_SPLIT_PART));

    btnMerge = addButton("Merge", SWT.NONE, "Merges this part with previous part");
    btnMerge.setImage(loadImageFromProject(ICON_MERGE_PART));

    btnUp = addButton("Up", SWT.NONE, "Moves a part up");
    btnUp.setImage(loadImageFromProject(ICON_MOVE_PART_UP));

    btnDown = addButton("Down", SWT.NONE, "Moves a part down");
    btnDown.setImage(loadImageFromProject(ICON_MOVE_PART_DOWN));
  }

  public Button addButton (final String text, int style, final String tooltip) {
    Button button = new Button (this, style);
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
      NewPartShell shell = new NewPartShell(getShell(), getMidifile(), getEditorContent().getSlidelistpanel().getCurrentPart());
      shell.addDisposeListener(new DisposeListener() {

        @Override
        public void widgetDisposed (DisposeEvent arg0) {
         getEditorContent().redrawSlidelist();
        }
      });
    }

    if (arg0.widget.equals(btnRemovePart)) {
      MidiFilePart nextPart = MidiPlayerService.removePart(getMidifile(), getEditorContent().getSlidelistpanel().getCurrentPart());
      getEditorContent().setCurrentPart(nextPart);
      getEditorContent().redrawSlidelist();
    }
    if (arg0.widget.equals(btnEditTheme)) {
      MidiFileDetailsShell details = new MidiFileDetailsShell(getShell(), getMidifile());
      details.addDisposeListener(new DisposeListener() {

        @Override
        public void widgetDisposed (DisposeEvent arg0) {
          if (getCurrentPart() != null)
            getEditorContent().getPreviewpanel().setCurrentPart(getCurrentPart());

        }
      });

    }
    if (arg0.widget.equals(btnMerge))
      previewEditor.getContentpanel().mergeWithPreviousPart();

    if (arg0.widget.equals(btnSplit))
      previewEditor.getContentpanel().splitPart();

    if (arg0.widget.equals(btnUp)) {
      MidiFilePart nextPart = MidiPlayerService.movePartUp(getMidifile(), getEditorContent().getSlidelistpanel().getCurrentPart());
      getEditorContent().setCurrentPart(nextPart);
      getEditorContent().redrawSlidelist();
    }

    if (arg0.widget.equals(btnDown)) {
      MidiFilePart nextPart = MidiPlayerService.movePartDown(getMidifile(), getEditorContent().getSlidelistpanel().getCurrentPart());
      getEditorContent().setCurrentPart(nextPart);
      getEditorContent().redrawSlidelist();
    }


  }
}
