package eu.nyerel.camelidea.test.route;

import org.apache.camel.BeanInject;
import org.apache.camel.builder.RouteBuilder;

public class MainRouteBuilder extends RouteBuilder {

    public static final String DIRECT_LALA = "direct:LALA";

    @BeanInject
    private TestBean testBean;

    public void configure() throws Exception {
        from("direct:LALA")
                .to("direct:a");

        from("direct:seconLALA")
                .to(DIRECT_LALA);

        from("direct:thirdLALA")
                .to("direct:seconLALA");

        from("direct:thirdLALA")
                .to("direct:LALA")
                .bean(testBean, "ahoj")
                .to(DIRECT_LALA);



    }

}
