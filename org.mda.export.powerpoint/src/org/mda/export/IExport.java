package org.mda.export;

import java.io.File;
import java.util.Collection;
import mda.AbstractSessionItem;
import mda.ExportConfiguration;


public interface IExport {

   /**
    * exports a collection of items in a specific format, saves the results in the parameterized exportfile
    *
    * @param items
    * @param exportFile
    * @param config
    * @return exportfile or <code>null</code> if an error occured
    * @throws Exception
    */
   File export (final Collection<AbstractSessionItem> items, final File exportFile, final ExportConfiguration config) throws ExportException;

   /**
    * gets the suffix for this export
    * @return
    */
   String getSuffix ();
}
