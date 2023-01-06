package tests.day_015SoftAssert;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemtPage;
import utilities.Driver;

public class C04_NegativeLoginTesti {

    // 3 test methodu olusturun
    // 1.'de yanlis email  doğru sifre
    // 2. de dogru email yanlis sfre
    // 3. de yanlis email yanlis sfre ile giris yapmayi denenyin ve giris yapilamadigini test edin.

    QualitydemtPage qualitydemtPage=new QualitydemtPage();

    @Test
    public void yanlisEmailTesti(){

        Driver.getDriver().get("https://www.qualitydemy.com/");
        qualitydemtPage.ilkLoginLinki.click();
        qualitydemtPage=new QualitydemtPage();
        qualitydemtPage.kullaniciEmailKutusu.sendKeys("svl@cbvn.com");
        qualitydemtPage.passwordKutusu.sendKeys("31488081");
        qualitydemtPage.loginButtonu.click();
        Assert.assertTrue(qualitydemtPage.kullaniciEmailKutusu.isDisplayed());

    }


    @Test
    public void yanlisPasswordTesti(){  // user_1106147@login.com
        Driver.getDriver().get("https://www.qualitydemy.com/");
        qualitydemtPage=new QualitydemtPage();
        qualitydemtPage.ilkLoginLinki.click();
        qualitydemtPage.kullaniciEmailKutusu.sendKeys(" user_1106147@login.com");
        qualitydemtPage.passwordKutusu.sendKeys("12345");
        qualitydemtPage.loginButtonu.click();
        Assert.assertTrue(qualitydemtPage.kullaniciEmailKutusu.isDisplayed());

    }


    @Test
    public void yanlisSfreyanlisPassword(){
        Driver.getDriver().get("https://www.qualitydemy.com/");
        qualitydemtPage=new QualitydemtPage();
        qualitydemtPage.ilkLoginLinki.click();
        qualitydemtPage.kullaniciEmailKutusu.sendKeys("svkh@djk.com");
        qualitydemtPage.passwordKutusu.sendKeys("12345");
        qualitydemtPage.loginButtonu.click();
        Assert.assertTrue(qualitydemtPage.kullaniciEmailKutusu.isDisplayed());

    }
}
