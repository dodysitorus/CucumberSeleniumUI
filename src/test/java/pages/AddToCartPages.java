package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Service;

import java.util.List;

public class AddToCartPages {

    @FindBy(xpath = "//div[@class='inventory_list']//div[@class='inventory_item']//button")
    private List<WebElement> addToCartButton;

    @FindBy(xpath = "//div[@id='header_container']//div[@id='shopping_cart_container']")
    private WebElement cartIcon;

    public void clickAddToCartButton() {
        addToCartButton.get(1).click();
    }

    public String getCountOfProduct() {
        return cartIcon.getText();
    }
}
