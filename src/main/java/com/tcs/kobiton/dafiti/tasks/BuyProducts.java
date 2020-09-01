package com.tcs.kobiton.dafiti.tasks;

import com.tcs.kobiton.dafiti.interactions.Search;
import com.tcs.kobiton.dafiti.models.Product;
import com.tcs.kobiton.dafiti.userinterface.BuyElements;
import com.tcs.kobiton.dafiti.userinterface.CategoriesElements;
import com.tcs.kobiton.dafiti.userinterface.MenuElements;
import com.tcs.kobiton.dafiti.userinterface.ProductsElements;
import com.tcs.kobiton.dafiti.utils.Format;
import java.util.List;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;

public class BuyProducts implements Task {

  private List<Product> products;

  public BuyProducts(List<Product> products) {
    this.products = products;
  }

  public static BuyProducts inTheApp(List<Product> products) {
    return Tasks.instrumented(BuyProducts.class, products);
  }

  @Step("{0} adds products to cart")
  @Override
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(Click.on(MenuElements.CATEGORIES_MENU));

    int totalPurchase = 0;

    for (Product product : products) {

      actor.attemptsTo(
          Click.on(CategoriesElements.CATEGORY.of(product.getProductCategory().toUpperCase())),
          Search.theElement(ProductsElements.PRODUCT.of(product.getProductName()))
      );

      totalPurchase += Format.value(Text.of(BuyElements.CURRENT_PRICE).viewedBy(actor).asString());

      actor.attemptsTo(
          Click.on(BuyElements.BUY_BUTTON),
          Click.on(BuyElements.SIZE_PRODUCT.of(product.getProductSize())),
          Click.on(ProductsElements.BACK)
      );
    }

    actor.attemptsTo(SeePromotions.andBuy());

    totalPurchase += Format.value(actor.recall("PROMOTIONS_VALUE"));
    actor.remember("TOTAL_PURCHASED", totalPurchase);
  }
}