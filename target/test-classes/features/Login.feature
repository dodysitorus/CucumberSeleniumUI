@Regression
Feature: Login Feature

  @LoginTestCase-01
  Scenario: user success login to website saucedemo
    Given [ui] user open web url "https://www.saucedemo.com/"
    And [ui] user input username "standard_user" and password "secret_sauce"
    When [ui] user click login button
    Then [ui] user success login and redirected to homepage
    And [ui] user close the browser

  @LoginTestCase-02
  Scenario Outline: user input wrong credential in website saucedemo with username "<username>" and password "<password>"
    Given [ui] user open web url "https://www.saucedemo.com/"
    And [ui] user input username "<username>" and password "<password>"
    When [ui] user click login button
    Then [ui] user should see error message "Epic sadface: Username and password do not match any user in this service"
    And [ui] user close the browser


    Examples:
      | username | password |
      | sadsadas | sadsadsa |

  @LoginTestCase-03
  Scenario Outline: user input null "<credential>" in website saucedemo
    Given [ui] user open web url "https://www.saucedemo.com/"
    And [ui] user input username "<username>" and password "<password>"
    When [ui] user click login button
    Then [ui] user should see error message "<errorMessage>"
    And [ui] user close the browser

    Examples:
      | credential | username      | password     | errorMessage                       |
      | username   |               | secret_sauce | Epic sadface: Username is required |
      | password   | standard_user |              | Epic sadface: Password is required |