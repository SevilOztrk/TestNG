package tests.day_014testNGFrameWork;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C05_SoftAssert {

    @Test(groups = "minireg1")
    public void test01(){

        // 1. adim softAssert objesi olustur.

        SoftAssert softAssert=new SoftAssert();

        //2 adim softAssert objesini kullanarak istenilen assertionlari yapin.

        softAssert.assertEquals(6,6); // Failed
        System.out.println("1. asssertion sonrasi");


        softAssert.assertTrue(5>3); // Passed
        System.out.println("2. assertion sonrasi");

        softAssert.assertFalse(3>5); // Failed
        System.out.println("3. assertion sonrasi");


        // 3.adim softAssert'e raporla diyecegiz.

        softAssert.assertAll(); // bu satirda calismayi durdurur. cunku failed olan assertion var.
        System.out.println("AssertAll sonrasi");
    }
}
