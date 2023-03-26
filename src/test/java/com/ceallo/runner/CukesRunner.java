package com.ceallo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin = {"html:target/cucumber-reports.html",
                    "me.jvt.cucumber.report.PrettyReports:target/cucumber"},
            features = "src/test/resources/features",
            glue = "com/ceallo/step_definitions",
            tags = "@CEA10-292"
    )
    public class CukesRunner{
    }



