package tests.day_014testNGFrameWork;

import org.testng.annotations.Test;

public class C01_TestNGilkTest {

    // Test NG isim sırasına göre calistirir.
   // prioriyt degeri verilen methotlar kucukten buyuge dopru calisir.
    // esit olan da harf sirasına bakar
    // eger priority degeri yazmazsak priority=0 kabul edilir.


    @Test(priority = 6)
    public void ilkTest(){

        System.out.println("ilk test calisti");
    }

    @Test (priority = 40)
    public void ikinciTest(){
        System.out.println("ikinci test calisti");
    }

    @Test(priority = -9)
    public void ucuncutest(){
        System.out.println("ucuncu test calisti");
    }
}

