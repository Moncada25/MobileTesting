package com.tcs.kobiton.dafiti.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartElements {

  public static final Target CART_BUTTON = Target.the("cart button")
      .located(By.id("cart_button"));
  public static final Target TOTAL_CHARGED = Target.the("total of purchase")
      .located(By.id("cart_bottom_price_normal"));
}
