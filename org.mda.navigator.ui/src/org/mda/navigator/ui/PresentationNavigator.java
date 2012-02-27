package org.mda.navigator.ui;

import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.ui.part.ViewPart;
import org.mda.ApplicationSession;
import org.mda.commons.ui.ContentProvider;
import org.mda.commons.ui.LabelProvider;


public class PresentationNavigator extends ViewPart{

  private ApplicationSession  appSession = ApplicationSession.getInjector().getInstance(ApplicationSession.class);
  private List treModel;
  private ListViewer treviewer;

  private void layoutButton (final Button button) {
    GridData data = new GridData();
    button.setLayoutData(data);
    data.grabExcessHorizontalSpace = true;
    data.heightHint = 50;
  }

  private void createButtons (final Composite arg) {
    Composite comp = new Composite(arg, SWT.NONE);
    comp.setLayout(new GridLayout(2, true));

    Button btnHome = new Button(comp, SWT.PUSH);
    layoutButton(btnHome);
    btnHome.setText("Home");
    layoutButton(btnHome);

    Button btnEnd = new Button(comp, SWT.PUSH);
    btnEnd.setText("End");
    layoutButton(btnEnd);

    Button btnPrevSong = new Button(comp, SWT.PUSH);
    btnPrevSong.setText("Prev song");
    layoutButton(btnPrevSong);

    Button btnNextSong = new Button(comp, SWT.PUSH);
    btnNextSong.setText("Next song");
    layoutButton(btnNextSong);

    Button btnPrev = new Button(comp, SWT.PUSH);
    btnPrev.setText("Prev slide");
    layoutButton(btnPrev);

    Button btnNext = new Button(comp, SWT.PUSH);
    btnNext.setText("Next slide");
    layoutButton(btnNext);

    Button btnBlack = new Button(comp, SWT.PUSH);
    btnBlack.setText("Black slide");
    layoutButton(btnBlack);

    Button btnWhite = new Button(comp, SWT.PUSH);
    btnWhite.setText("White slide");
    layoutButton(btnWhite);

    Button btnBackground = new Button(comp, SWT.PUSH);
    btnBackground.setText("Slide with background");
    layoutButton(btnBackground);

    Button btnDefaultSite = new Button(comp, SWT.PUSH);
    btnDefaultSite.setText("Default slide");
    layoutButton(btnDefaultSite);

  }

  @Override
  public void createPartControl (Composite arg0) {
    arg0.setLayout(new GridLayout(1, false));

    createButtons(arg0);

    treModel = new List(arg0, SWT.NONE);
    treModel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
    treviewer = new ListViewer(treModel);
    ContentProvider contentprovider = new ContentProvider();
    treviewer.setContentProvider(contentprovider);
    treviewer.setLabelProvider(new LabelProvider());
    treviewer.setInput(appSession.getCurrentSession());

  }

  @Override
  public void setFocus () {
    // TODO Auto-generated method stub

  }

}
