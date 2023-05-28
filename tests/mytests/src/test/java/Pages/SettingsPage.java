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
import org.openqa.selenium.support.ui.Select;



class SettingsPage extends PageBase {

    private final By settingsPageBy = By.xpath("//h2[text()='Edit Profile']");
    private final By textAreaBy = By.xpath("//span[text()='Description']/following::textarea");

    private final By genderDropdownBy = By.xpath("//span[contains(@class,'k-dropdown-wrap k-state-default')]//span");
    private final By submitButtonBy = By.xpath("//input[contains(@class,'k-button k-primary')]");
    private final By maleBy = By.xpath("(//ul[@id='gender_listbox']//li)[3]");

    // private final By fileUploadBy = By.xpath("//a[contains(@class,'no_click upload_avatar')]");
    // private final By fileUploadFollowUpBy = By.id("upload_files");

    
    // Main Page
    public SettingsPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://www.themoviedb.org/settings/profile");
    }

   

    // Functions

    public boolean waitAndCheckPageLoad() {
        WebElement editProfileElement = wait.until(ExpectedConditions.presenceOfElementLocated(this.settingsPageBy));
        return editProfileElement.isDisplayed();
    }

    public String readTextArea(){
        return this.driver.findElement(this.textAreaBy).getText();
    }

    public void sendFormWhileLoggedIn(){
        // filling Dropdown
        // Select select = new Select(this.waitAndReturnElement(this.genderDropdownBy));
        // select.selectByValue("2");

        // explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, 10); // Wait up to 10 seconds
        WebElement textArea = wait.until(ExpectedConditions.visibilityOfElementLocated(textAreaBy));
        textArea.clear();
        textArea.sendKeys("myDescription");

        this.waitAndReturnElement(this.submitButtonBy).click();
    }

    // public SettingsPage fileUpload(){
    //     this.waitAndReturnElement(this.fileUploadBy).click();
    //     this.waitAndReturnElement(this.fileUploadFollowUpBy).click();
    //     String filePath = "/home/seluser/image.png";
    //     this.waitAndReturnElement(this.fileUploadFollowUpBy).sendKeys(filePath);
    //     return new SettingsPage(this.driver);
    // }

}



