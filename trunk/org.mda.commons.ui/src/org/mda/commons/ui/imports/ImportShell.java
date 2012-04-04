package org.mda.commons.ui.imports;

import java.util.Arrays;
import java.util.List;
import mda.MidiFile;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.MidiPlayerService;
import org.mda.importer.DefaultTextImporterConfig;
import org.mda.importer.TextImporterService;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;

/** The importshells gives the opportunity to import text to a song
 * or to create a new song and import the text
 * @author oleym */
public class ImportShell extends Shell {

  private ApplicationSession session = MdaModule.getInjector().getInstance(ApplicationSession.class);

  private Button             btnCancel;
  private Button             btnOk;
  private final Text         txtImportedText;

  private MidiFile           midifile;

  private static final Log   LOGGER  = LogFactory.getLogger(ImportShell.class);

  /** Constructor
   * @param shell parentshell */
  public ImportShell (final Shell shell, final MidiFile midifile) {
    super(shell);
    LOGGER.info("Starting importshell for midifile " +
      midifile.getName());
    this.midifile = midifile;

    GridData gdDefault = new GridData();
    gdDefault.horizontalAlignment = GridData.FILL;
    gdDefault.grabExcessHorizontalSpace = true;

    setLayout(new GridLayout(3, false));
    setText("Import songtext...");

    Label lblImportArea = new Label(this, SWT.NONE);
    lblImportArea.setText("Imported text:");

    txtImportedText = new Text(this, SWT.MULTI);
    GridData gdImportedText = new GridData();
    gdImportedText.horizontalAlignment = GridData.FILL;
    gdImportedText.verticalAlignment = GridData.FILL;
    gdImportedText.grabExcessHorizontalSpace = true;
    gdImportedText.horizontalSpan = 2;
    gdImportedText.grabExcessVerticalSpace = true;
    txtImportedText.setLayoutData(gdImportedText);

    createButtonsPanel(this);

    setVisible(true);

  }

  private void createButtonsPanel (final Composite comp) {

    Composite compButtons = new Composite(comp, SWT.NONE);
    compButtons.setLayout(new RowLayout(SWT.HORIZONTAL));
    compButtons.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_DARK_RED));

    btnOk = new Button(compButtons, SWT.NONE);
    btnOk.setText("Importieren");
    btnOk.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected (SelectionEvent e) {
        DefaultTextImporterConfig config = new DefaultTextImporterConfig();

        String[] exported = txtImportedText.getText().split("\n");
        List<String> txt = Arrays.asList(exported);
        TextImporterService service = new TextImporterService(txt, config);
        service.importText(midifile);
        LOGGER.info(MidiPlayerService.toString(midifile));
      }

    });

    btnCancel = new Button(compButtons, SWT.NONE);
    btnCancel.setText("Abbrechen");
    btnCancel.addSelectionListener(new SelectionAdapter () {
      @Override
      public void widgetSelected (SelectionEvent e) {
        dispose();
      }
    });

  }

  protected void checkSubclass () {
    /* Do nothing - Subclassing is allowed */
  }

}
