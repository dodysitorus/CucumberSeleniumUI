package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPages {
    @FindBy(xpath = "//div[@id='login_button_container']//input[@id='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@id='login_button_container']//div[@class='form_group'][1]//input[@id='user-name']")
    private WebElement formUsername;

    @FindBy(xpath = "//div[@id='login_button_container']//div[@class='form_group'][2]//input[@id='password']")
    private WebElement formPassword;

    @FindBy(xpath = "//div[@id='login_button_container']//div[@class='error-message-container error']")
    private WebElement errorMessage;

    public void clickLoginButton() {
        loginButton.click();
    }

    public void fillFormUsername(String username) {
        formUsername.sendKeys(username);
    }

    public void fillFormPassword(String password) {
        formPassword.sendKeys(password);
    }

    public String errorMessage() {
        return errorMessage.getText();
    }

}
