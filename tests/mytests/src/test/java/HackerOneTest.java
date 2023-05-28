
import static org.junit.Assert.*;
import org.junit.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;




public class HackerOneTest {
    private WebDriver driver;

    @Before
    public void setUp() throws MalformedURLException{
        ChromeOptions options = new ChromeOptions();
        this.driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        this.driver.manage().window().maximize();

        // Browser modification
        options.addArguments("--lang=en-US");
        options.addArguments("--start-maximized");
        
        // Timeout Modification
        int timeoutSeconds = 50; 
        driver.manage().timeouts().implicitlyWait(timeoutSeconds, TimeUnit.SECONDS);
    }

    @Test
    public void testSelenium() {

        // Static Page
        MainPage mainPage = new MainPage(this.driver);
        System.out.println("====================FOOTER ===========");
        System.out.println(mainPage.getFooterText());


        // Login Test
        LoginPage loginPage = new LoginPage(this.driver);
        DashboardPage dashboardPage = loginPage.loginIn();
        System.out.println("==================== BODY ===========");
        System.out.println(dashboardPage.getBodyText());
        Assert.assertTrue(dashboardPage.waitAndCheckPageLoad());

        // Test Static page and read title
        System.out.println("==================== TITLE ===========");
        System.out.println(dashboardPage.readPageTitle());
        Assert.assertEquals("Welcome.", dashboardPage.readPageTitle());

        // Settings Test
        System.out.println("==================== SETTINGS ===========");
        SettingsPage settingsPage = new SettingsPage(this.driver);
        settingsPage.sendFormWhileLoggedIn();
        // reading TextArea
        System.out.println(settingsPage.readTextArea());
        // testing form submission
        // Assert.assertEquals("myDescription", settingsPage.readTextArea());

        // settingsPage.fileUpload();

        // Logout Test
        LoginPage loginPage2 = dashboardPage.logout();
        Assert.assertTrue(loginPage2.waitAndCheckPageLoad());
    }   

    @After
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }   
}
