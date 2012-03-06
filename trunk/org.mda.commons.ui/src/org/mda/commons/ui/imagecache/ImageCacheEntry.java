package org.mda.commons.ui.imagecache;

import java.io.File;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;


public class ImageCacheEntry {

  private final File file;

  private final Point size;

  private final Image image;

  public ImageCacheEntry (final File file, final Point size, final Image image) {
    this.file = file;
    this.size = size;
    this.image = image;
  }

  public Image getImage () {
    return image;
  }

  public Point getSize () {
    return size;
  }

  public File getFile () {
    return file;
  }

  public boolean isSame (final File file, final Point size) {
    return file.equals(this.file) && size.equals(this.size);
  }

}
