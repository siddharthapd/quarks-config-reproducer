package com.wasdshinobi.config;

import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;
import java.util.Optional;

@ConfigRoot(name = "reproducer", phase = ConfigPhase.RUN_TIME)
public class RunTimeConfig {

  /**
   * host name
   */
  @ConfigItem
  public String host;

  /**
   * mocked identity name
   */
  @ConfigItem
  public Optional<String> mockedIdentity;

}
