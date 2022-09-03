package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DialogContent extends Parent{
    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(),this);
    }

    @FindBy(id = "mat-input-0")
    private WebElement username;

    @FindBy(id = "mat-input-1")
    private WebElement password;

    @FindBy(css = "button[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(xpath = "//button[text()='Accept all cookies']")
    private WebElement acceptCookies;

    @FindBy(xpath = "(//span[contains(text(),'Dashboard')])[2]")
    private WebElement dashboard;

    //@FindBy(xpath="//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    // @FindBy(xpath = "//*[@id=ms-table-5_buttons]/ms-table-toolbar/div/ms-add-button/div/button/span[1]/fa-icon/svg/path")
    // private WebElement addButton;
    //*[@id="ms-table-5_buttons"]/ms-table-toolbar/div/ms-add-button/div/button/span[1]/fa-icon/svg/path

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement addButton;

   @FindBy( xpath="/html/body/app/vertical-layout-1/div/div/div/div/content/exam-list/ms-browse/div/ms-browse-table/div/ms-table/div/cdk-virtual-scroll-viewport/div[1]/table/thead/tr/th[8]/ms-table-toolbar/div/ms-add-button/div/button/span[1]/fa-icon/svg" )
   private WebElement addExamButton;

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//span")
    public WebElement IsCountryAdd;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']//input")
    private WebElement codeInput;

    @FindBy(xpath = "//ms-save-button//button") // //ms-save-button[@class='ng-star-inserted']//button
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    private WebElement successMessage;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    private WebElement shortName;

    @FindBy(xpath = "//div[contains(text(), 'already exists')]")
    private WebElement alreadyExist;

    @FindBy(xpath = "//button[@aria-label='Close dialog']")
    private WebElement closeDialog;

    @FindBy (xpath = "(//div[contains(@class,'mat-form-field-infix ng-tns-c74')]//input)[1]")
    private WebElement searchInput;

    @FindBy (xpath = "//ms-search-button//button")
    private WebElement searchButton;

    @FindBy (xpath = "//ms-delete-button//button")
    private WebElement deleteButton;

    @FindBy (xpath = "//span[contains(text(),'Delete')]")
    private WebElement deleteDialogBtn;

    @FindBy (xpath = "//ms-text-field[@formcontrolname='budgetAccountIntegrationCode']//input")
    private WebElement integrationCode;

    @FindBy (xpath = "//ms-integer-field[@formcontrolname='priority']//input")
    private WebElement priorityCode;

    WebElement myElement;
    public void findAndSend(String strElement , String value) // 2. aşama
    {
        switch (strElement){
            case "username" : myElement=username; break;
            case "password" : myElement=password; break;
            case "nameInput" : myElement=nameInput; break;
            case "codeInput" : myElement=codeInput; break;
            case "shortName" : myElement=shortName; break;
            case "searchInput" : myElement=searchInput; break;
            case "integrationCode" : myElement=integrationCode; break;
            case "priorityCode" : myElement=priorityCode; break;
        }
        // burda string isimden webelemente ulaşıcam
        sendKeysFunction(myElement ,value);
    }
    public void findAndClick(String strElement ) // 2. aşama
    {
        switch (strElement){
            case "loginButton" : myElement=loginButton; break;
            case "addButton" : myElement=addButton; break;
            case "IsCountryAdd" : myElement=IsCountryAdd; break;
            case "saveButton" : myElement=saveButton; break;
            case "closeDialog" : myElement=closeDialog; break;
            case "acceptCookies" : myElement=acceptCookies; break;
            case "searchButton" : myElement=searchButton; break;
            case "deleteButton" : myElement=deleteButton; break;
            case "deleteDialogBtn" : myElement=deleteDialogBtn; break;
            case "addExamButton" : myElement=addExamButton; break;

        }
        // burda string isimden webelemente ulaşıcam
        if (myElement==addButton)
            GWD.Bekle(3);
        clickFunction(myElement);
    }

    public void findAndContainsText(String strElement , String text) // 2. aşama
    {
        switch (strElement){
            case "dashboard" : myElement=dashboard; break;
            case "successMessage" : myElement=successMessage; break;
            case "alreadyExist" : myElement=alreadyExist; break;
        }
        // burda string isimden webelemente ulaşıcam
        verifyContainsText(myElement,text);
    }

    public void SearchAndDelete(String searchText) // 2. aşama
    {
        findAndSend("searchInput",searchText); // aranacak kelimeyi kutucuğa gönder
        findAndClick("searchButton"); // arama butonuna bas


        // WebDriverWait wait=new WebDriverWait(GWD.getDriver(),Duration.ofSeconds(10));
        // wait.until(ExpectedConditions.stalenessOf(deleteButton));
        waitUntillLoading();

        // GWD.Bekle(2);

        findAndClick("deleteButton"); // silme butonuna bas
        findAndClick("deleteDialogBtn"); // dialogdaki silme butonuna bas
    }





}
