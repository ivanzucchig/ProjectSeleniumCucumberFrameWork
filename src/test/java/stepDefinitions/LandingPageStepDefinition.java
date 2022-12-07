package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.TestContextSetup;


public class LandingPageStepDefinition {
    TestContextSetup testContextSetup;
    LandingPage landingPage;

    public LandingPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this. landingPage = testContextSetup.pageObjectManager.getLandingPage();
    }

    @Given("^user is on greenkart landing page$")
    public void user_is_on_greenkart_landing_page() {
        Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
    }

    @When("^user searched with shortname (.+) and extracted actual name of the product$")
    public void user_searched_with_shortname_and_extracted_actual_name_of_the_product(String name) {

        landingPage.searchItem(name);
        testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
        System.out.println(testContextSetup.landingPageProductName + "is extracted from home page");
    }

    @And("^added \"([^\"]*)\" items of the selected product to cart$")
    public void added_something_items_of_the_selected_product_to_cart(String strArg1) {
        landingPage.incrementQuantity(Integer.parseInt(strArg1));
        landingPage.addToCart();
    }
}
