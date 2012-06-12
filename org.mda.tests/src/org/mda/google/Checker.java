package org.mda.google;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.ConsoleSpammingMockitoJUnitRunner;


@RunWith(ConsoleSpammingMockitoJUnitRunner.class)
public class Checker {



  @Test
  public void main () throws MalformedURLException {

    CheckerTestable mock = Mockito.mock(CheckerTestable.class);

    URL url = new URL ("ftp://hallo");

    Mockito.when(mock.neu("old")).thenReturn("old");
    System.out.println (mock.neu("old"));

    Mockito.when(mock.getIrgendwas(url)).thenReturn("Hello");

    System.out.println ("And " + mock.getIrgendwas(url));

  }

}
