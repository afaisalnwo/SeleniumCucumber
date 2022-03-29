package com.tcs.assignment12_cucumber;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/tcs/assignment12_cucumber")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/report.html")
public class RunCucumberTest {
}
