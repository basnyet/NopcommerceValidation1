package StepDefinations;

import PageObjectModels.AddCustomerPage;
import PageObjectModels.NopCommercePage;
import Utility.ScreenShot;
import io.cucumber.java.en.*;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class NopCommerce extends BaseClass{


    WebDriver driver;
    @Given("User lunch Chrome browser")
    public void user_lunch_Chrome_browser()  {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
        this.driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);

        np= new NopCommercePage(driver);


    }

    @When("User open URL as {string}")
    public void user_open_URL_as(String URL)  {

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
    public void user_can_click_the_Login_bottom()  {


        np.getClick_Login().click();

    }


    @Then("The page Title should be {string}")
    public void the_page_Title_should_be(String title) throws InterruptedException, IOException {

      //  Thread.sleep(2000);
       if(driver.getPageSource().contains("Login was unsuccessful.")){
           driver.close();
           Assert.fail();
       }else{
           Assert.assertEquals(title,driver.getTitle());
       }
      //  Thread.sleep(4000);

        ScreenShot.Capture(driver,"Page title");
    }
//----------------------------------------------------------------------------------------------------------------------

    @Then("User click customer menu")
    public void user_click_customer_menu() throws InterruptedException {

      //  Thread.sleep(2000);
        cp.getClick_Customers().click();


    }

    @Then("User move to customers and click it")
    public void user_move_to_customers_and_click_it() throws InterruptedException {

       // Thread.sleep(2000);
       cp.getMove_to_Customer();

    }

    @Then("User click Add new button")
    public void user_click_Add_new_button() throws InterruptedException {

      //  Thread.sleep(2000);
      cp.getClick_Add_new();

    }

    @Then("User can view add new customer page")
    public void user_can_view_add_new_customer_page() throws InterruptedException {
       // Thread.sleep(2000);
        driver.getTitle();
        Assert.assertEquals("Add a new customer / nopCommerce administration",driver.getTitle());

    }

    @Then("User enter all customer information")
    public void user_enter_all_customer_information() throws InterruptedException {


        String email = randomString()+"@gmail.com";

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

        Thread.sleep(2000);
        cp.setDOB("DOB");

      //  Thread.sleep(2000);
        cp.setCompanyName("AtoZ");

       Thread.sleep(2000);
        cp.setIsTaxExempt("Yes");

//        Thread.sleep(2000);
//       cp.setNewsLetter("abc");
//
//        Thread.sleep(2000);
//        cp.setCustomerRole("guests");

//        Thread.sleep(2000);
//        cp.setActive("active");


      //  cp.setManagerOfVendor("Vandor2");


      //  Select select = new Select(WebElement);




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

        ScreenShot.Capture(driver,"Page Conformation");

    }

    @Then("User can view conformation massage {string}")
    public void user_can_view_conformation_massage(String massage) throws InterruptedException {

//        Thread.sleep(2000);
//        driver.get("massage");
//
//        Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissable\"]"))
//                        .getText().contains("The new customer has been added successfully."));

    }


    @Then("User click Logout bottom for Logout")
    public void user_click_Logout_bottom_for_Logout() throws InterruptedException {
        Thread.sleep(2000);
        np = new NopCommercePage(driver);
        np.getClick_Logout().click();
    }

    @Then("Take ScreenShot of this page")
    public void take_ScreenShot_of_this_page() throws IOException {
        ScreenShot.Capture(driver,"Logout page");
    }


    @Then("User can see page title {string}")
    public void user_can_see_page_title(String title) throws InterruptedException {

//        Thread.sleep(2000);
//    driver.getPageSource().contains("Your store. Login");
//    Assert.assertEquals(title,driver.getTitle());

    }


    @Then("close the browser")
    public void close_the_browser()  throws InterruptedException {
        //Thread.sleep(2000);

      driver.quit();

    }


}
