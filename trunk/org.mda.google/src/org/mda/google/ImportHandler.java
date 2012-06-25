package org.mda.google;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mda.MidiPlayerRoot;
import mda.UserType;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;
import com.google.gdata.util.ServiceException;


public class ImportHandler extends AbstractHandler {

  private static final Log LOGGER  = LogFactory.getLogger(ImportHandler.class);

  private ApplicationSession session = MdaModule.getInjector().getInstance(ApplicationSession.class);

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    MidiPlayerRoot currentModel = session.getCurrentModel();
    GoogleContactsConnector connector = new GoogleContactsConnector();
    GoogleContactsDescriptor desc = new GoogleContactsDescriptor(UserType.MEMBER, "Sound of faith");

    List <GoogleContactsDescriptor> descriptors = new ArrayList<GoogleContactsDescriptor>();
    descriptors.add(desc);
    try {
      connector.importAllContacts(currentModel, descriptors);
      session.saveModel();
    }
    catch (ServiceException e) {
      LOGGER.error(e.toString(), e);
    }
    catch (IOException e) {
      LOGGER.error(e.toString(), e);
    }
    return null;
  }

}