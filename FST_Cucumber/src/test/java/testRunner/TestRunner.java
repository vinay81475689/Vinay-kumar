package testRunner;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.SelectPackages;

import io.cucumber.junit.platform.engine.Constants;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("Features")
@ConfigurationParameter(
  key = Constants.GLUE_PROPERTY_NAME, value = "StepDefinations")
@ConfigurationParameter(
  key = Constants.FILTER_TAGS_PROPERTY_NAME,  value = "@activity3")
@ConfigurationParameter(
		key = Constants.PLUGIN_PROPERTY_NAME,
		value = "pretty, html:Reports/HTML_report.html, json:Reports/JSON_report.json, junit:Reports/XML_report.xml"
	)
	@ConfigurationParameter(
		key = Constants.PLUGIN_PUBLISH_ENABLED_PROPERTY_NAME,
		value = "true"
	)

public class TestRunner {}