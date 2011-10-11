package org.mda.editor.xtext;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.XtextResource;


public class InMemoryXtextResource extends XtextResource {

  @Override
  protected void doUnload () {
    // TODO Auto-generated method stub
    super.doUnload();
  }

  @Override
  public void doSave (OutputStream outputStream, Map<?, ?> options) throws IOException {
    super.doSave(outputStream, options);

    EObject eObject = getContents().get(0);
  }



}
