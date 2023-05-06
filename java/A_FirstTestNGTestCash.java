import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.sql.Driver;

public class A_FirstTestNGTestCash {
    WebDriver driver;

    @Test(priority = 1)
    void openBrowser() {
        System.out.println("Open Browser");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test(priority = 2)
    void register() {
        driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Sachin");
        driver.findElement(By.id("LastName")).sendKeys("Bhatt");
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("3");
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("april");
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("1989");
        driver.findElement(By.id("Email")).sendKeys("dasnadas208@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Devansh17");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Devansh17");
        driver.findElement(By.id("register-button")).click();
    }
    public void loginTest(String Email,String Pwd) {
        System.out.println(Email + " " + Pwd);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");

        driver.findElement(By.id("Email")).sendKeys(Email);
        driver.findElement(By.id("Password")).sendKeys(Pwd);

    }
        @Test(priority = 3)
    void logIn() {
        System.out.println("User Login");
        driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
        driver.findElement(By.id("Email")).sendKeys("test123@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Tester123");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();
    }

    @Test(priority = 4)
    void logout() {
        driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
        String ExpectedTitle="nopCommerce demo store. Register";
        String ActualTitle=driver.getTitle();

     if ( ExpectedTitle.equals(ActualTitle )){
         System.out.println("Test is passed");
     }else {
         System.out.println("Test is failed");
     }
    }

    @Test(priority = 5)
    void closeBrowser() {
        System.out.println("Close Browser");
        driver.close();
    }
}


