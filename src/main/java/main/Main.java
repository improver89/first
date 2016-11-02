package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.AllRequestsServlet;
import servlets.HomeWorkRequestServlet;

/**
 * Created by vsaprykin on 01.11.16.
 */
public class Main {
    public static void main (String[] args) throws Exception {

        AllRequestsServlet allRequestsServlet = new AllRequestsServlet();
        HomeWorkRequestServlet homeWorkRequestServlet = new HomeWorkRequestServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(allRequestsServlet), "/*");
        context.addServlet(new ServletHolder(homeWorkRequestServlet), "/mirror");


        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();
    }
}
