package tests.day_015testNGFrameWorkk;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemtPage;
import utilities.Driver;

public class C03_PozitifLoginTesti {


    @Test
    public void test01(){
    // 1- https://www.qualitydemy.com/ anasayfasina gidin

        Driver.getDriver().get("https://www.qualitydemy.com/");

    // 2- login linkine basin

        QualitydemtPage qualitydemtPage=new QualitydemtPage();
        qualitydemtPage.ilkLoginLinki.click();

    // 3- Kullanici email’i olarak valid email girin

        qualitydemtPage.kullaniciEmailKutusu.sendKeys("user_1106147@login.com");
    // 4- Kullanici sifresi olarak valid sifre girin

        qualitydemtPage.passwordKutusu.sendKeys("31488081");

    // 5- Login butonuna basarak login olun

        qualitydemtPage.loginButtonu.click();

    // 6- Basarili olarak giris yapilabildigini test edin

        Assert.assertTrue(qualitydemtPage.basariliGirisCourseslinki.isDisplayed());








}

}
