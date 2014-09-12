/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.xml.XmlConfiguration;

import java.io.File;

public class Launcher {
    private Server server;

    private int port = 0;

    public Launcher() throws Exception{
        this(8080);
    }

    public Launcher(int port) throws Exception {
        this.port = port;
        server = new Server(port);
        HandlerCollection handlers = new HandlerCollection();

        String serviceWebappBasePath = "/home/vincent/Projects/triple_brain/webapp/service/src/";
        WebAppContext serviceWebappContext = new WebAppContext(
                serviceWebappBasePath + "/main/webapp",
                "/service"
        );
        handlers.addHandler(serviceWebappContext);
        XmlConfiguration conf = new XmlConfiguration(new File(
                serviceWebappBasePath +  "test/webapp/WEB-INF/jetty-web.xml"
        ).toURI().toURL().openStream()
        );
        conf.configure(serviceWebappContext);

        WebAppContext mindMapWebappContext = new WebAppContext(
                "/home/vincent/Projects/triple_brain/webapp/mind_map/src/main/webapp",
                "/"
        );
        handlers.addHandler(mindMapWebappContext);


        server.setHandler(handlers);
    }

    int getPort() {
        return port;
    }

    public void launch() throws Exception {

        server.start();
    }

    public void stop() throws Exception {

        server.stop();
    }
}
