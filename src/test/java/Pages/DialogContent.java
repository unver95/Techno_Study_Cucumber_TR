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

    @FindBy(css = "span[class='nav-link-title']")
    private WebElement dashboardElement;

    WebElement myElement;

    public void findAndSend(String strlement, String value) {

        //element get

        switch (strlement) {
            case "username":
                myElement = username;
                break;
            case "password":
                myElement = password;
                break;
        }
        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String strlement) {

        //element get

        switch (strlement) {
            case "logginButton":
                myElement = logginButton;
                break;
        }
        clickFunction(myElement);
    }

    public void findAndContainsText(String strlement, String text) {
        switch (strlement) {
            case "dashboardElement":
                myElement = dashboardElement;
                break;
        }
        verifyContainsTextFunction(myElement, text);
    }
}
