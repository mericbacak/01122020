package org.gtStep;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class SeleniumMethods {
  public WebDriver driver;
  public WebDriverWait wait;
  public WebElement FindElement(By by) {
    wait.until(ExpectedConditions.presenceOfElementLocated(by));
    wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    return driver.findElement(by);
  }
  public void Sendkeys(By by,String text){
    FindElement(by).sendKeys(text);
  }
  public void clickElement(By by){
    //görünür olması
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    //clickable olması
    wait.until(ExpectedConditions.elementToBeClickable(by));
    FindElement(by).click();
  }
  public void untilElementDisappear(By by){
    wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
  }
  public String gettext(By by){

    return FindElement(by).getText();
  }
  public String getAttribute(By by,String attrbname){

    return FindElement(by).getAttribute(attrbname);
  }
  public void YeniAcilanSekmeyiKapa(){
    ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(tabs2.get(1));
    driver.close();
    driver.switchTo().window(tabs2.get(0));
   }
  public void YeniAcilanSekmeyeOdaklan(){
    ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(tabs2.get(1));
  }

  @After
  public void close() throws InterruptedException {
    driver.close();
    driver.quit();
  }
}
