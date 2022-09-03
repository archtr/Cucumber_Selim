package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _04_CitizenshipSteps {
    LeftNav ln=new LeftNav();
    DialogContent dc=new DialogContent();
    @And("Navigate to Citizenship page")
    public void navigateToCitizenshipPage() {
        ln.findAndClick("setupOne"); // setup click
        ln.findAndClick("parameters"); // parameters click
        ln.findAndClick("citizenShip"); // citizenShip click ve loc tanımla
    }

    @When("User a Citizenship name as {string} short name as {string}")
    public void userACitizenshipNameAsShortNameAs(String name, String shortName) {
        dc.findAndClick("addButton");
        //dc.findAndClick("IsCountryAdd"); // hata alanlar için alternatif addbutton
        dc.findAndSend("nameInput",name);
        dc.findAndSend("shortName",shortName); // shortname loc tanımlanacak
        dc.findAndClick("saveButton");
    }

    @Then("Already exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {
        dc.findAndContainsText("alreadyExist","already exists"); // loc tanımla

    }

    @And("Click on close button")
    public void clickOnCloseButton() {
        dc.findAndClick("closeDialog"); // loc tanımlanacak
    }

    @When("User delete the {string}")
    public void userDeleteThe(String arananKelime) {
        dc.SearchAndDelete(arananKelime);
    }
}
