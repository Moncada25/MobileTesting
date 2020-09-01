package com.tcs.kobiton.dafiti.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuElements {

  public static final Target CATEGORIES_MENU = Target.the("categories menu")
      .located(By.id("navigation_categories"));
  public static final Target PROMOTIONS_MENU = Target.the("promotions menu")
      .located(By.id("navigation_sales"));
}
