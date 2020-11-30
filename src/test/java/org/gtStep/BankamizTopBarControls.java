package org.gtStep;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.gtStep.Contants.*;

public class BankamizTopBarControls extends SeleniumMethods {
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
        FindElement(By.xpath(BankamizBiziTaniyin)).isDisplayed();
        System.out.println(FindElement(By.xpath(BankamizBiziTaniyin)).getText());
        FindElement(By.xpath(BankamizKurumsalİletisim)).isDisplayed();
        System.out.println(FindElement(By.xpath(BankamizKurumsalİletisim)).getText());
        FindElement(By.xpath(BankamizSurdurulebilirlik)).isDisplayed();
        System.out.println(FindElement(By.xpath(BankamizSurdurulebilirlik)).getText());
        FindElement(By.xpath(BankamizOrtakliklar)).isDisplayed();
        System.out.println(FindElement(By.xpath(BankamizOrtakliklar)).getText());
        FindElement(By.xpath(BankamizSosyalMedya)).isDisplayed();
        System.out.println(FindElement(By.xpath(BankamizSosyalMedya)).getText());
        FindElement(By.xpath(BankamizIK)).isDisplayed();
        System.out.println(FindElement(By.xpath(BankamizIK)).getText());
        FindElement(By.xpath(Bankamiziletisim)).isDisplayed();
        System.out.println(FindElement(By.xpath(Bankamiziletisim)).getText());
    }


    @After
    public void close() throws InterruptedException {
        driver.close();
        driver.quit();
    }
}
