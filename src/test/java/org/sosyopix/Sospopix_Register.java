package org.sosyopix;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
public class Sospopix_Register  extends SeleniumMethods{
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\SeleniumTraning\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver,15);
        driver.manage().window().maximize();
    }
    @Test
    public void case0(){
        //SospopixRegisterHappyPathRegistered
        //e mail registered olduğu için zaten kayıtlı mesajını isDisplayed edilmesi
        driver.get("https://www.sosyopix.com/uye-ol");
        SENDKEYS(By.id("Name"),"Meriç BACAK");
        SENDKEYS(By.id("Email"),"mericbacak@gmail.com");
        SENDKEYS(By.id("Password"),"123456789");
        SENDKEYS(By.id("RePassword"),"123456789");
        FINDELEMENT(By.id("acceptKvkkLabel")).click();
        FINDELEMENT(By.id("acceptLabel")).click();
        FINDELEMENT(By.id("acceptKvkkLabel")).click();
        FINDELEMENT(UyeolElement).isDisplayed();
        clickElement(UyeolElement);
        String windhandleBefore=driver.getWindowHandle();
        for (String winHandle:driver.getWindowHandles()){
            System.out.println("**Handle: "+winHandle);
            if(!windhandleBefore.equals(winHandle))
                driver.switchTo().window(winHandle);
        }
        FINDELEMENT(KapatButtonElement).isDisplayed();
        if(FINDELEMENT(KapatButtonElement).isDisplayed()){
            System.out.println("Kapat Butonu Görüntülendi");
        }
        FINDELEMENT(AlreadyRegistered).isDisplayed();
        clickElement(KapatButtonElement);
        FINDELEMENT(ZatenUyeyim).isDisplayed();
    }
    @Test
    public void case1(){
        //SosyopixRegisterNameFieldCheck
        driver.get("https://www.sosyopix.com/uye-ol");
        SENDKEYS(By.id("Name"),"ab");
        SENDKEYS(By.id("Email"),"mericbacak@gmail.com");
        SENDKEYS(By.id("Password"),"123456789");
        SENDKEYS(By.id("RePassword"),"123456789");
        clickElement(By.id("acceptKvkkLabel"));
        clickElement(By.id("acceptLabel"));
        clickElement(By.id("acceptKvkkLabel"));
        clickElement(UyeolElement);
        FINDELEMENT(AdSoyodAdUyarıElement).isDisplayed();
    }
    @Test
    public void case2(){
        //SosyopixRegisterEmailFieldCheck
        driver.get("https://www.sosyopix.com/uye-ol");
        SENDKEYS(By.id("Name"),"Meriç Bacak");
        SENDKEYS(By.id("Email"),"ab");
        SENDKEYS(By.id("Password"),"123456789");
        SENDKEYS(By.id("RePassword"),"123456789");
        FINDELEMENT(By.id("acceptKvkkLabel")).click();
        FINDELEMENT(By.id("acceptLabel")).click();
        FINDELEMENT(By.id("acceptKvkkLabel")).click();
        FINDELEMENT(UyeolElement).isDisplayed();
        clickElement(UyeolElement);
        FINDELEMENT(emailUyarıElement).isDisplayed();
    }
    @Test
    public void case3(){
        //SosyopixRegisterPassWordFieldCheck
        //minium value
        driver.get("https://www.sosyopix.com/uye-ol");
        SENDKEYS(By.id("Name"),"Meriç Bacak");
        SENDKEYS(By.id("Email"),"mericbacak@gmail.com");
        SENDKEYS(By.id("Password"),"12");
        SENDKEYS(By.id("RePassword"),"12");
        FINDELEMENT(By.id("acceptKvkkLabel")).click();
        FINDELEMENT(By.id("acceptLabel")).click();
        FINDELEMENT(By.id("acceptKvkkLabel")).click();
        FINDELEMENT(UyeolElement).isDisplayed();
        clickElement(UyeolElement);
        FINDELEMENT(ŞifreUyarı).isDisplayed();
        SENDKEYS(By.id("Password"),"123123123123123123123123123123123123123132132132123123123132132133");
        SENDKEYS(By.id("RePassword"),"123123123123123123123123123123123123123132132132123123123132132133");
        clickElement(UyeolElement);
        FINDELEMENT(ŞifreUyarı).isDisplayed();
    }
    @Test
    public void case4() {
        //SosyopixRegisterPassWordFieldCheck
        //şifre eşleşmedi
        driver.get("https://www.sosyopix.com/uye-ol");
        SENDKEYS(By.id("Name"),"Meriç Bacak");
        SENDKEYS(By.id("Email"),"mericbacak@gmail.com");
        SENDKEYS(By.id("Password"),"123465798000");
        SENDKEYS(By.id("RePassword"),"1234567980");
        FINDELEMENT(By.id("acceptKvkkLabel")).click();
        FINDELEMENT(By.id("acceptLabel")).click();
        FINDELEMENT(By.id("acceptKvkkLabel")).click();
        FINDELEMENT(UyeolElement).isDisplayed();
        clickElement(UyeolElement);
        FINDELEMENT(PassDidntMatch).isDisplayed();

    }
    @Test
    public void case5() {
        //Üye olmak için sözleşmeyi onaylaman gerekiyor. hatası is displayed yaptırma
        driver.get("https://www.sosyopix.com/uye-ol");
        SENDKEYS(By.id("Name"),"Meriç Bacak");
        SENDKEYS(By.id("Email"),"mericbacak@gmail.com");
        SENDKEYS(By.id("Password"),"123465789");
        SENDKEYS(By.id("RePassword"),"132465789");
        FINDELEMENT(UyeolElement).isDisplayed();
        clickElement(UyeolElement);
        FINDELEMENT(SozlemeOnay).isDisplayed();
    }

    @After
    public void close() throws InterruptedException {
        driver.close();
        driver.quit();
    }
}