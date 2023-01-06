package tests.day_014testNGFrameWork;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C04_HardAssert {

    // Test NG'de iki tane assert class'i var
    //1. si Junitteki asssert ile aynı methodlara sahiptir.
    //ilk failed olan assert isleminde calismayi durdurur ve hata mesaji verir.

    //2. Assert classi'nin adi SoftAssert oldugu icin ilkine hard assert denmistir.

    // 2 . assert class'i ise soft assert classi'dir.
    // SoftAssert biz raporla diyinceye kadar assertionlari failed olsa bile calistirmaya devam eder.
    // biz raporla dedigimizde calisan assertionlardan kacinin failed oldugunu sçyler ve failed olan
    // assertion varsa raporla dedigimiz satirda calismayi durdurur.

    @Test
    public void test01(){

        Assert.assertTrue(6>4);
        System.out.println("1.assertion sonrasi");
        Assert.assertTrue(6>14);
        System.out.println("2.assertion sonrasi"); // assertion failed oldu geriye kalan ignore edildi.
        Assert.assertEquals(6,6);
        System.out.println("3. assertion sonrasi");
    }
}
