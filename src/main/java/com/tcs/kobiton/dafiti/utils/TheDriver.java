package com.tcs.kobiton.dafiti.utils;

import io.appium.java_client.AppiumDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TheDriver {

  public static WebDriver mobile() {

    String serverHub = "http://0.0.0.0:4723/wd/hub";

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("deviceName", "emulator-5554");
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("platformVersion", "7.1.1");
    capabilities.setCapability("appPackage", "br.com.dafiti");
    capabilities.setCapability("appActivity", "br.com.dafiti.activity.SplashSelectCountry_");
    capabilities.setCapability("udid", "emulator-5554");
    capabilities.setCapability("noReset", "true");

//    String serverHub = "https://api.kobiton.com:443/wd/hub";
//
//    DesiredCapabilities capabilities = new DesiredCapabilities();
//    capabilities.setCapability("sessionName", "Automation test session");
//    capabilities.setCapability("username", "smoncada2");
//    capabilities.setCapability("accessKey", "0ed0190e-317a-443d-b6ff-43d0f504d421");
//    capabilities.setCapability("noReset", true);
//    capabilities.setCapability("autoGrantPermissions", true);
//    capabilities.setCapability("app", "kobiton-store:71480");
//    capabilities.setCapability("deviceOrientation", "portrait");
//    capabilities.setCapability("captureScreenshots", true);
//    capabilities.setCapability("deviceGroup", "KOBITON");
//    capabilities.setCapability("deviceName", "Pixel 3a");
//    capabilities.setCapability("platformVersion", "10");
//    capabilities.setCapability("platformName", "Android");
//    capabilities.setCapability("appPackage", "br.com.dafiti");
//    capabilities.setCapability("appActivity", "br.com.dafiti.activity.SplashSelectCountry_");

    try {
      return new AppiumDriver(new URL(serverHub),
          capabilities);
    } catch (MalformedURLException e) {
      e.printStackTrace();
      return null;
    }
  }
}