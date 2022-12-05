package config;

import api.ProductApi;
import com.google.inject.AbstractModule;
import com.google.inject.Module;
import dao.FactoryDao;
import dao.ProductDao;
import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

import javax.servlet.ServletContext;
import java.util.Collections;
import java.util.List;

public final class GuiceListener extends GuiceResteasyBootstrapServletContextListener {
    @Override
    protected List<? extends Module> getModules(ServletContext context) {
        return Collections.singletonList(new GuiceModule());
    }

    private static final class GuiceModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(FactoryDao.class);
            bind(ProductDao.class);
            bind(ProductApi.class);
        }
    }
}
