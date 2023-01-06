package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    // Driver claasindan driver'i getDriver() ile kuallaniyoruz
    // sonradan projeye katilan insanlarin Driver class2indan obje olusturarak driver kullanmaya
    // calismalarini engellemek icin
    // Driver cllasini SINGLETON PATTERN ile duzenleyebilirz.

    // bunun icin driver classinin parametrresiz cons'unu olusturup
    // access modifierini Private yapmamiz lazim.

    private  Driver(){  // kimse bu classtan obje üretemez artk

    }


    static  WebDriver driver;
    public static WebDriver getDriver(){

        String browser=ConfigReader.getProperty("browser");
        if (driver==null) { // failed olmamasi icin deger atamaliyiz yoksa sürekli yeni sayfa acar.
            // driver'a daha once deger atanmis mi demek.


            switch (browser){

                case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;


                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;


                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }



            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driver;
    }


    public static void closeDriver(){

        if (driver!=null){
            driver.close();
            driver=null;
        }
    }
}
