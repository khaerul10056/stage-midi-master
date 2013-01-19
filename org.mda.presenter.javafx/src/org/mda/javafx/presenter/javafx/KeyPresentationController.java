package org.mda.javafx.presenter.javafx;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import org.mda.presenter.controller.DefaultPresentationController;

public class KeyPresentationController extends DefaultPresentationController implements EventHandler<KeyEvent> {
	
	private static final Log LOGGER  = LogFactory.getLogger(KeyPresentationController.class);

	@Override
	public void handle(KeyEvent e) {
		LOGGER.info("GlobalKeyRegistryPresentationController recieved key " + e.getText()); // TODO + Util.logEvent(e));
		
		
    	
//    	if (e.character == '1') {  TODO
//    		LOGGER.info("Footcontroller pressed");
//			midiplayer.togglePause();
//		}
    	
        
        if (e.getCode().equals(KeyCode.F4) && e.isAltDown())
      	  end();

        if (e.getCode().equals(KeyCode.RIGHT) && ! e.isShiftDown()) {
          //midiplayer.savePartIntersection(); TODO
          nextSlide();
        }

        if (e.getCode().equals(KeyCode.LEFT) && ! e.isShiftDown())
          previousSlide();

        if (e.getCode().equals(KeyCode.LEFT) && e.isShiftDown())
          previousSong();

        if (e.getCode().equals(KeyCode.RIGHT) && e.isShiftDown())
          nextSong();

        if (e.getCharacter().equals("w")) {
          toggleWhite();
        }

        if (e.getCharacter().equals("b")) {
          toggleBlack();
        }

        if (e.getCharacter().equals("t")) {
          toggleOnlyBackground();
        }
        
        if (e.getCharacter().equals("n")) {
            toggleNormalize();
          }
        
        e.consume();
		
	}
	

	

}
