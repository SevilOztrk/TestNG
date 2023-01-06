package tests.day_014testNGFrameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C03_NutellaTesti {



    @Test
    public void test01(){

        // amazon anasayfaya gidin
        // nutella icin arama yap
        //sonuclarin Nutella icerdigini test et.


        Driver.getDriver().get("https://www.amazon.com"); // failed olmamasi icin deger atamaliyiz yoksa sürekli yeni sayfa acar.


        //WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));

        AmazonPage amazonPage=new AmazonPage(); // amazonpage methodunu kullanmak icin obje olusturmaliyiz.
        amazonPage.amazonAramaKutusu.sendKeys("Nutella" + Keys.ENTER); // amazonpage objesi uzerinden gidip alıp geldik.


       // WebElement aramaSonucuElementi=Driver.getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedKelime="Nutella";
        String actualAramaSonucu=amazonPage.aramaSonucuElementi.getText();

        Assert.assertTrue(actualAramaSonucu.contains(expectedKelime));


        Driver.closeDriver();







    }



















    }
