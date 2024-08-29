package com.sparta.awtp.webtestframework;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// tags can be used to specify what tests should be run

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"pretty", "html:target/testReport.html", "json:target/jsonReport.json"},
        publish = true
)
public class TestRunner {

}

