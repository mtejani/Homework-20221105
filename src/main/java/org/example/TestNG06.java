package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;

import static java.awt.SystemColor.text;

public class TestNG06
{
    protected static WebDriver driver;

    @BeforeMethod
    public void openBrowser()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/Drivers/chromedriver.exe"); //set a driver path for Chrome browser
        driver = new ChromeDriver(); //opening Chrome browser
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());

        driver.manage().window(); //Keeping the browser in fullscreen mode
        driver.get("https://demo.nopcommerce.com/"); //opening given url;
    }
    public String timeStamp() //to create a timeStamp.
    {
        return  new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
    }

    public void clickElement(By by) // to create find elements that are used to make it easy to use and less code as well.
    {
        driver.findElement(by).click();
    }

    public void typeText(By by,String text)
    {
        driver.findElement(by).sendKeys(text);
    }

    public String readMsg(By by)
    {
        return driver.findElement(by).getText();

    }

    @Test
    public void toRegisterOnDemoNopCommerceWebsiteAndCreateUserAccount()
    {
        clickElement(By.className("ico-register")); //clicking on the button register
        clickElement(By.id("gender-male")); // defin the gender.
        typeText(By.id("FirstName"),"Murket"); // to register with first name.
        typeText(By.id("LastName"),"Mentos"); // to register with last name.
        Select selectDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
        selectDay.selectByIndex(6);

        Select selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        selectMonth.selectByValue("5");

        Select selectYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
        selectYear.selectByValue("2001");

        typeText(By.id("Email"),"Muk" + timeStamp()+"esh" + "@gmail.com"); // to register with email
        typeText(By.id("Company"),"MT Software Ltd"); // to register with company name.

        typeText(By.id("Password"),"Mux1@121");// assign password.
        typeText(By.id("ConfirmPassword"),"Mux1@121"); // to reconfirm the password.
        clickElement(By.id("register-button")); // to click on register.


        String regMsg = readMsg(By.className(("result"))); // to catch the register a confirmation result.

        System.out.println(regMsg); // to print registration connfirmation.
        System.out.println("Date and time at time of test completed:"+timeStamp()); // to print registration confirmation with timestamp.
    }

    @Test
    public void ToReadDeskTopCategoryProducts()
    {

        clickElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a")); //to enter under product category.
        clickElement(By.xpath("//ul[@class='sublist']/li[1]/a ")); //to enter in to the products.

        String Mesg1 = readMsg(By.xpath(("//div[@class=\"item-grid\"]/div[1]//h2/a"))); // to read a list of items.
        String Mesg2 = readMsg(By.xpath(("//div[@class=\"item-grid\"]/div[2]//h2/a"))); // to read a list of items.
        String Mesg3 = readMsg(By.xpath(("//div[@class=\"item-grid\"]/div[3]//h2/a"))); // to read a list of items.

        driver.close(); //to close open web browser.
        System.out.println("Item no.1:"+Mesg1); // to print item category msg 1
        System.out.println("Item no.2:"+Mesg2); // to print item category msg 2
        System.out.println("Item no.3:"+Mesg3); // to print item category msg 3
        System.out.println("Test time:"+timeStamp()); // to print time at time of stamp.

    }

    @Test
    public void toCommentOnNewsArticalPageandCatchMsg()
    {

        clickElement(By.xpath("//div[@class=\"news-items\"]/div[2]/div[3]/a")); // to click on news items.
        typeText(By.id("AddNewComment_CommentTitle"),"News you like"); // to comment on news
        typeText(By.id("AddNewComment_CommentText"),"News you like and this is worth sharing to you"); // to type a message for news share.
        clickElement(By.xpath("//div[@class='fieldset new-comment']/form/div[2]/button")); //to share news click button share.

        String result = readMsg(By.xpath("//div[@class='result']"));
        System.out.println(result); // to print registration connfirmation.
        System.out.println(timeStamp()); // to print registration confirmation with timestamp.
    }

    @Test
    public void toReadDemoNopCommerceHomePageItemCategory()
    {
        String read1 = readMsg(By.xpath("//div[@class='header-menu']/ul/li[1]/a")); // to catch header item category msg 01.
        String read2 = readMsg(By.xpath("//div[@class='header-menu']/ul/li[2]/a")); // to catch header item category msg 02.
        String read3 = readMsg(By.xpath("//div[@class='header-menu']/ul/li[3]/a")); // to catch header item category msg 03.
        String read4 = readMsg(By.xpath("//div[@class='header-menu']/ul/li[4]/a")); // to catch header item category msg 04.
        String read5 = readMsg(By.xpath("//div[@class='header-menu']/ul/li[5]/a")); // to catch header item category msg 05.
        String read6 = readMsg(By.xpath("//div[@class='header-menu']/ul/li[6]/a")); // to catch header item category msg 06.
        String read7 =readMsg(By.xpath("//div[@class='header-menu']/ul/li[7]/a")); // to catch header item category msg 07.


        System.out.println("Category of Item available at NopCommerce"); // to print category items header.
        System.out.println();  // to leave blank line.
        System.out.println("Category 01: "+read1); // to print category item.
        System.out.println("Category 02: "+read2); // to print category item.
        System.out.println("Category 03: "+read3); // to print category item.
        System.out.println("Category 04: "+read4); // to print category item.
        System.out.println("Category 05: "+read5); // to print category item.
        System.out.println("Category 07: "+read7); // to print category item.
        System.out.println(); // to leave blank line.

        System.out.println("Date and time at time of test completed:"+timeStamp()); // to print registration confirmation with timestamp.
    }

    @Test
    public void eMailandItemtoFriend()
    {
        clickElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a")); // to direct to computer category.
        clickElement(By.xpath("//ul[@class='sublist']/li[2]/a")); // to details in computer category
        clickElement(By.xpath("//div[@data-productid='4']/div[2]/h2/a")); // to reach to details computer specific item
        clickElement(By.xpath("//div[@class='email-a-friend']/button")); // click to share button
        typeText(By.id("FriendEmail"),"Friend"+timeStamp()+"@testmail.com"); // enter firends email id
        typeText(By.id("YourEmailAddress"),"YourEMail"+timeStamp()+"@testmail.com"); //to enter senders email id.
        typeText(By.id("PersonalMessage"),"I thought this might be the machine that you are looking for a while"); // enter comment before sharing the item.
        clickElement(By.name("send-email")); // to button share the utem
        String Msg = readMsg(By.xpath("//div[@class='message-error validation-summary-errors']/ul/li")); // read the outcome of sharing the item.


        System.out.println("Try to share Apple MacBook Pro 13-inc"); // to print category item.

        System.out.println("Message appear after clicking Sent email button:" +Msg); // to print category item.
        System.out.println("Test completed on :"+timeStamp()); // to print registration confirmation with timestamp.

    }

    @AfterMethod
    public void closeBrowser()
   {
       driver.quit(); // to close webdriver

   }

}
