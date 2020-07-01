package PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

public class InformationPage {
    WebDriver driver;

    public InformationPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    String Country;

    public void selectCountry() {
      WebElement selectCountry =
        driver.findElement(By.id("Address_CountryId"));
       // driver.findElement(By.id("Address_CountryId"));


        Select select= new Select(selectCountry);
        select.selectByVisibleText("United States");

    }
    public void selectState(){
        WebElement selectState=
        driver.findElement(By.id("Address_StateProvinceId"));
        driver.findElement(By.id("Address_StateProvinceId")).click();

        Select select = new Select(selectState);
        select.selectByVisibleText("Texas");
    }



    String County;

    public void setCounty(String Dallas) {
        County = Dallas;
        driver.findElement(By.id("Address_County")).sendKeys(Dallas);
    }

    String city;

    public void setCity(String Irving) {
        city = Irving;
        driver.findElement(By.id("Address_City")).sendKeys(Irving);
    }

}



