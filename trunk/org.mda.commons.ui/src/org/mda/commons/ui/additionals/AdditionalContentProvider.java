package org.mda.commons.ui.additionals;



import mda.AdditionalType;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.mda.additionals.AdditionalsHandler;


public class AdditionalContentProvider implements IStructuredContentProvider {

  private AdditionalType currentType;



  @Override
  public void dispose () {
  }

  @Override
  public void inputChanged (Viewer viewer, Object oldInput, Object newInput) {
    // TODO Auto-generated method stub

  }

  @Override
  public Object[] getElements (Object parentElement) {

    if (parentElement instanceof AdditionalsHandler) {
      AdditionalsHandler handler = (AdditionalsHandler) parentElement;
      return handler.getAdditionals(getCurrentType()).toArray();
    }

    return null;

  }

  public AdditionalType getCurrentType () {
    return currentType;
  }

  public void setCurrentType (AdditionalType currentType) {
    this.currentType = currentType;
  }


}

