package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;


public class OfferPageStepDefinition {
    public String offerPageProductName;
    TestContextSetup testContextSetup;
    PageObjectManager pageObjectManager;

    public OfferPageStepDefinition(TestContextSetup testContextSetup) {

        this.testContextSetup = testContextSetup;
    }

    @Then("^user searched for (.+) shortname in offers page$")
    public void user_searched_for_shortname_in_offers_page(String name){
        switchToOffersPage();
        OffersPage offersPage = testContextSetup.pageObjectManager.OfferPage();
        offersPage.searchItem(name);
        offerPageProductName = offersPage.getProductName();
    }

    public void switchToOffersPage() {
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.selectTopDealsPage();
        testContextSetup.genericUtils.SwitchWindowToChild();

    }

    @And("^validate product name in offers page matches with landing page$")
    public void validate_product_name_in_offers_page_matches_with_landing_page(){
        Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
    }
}
