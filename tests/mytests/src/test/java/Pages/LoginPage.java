import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


class LoginPage extends PageBase {

    // By objects
    private final By userLocator = By.id("username");
	private final By passLocator = By.id("password");
	private final By loginLocator = By.xpath("(//input[@type='submit'])[2]");
    private final By dontHaveAnAccountTextBy = By.xpath("(//a[@href='/signup'])[2]");
    //xeyetib576@cutefier.com
    private final String User = "k3rn3l";
	private final String Pass = "@Tester01";



    // Main Page
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.themoviedb.org/login");
    }


    // Functions
    public DashboardPage loginIn(){
        this.waitAndReturnElement(userLocator).click();
        this.waitAndReturnElement(userLocator).sendKeys(User);
        this.waitAndReturnElement(passLocator).click();
        this.waitAndReturnElement(passLocator).sendKeys(Pass);
        this.waitAndReturnElement(loginLocator).click();

        return new DashboardPage(this.driver);
    }

    public boolean waitAndCheckPageLoad() {
        WebElement text = wait.until(ExpectedConditions.presenceOfElementLocated(this.dontHaveAnAccountTextBy));
        // String text = this.waitAndReturnElement(this.dontHaveAnAccountTextBy).getText();
        return text.isDisplayed();
    }
}
