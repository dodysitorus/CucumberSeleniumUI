package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPages;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginSteps {

    WebDriver driver;

    LoginPages loginPages;

    @Given("[ui] user open web url {string}")
    public void uiUserOpenWebUrl(String url) {
        driver = Driver.getDriver();
        WebDriverManager.chromedriver().setup();
        driver.get(url);
        driver.manage().window().maximize();
        loginPages = PageFactory.initElements(driver, LoginPages.class);
    }

    @And("[ui] user input username {string} and password {string}")
    public void uiUserInputUsernameAndPassword(String username, String password) {
        loginPages.fillFormUsername(username);
        loginPages.fillFormPassword(password);
    }

    @When("[ui] user click login button")
    public void uiUserClickLoginButton() {
        loginPages.clickLoginButton();
    }

    @Then("[ui] user success login and redirected to homepage")
    public void uiUserSuccessLoginAndRedirectedToHomepage() {
        assertThat("wrong homepage", driver.getCurrentUrl(), equalTo("https://www.saucedemo.com/inventory.html"));
    }

    @Then("[ui] user should see error message {string}")
    public void uiUserShouldSeeErrorMessage(String errorMessage) {
        assertThat("wrong error message", loginPages.errorMessage(), equalTo(errorMessage));
    }

    @And("[ui] user close the browser")
    public void uiUserCloseTheBrowser() {
        driver.close();
    }
}

