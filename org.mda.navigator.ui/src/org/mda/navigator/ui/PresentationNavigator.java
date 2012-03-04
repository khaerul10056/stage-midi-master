package org.mda.navigator.ui;

import mda.AbstractSessionItem;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.ui.part.ViewPart;
import org.mda.commons.ui.ContentProvider;
import org.mda.commons.ui.LabelProvider;
import org.mda.commons.ui.Util;
import org.mda.commons.ui.navigator.NavigatorItem;
import org.mda.presenter.ui.DefaultPresentationController;
import org.mda.presenter.ui.MdaPresenterModule;
import org.mda.presenter.ui.PresentationContext;
import org.mda.presenter.ui.SpecialSlide;


public class PresentationNavigator extends ViewPart{

  private PresentationContext  presentationContext = MdaPresenterModule.getInjector().getInstance(PresentationContext.class);
  private List treModel;
  private ListViewer treviewer;

  private final DefaultPresentationController controller = new DefaultPresentationController();

  private void layoutButton (final Button button) {
    GridData data = new GridData();
    button.setLayoutData(data);
    data.grabExcessHorizontalSpace = true;
    data.heightHint = 50;
  }

  private void createButtons (final Composite arg) {
    Composite comp = new Composite(arg, SWT.NONE);
    comp.setLayout(new GridLayout(2, true));

    Button btnPrevSong = new Button(comp, SWT.PUSH);
    btnPrevSong.setText("Prev song");
    layoutButton(btnPrevSong);
    btnPrevSong.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
        getController().previousSong();
      }
    });

    Button btnNextSong = new Button(comp, SWT.PUSH);
    btnNextSong.setText("Next song");
    layoutButton(btnNextSong);
    btnNextSong.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
        getController().nextSong ();
      }
    });

    Button btnPrev = new Button(comp, SWT.PUSH);
    btnPrev.setText("Prev slide");
    layoutButton(btnPrev);
    btnPrev.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
        getController().previousSlide();
      }
    });

    Button btnNext = new Button(comp, SWT.PUSH);
    btnNext.setText("Next slide");
    layoutButton(btnNext);
    btnNext.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
        getController().nextSlide();
      }
    });

    final Button btnBlack = new Button(comp, SWT.TOGGLE);
    btnBlack.setText("Black slide");
    layoutButton(btnBlack);
    btnBlack.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
        getController().toggleBlack (btnBlack.getSelection());
      }
    });

    final Button btnWhite = new Button(comp, SWT.TOGGLE);
    btnWhite.setText("White slide");
    layoutButton(btnWhite);
    btnWhite.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
        getController().toggleWhite(btnWhite.getSelection());
      }
    });

    final Button btnBackground = new Button(comp, SWT.TOGGLE);
    btnBackground.setText("Slide with background");
    layoutButton(btnBackground);
    btnBackground.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
        getController().toggleOnlyBackground(btnBackground.getSelection());
      }
    });

    Button btnDefaultSite = new Button(comp, SWT.PUSH);
    btnDefaultSite.setText("Default slide");
    btnDefaultSite.setEnabled(false);
    layoutButton(btnDefaultSite);

  }

  @Override
  public void createPartControl (Composite arg0) {
    arg0.setLayout(new GridLayout(1, false));
    presentationContext.registerController(getController());

    createButtons(arg0);

    treModel = new List(arg0, SWT.NONE);
    treModel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
    treviewer = new ListViewer(treModel);
    ContentProvider contentprovider = new ContentProvider();
    treviewer.setContentProvider(contentprovider);
    treviewer.setLabelProvider(new LabelProvider());
    treviewer.setInput(presentationContext.getCurrentSession());
    treviewer.addSelectionChangedListener(new ISelectionChangedListener() {

      @Override
      public void selectionChanged (SelectionChangedEvent arg0) {
        NavigatorItem <AbstractSessionItem> item = (NavigatorItem<AbstractSessionItem>) Util.getStructuredSelection(treviewer.getSelection());
        if (item != null) {
          AbstractSessionItem selectSessionItem = item.getModelElement();
          controller.toItem(selectSessionItem);
        }
      }
    });
  }

  private DefaultPresentationController getController () {
    return controller;
  }

  @Override
  public void setFocus () {
    // TODO Auto-generated method stub

  }

}
