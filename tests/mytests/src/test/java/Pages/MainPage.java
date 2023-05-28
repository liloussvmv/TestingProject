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


class MainPage extends PageBase {

    // By objects
    private By footerBy = By.xpath("//footer[@class='single_column  ']//nav[1]");
    private By loginRedirectorBy = By.xpath("//a[@href='/login']");

    // Main Page
    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.themoviedb.org/");
    }



    // Functions
    public String getFooterText() {
        return this.waitAndReturnElement(this.footerBy).getText();
    }

    public LoginPage clickLoginToRedirect() {
        this.waitAndReturnElement(this.loginRedirectorBy).click();
        return new LoginPage(this.driver);
    }

}
