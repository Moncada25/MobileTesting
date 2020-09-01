package com.tcs.kobiton.dafiti.runners;

import com.tcs.kobiton.dafiti.utils.datadriven.BeforeSuite;
import com.tcs.kobiton.dafiti.utils.datadriven.DataToFeature;
import com.tcs.kobiton.dafiti.utils.datadriven.RunnerPersonalizado;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(features = "src\\test\\resources\\features\\purchase.feature",
    glue = "com.tcs.kobiton.dafiti.stepdefinitions",
    snippets = SnippetType.CAMELCASE)
public class Purchase {

  @BeforeSuite
  public static void test() throws IOException, InvalidFormatException {
    DataToFeature.overrideFeatureFiles("src//test//resources//features//purchase.feature");
  }
}
