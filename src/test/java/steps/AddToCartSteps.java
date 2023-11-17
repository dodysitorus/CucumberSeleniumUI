package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pages.AddToCartPages;
import pages.LoginPages;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddToCartSteps {
    WebDriver driver;
    AddToCartPages addToCartPages;

    @And("[ui] preparation driver add to cart")
    public void uiPreparationDriverAddToCart() {
        driver = Driver.getDriver();
        addToCartPages = PageFactory.initElements(driver, AddToCartPages.class);
    }

    @Given("[ui] user click button add to cart on products page")
    public void uiUserClickButtonAddToCartOnProductsPage() {
        addToCartPages.clickAddToCartButton();
    }

    @Then("[ui] user should see count of product is {string} in cart on products page")
    public void uiUserShouldSeeCountOfProductIsInCartOnProductsPage(String countOfProduct) {
        assertThat("wrong count of product",addToCartPages.getCountOfProduct(), equalTo(countOfProduct));
    }

}
