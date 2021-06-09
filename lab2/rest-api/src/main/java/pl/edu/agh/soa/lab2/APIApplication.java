package pl.edu.agh.soa.lab2;

import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class APIApplication extends Application {
    public APIApplication() {
        BeanConfig beanConfig = new BeanConfig();

        beanConfig.setVersion("1.0.0");
        beanConfig.setTitle("StudentApp API");
        beanConfig.setBasePath("/rest-api/api");
        beanConfig.setResourcePackage("pl.edu.agh.soa.lab2");
        beanConfig.setScan(true);
    }
}
