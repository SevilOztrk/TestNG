package tests.day18_htmlReports;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemtPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProviderIleNegatifLoginTesti {


    // Qualitydemy anasayfaya gidin
    // verilen yanlis kullanici adi ve password kombinasyonlari icin
    // giris yapilamadigini test edin.
    // username password
    // A11     A12345
    // B12     B12345
    //C13      C12345
    //D14      D12345
    //E15      E12345



    @DataProvider
    public static Object[][] kullaniciBilgileri() {

        Object[][] kullaniciBilgileriArr={{"A11","A12345"}, {"B12", "B12345"}, {"C13","C12345"}, {"D14","D12345"},{"E15","E12345"}};

        return kullaniciBilgileriArr;
    }


    @Test(dataProvider = "kullaniciBilgileri")
    public void negativeLoginTest(String username, String password){

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        QualitydemtPage qd=new QualitydemtPage();
        qd.ilkLoginLinki.click();

        qd.kullaniciEmailKutusu.sendKeys(username);
        qd.passwordKutusu.sendKeys(password);
        qd.loginButtonu.click();

        Assert.assertTrue(qd.kullaniciEmailKutusu.isDisplayed());


    }



}
