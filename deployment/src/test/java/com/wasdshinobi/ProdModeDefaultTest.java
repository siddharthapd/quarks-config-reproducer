package com.wasdshinobi;

import static io.restassured.RestAssured.given;

import io.quarkus.test.QuarkusUnitTest;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

public class ProdModeDefaultTest {

  @RegisterExtension
  static QuarkusUnitTest test = new QuarkusUnitTest()
      .withApplicationRoot((jar) -> jar
          .addClasses(TestController.class)
          .addAsResource(
              new StringAsset(
                  """
                      quarkus.reproducer.host=sid
                      quarkus.http.test-port=8051
                      """),
              "application.properties"
          )

      );

  @Test
  void testHelloEndpointProdModeDefault() {
    given()
        .when().get("/hello")
        .then()
        .statusCode(200);
  }
}
