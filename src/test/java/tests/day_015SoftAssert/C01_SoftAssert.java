package tests.day_015SoftAssert;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.Driver;
import utilities.ReusableMEthods;

public class C01_SoftAssert {


    @Test
    public void test01(){

        // amazon anasayfaya gidin

        Driver.getDriver().get("https://www.amazon.com");

        // amazon anasayfaya gittiginizi doğrulayin.
        SoftAssert softAssert=new SoftAssert();
        String expectedUrlKelime="amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains(expectedUrlKelime),"Url amazon icermiyor");

        // nutella aratin
        AmazonPage amazonpage=new AmazonPage();
        amazonpage.amazonAramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // arama sonuclarinin nutella icerdigini dogrulayin.
        String aramaSonucYazisi=amazonpage.aramaSonucuElementi.getText();
        softAssert.assertTrue(aramaSonucYazisi.contains("Nutella"),"arama sonuclari nutella icermiyor");

        // Java aratin.

        amazonpage.amazonAramaKutusu.clear();
        amazonpage.amazonAramaKutusu.sendKeys("Java"+ Keys.ENTER);

        ReusableMEthods.bekle(3);

        // Arama sonuclarinin 1000'den fazla oldugunu dogrulayin.

        // 1-48 of over, 6,000 results for "Java"

        aramaSonucYazisi=amazonpage.aramaSonucuElementi.getText();

        String[] sonucArr=aramaSonucYazisi.split("");
       // [1-48, of, over, 6,000, results, for, "Java"]

        String javaSonucSayisiStr=sonucArr[3]; //6,000

        javaSonucSayisiStr=javaSonucSayisiStr.replaceAll("\\W",""); //6000

        int sonucSayisiInt=Integer.parseInt(javaSonucSayisiStr);

        softAssert.assertTrue(sonucSayisiInt>1000, "java icin arama sayisi 1000'den cok degil");










        softAssert.assertAll(); // raporla demek
        Driver.closeDriver();
    }
}
