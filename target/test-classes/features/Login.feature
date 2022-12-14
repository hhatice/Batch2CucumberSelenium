@login
Feature: Krafttech Log in Test
  #Agile story : As a user, I should be able to log in so I can see my account

  Background:
    Given User should be on the login page

  @Mike @smoke @SDET
  Scenario: Login as Mike
    When The user enters Mike credentials
    Then The user should be able to login

  @Sebastian @smoke @QA
  Scenario: Login as Sebastian
    When The user enters Sebastian credentials
    Then The user should be able to login

  @developer @db
  Scenario: Login as Jhon Nash
    When The user enters Jhon Nash credentials
    Then The user should be able to login

  @SDET @smoke @db
  Scenario: Login as Rosa
    When The user enters Rosa credentials
    Then The user should be able to login

@selam
  Scenario: User should be able to login with valid credantilas
  Given User should be on the login page
    When User should input login information
    Then User should be on home page

  Scenario: Login with parameters
    Given User should be on the login page
    When User should input "hatice@gmail.com" and "12345678"
    Then User should be on home page


#  Scenario: Login as a given user
#
#    Then User should input foolowing credantials
#      | email    | alp@gmail.com |
#      | password | 12345678      |
#      | Name     | Alparslan     |
#
#
#  Scenario Outline: Data table and scenario outline
#    Then User should input foolowing credantials
#
#      | email    | <userEmail> |
#      | password | <password>  |
#      | Name     | <name>      |
#
#    Examples:
#      | userEmail               | password   | name           |
#      | user22@test.com         | Test123456 | User22         |
#      | eddiem@kraft.com        | eddiem12   | Eddie Murphy   |
#      | morganfreeman@kraft.com | mfreeman   | Morgan Freeman |


