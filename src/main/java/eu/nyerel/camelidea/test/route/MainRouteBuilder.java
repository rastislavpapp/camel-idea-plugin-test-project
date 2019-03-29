package eu.nyerel.camelidea.test.route;

import org.apache.camel.BeanInject;

public class MainRouteBuilder extends AbstractRouteBuilder {

    public static final String DIRECT_LALA = "direct:LALA";

    @BeanInject
    private TestBean testBean;

    public void configure() throws Exception {
        from("direct:LALA?synchronous=false")
                .to("direct:abc?heh=false&something=else");


        from("direct:LALA")
                .to("direct:abc?attr=value");

        from("direct:secondLALA")
                .to("direct:LALA")
                .to(DIRECT_LALA);

        from("direct:thirdLALA")
                .to("direct:LALA");

        from("direct:aaabc")
                .to("direct:aaabc");

        from("direct:thirdLALA")
                .to("")
                .bean(testBean, "ahoj")
                .to(DIRECT_LALA)
                .to(DIRECT_LALA)
                .to(DIRECT_LALA)
                .to(DIRECT_LALA)
                .to(DIRECT_LALA);



    }

}
