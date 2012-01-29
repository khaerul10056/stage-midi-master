package org.mda.logging;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LogFormatter extends Formatter{

  private String getStackTrace(Throwable aThrowable) {
    final Writer result = new StringWriter();
    final PrintWriter printWriter = new PrintWriter(result);
    aThrowable.printStackTrace(printWriter);
    return result.toString();
  }

  @Override
  public String format(LogRecord record) {
    StringBuilder builder = new StringBuilder("");
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS"); //2010-09-23 15:27:26,19
    String date = format.format(new Date (record.getMillis()));
    builder.append (date + " ");
    builder.append (record.getLevel().getName() + " ");
    builder.append (record.getLoggerName() + " ");
    builder.append (record.getMessage());
    if (record.getThrown() != null)
      builder.append (getStackTrace(record.getThrown()));

    builder.append("\n");

    return builder.toString();
  }

}