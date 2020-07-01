package PageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddShippingPage {
    WebDriver driver;

    public AddShippingPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = ("/html/body/div[3]/div[2]/div/ul/li[7]/a/i[2]"))
    WebElement click_configuration;

    public WebElement getClick_configuration(){
        return click_configuration;
    }

    @FindBy(xpath = ("/html/body/div[3]/div[2]/div/ul/li[7]/ul/li[11]/a/i[2]"))
    WebElement Click_Shipping;
public WebElement Click_Shipping(){
    return Click_Shipping;
}
@FindBy(xpath = ("/html/body/div[3]/div[2]/div/ul/li[7]/ul/li[11]/ul/li[2]/a/span"))
    WebElement Click_Warehouse;
public WebElement Click_Warehouse(){
    return Click_Warehouse;
}
@FindBy(xpath = ("//a[@href=\"/Admin/Shipping/CreateWarehouse\"]"))
    WebElement Click_Addnew;
public WebElement Click_Addnew(){
    return Click_Addnew;
}
 @FindBy(name = ("save"))
    WebElement Click_Save;
public WebElement Click_Save(){
    return Click_Save;
}
@FindBy(id = ("Address_Address1"))
WebElement Type_Adress;
public WebElement Type_Adress(){
    driver.findElement(By.id("Address_Address1")).sendKeys("2223 WalnutHill Ln");
    return Type_Adress;
}
@FindBy(id = ("Address_ZipPostalCode"))
 WebElement Type_PostalCode;
public WebElement Type_PostalCode(){
    driver.findElement(By.id("Address_ZipPostalCode")).sendKeys("75237");
    return Type_PostalCode;
}
@FindBy(id = ("AdminComment"))
WebElement Type_AddminComment;
public WebElement Type_AddminComment(){
    driver.findElement(By.id("AdminComment"))
            .sendKeys("Thank You for Joining to us, will see next Visit.");
    return Type_AddminComment;
}
@FindBy(id = ("Address_PhoneNumber"))
WebElement Type_PhoneNumber;
public WebElement Type_PhoneNumber(){
    driver.findElement(By.id("Address_PhoneNumber")).sendKeys("++1-817-888-4703");
    return Type_PhoneNumber;
}
@FindBy(id = ("Name"))
WebElement Type_Name;
public WebElement Type_Name(){
    driver.findElement(By.id("Name")).sendKeys("Nameste Grill and Bar");
    return Type_Name;
}


}
