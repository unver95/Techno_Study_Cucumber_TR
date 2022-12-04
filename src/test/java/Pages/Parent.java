package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Parent {
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollToelement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void sendKeysFunction(WebElement element, String value) {
        waitUntilVisible(element); // Gozukene kadar bekle (wait)
        scrollToelement(element); // Elemenete kadar scroll yap (javaScriptexecuter)
        element.clear();           // Temizle (clear)
        element.sendKeys(value);   // Deger gonder (sendKeys)
    }

    public void clickFunction(WebElement element) {
        waitUntilClickable(element); // baslilana kadar bekle (wait)
        scrollToelement(element); // Elemenete kadar scroll yap (javaScriptexecuter)
        element.click();           // Click
    }

    public void verifyContainsTextFunction(WebElement element, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        scrollToelement(element); // Elemenete kadar scroll yap (javaScriptexecuter) // Hoca burayi sildi ama bizim icin gerekli
        Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()), "aranan text bulunmadi");
        new Actions(GWD.getDriver()).sendKeys(Keys.ESCAPE).perform(); // acik dialog kutusu varsa kapansin
    }

    public void waitUntilLoading()
    {
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("fuse-progress-bar > *"), 0));
        // progressbar ın çocukları
    }
}
