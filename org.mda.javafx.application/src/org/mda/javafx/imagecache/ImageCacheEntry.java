package org.mda.javafx.imagecache;

import java.io.File;

import org.mda.measurement.SizeInfo;

import javafx.scene.image.Image;


public class ImageCacheEntry {

  private final File file;

  private final SizeInfo size;

  private final Image image;

  public ImageCacheEntry (final File file, final SizeInfo size, final Image image) {
    this.file = file;
    this.size = size;
    this.image = image;
  }

  public Image getImage () {
    return image;
  }

  public SizeInfo getSize () {
    return size;
  }

  public File getFile () {
    return file;
  }

  public boolean isSame (final File file, final SizeInfo size) {
    return file.equals(this.file) && size.equals(this.size);
  }

}
