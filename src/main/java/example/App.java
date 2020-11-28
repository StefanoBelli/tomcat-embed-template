package example;

import java.io.File;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App {
	
	private static final int PORT = 8080;
	private static final String TOMCATBASEDIR = "astemp";
	private static final String BASE = "";
	private static final String WEBAPPDIR = getAbsolutePath("src/main/webres");
	
	private static void startTomcat() throws LifecycleException{
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(PORT);
		tomcat.setBaseDir(TOMCATBASEDIR);
		tomcat.addWebapp(BASE, WEBAPPDIR);
		
		tomcat.start();
		
		tomcat.getServer().await();
	}

	public static void main(String[] args) throws LifecycleException {
		startTomcat();
	}
	
	/* util */
	private static String getAbsolutePath(String relative) {
		return new File(relative).getAbsolutePath();
	}

}
