package com.wasdshinobi;

import com.wasdshinobi.config.RunTimeConfig;
import jakarta.annotation.Priority;
import jakarta.enterprise.inject.Alternative;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Alternative
@Priority(1)
public class ProdModeBean {
    public ProdModeBean(RunTimeConfig config) {
        log.info("Prod Mode Bean was instantiated & proxied...");
        log.info("host : {}", config.host);
        log.info("Mocked Identity : {}", config.mockedIdentity.orElse("null"));
    }
}
