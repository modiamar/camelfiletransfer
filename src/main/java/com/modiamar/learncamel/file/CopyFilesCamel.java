package com.modiamar.learncamel.file;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopyFilesCamel {

    public static void main(String[] args) {
        /**
         * In order for the Camel project to work, you need the Camel context.
         */
        DefaultCamelContext camelContext = new DefaultCamelContext();

        try {
            /**
             * All Camel configs are under Routes. Make a new route builder.
             */
            camelContext.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("file:data/input?noop=true")
                            .to("file:data/output");
                }
            });

            camelContext.start();

            Thread.sleep(5000);
            System.out.println("IT Works");
            camelContext.stop();
        } catch (Exception e) {
            System.out.println("Error Caused Exception thrown: " + e);
            e.printStackTrace();
        }

    }
}
