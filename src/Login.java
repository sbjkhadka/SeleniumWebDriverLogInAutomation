import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

//automating log in using selenium web driver
public class Login {
    public static void main(String[] args){
        // Define the web driver
        System.setProperty("webdriver.chrome.driver","C:\\Users\\khadk\\Desktop\\Software\\chromeDriver80\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        // Opening the browser and navigating to the URL
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        //Supplying information into the email field
        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");

        //Supplying information to the password field
        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass1");

        //logging in by clicking log in button
        driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();

        //Checking of log in is successful
        String message; //container to store result string
       if(!driver.findElements(By.id("conf_message")).isEmpty()){ //if element is found
           message=driver.findElement(By.id("conf_message")).getText(); //getting conformation message if log in is successful
       }else { //if element is not found
           message=driver.findElement(By.id("MainContent_lblTransactionResult")).getText(); //getting error message if login fails
       }
       //getting result in the console
       System.out.println("Result: "+message);
       //closing web driver, browser will be closed with close() method
       driver.close();
    }
}
