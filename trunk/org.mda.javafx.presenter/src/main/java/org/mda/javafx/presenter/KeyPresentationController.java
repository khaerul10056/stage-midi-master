package org.mda.javafx.presenter;

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
		LOGGER.info("GlobalKeyRegistryPresentationController recieved key " + e.getText() + "-" + e.getCode().getName()); // TODO + Util.logEvent(e));
		
		
    	
//    	if (e.character == '1') {  TODO
//    		LOGGER.info("Footcontroller pressed");
//			midiplayer.togglePause();
//		}
    	
		if (e.getCode().equals(KeyCode.SPACE))
			toggleMediaPlaying();
        
        if (e.getCode().equals(KeyCode.F4) && e.isAltDown())
      	  end();

        if (e.getCode().equals(KeyCode.RIGHT) && ! e.isShiftDown()) {
          //midiplayer.savePartIntersection(); TODO
          nextSlide();
        }
        
        if (e.getCode().equals(KeyCode.HOME))
        	toBeginning();
        
        if (e.getCode().equals(KeyCode.END))
        	toEnd();

        if (e.getCode().equals(KeyCode.LEFT) && ! e.isShiftDown())
          previousSlide();

        if (e.getCode().equals(KeyCode.LEFT) && e.isShiftDown())
          previousSong();

        if (e.getCode().equals(KeyCode.RIGHT) && e.isShiftDown())
          nextSong();

        if (e.getText().equals("w")) {
          toggleWhite();
        }

        if (e.getText().equals("b")) {
          toggleBlack();
        }

        if (e.getText().equals("t")) {
          toggleOnlyBackground();
        }
        
        if (e.getText().equals("n")) {
            toggleNormalize();
          }
        
        e.consume();
		
	}
	

	

}
