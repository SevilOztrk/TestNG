package tests.day_014testNGFrameWork;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C02_DependsOnMethods {

    @Test // direk önce bu calissin dersen priority verirsin.
    public void ilkTest(){

        System.out.println("ilk test calisti");
       // Assert.assertTrue(5>8); // bu failed olunca digerlerini direk ignore eder.
        // baglı olan test passed olursa digeri calisir yoksa calismaz.
    }

    @Test (dependsOnMethods = "ilkTest")
    public void ikinciTest(){
        System.out.println("ikinci test calisti");
    }

    @Test(dependsOnMethods = "ikinciTest")
    public void ucuncutest(){
        System.out.println("ucuncu test calisti");
    }
}
