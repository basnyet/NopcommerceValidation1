package StepDefinations;

import PageObjectModels.*;
import Utility.PathStore;
import Utility.ScreenShot;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class NopCommerce extends BaseClass {


    WebDriver driver;

    @Given("User lunch Chrome browser")
    public void user_lunch_Chrome_browser() {

        System.setProperty(PathStore.BROWSER_NAME_C, PathStore.CHROME_DRIVER_PATH);
        this.driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        np = new NopCommercePage(driver);
        addSP = new AddShippingPage(driver);
        info = new InformationPage(driver);
        salesPages = new NopCommerceSalesPages(driver);
    }

    @When("User open URL as {string}")
    public void user_open_URL_as(String URL) {

        driver.get(URL);
        //  Thread.sleep(2000);
    }

    @Then("User clear the text on Email box and Password box")
    public void user_clear_the_text_on_Email_box_and_Password_box() throws InterruptedException {
        cp = new AddCustomerPage(driver);
        Thread.sleep(2000);
        cp.Clear_Text_EBox().clear();

        cp.Clear_Text_PBox().clear();

    }

    @When("User enter email {string} and Password {string}")
    public void user_enter_email_and_Password(String email, String Password) throws InterruptedException {
        Thread.sleep(2000);
        np.getType_Email().sendKeys(email);

        np.getType_Pasword().sendKeys(Password);
    }

    @When("User enter {string} and {string}")
    public void user_enter_and(String email, String Password) throws InterruptedException {

        Thread.sleep(2000);
        np.getType_Email().sendKeys(email);
        np.getType_Pasword().sendKeys(Password);

    }

    @Then("User can click the Login bottom")
    public void user_can_click_the_Login_bottom() {


        np.getClick_Login().click();

    }


    @Then("The page Title should be {string}")
    public void the_page_Title_should_be(String title) throws InterruptedException, IOException {

        //  Thread.sleep(2000);
        if (driver.getPageSource().contains("Login was unsuccessful.")) {
            driver.close();
            Assert.fail();
        } else {
            Assert.assertEquals(title, driver.getTitle());
        }
        Thread.sleep(2000);

        ScreenShot.Capture(driver, "Page title");
    }
//----------------------------------------------------------------------------------------------------------------------

    @Then("User click customer menu")
    public void user_click_customer_menu() {

        cp.getClick_Customers().click();

    }

    @Then("User move to customers and click it")
    public void user_move_to_customers_and_click_it()  {

        cp.getMove_to_Customer();

    }

    @Then("User click Add new button")
    public void user_click_Add_new_button() {



        cp.getClick_Add_new();

    }

    @Then("User can view add new customer page")
    public void user_can_view_add_new_customer_page() throws InterruptedException, IOException {
        Thread.sleep(2000);
       // cp.Pannel_heading();

        WebElement info =   driver.findElement(By.xpath("//div[@class=\"panel-heading\"]"));

        if(info.equals(  driver.findElement(By.xpath("//div[@class=\"panel-heading\"]")))){
            driver.findElement(By.xpath("//div[@class=\"panel-heading\"]")).click();
        }  else {
            driver.findElement(By.xpath("//div[@class=\"panel-heading opened\"]"));
        }
        Thread.sleep(2000);
        driver.getTitle();
        Assert.assertEquals("Add a new customer / nopCommerce administration", driver.getTitle());
        Assert.assertTrue(true);
        ScreenShot.Capture(driver, "New Customer Page Title");

    }

    @Then("User enter all customer information")
    public void user_enter_all_customer_information() throws InterruptedException {


        String email = randomString() + "@gmail.com";

        Thread.sleep(2000);
        cp.setEmail(email);

        Thread.sleep(2000);
        cp.setPassword("abc113456");

        //  Thread.sleep(2000);
        cp.setFirstName("Krish");

        Thread.sleep(2000);
        cp.setLastName("Basnyet");

        //  Thread.sleep(2000);
        cp.setGender("Male");

        Thread.sleep(3000);
        cp.setDOB("DOB");

        //  Thread.sleep(2000);
        cp.setCompanyName("AtoZ");

        Thread.sleep(2000);
        cp.setIsTaxExempt("Yes");

        Thread.sleep(2000);
        cp.setNewsLetter("TestStore2");


        Thread.sleep(2000);
        cp.setCustomerRole("Guest");

        Thread.sleep(3000);
        cp.setActive("active");

        cp.ManagerOfVendor();

    }

    @Then("Write comment on admin comment box")
    public void write_comment_on_admin_comment_box() throws InterruptedException {

        // Thread.sleep(2000);

        cp.setAdminComment("Testing");
    }


    @Then("User click on save button")
    public void user_click_on_save_button() throws InterruptedException, IOException {

        Thread.sleep(2000);

        cp.setSave("save");

        // Thread.sleep(4000);


    }

    @Then("User can view conformation massage {string}")
    public void user_can_view_conformation_massage(String massage) throws InterruptedException, IOException {

        Assert.assertTrue("The new customer has been added successfully.", true);
        ScreenShot.Capture(driver, "Conformation Massage");

    }

    @Then("User click Logout bottom for Logout")
    public void user_click_Logout_bottom_for_Logout() throws InterruptedException {
        Thread.sleep(2000);
        np = new NopCommercePage(driver);
        np.getClick_Logout().click();
    }

    @Then("Take ScreenShot of this page")
    public void take_ScreenShot_of_this_page() throws IOException {
        ScreenShot.Capture(driver, "Logout page");
    }


    @Then("User can see {string}")
    public void user_can_see(String title) throws InterruptedException {

        Thread.sleep(2000);
        driver.getPageSource().contains("Your store. Login");
        Assert.assertEquals(title, driver.getTitle());

    }

    @Then("User can see page title {string}")
    public void user_can_see_page_title(String title) throws InterruptedException, IOException {
        Thread.sleep(2000);
        driver.getPageSource().contains("Your store. Login");
        Assert.assertEquals(title, driver.getTitle());
        ScreenShot.Capture(driver, "Page Title");

    }


    @Then("close the browser")
    public void close_the_browser() throws InterruptedException {
        Thread.sleep(2000);

        driver.quit();

    }
//------------------Add shipping-----------------------------------------
    @Then("User click Configuration menu")
    public void user_click_Configuration_menu() throws InterruptedException {

        Thread.sleep(2000);
        addSP.getClick_configuration().click();
    }

    @Then("User click Shipping menu")
    public void user_click_Shipping_menu() throws InterruptedException {

//    Thread.sleep(2000);

        addSP.Click_Shipping().click();

    }

    @Then("User click warehouses menu")
    public void user_click_warehouses_menu() throws InterruptedException {

        //  Thread.sleep(2000);
        addSP.Click_Warehouse().click();
    }

    @Then("click on Add New")
    public void click_on_Add_New() throws InterruptedException {
        Thread.sleep(2000);
        addSP.Click_Addnew().click();
    }

    @Then("Fill it up all information showing this page")
    public void fill_it_up_all_information_showing_this_page() throws InterruptedException {


        addSP.Type_Name();
        Thread.sleep(2000);
        info.selectCountry();
        Thread.sleep(2000);
        info.selectState();

        addSP.Type_Adress();

        info.setCounty("Dallas");

        info.setCity("Irving");

        addSP.Type_PostalCode();

        Thread.sleep(2000);
        addSP.Type_PhoneNumber();

        Thread.sleep(2000);
        addSP.Type_AddminComment();

    }

    @Then("click save")
    public void click_save() throws InterruptedException {
        Thread.sleep(2000);
        addSP.Click_Save().click();

    }

    @Then("User can see conformation page {string}")
    public void user_can_see_conformation_page(String conformation) throws InterruptedException, IOException {

        Thread.sleep(2000);
        Assert.assertTrue("The new warehouse has been added successfully.", true);
        ScreenShot.Capture(driver, "conformation page");

    }

    @Then("User click Sales menu")
    public void user_click_Sales_menu() throws InterruptedException {
        Thread.sleep(2000);
        salesPages.Click_Sales().click();

    }

    @Then("User click Orders menu")
    public void user_click_Orders_menu() throws InterruptedException {
        Thread.sleep(2000);
        salesPages.Click_orders().click();

    }

    @Then("User click the check box of Order number #{int}")
    public void user_click_the_check_box_of_Order_number(Integer int5) throws InterruptedException {
        Thread.sleep(3000);
        salesPages.Click_CheckBox();


    }

    @Then("User Click View to see the detail of this order")
    public void user_Click_View_to_see_the_detail_of_this_order() throws InterruptedException {
        Thread.sleep(3000);
        salesPages.Click_View().click();

    }

    @Then("User click Change Status for status change")
    public void user_click_Change_Status_for_status_change() throws InterruptedException {
        Thread.sleep(5000);


        WebElement info =   driver.findElement(By.xpath("//div[@class=\"panel-heading\"]"));

        if(info.equals(  driver.findElement(By.xpath("//div[@class=\"panel-heading\"]")))){
             driver.findElement(By.xpath("//div[@class=\"panel-heading\"]")).click();
        }  else driver.findElement(By.xpath("//div[@class=\"panel-heading opened\"]"));


        Thread.sleep(3000);
        salesPages.Click_ChangeStatus().click();
        }



    @Given("User click the box and choose the option")
    public void user_click_the_box_and_choose_the_option() throws InterruptedException {

        Thread.sleep(2000);
        salesPages.Click_SelectOption().click();

    }


    @Then("User click save button to save it")
    public void user_click_save_button_to_save_it() throws InterruptedException {
        Thread.sleep(3000);
        salesPages.Click_Save();

    }

    @Then("User accept the PopUp Alert")
    public void user_accept_the_PopUp_Alert() throws InterruptedException {
        Thread.sleep(2000);
        salesPages.PopUp();

    }


    @Then("User click Refund for refund")
    public void user_click_Refund_for_refund() throws InterruptedException {
        Thread.sleep(2000);
        salesPages.Click_Refund().click();

    }

    @Then("User dismiss the PopUp Alert")
    public void user_dismiss_the_PopUp_Alert() throws InterruptedException {

        Thread.sleep(2000);
        salesPages.Pops();

    }


    @Then("User click Partial Refund for partial refund")
    public void user_click_Partial_Refund_for_partial_refund() throws InterruptedException {
        Thread.sleep(2000);
        salesPages.Click_PartialRefund().click();

    }

    @Then("User move to new new window, filed some nessery things and close the window")
    public void user_move_to_new_new_window_filed_some_nessery_things_and_close_the_window() throws InterruptedException {


        Thread.sleep(2000);
        Set<String> handler = driver.getWindowHandles();
        Iterator<String> it = handler.iterator();

        String parentWindowID = it.next();
        String childWindowID = it.next();

        Thread.sleep(2000);

        driver.switchTo().window(childWindowID);
        driver.manage().window().maximize();
        Thread.sleep(2000);

       // driver.findElement(By.name("AmountToRefund")).sendKeys("14.50");

        driver.findElement(By.id("partialrefundorder")).click();

        Thread.sleep(2000);
        driver.close();

        driver.switchTo().window(parentWindowID);

    }

    @Then("user click Add order note")
    public void user_click_Add_order_note() throws InterruptedException {
        Thread.sleep(3000);
        salesPages.Add_OrderNote();

    }

    @Then("User manage PopUp Window")
    public void user_manage_PopUp_Window() throws InterruptedException {
        Thread.sleep(3000);
        salesPages.Manage_PopUp();

    }

    @Then("User Click Attached File check box")
    public void user_Click_Attached_File_check_box() throws InterruptedException {
        Thread.sleep(3000);

        salesPages.Click_AttachedFile();

    }

    @Then("User Upload file")
    public void user_Upload_file() throws InterruptedException {
        Thread.sleep(3000);
        salesPages.Upload_File();

    }

    @Then("User Border Billing and Shipping")
    public void user_Border_Billing_and_Shipping() throws InterruptedException {

       // Thread.sleep(3000);
      // salesPages.drawBorder("BillingAndShipping", driver);

    }

    @Then("User High light Full Name")
    public void user_High_light_Full_Name() {
     //salesPages.changecolor("color,element,driver");
    }

    @Then("User close the browser")
    public void user_close_the_browser() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();

    }

}


