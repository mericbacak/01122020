package org.sosyopix;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class SosyopixCategoryTitleConctrol {
    public WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\Sosyopix_Demos_Meric\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void case1() {
        driver.navigate().to("https://www.sosyopix.com/");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Sosyopix 🧡 Anılarına Dokun");

        driver.navigate().to("https://www.sosyopix.com/hediye");
        String title1 = driver.getTitle();
        Assert.assertEquals(title1, "Hediye, 🎁 En Özel & En Anlamlı Kişiye Özel Hediyeler 💝| Sosyopix");


        driver.navigate().to("https://www.sosyopix.com/fotograf-baski");
        String title2 = driver.getTitle();
        Assert.assertEquals(title2, "Fotoğraf Baskı, Kişiye Özel Fotoğraf Albümleri, Online Fotoğraf Çıkartma | Sosyopix");

        driver.navigate().to("https://www.sosyopix.com/takvim");
        String title3 = driver.getTitle();
        Assert.assertEquals(title3, "Takvim & En Güzel ve Kişiye Özel Fotoğraf Baskılı Takvimler | Sosyopix");

        driver.navigate().to("https://www.sosyopix.com/album");
        String title4 = driver.getTitle();
        Assert.assertEquals(title4, "Fotoğraf Albümü & Anı Kitapları, En Güzel Fotoğraf Albümleri | Sosyopix");

        driver.navigate().to("https://www.sosyopix.com/kanvas-tablo");
        String title5 = driver.getTitle();
        Assert.assertEquals(title5, "Kanvas Tablo, Kişiye Özel Fotoğraflı ve Parçalı Kanvas Tablolar | Sosyopix");


        driver.navigate().to("https://www.sosyopix.com/magnetler");
        String title6 = driver.getTitle();
        Assert.assertEquals(title6, "Foto Magnetler & Kişiye Özel Resimli Magnet Fiyatları | Sosyopix");

        driver.navigate().to("https://www.sosyopix.com/metal-baskilar");
        String title7 = driver.getTitle();
        Assert.assertEquals(title7, "Metal Baskılar, Kişiye Özel ve Hediyelik Fotoğraflı Metal Baskı | Sosyopix");

        driver.navigate().to("https://www.sosyopix.com/duvar-dekorasyonu");
        String title8 = driver.getTitle();
        Assert.assertEquals(title8, "Duvar Dekorasyonu & En Güzel ve Özel Duvar Dekorları | Sosyopix");

        driver.navigate().to("https://www.sosyopix.com/poster");
        String title9 = driver.getTitle();
        Assert.assertEquals(title9, "Poster Baskı, Kişiye Özel Online Poster Yaptırma Uygun Fiyatlarla | Sosyopix");

        driver.navigate().to("https://www.sosyopix.com/aksesuarlar");
        String title10 = driver.getTitle();
        Assert.assertEquals(title10, "Aksesuar - Sosyopix");

        driver.navigate().to("https://www.sosyopix.com/gulen-gozler");
        String title11 = driver.getTitle();
        Assert.assertEquals(title11, "Gülen Gözler :) %100 Mutluluk - Sosyopix.com");
    }

    @After
    public void close() throws InterruptedException {
        driver.close();
        driver.quit();
    }
}
