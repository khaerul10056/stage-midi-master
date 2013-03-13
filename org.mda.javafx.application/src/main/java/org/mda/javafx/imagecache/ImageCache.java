package org.mda.javafx.imagecache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javafx.scene.image.Image;

import org.mda.measurement.SizeInfo;


public class ImageCache {

  private static final Logger LOGGER  = Logger.getLogger(ImageCache.class.getName());

  private static List<ImageCacheEntry> entries = new ArrayList<ImageCacheEntry>();

  private static int hit = 0;
  private static int failed = 0;

  public Image getImage (final File file, final SizeInfo size) {
    for (ImageCacheEntry entry: entries) {
      if (entry.isSame(file, size)) {
        hit ++;
        LOGGER.info("Get Image " + file.getAbsolutePath() + "," + size +  " from cache (hit: " + hit + ", failed: " + failed + ")");
        return entry.getImage();
      }
    }
    
    Image loadImageFromProject;
	try {
		loadImageFromProject = new Image (new FileInputStream(file));
	} catch (FileNotFoundException e) {
		throw new IllegalStateException(e);
	}

    ImageCacheEntry newEntry = new ImageCacheEntry(file, size, loadImageFromProject);
    entries.add(newEntry);
    return newEntry.getImage();
  }

  public void clear () {
    for (ImageCacheEntry next: entries)
      next.getImage().cancel();

    entries.clear();
    hit = 0;
    failed = 0;
  }

}
