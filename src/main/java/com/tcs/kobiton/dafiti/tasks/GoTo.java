package com.tcs.kobiton.dafiti.tasks;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import com.tcs.kobiton.dafiti.userinterface.SplashElements;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

public class GoTo implements Task {

  public static GoTo home() {
    return Tasks.instrumented(GoTo.class);
  }

  @Step("{0} go to home app")
  @Override
  public <T extends Actor> void performAs(T actor) {

    if (SplashElements.COUNTRY_COL.resolveFor(actor).isVisible()) {

      actor.wasAbleTo(
          Click.on(SplashElements.COUNTRY_COL),
          Click.on(SplashElements.SELECT_MALE)
      );
    }
  }
}
