package com.wasdshinobi;


import com.wasdshinobi.config.RunTimeConfig;
import jakarta.annotation.Priority;
import jakarta.enterprise.inject.Alternative;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Alternative
@Priority(1)
public class DevModeBean {

  public DevModeBean(RunTimeConfig config) {
    log.info("Dev Mode Bean was instantiated & proxied...");
    log.info("host : {}", config.host);
    log.info("Mocked Identity : {}", config.mockedIdentity.orElse("null"));
  }


}
