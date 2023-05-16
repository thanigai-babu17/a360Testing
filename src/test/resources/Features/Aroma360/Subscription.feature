Feature: Subscription Plan

Background: Access Launch Page
    Given Initialize the browser with chrome  
    
@scenario7
Scenario: One Time Purchase
#When I am in the Home page of the application 
#Then Verify that user is succesfully logged in "Aroma360"
#And Change the currency to "US" 
Then from Merchant API Product list check subscription and onetimepurchase     
    

Scenario: One Time Purchase
#When I am in the Home page of the application 
#Then Verify that user is succesfully logged in "Aroma360"
#And Change the currency to "US" 
Then from API Product list check subscription and onetimepurchase 


         
	
	
@scenario99 
Scenario Outline: One Time Purchase
When I am in the Home page of the application 
Then Verify that user is succesfully logged in "<pageHeading>"
And Change the currency to "<currency>" 
And Click on search bar and search with product "<productName>"
And select the product "<productName>"
Then Verify that user is succesfully logged in "<productPage>"
And validate Product name "<productName>" and Subscription and Price
Then validate Product name "<productName>" for all variant with Subscription has same price as in Script 
And Click on One time Purchase radio button
And validate Product name "<productName>" and Subscription and Price
Then validate Product name "<productName>" for variant "<variant>" has same price as in Script

