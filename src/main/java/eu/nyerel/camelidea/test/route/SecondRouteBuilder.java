package eu.nyerel.camelidea.test.route;

import org.apache.camel.builder.RouteBuilder;

public class SecondRouteBuilder extends RouteBuilder {

    public void configure() throws Exception {
        from("direct:LALA")
                .to("direct:ajaj");

        from("direct:secondRouteBuilderRoute")
                .to("direct:LALA");
    }

}
