package br.com.robertodebarba.jersey_example_project.core;

import org.glassfish.jersey.server.ResourceConfig;

public class MyApplication extends ResourceConfig {
    public MyApplication() {
        register(new MyApplicationBinder());
        packages(true, "br.com.robertodebarba.jersey_example_project.api");
    }
}
