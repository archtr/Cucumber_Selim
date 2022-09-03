package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD {

    public static WebDriver driver;

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>(); // webdriver1 webdriwer2
    public static ThreadLocal<String> threadBrowserName = new ThreadLocal<>(); // chrome , firefox ...

    // threadDriver.get() -> ilgili thread deki driveri verecek
    // threadDriver.set(driver) -> ilgili thread e driver set ediliyor


    public static WebDriver getDriver() {
        // bana neler lazım : 1 browser tipi lazım burada ona göre oluşturucam
        // her bir paralel çalışan süreç için sadece o sürece özel static bir değişken lazım
        // çünkü runner classdaki işaret edilen tüm senaryolarda aynısının çalışması lazım
        // demekki her pipeline için (local) ve de ona özel static bir drivera ihtiyacım var


        // extend report türkçe rapor vermemesi sebebiyle koyuldu
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        Logger.getLogger("").setLevel(Level.SEVERE);
        System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");
        if (threadBrowserName.get()==null) // paralel çalışmayan yani xml den parametreyle gelmeyenler için
            threadBrowserName.set("chrome"); // basic arayanlar için

        if (threadDriver.get() == null) {
            String browserName = threadBrowserName.get(); // bu threaddeki browsername i verdi

            switch (browserName) {
                case "chrome":
                    // System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                    WebDriverManager.chromedriver().setup();
                    threadDriver.set(new ChromeDriver()); // bu thread e chrome istenmişse ve yoksa bir tane ekleniyor
                    break;

                case "firefox":
                    // System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                    WebDriverManager.firefoxdriver().setup();
                    threadDriver.set(new FirefoxDriver()); // bu thread e firefox istenmişse ve yoksa bir tane ekleniyor
                    break;

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    threadDriver.set(new SafariDriver());
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    threadDriver.set(new EdgeDriver());
                    break;
            }
        }
        return threadDriver.get();
    }

    public static void quitDriver() {
        Bekle(5);
        if (threadDriver.get() != null) { // driver varsa quit yap
            threadDriver.get().quit();
            WebDriver driver=threadDriver.get();
            driver=null;
            threadDriver.set(driver); // tekrar gelirse içi boş olmuş olsun
        }
    }

    public static void Bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
