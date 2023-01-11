package tests.day18_htmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProvider {
    @DataProvider
    public static Object[][] AmazonAranacakKelimeler() {
        /*
        @DataProvider istedigimiz test methoduna test datası saglamak icin kullanilir.
        sadece bir sarti vardir,
        iki katli bir Object array'i dondurmelidir.
         */

        Object[][] amazonAranacakKelimelerArrayi={{"Nutella"}, {"Java"}, {"Apple"} };

        return amazonAranacakKelimelerArrayi;
    }

    // amazona git
    // Nutella, java, apple, kelimeri icin arama yapalim
    // sonuclarin bu kelimeleri icerdigini test edelim.


    @Test(dataProvider = "AmazonAranacakKelimeler")
    public void aramaTest(String aranacakKelime){

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        AmazonPage amazonpage=new AmazonPage();

        amazonpage.amazonAramaKutusu.sendKeys(aranacakKelime+ Keys.ENTER);

        String actualSonucYazisi=amazonpage.aramaSonucuElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(aranacakKelime));


    }
}
