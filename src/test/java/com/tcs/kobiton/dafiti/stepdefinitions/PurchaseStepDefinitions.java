package com.tcs.kobiton.dafiti.stepdefinitions;

import static com.tcs.kobiton.dafiti.utils.Constants.FAILS_TO_CALCULATE_THE_TOTAL_PURCHASE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.tcs.kobiton.dafiti.exceptions.TheTotalDoesNotMatchException;
import com.tcs.kobiton.dafiti.models.Product;
import com.tcs.kobiton.dafiti.questions.TheTotal;
import com.tcs.kobiton.dafiti.tasks.BuyProducts;
import com.tcs.kobiton.dafiti.tasks.GoTo;
import com.tcs.kobiton.dafiti.utils.TheDriver;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;

public class PurchaseStepDefinitions {

  @Before
  public void setUp() {
    setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(TheDriver.mobile())));
    theActorCalled("Santiago");
  }

  @Given("^the user opens the app$")
  public void theUserOpensTheApp() {
    theActorInTheSpotlight().wasAbleTo(GoTo.home());
  }

  @When("^he buys some products$")
  public void heBuysSomeProducts(List<Product> products) {
    theActorInTheSpotlight().attemptsTo(BuyProducts.inTheApp(products));
  }

  @Then("^he should see the total of the products purchased$")
  public void heShouldSeeTheTotalOfTheProductsPurchased() {
    theActorInTheSpotlight().should(seeThat(TheTotal.ofPurchase()).orComplainWith(
        TheTotalDoesNotMatchException.class, FAILS_TO_CALCULATE_THE_TOTAL_PURCHASE));
  }
}
