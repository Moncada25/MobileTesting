package com.tcs.kobiton.dafiti.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BuyElements {

  public static final Target BUY_BUTTON = Target.the("buy button").located(By.id("buy_button"));
  public static final Target SIZE_PRODUCT = Target.the("size of product {0}").locatedBy("//*[@text='{0}']");
  public static final Target CURRENT_PRICE = Target.the("current price of product").located(By.id("current_price"));
}