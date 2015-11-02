package com.ubiwhere.training;

import java.util.logging.Logger;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.client.filter.EncodingFeature;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.message.DeflateEncoder;
import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

@ApplicationPath("/")
public class MyApplication extends ResourceConfig {

    private static boolean slf4j_installed = false;

    public MyApplication() {

        // Register resources and providers using package-scanning.
        packages("com.ubiwhere.training");

        //gzip encoding
        EncodingFeature encoding = new EncodingFeature(DeflateEncoder.class, GZipEncoder.class);
        register(encoding);

        // register our serializer
        register(net.derquinse.common.jaxrs.gson.GsonProvider.class);

        // register our access control feature
        register(RolesAllowedDynamicFeature.class);

        // Register an instance of LoggingFilter.
        LoggingFilter requestLogger;

        requestLogger = new LoggingFilter(Logger.getLogger("MyApplication"), true);

        register(requestLogger);
    }
}
