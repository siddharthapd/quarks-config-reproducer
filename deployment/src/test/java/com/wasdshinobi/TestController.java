package com.wasdshinobi;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hello")
public class TestController {

  @GET
  public String getName() {
    return "success";
  }
}
