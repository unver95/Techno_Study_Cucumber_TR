package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD {  //Genel Web Driver
    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) // eger driverin ici bir kez dolduysa asagadaki islemleri bir daha yapmasinina gerek kalmiyacak sadece driver return edecek
        {
/*            WebDriverManager.chromedriver().setup();

            Logger.getLogger("").setLevel(Level.SEVERE);
            System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true"); // Chrome Driver Output Proerty leri susturdu sadece Error verirse bir sey yazacak

            ChromeOptions opt = new ChromeOptions();      // web sayfasini kontrol eden gorevli

            opt.setBinary("C:/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe");

            driver = new ChromeDriver(opt);*/

        //firefxo
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        }
        return driver;
    }

    public static void quitDriver(){
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        if(driver != null) // dolu ise
        {
            //driver.quit();
            driver = null;
        }
    }
}
