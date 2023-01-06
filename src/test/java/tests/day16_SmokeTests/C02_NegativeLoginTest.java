package tests.day16_SmokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import pages.QualitydemtPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_NegativeLoginTest {

    // 3 test method'u olusturun
// 1.de yanlis email, dogru sifre
// 2.de dogru email yanlis sifre
// 3.de yanlis email, yanlis sifre ile giris yapmayi deneyin
// giris yapilamadigini test edin

    QualitydemtPage qualitydemtPage=new QualitydemtPage();

    @Test
    public void yanlisEmailTesti(){

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qualitydemtPage.ilkLoginLinki.click();
        qualitydemtPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUserName"));
        qualitydemtPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qualitydemyGecerliPassword"));
        qualitydemtPage.loginButtonu.click();
        Assert.assertTrue(qualitydemtPage.kullaniciEmailKutusu.isDisplayed());
    }


    @Test
    public void yanlisPasswordTesti(){

        qualitydemtPage=new QualitydemtPage();

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qualitydemtPage.ilkLoginLinki.click();
        qualitydemtPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qualitydemyGecerliUserName"));
        qualitydemtPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qualitydemtPage.loginButtonu.click();
        Assert.assertTrue(qualitydemtPage.kullaniciEmailKutusu.isDisplayed());
    }

    @Test
    public void yanlisUsernameYanlisPasswordTesti(){

        qualitydemtPage=new QualitydemtPage();

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qualitydemtPage.ilkLoginLinki.click();
        qualitydemtPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUserName"));
        qualitydemtPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qualitydemtPage.loginButtonu.click();
        Assert.assertTrue(qualitydemtPage.kullaniciEmailKutusu.isDisplayed());
    }

}
