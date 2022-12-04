package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DialogContent extends Parent {

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "input[formcontrolname='username']")
    private WebElement username;

    @FindBy(css = "input[formcontrolname='password']")
    private WebElement password;

    @FindBy(css = "button[aria-label='LOGIN']")
    private WebElement logginButton;

    @FindBy(css = "span[class='mat-tooltip-trigger logo-text']")
    private WebElement txtTechnoStudy;

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement addButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']//input")
    private WebElement codeInput;

    @FindBy(xpath = "//ms-save-button//button")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    private WebElement successMessage;

    @FindBy(css = "button[class='consent-give']")
    private WebElement acceptCookies;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    private WebElement shortName;

    @FindBy(xpath = "//div[contains(text(),'already exist')]")
    private WebElement alreadyExist;

    @FindBy(xpath = "//mat-form-field//input[@data-placeholder='Name']")
    private WebElement searchInput;

    @FindBy(xpath = "//ms-search-button//button")
    private WebElement searchButton;

    @FindBy(xpath = "(//ms-delete-button//button)[1]")
    private WebElement deleteButton;

    @FindBy(xpath = "//span[text()=' Delete ']")
    private WebElement deleteDialogBtn;

    @FindBy(xpath = "(//td[@role='cell'])[2]")
    private WebElement searchResultCell;


    @FindBy(xpath = "//ms-text-field[@formcontrolname='budgetAccountIntegrationCode']//input")
    private WebElement integrationCode;

    @FindBy(xpath = "//ms-integer-field[@formcontrolname='priority']/input")
    private WebElement priorityCode;

    @FindBy(xpath="//mat-slide-toggle[@formcontrolname='active']")
    private WebElement  toggleBar;



    WebElement myElement;

    public void findAndSend(String strlement, String value) {

        //element get

        switch (strlement) {
            case "username" -> myElement = username;
            case "password" -> myElement = password;
            case "nameInput" -> myElement = nameInput;
            case "codeInput" -> myElement = codeInput;
            case "shortName" -> myElement = shortName;
            case "searchInput" -> myElement = searchInput;
            case "integrationCode" -> myElement = integrationCode;
            case "priorityCode" -> myElement = priorityCode;
        }

        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String strlement) {

        //element get

        switch (strlement) {
            case "logginButton" -> myElement = logginButton;
            case "acceptCookies" -> myElement = acceptCookies;
            case "addButton" -> myElement = addButton;
            case "saveButton" -> myElement = saveButton;
            case "searchButton" -> myElement = searchButton;
            case "deleteButton" -> myElement = deleteButton;
            case "deleteDialogBtn" -> myElement = deleteDialogBtn;
            case "toggleBar" -> myElement = toggleBar;
        }
        clickFunction(myElement);
    }

    public void findAndContainsText(String strlement, String text) {
        switch (strlement) {
            case "txtTechnoStudy" -> myElement = txtTechnoStudy;
            case "successMessage" -> myElement = successMessage;
            case "alreadyExist" -> myElement = alreadyExist;
            case "searchResultCell" -> myElement = searchResultCell;
        }
        verifyContainsTextFunction(myElement, text);
    }

    public void FindAndDelete(String searchText) {
        findAndSend("searchInput", searchText); // aranacak kelimeyi kutucaga gonder
        findAndClick("searchButton");           // arama butonuna bas

        findAndContainsText("searchResultCell",searchText);  // arama sonuclarinin ilkinde arana kelime gozukune kadar bekle

        findAndClick("deleteButton");          // silme butona bas, cop kutusu
        findAndClick("deleteDialogBtn");       // dilogdaju silme butonuna bas
    }
}