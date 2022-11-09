package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.text.SimpleDateFormat;

public class Register01
{

    protected static WebDriver driver; //to assign webdrivers

    public static void main(String[] args)
    {
    System.setProperty("webdriver.chrome.driver","src/test/Drivers/chromedriver.exe"); //set a driver path for Chrome browser
    driver =new ChromeDriver(); //opening Chrome browser
    String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date()); //create time stamp.

        driver.manage().window(); //maximize(); //Keeping the browser in fullscreen mode
        driver.get("https://demo.nopcommerce.com/"); //opening given url
        driver.findElement(By.className("ico-register")).click(); //clicking on the button register
        driver.findElement(By.id("gender-male")).click(); // defin the gender.
        driver.findElement(By.id("FirstName")).sendKeys("Murket"); // to register with first name.
        driver.findElement(By.id("LastName")).sendKeys("Month"); // to register with last name.
        Select selectDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
            selectDay.selectByIndex(6);

        Select selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
            selectMonth.selectByValue("2");

        Select selectYear = new Select(driver.findElement(By.name("DateOfBirthMonth")));
            selectYear.selectByIndex(8);

        driver.findElement(By.id("Email")).sendKeys("Muk" + timeStamp+"esh" + "@gmail.com"); // to register with email
        driver.findElement(By.id("Password")).sendKeys("Mux1@121"); // assign password.
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Mux1@121"); // to reconfirm the password.
        driver.findElement(By.id("register-button")).click(); // to click on register.
        String regMsg = driver.findElement(By.className(("result"))).getText(); // to catch the register a confirmation result.
        driver.close(); // to close webdriver
        System.out.println(regMsg); // to print registration connfirmation.
        System.out.println("Date and time at time of test completed:"+timeStamp); // to print registration confirmation with timestamp.

    }

}
