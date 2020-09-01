package com.tcs.kobiton.dafiti.interactions;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;

public class Swipe implements Interaction {

  public static Swipe vertical() {
    return Tasks.instrumented(Swipe.class);
  }

  @Step("{0} make scroll vertical")
  @Override
  public <T extends Actor> void performAs(T actor) {

    int middlePointX = BrowseTheWeb.as(actor).getDriver().manage().window().getSize().getWidth() / 2;
    int middlePointY = BrowseTheWeb.as(actor).getDriver().manage().window().getSize().getHeight() / 2;

    int fourthPartScreenY = middlePointY / 2;

    new TouchAction((PerformsTouchActions) BrowseTheWeb.as(actor).getDriver())
        .press(PointOption.point(middlePointX, middlePointY))
        .moveTo(PointOption.point(middlePointX, fourthPartScreenY)).release().perform();
  }
}