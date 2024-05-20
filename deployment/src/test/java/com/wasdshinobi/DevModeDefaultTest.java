package com.wasdshinobi;

import static io.restassured.RestAssured.given;

import io.quarkus.test.QuarkusDevModeTest;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

public class DevModeDefaultTest {

  @RegisterExtension
  static QuarkusDevModeTest test = new QuarkusDevModeTest()
      .withApplicationRoot((jar) -> jar
          .addClasses(TestController.class)
          .addAsResource(
              new StringAsset(
                  """
                      quarkus.reproducer.host=sid
                      """),
              "application.properties"
          )

      );

  @Test
  void testHelloEndpointDevModeDefault() {
    given()
        .when().get("/hello")
        .then()
        .statusCode(200);
  }
}
