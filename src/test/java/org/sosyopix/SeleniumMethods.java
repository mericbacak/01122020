package org.sosyopix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumMethods {
    public By UyeolElement=By.xpath("//button[@class='button normal orange shadow click-enter processing' and text()='Üye Ol']");
    public By KapatButtonElement=By.xpath("//a[@class='close-modal' and text()='Kapat']");
    public By AlreadyRegistered=By.xpath("//span[@class='msg'and text()='Bu kullanıcı zaten kayıtlı']");
    public By ZatenUyeyim=By.xpath("//span[@class='text' and text()='Zaten üyeyim ']");
    public By AdSoyodAdUyarıElement=By.xpath("//span[@class='field-validation-valid text-danger' and text()='Adını ve Soyadını aralarında boşluk bırakarak yazabilir misin?']");
    public By emailUyarıElement=By.xpath("//span[@class='field-validation-valid text-danger' and text()='E-posta adresini kontrol edip tekrar deneyebilir misin?']");
    public By ŞifreUyarı=By.xpath("//span[@class='field-validation-valid text-danger' and text()='Şifre 5 ve 50 arasında karakter uzunluğunda olmalı.']");
    public By PassDidntMatch=By.xpath("//span[@class='field-validation-valid text-danger' and text()='Şifreler eşleşmedi :( Tekrar deneyebilir misin?']");
    public By SozlemeOnay=By.xpath("//span[@id='nacceptInfo' and text()='Üye olmak için sözleşmeyi onaylaman gerekiyor.']");
    public WebDriver driver;
    public WebDriverWait wait;

    public void SelectMethod() {
        Select select = new Select(driver.findElement(By.id("")));
        select.selectByValue("");
    }
    public WebElement FINDELEMENT(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElement(by);
    }
    public void SENDKEYS(By by,String text){
       FINDELEMENT(by).sendKeys(text);
    }
    public void clickElement(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        FINDELEMENT(by).click();
    }
}
