package org.gtStep;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.gtStep.Contants.*;
public class BankamizBannerControls extends SeleniumMethods {
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","properties\\driver\\chromedriver87.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);
    }
    @Test
    public void CaseSteps() throws InterruptedException {
        driver.get(HalkBankBankamiz);
        FindElement(By.xpath(GenelMudurdenMesajBanneri)).isDisplayed();
        Assert.assertEquals(gettext(By.xpath(GenelMudurdenMesajBanneri)),"Genel Müdür'den Mesaj");
        FindElement(By.xpath(GenelMudurdenMesajDevami)).isDisplayed();
        FindElement(By.xpath(GenelMudurdenMesajDevami)).click();
        Assert.assertEquals(driver.getCurrentUrl(),GenelMudurdenMesajlink);
        FindElement(By.xpath(GenelMüdürdenMesajBaslik)).isDisplayed();
        Assert.assertEquals(gettext(By.xpath(GenelMüdürdenMesajBaslik)),"Genel Müdür'den Mesaj");
        driver.navigate().back();

        FindElement(By.xpath(YatirimciiliskileriBanneri)).isDisplayed();
        Assert.assertEquals(gettext(By.xpath(YatirimciiliskileriBanneri)),"Yatırımcı İlişkileri");
        FindElement(By.xpath(YatirimciiliskileriDevamiButonu)).isDisplayed();
        FindElement(By.xpath(YatirimciiliskileriDevamiButonu)).click();
        Assert.assertEquals(driver.getCurrentUrl(),Yatirimciiliskileridevamilink);
        FindElement(By.xpath(YatirimciiliskileriDevamiBaslik)).isDisplayed();
        Assert.assertEquals(gettext(By.xpath(YatirimciiliskileriDevamiBaslik)),"Üçüncü çeyrekte de sektörün ikinci büyük bankası yine Halkbank oldu");
        driver.navigate().back();

        FindElement(By.xpath(HaberlerDuyurular)).isDisplayed();
        Assert.assertEquals("Haberler/Duyurular",FindElement(By.xpath(HaberlerDuyurular)).getText());
        FindElement(By.xpath(HaberlerDuyurularDevam)).isDisplayed();
        FindElement(By.xpath(HaberlerDuyurularDevam)).click();
        FindElement(By.xpath(HaberlerDuyurularDevamiTitle)).isDisplayed();
        Assert.assertEquals(HaberlerDuyurularDevamiTitleText,FindElement(By.xpath(HaberlerDuyurularDevamiTitle)).getText());
        driver.navigate().back();

        FindElement(By.xpath(InsanKaynaklariBannerTitle)).isDisplayed();
        FindElement(By.xpath(InsanKaynaklariDevamiButton)).isDisplayed();
        FindElement(By.xpath(InsanKaynaklariDevamiButton)).click();
        FindElement(By.xpath(InsankaynaklariDevamiPageVeriyText)).isDisplayed();
        String VerifyText= FindElement(By.xpath(InsankaynaklariDevamiPageVeriyText)).getText();
        Assert.assertEquals(VerifyText,FindElement(By.xpath(InsankaynaklariDevamiPageVeriyText)).getText());
    }


    @After
    public void close() throws InterruptedException {
        driver.close();
        driver.quit();
    }
}
