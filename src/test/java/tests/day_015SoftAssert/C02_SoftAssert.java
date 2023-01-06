package tests.day_015SoftAssert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZerowebAppPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class C02_SoftAssert {

    @Test
    public void test01(){

        /*
        1. “http://zero.webappsecurity.com/” Adresine gidin
        2. Sign in butonuna basin
        3. Login kutusuna “username” yazin
         4. Password kutusuna “password” yazin
        5. Sign in tusuna basin
        6. Online banking menusu icinde Pay Bills sayfasina gidin
        7. “Purchase Foreign Currency” tusuna basin
         8. “Currency” drop down menusunden Eurozone’u secin
        9. soft assert kullanarak “Eurozone (euro)” secildigini test edin
        10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin “Select One”,
 “Australia (dollar)“, “Canada (dollar)“,”Switzerland (franc)“,”China (yuan)“,
 ”Denmark (krone)“,”Eurozone (euro)“,”Great Britain (pound)“,”Hong Kong (dollar)“,
 ”Japan (yen)“,”Mexico (peso)“,”Norway (krone)“,”New Zealand (dollar)“,
 ”Sweden (krona)“,”Singapore (dollar)“,”Thailand (baht)”
         */





        Driver.getDriver().get("https://zero.webappsecurity.com/");


        ZerowebAppPage zerowebAppPage=new ZerowebAppPage();
        zerowebAppPage.signInButonu.click();


        zerowebAppPage.userNameKutusu.sendKeys("username");


        zerowebAppPage.userPassword.sendKeys("password");


        zerowebAppPage.signInSubmitButonu.click();



        // 6. Online banking menusu icinde Pay Bills sayfasina gidin
        Driver.getDriver().navigate().back(); // geri
        zerowebAppPage.onlineBanking.click();
        zerowebAppPage.payBillLink.click();


        //  7. “Purchase Foreign Currency” tusuna basin

        zerowebAppPage.purchaseFCButonu.click();

        //  8. “Currency” drop down menusunden Eurozone’u secin
        Select select=new Select(zerowebAppPage.currencydropDown);
        select.selectByVisibleText("Eurozone (euro)");


        // 9. soft assert kullanarak “Eurozone (euro)” secildigini test edin

        SoftAssert softAssert=new SoftAssert();
        String actualDropDownSecim=select.getFirstSelectedOption().getText();
        String expectedDropDownSecim="Eurozone (euro)";
        softAssert.assertEquals(actualDropDownSecim,expectedDropDownSecim,"eurozone secimi testi failed");


        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin

        //“Select One”,
        // “Australia (dollar)“, “Canada (dollar)“,”Switzerland (franc)“,”China (yuan)“,
        // ”Denmark (krone)“,”Eurozone (euro)“,”Great Britain (pound)“,”Hong Kong (dollar)“,
        // ”Japan (yen)“,”Mexico (peso)“,”Norway (krone)“,”New Zealand (dollar)“,
        // ”Sweden (krona)“,”Singapore (dollar)“,”Thailand (baht)”


        List<WebElement> optionsElemntListesi=select.getOptions();
        List<String> actualOptionsListesStr=new ArrayList<>();

        for (WebElement each:optionsElemntListesi
             ) {
            actualOptionsListesStr.add(each.getText());
        }

        String[] arr={"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"};
        List<String> expectedOptionsListesi= Arrays.asList(arr);
        Collections.sort(actualOptionsListesStr);
        Collections.sort(expectedOptionsListesi);
        softAssert.assertEquals(actualOptionsListesStr,expectedOptionsListesi);








        softAssert.assertAll();
        Driver.closeDriver();


    }
}
