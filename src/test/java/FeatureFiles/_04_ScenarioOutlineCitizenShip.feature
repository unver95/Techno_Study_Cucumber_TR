#Senaryo
#CitizenShip sayfasina gidiniz
#Daha sonra ayni bilgilerle tekrar Create yapilamadigini dogrulayiniz.
#Yukaridaki islemleri Paramter yontemi ile yapiniz


Feature: CizizenShip

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully
    And Navigate to CitizenShip page

  Scenario Outline: CitizenShip Create
    When User a CitizenShip name as "<Name>" short name as "<ShortName>"
    Then Success message should be displayed

    When User a CitizenShip name as "<Name>" short name as "<ShortName>"
    Then Already exist message should be displayed

    When User delete the "<Name>"
    Then Success message should be displayed

    Examples:
      | Name | ShortName |
      | Sn1  | peynir    |
      | Sn2  | peynir    |
      | Sn3  | peynir    |
      | Sn4  | peynir    |
