package org.mda.export.word;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import mda.AbstractSessionItem;

import org.apache.poi.hpsf.MutableProperty;
import org.apache.poi.hpsf.MutablePropertySet;
import org.apache.poi.hpsf.MutableSection;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hpsf.Variant;
import org.apache.poi.hpsf.WritingNotSupportedException;
import org.apache.poi.hpsf.wellknown.PropertyIDMap;
import org.apache.poi.hpsf.wellknown.SectionIDMap;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.mda.export.ExportException;
import org.mda.export.IExport;
import org.mda.presenter.config.IPresenterConfig;


public class WordExporter implements IExport {


  @Override
public File export (final Collection<AbstractSessionItem> items, final File exportFile, final IPresenterConfig exportConf) throws ExportException {

//    POIFSFileSystem fs = new POIFSFileSystem();
//    HWPFDocument document = new HWPFDocument(fs);
//
//    document.getRange().insertAfter("Hallo");
//    if (! exportFile.getAbsoluteFile().getParentFile().exists())
//      exportFile.getParentFile().mkdirs();

    /* Create a mutable property set. Initially it contains a single section
     * with no properties. */
    final MutablePropertySet mps = new MutablePropertySet();

    /* Retrieve the section the property set already contains. */
    final MutableSection ms = (MutableSection) mps.getSections().get(0);

    /* Turn the property set into a summary information property. This is
     * done by setting the format ID of its first section to
     * SectionIDMap.SUMMARY_INFORMATION_ID. */
    ms.setFormatID(SectionIDMap.SUMMARY_INFORMATION_ID);

    /* Create an empty property. */
    final MutableProperty p = new MutableProperty();

    /* Fill the property with appropriate settings so that it specifies the
     * document's title. */
    p.setID(PropertyIDMap.PID_TITLE);
    p.setType(Variant.VT_LPWSTR);
    p.setValue("Sample title");

    /* Place the property into the section. */
    ms.setProperty(p);

    /* Create the POI file system the property set is to be written to. */
    final POIFSFileSystem poiFs = new POIFSFileSystem();

    /* For writing the property set into a POI file system it has to be
     * handed over to the POIFS.createDocument() method as an input stream
     * which produces the bytes making out the property set stream. */
    try {
    final InputStream is = mps.toInputStream();

    /* Create the summary information property set in the POI file
     * system. It is given the default name most (if not all) summary
     * information property sets have. */
    poiFs.createDocument(is, SummaryInformation.DEFAULT_STREAM_NAME);

    /* Write the whole POI file system to a disk file. */
    poiFs.writeFilesystem(new FileOutputStream(exportFile));

    } catch (IOException e) {
      throw new ExportException("Error saving exportfile " + exportFile.getAbsolutePath(), e);
    } catch (WritingNotSupportedException e) {
      throw new ExportException("Error saving exportfile " + exportFile.getAbsolutePath(), e);
    }

    return exportFile;
  }

  @Override
  public String getSuffix () {
    return ".doc";
  }

}
