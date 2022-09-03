package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

public class _02_CountrySteps {
    LeftNav ln=new LeftNav();
    DialogContent dc=new DialogContent();

    @And("Navigate to Country Page")
    public void navigateToCountryPage() {
        ln.findAndClick("setupOne"); // setup click
        ln.findAndClick("parameters"); // parameters click
        ln.findAndClick("countries"); // countries click

    }

    @When("Create a Country")
    public void createACountry() {
        String randomGenName= RandomStringUtils.randomAlphabetic(8); // random text , pom xml de eklentisi var
        String randomGenCode= RandomStringUtils.randomAlphabetic(4);
        dc.findAndClick("addButton");
        //dc.findAndClick("IsCountryAdd"); // hata alanlar için alternatif addbutton
        dc.findAndSend("nameInput",randomGenCode);
        dc.findAndSend("codeInput",randomGenCode);
        dc.findAndClick("saveButton");
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dc.findAndContainsText("successMessage","success");
    }

    @When("Create a country name as {string} code as {string}")
    public void createACountryNameAsCodeAs(String name, String code) {
        dc.findAndClick("addButton");
        //dc.findAndClick("IsCountryAdd"); // hata alanlar için alternatif addbutton
        dc.findAndSend("nameInput",name);
        dc.findAndSend("codeInput",code);
        dc.findAndClick("saveButton");

    }
}
