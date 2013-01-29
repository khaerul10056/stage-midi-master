package org.mda.export;

import javax.inject.Inject;

import org.mda.presenter.SongSlideCalculator;



public abstract class AbstractExporter implements IExport {

  @Inject
  SongSlideCalculator calculator;
  
  protected SongSlideCalculator getCalculator () {
    return calculator;
  }

  

}
