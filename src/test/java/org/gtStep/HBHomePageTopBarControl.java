package org.gtStep;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.security.pkcs11.Secmod;

import static org.gtStep.Contants.*;

public class HBHomePageTopBarControl extends SeleniumMethods {

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
    driver.get(Halkbank);
    if(FindElement(By.xpath(HBimage)).isDisplayed()){

      System.out.println("HalkBank logosu görüntülendi");
    }
    else{
      System.out.println("Halkbank Logosu görüntülenmedi");
    }
    FindElement(By.xpath(anasayfaikon)).isDisplayed();
    FindElement(By.xpath(Bankamız)).isDisplayed();
    FindElement(By.xpath(Bankamız)).isEnabled();
    FindElement(By.xpath(Bireysel)).isDisplayed();
    FindElement(By.xpath(Kobi)).isDisplayed();
    FindElement(By.xpath(TicariKurumsal)).isDisplayed();
    FindElement(By.xpath(Yatırım)).isDisplayed();
    FindElement(By.xpath(DijitalBankacılık)).isDisplayed();
    FindElement(By.xpath(Yatırımcıİlişkileri)).isDisplayed();
    FindElement(By.xpath(ÜrünHizmetveÜcretleri)).isDisplayed();
    FindElement(By.xpath(ÜrünHizmetveÜcretleri)).click();
    //ürünhizmet ve ücretleri açılış sonrası kontrol
    Assert.assertEquals(driver.getCurrentUrl(),ÜrünHizmetveÜcretleriPage);
    if(FindElement(By.xpath(AlışverişFaizOranı)).isDisplayed()){
      System.out.println("ÜrünHizmetveÜcretleriPage açıldı");
    }
    else{
      System.out.println("ÜrünHizmetveÜcretleriPage sayfasında hata var");
    }
    FindElement(By.xpath(anasayfaikon)).click();
    FindElement(By.xpath(Bankamız)).click();
    FindElement(By.xpath(Bireysel)).click();
    FindElement(By.xpath(Kobi)).click();
    YeniAcilanSekmeyeOdaklan();
    FindElement(By.xpath(ParafKobiKart)).isDisplayed();
    Assert.assertEquals(FindElement(By.xpath(ParafKobiKart)).getText(),ParafKobiKartText);
    System.out.println(FindElement(By.xpath(ParafKobiKart)).getText());
    YeniAcilanSekmeyiKapa();

    FindElement(By.xpath(TicariKurumsal)).isDisplayed();
    FindElement(By.xpath(TicariKurumsal)).click();
    FindElement(By.xpath(TicariKurumsalAssertion)).isDisplayed();
    Assert.assertEquals(FindElement(By.xpath(TicariKurumsalAssertion)).getText(),TicariKurumsalAssertionText);
    System.out.println(FindElement(By.xpath(TicariKurumsalAssertion)).getText());
    FindElement(By.xpath(NakitYonetimiButton)).isDisplayed();
    FindElement(By.xpath(NakitYonetimiButton)).click();
    FindElement(By.xpath(TahsilatSistemleri)).isDisplayed();
    FindElement(By.xpath(TahsilatSistemleri)).click();
    FindElement(By.xpath(DBS)).isDisplayed();
    System.out.println("DBS text "+ FindElement(By.xpath(DBS)).getText());

    FindElement(By.xpath(Yatırım)).click();
    FindElement(By.xpath(DijitalBankacılık)).click();
    FindElement(By.xpath(anasayfaikon)).click();

    FindElement(By.xpath(KrediHesaplama)).isDisplayed();
    FindElement(By.xpath(ihtiyacKredi)).isDisplayed();
    FindElement(By.xpath(ihtiyacKredi)).click();
    Assert.assertEquals("1,77",gettext(By.xpath(ihtiyacKrediFaizOrani)));

    FindElement(By.xpath(tasitkredi)).isDisplayed();
    FindElement(By.xpath(tasitkredi)).click();
    Assert.assertEquals("1,77",gettext(By.xpath(tasitkrediFaizOrani)));

    FindElement(By.xpath(konutkredi)).isDisplayed();
    FindElement(By.xpath(konutkredi)).click();
    Assert.assertEquals("1,52",gettext(By.xpath(konutkrediFaizorani)));
  }

  @After
  public void close() throws InterruptedException {
    driver.close();
    driver.quit();
  }
}