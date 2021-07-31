import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LoginPage
{
    private WebDriver driver;

    LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    void enterUserName(String name)
    {
        driver.findElement(By.id("login")).sendKeys("admin");
    }

    void enterPassword(String pass)
    {
        driver.findElement(By.id("pass")).sendKeys("changeme");
    }

    void clickLogin()
    {

    }

    void open()
    {
        driver.get("https://lingualeo.com");
    }

    boolean atPage()
    {
        if(driver.getTitle().equals("https://lingualeo.com"))
        {
            return true;
        } else
        {
            return false;
        }
    }
}
