package org.mda.struct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mda.Song;
import mda.SongPart;
import mda.SongPartType;

/**
 * This class describes the structure of a midilfile,
 * e.g. how many parts of a special type exist...
 * @author oleym
 *
 */
public class SongStruct {

  private List <SongStructItem> items = new ArrayList<SongStructItem>();

  public SongStruct (final Song file) {
    readStruct(file);
  }

  public SongStructItem getItem (final SongPart part) {
    for (SongStructItem nextItem: getItems()) {
      if (nextItem.getPart().equals(part))
        return nextItem;
    }

    return null;
  }

  /**
   * checks the last items with the same type
   * and gets the first that is shown
   * If no shown item with the given type is found directly above, than <code>null</code> is returned
   * If no suitable item is found, than <code>null</code> is returned either
   * @param type type to find
   * @return item or <code>null</code>
   */
  private SongStructItem getLastShownItem (SongPart contentPart) {
    SongStructItem markedItem = null;
    for (int i = getItems().size() - 1; i >= 0; i--) {
      SongStructItem prevItem = getItems().get(i);
      SongPart contentPartCompare = prevItem.getPart().getRefPart() != null ? prevItem.getPart().getRefPart() : prevItem.getPart();
      if (!contentPartCompare.equals(contentPart))
        return markedItem;
      else
        markedItem = prevItem;
    }
    return null;
  }

  /**
   * reads the structure of a song to give additionals infos to show
   * @param file file
   * @return structitems
   */
  private void readStruct (final Song file) {
    HashMap<SongPartType, Integer> partcountsCreated = new HashMap<SongPartType, Integer>();
    for (SongPart nextPart: file.getParts()) {

      SongPart contentPart = nextPart.getRefPart() != null ? nextPart.getRefPart() : nextPart;
      SongStructItem item = getItem(contentPart);

      if (item == null) { //if current part was not analyzed, then the current part is a new one, so increment the counter
        Integer integer = partcountsCreated.get(nextPart.getParttype());
        if (integer == null)
          integer = new Integer(1);
        else
          integer = new Integer(integer.intValue() + 1);
        partcountsCreated.put(nextPart.getParttype(), integer);
      }

      SongStructItem newItem = new SongStructItem();
      newItem.setPart(nextPart); //the part itself, references are not resolved
      newItem.setType(nextPart.getParttype());
      newItem.setIndex(item != null ? item.getIndex() : partcountsCreated.get(nextPart.getParttype())); //REFRAIN2...
      newItem.setContentShown(nextPart.getRefPart() == null);

      //.... REFRAIN 3x
      SongStructItem lastShownItem = getLastShownItem(contentPart);
      if (lastShownItem != null) {
        newItem.setContentShown(false);
        newItem.setVisible(false);
        lastShownItem.increaseCumulation ();
      }

      getItems().add(newItem);
    }

    for (SongStructItem nextItem: getItems()) {
      Integer count = partcountsCreated.get(nextItem.getType());
      if (count == 1)
        nextItem.setIndex(null);
    }
  }

  public List <SongStructItem> getItems () {
    return items;
  }





}
