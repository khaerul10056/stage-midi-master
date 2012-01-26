package org.mda.commons.ui.navigator;

import org.eclipse.emf.common.util.EList;


public class NavigatorItem<T> {

  private final T modelElement;

  private final EList <T> holder;

  public NavigatorItem (final T modelElement, final EList <T> holder) {
    this.modelElement = modelElement;
    this.holder = holder;
  }

  public T getModelElement () {
    return modelElement;
  }

  public EList <T> getHolder () {
    return holder;
  }

  public void remove () {
    holder.remove(modelElement);
  }

  public void moveUp () {
    int index = holder.indexOf(modelElement);
    if (index > 0) {
      holder.remove(index);
      holder.add(index - 1, modelElement);
    }
  }

  public void moveDown () {
    int index = holder.indexOf(modelElement);
    if (index < holder.size() - 1) {
      holder.remove(index);
      holder.add(index + 1, modelElement);
    }

  }

  @Override
  public boolean equals (Object obj) {
    if (obj instanceof NavigatorItem) {
      NavigatorItem<T> equalsNav = (NavigatorItem<T>) obj;
      return modelElement.equals(equalsNav.getModelElement()) && holder.equals(equalsNav.getHolder());
    }
    return false;
  }









}