package com.tcs.kobiton.dafiti.questions;

import com.tcs.kobiton.dafiti.userinterface.CartElements;
import com.tcs.kobiton.dafiti.utils.Format;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

public class TheTotal implements Question<Boolean> {

  public static TheTotal ofPurchase() {
    return new TheTotal();
  }

  @Subject("validate the total")
  @Override
  public Boolean answeredBy(Actor actor) {

    int totalPurchased = actor.recall("TOTAL_PURCHASED");
    int totalCharged = Format.value(Text.of(CartElements.TOTAL_CHARGED).viewedBy(actor).asString());

    System.out.println("Purchased: " + totalPurchased);
    System.out.println("Charged: " + totalCharged);

    return totalPurchased == totalCharged;
  }
}
