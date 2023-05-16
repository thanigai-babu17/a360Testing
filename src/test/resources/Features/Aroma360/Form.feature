Feature: Contact form of Application

Background: Access Launch Page
    Given Initialize the browser with chrome  
	
@scenario9
Scenario Outline: Contact Form
When I am in the Contact page of the application 
Then Verify that user is succesfully logged in "<pageHeading>"
And Scroll down and validate Form is present
Then Select Interested in scenting "<scent>" from dropdown
And Enter First Name "<FirstName>"
And Enter Last Name "<LastName>"
And Enter Mail Id "<MailId>"
And Enter Phone number "<phoneno>" 
And Enter City "<City>" and State "<state>" and Zip code "<zip>"
And Enter the comments "<comment>"
#Then check the captcha button
When click on Submit button
Then Verify successfully landed on Thank you page 

Examples:
|pageHeading|scent          |FirstName|LastName|MailId                      |phoneno   |City     |state   |zip   |comment  |
|Contact Us |Home Scenting  |Kumar    |Shubham |kumar.shubham@coderapper.com|9786058796|Bangalore|Karnatka|560110|Testing@1|