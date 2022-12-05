import config.GuiceListener;
import config.JettyServer;
import db_migration.DBCreator;
import handler.SecurityHandlerBuilder;
import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.security.JDBCLoginService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

public class Main {
    public static void main(String[] args) throws Exception {
        DBCreator.init();

        Server server = JettyServer.build();
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        contextHandler.addServlet(HttpServletDispatcher.class, "/");
        contextHandler.addEventListener(new GuiceListener());
        String jdbcConfiguration = Main.class.getResource("/db/jdbc_config").toExternalForm();
        JDBCLoginService jdbcLoginService = new JDBCLoginService("login", jdbcConfiguration);
        ConstraintSecurityHandler securityHandler = new SecurityHandlerBuilder().build(jdbcLoginService);
        server.addBean(jdbcLoginService);
        contextHandler.setHandler(securityHandler);
        server.setHandler(contextHandler);
        server.start();
    }
}
