package PageObjectModels;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.testng.reporters.jq.BasePanel.C;

public class NopCommerceSalesPages {

    WebDriver driver;

    public NopCommerceSalesPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ("i.fa.fa-shopping-cart"))
    WebElement Click_Sales;

    public WebElement Click_Sales() {
        return Click_Sales;
    }

    @FindBy(xpath = ("/html/body/div[3]/div[2]/div/ul/li[3]/ul/li[1]/a/span"))
    WebElement Click_orders;

    public WebElement Click_orders() {
        return Click_orders;
    }

    @FindBy(name = ("checkbox_orders"))
    WebElement Click_CheckBox;

    public WebElement Click_CheckBox() {

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.name("checkbox_orders"))).build().perform();
        driver.findElement(By.name("checkbox_orders")).click();
        return Click_CheckBox;
    }

    @FindBy(xpath = ("//a[@class=\"btn btn-default\"]"))
    WebElement Click_View;

    public WebElement Click_View() {
        return Click_View;
    }

    @FindBy(name = ("btnChangeOrderStatus"))
    WebElement Click_ChangeStatus;

    public WebElement Click_ChangeStatus() {
        return Click_ChangeStatus;
    }

    @FindBy(id = ("OrderStatusId"))
    WebElement Click_SelectOption;

    public WebElement Click_SelectOption() {
        driver.findElement(By.id("OrderStatusId")).click();
        Select select = new Select(Click_SelectOption);
        select.selectByVisibleText("Processing");
        return Click_SelectOption;
    }

    public void Click_Save() {

        driver.findElement(By.xpath("//button[@id=\"btnSaveOrderStatus\"]")).click();
    }

    public void PopUp() {

        driver.findElement(By.xpath("/html/body")).click();

    }

    public void Pops() {

        driver.findElement(By.xpath("/html/body")).click();
    }

    @FindBy(id = ("refundorderoffline"))
    WebElement Click_Refund;

    public WebElement Click_Refund() {
        return Click_Refund;
    }


    @FindBy(id = ("partiallyrefundorderoffline"))
    WebElement Click_PartialRefund;

    public WebElement Click_PartialRefund() {

        return Click_PartialRefund;
    }

    public void Add_OrderNote() {
        driver.findElement(By.id("addOrderNote")).click();
    }

    public void Manage_PopUp() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void Click_AttachedFile() {
        driver.findElement(By.id("AddOrderNoteHasDownload")).click();
    }

    public void Upload_File() {
        driver.findElement(By.name("qqfile")).sendKeys("C:\\Users\\basny_gg\\OneDrive\\Documents.png");
    }


    public void drawBorder(String element, WebDriver driver) {
        driver.findElement(By.xpath("//*[@id=\"order-billing-shipping\"]/div[1]/span"));
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("arguments[0].style.border='3px solid red'", element);

    }

    public void changecolor(String color, WebElement element, WebDriver driver) { // highlight the background color
       driver.findElement(By.xpath("//*[@id=\"order-billing-shipping\"]/div[2]/div/div[1]/div/div[1]/div[1]/table/tbody/tr[1]-"));
        JavascriptExecutor jse = ((JavascriptExecutor)driver);
        jse.executeScript("arguments[0].style.backgroundcolor = " +color+"'", element);


    }


}

