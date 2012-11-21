package org.mda.google;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mda.MidiPlayerRoot;
import mda.UserType;

import org.eclipse.e4.core.di.annotations.Execute;
import org.mda.ApplicationSession;
import org.mda.inject.InjectService;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

import com.google.gdata.util.ServiceException;
import com.google.inject.Inject;


public class ImportHandler {

  private static final Log LOGGER  = LogFactory.getLogger(ImportHandler.class);

  @Inject
  private ApplicationSession session;

  @Execute
  public Object execute() {
	InjectService.injectObject(this);
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