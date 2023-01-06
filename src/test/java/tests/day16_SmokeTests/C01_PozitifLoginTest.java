package tests.day16_SmokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemtPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMEthods;

public class C01_PozitifLoginTest {


    @Test
    public void pozitifLoginTest(){

        // qualitydemy anasayfaya git

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));


        QualitydemtPage qualitydemtPage=new QualitydemtPage();
        qualitydemtPage.ilkLoginLinki.click();

        qualitydemtPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qualitydemyGecerliUserName"));
        qualitydemtPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qualitydemyGecerliPassword"));

        qualitydemtPage.loginButtonu.click();


        ReusableMEthods.bekle(2);

        Assert.assertTrue(qualitydemtPage.basariliGirisCourseslinki.isDisplayed());
        Driver.closeDriver();
    }
}
