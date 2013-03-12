package org.mda.javafx.starter;



public class MdaApplicationStarter extends AbstractApplicationStarter {
	
	public MdaApplicationStarter (final String [] args) {
		super ("org.mda.javafx.application.MdaJavaFXApp", args);
	}
	
	
	public static void  main (final String[] args) throws Exception {
		MdaApplicationStarter starter = new MdaApplicationStarter(args);
		starter.start();
	}
	
	
}
