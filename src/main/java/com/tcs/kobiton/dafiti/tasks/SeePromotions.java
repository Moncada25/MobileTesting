package com.tcs.kobiton.dafiti.tasks;

import com.tcs.kobiton.dafiti.userinterface.BuyElements;
import com.tcs.kobiton.dafiti.userinterface.CartElements;
import com.tcs.kobiton.dafiti.userinterface.MenuElements;
import com.tcs.kobiton.dafiti.userinterface.ProductsElements;
import com.tcs.kobiton.dafiti.userinterface.PromotionsElements;
import com.tcs.kobiton.dafiti.utils.Format;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;

public class SeePromotions implements Task {

  public static SeePromotions andBuy() {
    return Tasks.instrumented(SeePromotions.class);
  }

  @Step("{0} see promotions and buy a product")
  @Override
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(
        Click.on(MenuElements.PROMOTIONS_MENU),
        Click.on(PromotionsElements.FIRST_PROMOTION),
        Click.on(PromotionsElements.FIRST_PRODUCT)
    );

    actor.remember("PROMOTIONS_VALUE", Text.of(BuyElements.CURRENT_PRICE).viewedBy(actor).asString());

    actor.attemptsTo(
        Click.on(BuyElements.BUY_BUTTON),
        Check.whether(
            BuyElements.SIZE_PRODUCT.of("L").resolveFor(actor).isVisible())
            .andIfSo(Click.on(BuyElements.SIZE_PRODUCT.of("L")))
            .otherwise(Click.on(BuyElements.SIZE_PRODUCT.of("40"))),
        Click.on(ProductsElements.BACK),
        Click.on(CartElements.CART_BUTTON)
    );
  }
}
