package com.wasdshinobi.processor;

import com.wasdshinobi.DevModeBean;
import com.wasdshinobi.ProdModeBean;
import com.wasdshinobi.config.BuildTimeConfig;
import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.deployment.IsDevelopment;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import lombok.extern.slf4j.Slf4j;

import java.util.function.BooleanSupplier;

@Slf4j
public class ConfigBuildDefaultProcessor {

    private static final String FEATURE = "quarkus-config-reproducer";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }
}
