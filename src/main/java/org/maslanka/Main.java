package org.maslanka;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws LifecycleException {
        //https://northcoder.com/post/embedded-tomcat-v90-and-v100/

        int portNum= 3000;

        Logger.getLogger("org.apache.catalina").setLevel(Level.FINE);
        Logger.getLogger("org.apache.jasper").setLevel(Level.FINE);

        Tomcat tomcat= new Tomcat();
        tomcat.setBaseDir("temp");
        Connector conn = new Connector();
        conn.setPort(portNum);
        tomcat.setConnector(conn);

        String webappLocation = "src/main/webapp";
        Context context = tomcat.addWebapp("", new File(webappLocation).getAbsolutePath());

        Tomcat.addServlet(context, "MainServlet", new MainServlet());
        context.addServletMappingDecoded("/mainServlet", "MainServlet");

        tomcat.start();
        System.out.println("Tomcat started on port: " + portNum);
        tomcat.getServer().await();

    }
}