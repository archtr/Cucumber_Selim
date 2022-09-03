package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormContent  extends Parent{
    public FormContent() {
        PageFactory.initElements(GWD.getDriver(),this);
    }

    @FindBy(xpath = "(//mat-select[@formcontrolname='id']/div/div)[1]")
    private WebElement academicPeriod;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[1]")
    private WebElement academicPeriod1;

    @FindBy(xpath = "(//mat-select[@formcontrolname='id']/div/div)[3]")
    private WebElement gradeLevel;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[1]")
    private WebElement gradeLevel2;


    WebElement myElement;

    public void findAndClick(String strElement ) // 2. aşama
    {
        switch (strElement){
            case "academicPeriod" : myElement=academicPeriod; break;
            case "academicPeriod1" : myElement=academicPeriod1; break;
            case "gradeLevel" : myElement=gradeLevel; break;
            case "gradeLevel2" : myElement=gradeLevel2; break;
        }
        // burda string isimden webelemente ulaşıcam
        if (myElement==academicPeriod|| myElement==gradeLevel)
            GWD.Bekle(3);
        clickFunction(myElement);
    }




}

