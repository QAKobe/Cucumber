package com.test.weborder.runners;

/*
These are all interview questions
    ->Runner class is a way to run your all feature files from here.(xml in TestNG)
    Regression, smoke, integration...etc
    -->@RunWith--> Annotation comes from Junit and it executes the feature file steps.
    -->CucumberOptions--> is a special annotation that have some keywords.
    -->Features --> it means location of feature files(this one should be content root)
    -->Glue--> this is location of StepDef files(this should be source root)
    -->dryRun--> this is a way to get snips(steps) without executing the whole implementation.
    -->tags --> is a way to specialize scenarios for specific purposes. It means, you can run some scenarios for only
    regression or smoke or etc...
    -->Plugin--> is a way to integrate specific condition for the keyword. It is mostly used to create a report card.

 */

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/weborder",
        glue = "com/test/weborder/stepdefinitions",
        dryRun = false,
        tags = "@regression"


)
public class WebOrderRunner {
}
