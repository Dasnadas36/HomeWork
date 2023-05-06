import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomeWork extends Utils {
    // Initialise WebElement
    @BeforeClass
        // Create a method
    void homepage(){
        System.out.println("Open Browser");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

    }
    WebDriver driver;
    @Test(priority = 2)
    void title() throws InterruptedException {
        String Title = driver.getTitle();
       // Thread.sleep(3000);
        Assert.assertEquals(Title,"nopCommerce demo","Title page is incorrect");

    }
    @Test(priority = 3)
    void guest(){
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a")).click();

    }

    @Test(priority = 4)
    void desktop() throws InterruptedException {
       // Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div/a/img")).click();
    }

    @Test(priority = 5)
    void lenovo() throws InterruptedException {
        //Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[1]/a/img")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[3]/div[2]/button[1]")).click();
    }

    @Test(priority = 6)
    void addToCart() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-3\"]")).click();
        //Thread.sleep(3000);
        //driver.findElement(By.id("add to cart button 3")).click();
    }

    @Test(priority = 7)
    void shoppingCart() throws InterruptedException {
       // Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]")).click();
        driver.findElement(By.className("qty-input")).clear();
        driver.findElement(By.className("qty-input")).sendKeys("3");
        driver.findElement(By.id("updatecart")).click();
    }
    @Test(priority = 8)
    void termsAndCondition() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        //Thread.sleep(3000);
        driver.findElement(By.id("termsofservice")).click();
    }


    @Test(priority = 9)
    void checkout() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,50);
        Thread.sleep(3000);
        wait.until (ExpectedConditions.elementToBeClickable(By.id("checkout"))).click();
    }

    @Test(priority = 10)
    void chGuest(){
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")).click();
    }

    @Test(priority = 11)
    void billing() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("sachin");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("bhatt");
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("dasnadas208@gmail.com");
        driver.findElement(By.name("BillingNewAddress.Company")).sendKeys("kbc ltd");
    }



    @Test(priority = 12)
    void country() throws InterruptedException {
        Thread.sleep(3000);
        WebElement selectCountry = driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]"));
        selectValueFromDropDown(selectCountry,"United Kingdom");
    }


    @Test(priority = 13)
    void state(){
        WebElement state = driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_StateProvinceId\"]"));
        selectValueFromDropDown(state,"Select state");
    }

    @Test(priority = 14)
    void city(){
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("London");
    }

    @Test(priority = 15)
    void address(){
        driver.findElement(By.name("BillingNewAddress.Address1")).sendKeys("Thornton road");
        driver.findElement(By.name("BillingNewAddress.Address2")).sendKeys("pond");
        driver.findElement(By.name("BillingNewAddress.ZipPostalCode")).sendKeys("cr6 6bh");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("012345678912");
        driver.findElement(By.name("save")).click();

    }

    @Test(priority = 16)
    void payment() {
        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"payment-method-block\"]/li[2]/div/div[2]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/button")).click();
       // driver.findElement(By.className("method-name")).click();//Shipping method
       // driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/button")).click();
       // driver.findElement(By.className("button-1 shipping-method-next-step-button")).click();
//        driver.findElement(By.className("shipping-method-next-step-button")).click();
    }


    @Test(priority = 17)
    void cardDetails(){
        WebElement card = driver.findElement(By.xpath("//*[@id=\"CreditCardType\"]"));
        selectValueFromDropDown(card,"Master card");
    }
    @Test(priority = 18)
    void cardHolderDetails(){
        driver.findElement(By.name("CardholderName")).sendKeys("SHB");
        driver.findElement((By.id("CardNumber"))).sendKeys("12345678912345");
    }

    @Test(priority = 19)
    void expDate(){
        WebElement Month = driver.findElement(By.xpath("//*[@id=\"ExpireMonth\"]"));
        WebElement Year = driver.findElement(By.xpath("//*[@id=\"ExpireYear\"]"));
        selectValueFromDropDown(Month,"09");
        selectValueFromDropDown(Year,"2031");
    }

    @Test(priority = 20)
    void cvv(){
        driver.findElement(By.xpath("//*[@id=\"CardCode\"]")).sendKeys("456");
    }
    @AfterClass
        //  @Test(priority = 21)
    void close(){
        driver.close();
    }

}


