package com.ceallo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin = {"html:target/cucumber-reports.html",
                    "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                    "json:target/cucumber.json"
            },
            features = "src/test/resources/features",
            glue = "com/ceallo/step_definitions",
            dryRun = false,
            tags = "@CEA10-301"
    )
    public class CukesRunner{
    }



