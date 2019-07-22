Feature: Banking application on Guru99

Scenario Outline: Unsuccessful login to the banking website
Given Login page of banking app is open
When User enters invalid <username> and <password>
Then User cannot login and error message is displayed

Examples:
| Username |  Password  |
|jurabek   |12345       |
|mngr211208|123456      |
|user      |EqAnYta     |

Scenario: Successful login to the banking website
Given Login page of banking app is open
When User enters valid username: "mngr211208" and password: "EqAnYta"
Then Home page of banking app opens
