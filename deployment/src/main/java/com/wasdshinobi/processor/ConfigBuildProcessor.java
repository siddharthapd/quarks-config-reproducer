package com.wasdshinobi.processor;

import com.wasdshinobi.DevModeBean;
import com.wasdshinobi.ProdModeBean;
import com.wasdshinobi.config.BuildTimeConfig;
import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.deployment.IsDevelopment;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import lombok.extern.slf4j.Slf4j;

import java.util.function.BooleanSupplier;

import static io.quarkus.arc.processor.DotNames.SINGLETON;

@Slf4j
public class ConfigBuildProcessor {

    @BuildStep(onlyIf = {IsEnabled.class, IsDevelopment.class})
    public void setupDevMode(BuildProducer<AdditionalBeanBuildItem> additionalBeans) {
        log.info("Adding Dev Mode Beans...");
        var builder = AdditionalBeanBuildItem.builder().setUnremovable();

        builder.addBeanClass(DevModeBean.class)
                .setDefaultScope(SINGLETON);

        additionalBeans.produce(builder.build());
    }

    @BuildStep(onlyIf = IsEnabled.class, onlyIfNot = IsDevelopment.class)
    public void setupProdMode(BuildProducer<AdditionalBeanBuildItem> additionalBeans) {
        log.info("Adding Prod Mode Beans...");
        var builder = AdditionalBeanBuildItem.builder().setUnremovable();

        builder.addBeanClass(ProdModeBean.class)
                .setDefaultScope(SINGLETON);

        additionalBeans.produce(builder.build());
    }

    private static class IsEnabled implements BooleanSupplier {
        BuildTimeConfig config;

        @Override
        public boolean getAsBoolean() {
            if (config.enabled.isPresent() && Boolean.FALSE.equals(config.enabled.get())) {
                log.info("Config Reproducer is disabled.");
                return false;
            }
            log.info("Config Reproducer is enabled.");
            return true;
        }
    }
}
