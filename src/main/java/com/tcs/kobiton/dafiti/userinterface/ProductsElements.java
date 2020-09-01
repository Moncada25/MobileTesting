package com.tcs.kobiton.dafiti.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductsElements {

  public static final Target PRODUCT = Target.the("product {0}").locatedBy("//*[@text='{0}']");
  public static final Target BACK = Target.the("go to back").located(By.xpath("//android.widget.ImageButton[@content-desc='Desplazarse hacia arriba']"));

}
