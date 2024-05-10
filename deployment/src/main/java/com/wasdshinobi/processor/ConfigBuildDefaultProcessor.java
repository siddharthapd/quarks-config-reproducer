package com.wasdshinobi.processor;

import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConfigBuildDefaultProcessor {

  private static final String FEATURE = "quarkus-config-reproducer";

  @BuildStep
  FeatureBuildItem feature() {
    return new FeatureBuildItem(FEATURE);
  }
}
