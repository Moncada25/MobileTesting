package com.tcs.kobiton.dafiti.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class CategoriesElements {

  public static final Target CATEGORY = Target.the("category {0}").locatedBy("//*[@text='{0}']");
}
