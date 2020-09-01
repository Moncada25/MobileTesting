package com.tcs.kobiton.dafiti.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.NoSuchElementException;

public class Search implements Interaction {

  private Target element;

  public Search(Target element) {
    this.element = element;
  }

  public static Search theElement(Target element) {
    return Tasks.instrumented(Search.class, element);
  }

  @Step("{0} search #element")
  @Override
  public <T extends Actor> void performAs(T actor) {

    for (int i = 0; i < 30; i++) {

      if (element.resolveFor(actor).isCurrentlyVisible()) {
        break;
      } else {
        actor.attemptsTo(Swipe.vertical());
      }
    }

    if (element.resolveFor(actor).isCurrentlyVisible()) {
      actor.attemptsTo(Click.on(element));
    } else {
      throw new NoSuchElementException(element.getCssOrXPathSelector());
    }
  }
}
