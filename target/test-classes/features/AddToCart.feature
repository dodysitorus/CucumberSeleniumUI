@Regression
Feature: Add to Cart Feature

  Background: user successfully login to website saucedemo
    Given [ui] user open web url "https://www.saucedemo.com/"
    And [ui] user input username "standard_user" and password "secret_sauce"
    When [ui] user click login button
    Then [ui] user success login and redirected to homepage
    And [ui] preparation driver add to cart

  @AddToCartTestCase-01
  Scenario: user success add one product to cart
    Given [ui] user click button add to cart on products page
    Then [ui] user should see count of product is "1" in cart on products page
    And [ui] user close the browser