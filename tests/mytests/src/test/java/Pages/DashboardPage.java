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



class DashboardPage extends PageBase {

    // By objects
    private final By profileButtonBy = By.xpath("//span[contains(@class,'avatar background_color')]");
    private final By logoutButtonBy = By.xpath("(//a[@href='/logout'])[2]");
    private final By settingsButtonBy = By.xpath("(//a[@href='/settings/profile'])[2]");
    private final By pageTitleBy = By.xpath("//div[@class='title']//h2[1]");
   

    // Main Page
    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.themoviedb.org/");
    }

    public boolean waitAndCheckPageLoad() {
        // String text = this.waitAndReturnElement(this.messageLocator).getText();
        // return text.contains("Signed in successfully");
        WebElement avatarElement = wait.until(ExpectedConditions.presenceOfElementLocated(this.profileButtonBy));

        return avatarElement.isDisplayed();
    }



    // Toggle profile dropdown 

    // public void toggleProfile() {
    //     WebElement profileButton = this.waitAndReturnElement(this.profileButtonBy);
    //     profileButton.click();
    // }

    // JavaScript executor
    public void toggleProfile() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement profileButton = this.waitAndReturnElement(this.profileButtonBy);
        jsExecutor.executeScript("arguments[0].click();", profileButton);
    }



    public SettingsPage settings(){
        toggleProfile();
        WebElement logoutButton = this.waitAndReturnElement(this.settingsButtonBy);
        logoutButton.click();
        return new SettingsPage(this.driver);
    }


    public LoginPage logout() {
        toggleProfile();
        WebElement logoutButton = this.waitAndReturnElement(this.logoutButtonBy);
        logoutButton.click();
        return new LoginPage(this.driver);
    }

    public String readPageTitle(){
        return this.waitAndReturnElement(this.pageTitleBy).getText();
    }


    // Functions

}
