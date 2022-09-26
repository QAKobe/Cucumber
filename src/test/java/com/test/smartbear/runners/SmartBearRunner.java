package com.test.smartbear.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/smartbear",
        glue = "com/test/smartbear/stepdefinitions",
        dryRun = false,
        tags = "@smart"
)
public class SmartBearRunner {
}
