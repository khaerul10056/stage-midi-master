package org.mda.commons.ui.imagecache;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.mda.Utils;


public class ImageCache {

  private static final Logger LOGGER  = Logger.getLogger(ImageCache.class.getName());

  private static List<ImageCacheEntry> entries = new ArrayList<ImageCacheEntry>();

  private static int hit = 0;
  private static int failed = 0;

  public Image getImage (final File file, final Point size) {
    for (ImageCacheEntry entry: entries) {
      if (entry.isSame(file, size)) {
        hit ++;
        LOGGER.info("Get Image " + file.getAbsolutePath() + "," + size +  " from cache (hit: " + hit + ", failed: " + failed + ")");
        return entry.getImage();
      }
    }

    Image loadImageFromProject = Utils.loadImageFromProject(file);
    ImageData scaledTo = loadImageFromProject.getImageData().scaledTo(size.x, size.y);
    ImageCacheEntry newEntry = new ImageCacheEntry(file, size, new Image(Display.getCurrent(), scaledTo));
    entries.add(newEntry);
    return newEntry.getImage();
  }

  public void clear () {
    for (ImageCacheEntry next: entries)
      next.getImage().dispose();

    entries.clear();
    hit = 0;
    failed = 0;
  }

}
