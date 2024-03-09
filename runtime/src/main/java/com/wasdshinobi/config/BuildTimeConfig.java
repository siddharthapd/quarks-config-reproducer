package com.wasdshinobi.config;

import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;

import java.util.Optional;

@ConfigRoot(name = "reproducer", phase = ConfigPhase.BUILD_AND_RUN_TIME_FIXED)
public class BuildTimeConfig {

    /**
     * Wether this reproducer is enabled or not
     */
    @ConfigItem
    public Optional<Boolean> enabled;
}