Examples:
|pageHeading|currency|productName         |productPage         |variant| 
|Aroma360   |US      |Champagne Supernov              |Champagne Supernova              |50ml   | 	
##|Aroma360   |US      |My Way Reed Diffuser|My Way Reed Diffuser|Black  |
#|Dream On          |US      |Dream On              |Dream On              |120ml   |
#|24K Magic         |US      |24K Magic              |24K Magic              |50ml   |
#|Chandelier       |US      |Chandelier              |Chandelier              |50ml   |
#|Escapade          |US      |Escapade              |Escapade              |50ml   |
#|Smoke on the Water|US      |Smoke on the Water              |Smoke on the Water              |50ml   |
#|E11EVEN           |US      |E11EVEN              |E11EVEN              |50ml   |
#|Sweet Caroline    |US      |Sweet Caroline              |Sweet Caroline              |50ml   |
#|Break My Soul     |US      |Break My Soul              |Break My Soul              |50ml   |
#|Electric Youth    |US      |Electric Youth              |Electric Youth              |50ml   |
#|Jolene|US         |Jolene              |Jolene              |50ml   |
#|Love Language      |US      |Love Language              |Love Language              |50ml   |
#|Never Too Much    |US      |Never Too Much              |Never Too Much              |50ml   |
#|Across The Universe|US      |Across The Universe              |Across The Universe              |120ml   |
#|Adore             |US       |Adore              |Adore              |50ml   |
#|All of Me         |US      |All of Me              |All of Me              |120ml   |
#|Allure            |US      |Allure              |Allure              |50ml   |
#|Beach House       |US      |Beach House              |Beach House              |50ml   |
#|Black Velvet      |US      |Black Velvet              |Black Velvet              |50ml   |
#|Blue Moon         |US      |Blue Moon              |Blue Moon              |50ml   |
#|California Love   |US      |California Love              |California Love              |50ml   |
#|Champagne Supernova |US      |Champagne Supernova              |Champagne Supernova              |50ml   |
#|Déjà Vu           |US      |Déjà Vu              |Déjà Vu              |50ml   |
#|Desert Rose       |US      |Desert Rose              |Desert Rose              |50ml   |
#|Escape            |US      |Escape              |Escape              |200ml   |
#|Eternal Sunshine |US      |Eternal Sunshine              |Eternal Sunshine              |50ml   |
#|Exhale            |US      |Exhale              |Exhale              |50ml   |
#|Graceland         |US      |Graceland              |Graceland              |50ml   |
#|Hawaiian Sunset   |US      |Hawaiian Sunset              |Hawaiian Sunset              |50ml   |
#|Iris              |US      |Iris              |Iris              |50ml   |
#|Kiss By a Rose    |US      |Kiss By a Rose              |Kiss By a Rose              |120ml   |
#|Little White Lies |US      |Little White Lies              |Little White Lies              |50ml   |
#|London Calling    |US      |London Calling              |London Calling              |50ml   |
#|Marquee Moon      |US      |Marquee Moon              |Marquee Moon              |50ml   |
#|Midnight in Paris |US      |Midnight in Paris              |Midnight in Paris              |50ml   |
#|Mistletoe         |US      |Mistletoe              |Mistletoe              |50ml   |
#|Mother Ocean      |US      |Mother Ocean              |Mother Ocean              |50ml   |
#|Mystify           |US      |Mystify              |Mystify              |50ml   |
#|Nirvana           |US      |Nirvana              |Nirvana              |50ml   |
#|November Rain     |US      |November Rain              |November Rain              |50ml   |
#|Ocean Eyes        |US      |Ocean Eyes              |Ocean Eyes              |50ml   |
#|Paradise Lost     |US      |Paradise Lost              |Paradise Lost              |50ml   |
#|Shadow Dancing    |US      |Shadow Dancing              |Shadow Dancing              |50ml   |
#|Skyfall           |US      |Skyfall              |Skyfall              |50ml   |
#|Smooth Operator   |US      |Smooth Operator              |Smooth Operator              |50ml   |
#|Stargazing        |US      |Stargazing              |Stargazing              |50ml   |
#|Summer Breeze     |US      |Summer Breeze              |Summer Breeze              |50ml   |
#|Sunrise           |US      |Sunrise              |Sunrise              |50ml   |
#|The Bliss         |US      |The Bliss              |The Bliss              |50ml   |
#|The Sweetest Taboo|US      |The Sweetest Taboo              |The Sweetest Taboo              |120ml   |
#|Timeless          |US      |Timeless              |Timeless              |50ml   |
#|Waterfalls        |US      |Waterfalls              |Waterfalls              |50ml   |
#|Wicked Game       |US      |Wicked Game              |Wicked Game              |50ml   |
##Scent Diffusers
#|Mini360 SL                  |US|Mini360 SL                  |Mini360 SL                  ||
#|VanGogh360                  |US|VanGogh360                  |VanGogh360                  ||
#|Museum360                   |US|Museum360                   |Museum360                   ||
#|Interactive Scenting Kiosk  |US|Interactive Scenting Kiosk  |Interactive Scenting Kiosk  ||
#|DaVinci360                  |US|DaVinci360                  |DaVinci360                  ||
#|Museum360                   |US|Museum360                   |Museum360                   ||
##Scent Accents
#|Paris Collection Reed Diffuser Duo |US|Paris Collection Reed Diffuser Duo |Paris Collection Reed Diffuser Duo ||
#|Paris Collection Candle Duo        |US|Paris Collection Candle Duo        |Paris Collection Candle Duo        ||
#|Paris Collection Candle Trio       |US|Paris Collection Candle Trio       |Paris Collection Candle Trio       ||
#|Paris Collection Set               |US|Paris Collection Set               |Paris Collection Set               ||
#|Paris Collection Room Spray Duo    |US|Paris Collection Room Spray Duo    |Paris Collection Room Spray Duo    ||
#|My Way 3-Wick Candle               |US|My Way 3-Wick Candle               |My Way 3-Wick Candle               ||
#|My Way Room Spray                  |US|My Way Room Spray                  |My Way Room Spray                  ||
#|My Way Reed Diffuser               |US|My Way Reed Diffuser               |My Way Reed Diffuser               ||
#|Déjà Vu Room Spray                 |US|Déjà Vu Room Spray                 |Déjà Vu Room Spray                 ||
#|Déjà Vu Reed Diffuser              |US|Déjà Vu Reed Diffuser              |Déjà Vu Reed Diffuser              ||
#|Déjà Vu 3-Wick Candle              |US|Déjà Vu 3-Wick Candle              |Déjà Vu 3-Wick Candle              ||
#|Iris Reed Diffuser                 |US|Iris Reed Diffuser                 |Iris Reed Diffuser                 ||
#|Iris Room Spray                    |US|Iris Room Spray                    |Iris Room Spray                    ||
#|Iris 3-Wick Candle                 |US|Iris 3-Wick Candle                 |Iris 3-Wick Candle                 ||
#|My Way Single-Wick Candle          |US|My Way Single-Wick Candle          |My Way Single-Wick Candle          ||
#|Dream On Single-Wick Candle        |US|Dream On Single-Wick Candle        |Dream On Single-Wick Candle        ||
#|Escapade Single-Wick Candle        |US|Escapade Single-Wick Candle        |Escapade Single-Wick Candle        ||
#|Iris 500mL Reed Diffuser           |US|Iris 500mL Reed Diffuser           |Iris 500mL Reed Diffuser           ||
#|Déjà Vu 500mL Reed Diffuser        |US|Déjà Vu 500mL Reed Diffuser        |Déjà Vu 500mL Reed Diffuser        ||
#|My Way 500mL Reed Diffuser         |US|My Way 500mL Reed Diffuser         |My Way 500mL Reed Diffuser         ||
#|Paris Collection Room Spray Duo    |US|Paris Collection Room Spray Duo    |Paris Collection Room Spray Duo    ||
#
#


Scenario Outline: Subscription
When I am in the Home page of the application 
Then Verify that user is succesfully logged in "<pageHeading>"
And Change the currency to "<currency>" 
And Click on search bar and search with product "<productName>"
And select the product "<productName>"
Then Verify that user is succesfully logged in "<productPage>"
And validate Product name "<productName>" and Subscription and Price
Then validate Product name "<productName>" for all variant with Subscription has same price as in Script 


Examples:
|pageHeading|currency|productName         |productPage         |variant| 
#|Aroma360   |US      |My Way              |My Way              |50ml   | 



Scenario Outline: One Time Purchase
When I am in the Home page of the application 
Then Verify that user is succesfully logged in "<pageHeading>"
And Change the currency to "<currency>" 
And Click on search bar and search with product "<productName>"
And select the product "<productName>"
Then Verify that user is succesfully logged in "<productPage>"
And Click on One time Purchase radio button
And validate Product name "<productName>" and Subscription and Price
Then validate Product name "<productName>" for variant "<variant>" has same price as in Script
 


                          
Examples:
|pageHeading       |currency|productName         |productPage         |variant|
#|Aroma360          |US      |My Way              |My Way              |50ml   | 
