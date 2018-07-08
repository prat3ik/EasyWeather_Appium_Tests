# EasyWeather_Appium_Tests
Automation of EasyWeather Android app

## Technology Stack and Framework
Technology:
* Java + TestNG(v6.11) + Java-Appium client(v6.1.0)

Framework supports:
* Page Object Modeling(POM) based.
* Purely Object Oriented.
* Cross Platform support(Android/iOS)
* Hybrid Testing Framework.
* Thread-safe execution.
* Screenshot capture on Failure.
* Jenkins(CI/CD) Enabled.

## How to setup on IntelliJ
### Prerequisites
- Make sure Appilum local server is running on http://127.0.0.1:4723/ (Or you can change the url on [configuration.properties](https://github.com/prat3ik/EasyWeather_Appium_Tests/blob/master/src/test/resources/configuration.properties))
- TestNG plugin must be installed on IntelliJ Idea

### Steps(To run Locally)
1. New Project from version control > git > copy this url: https://github.com/prat3ik/EasyWeather_Appium_Tests.git
2. Run build.gradle successfully
3. Move to [configuration.properties](https://github.com/prat3ik/EasyWeather_Appium_Tests/blob/master/src/test/resources/configuration.properties) and change the properties according to your connected Physical Android Device/Emulator
3. Move to [TestCases.java](https://github.com/prat3ik/EasyWeather_Appium_Tests/blob/master/src/test/java/testcases/TestCases.java)
4. Run as a TestNG test

### How to Run in BrowserStack:
`execution.type=bs` in [configuration.properties](https://github.com/prat3ik/EasyWeather_Appium_Tests/blob/master/src/test/resources/configuration.properties) and change the properties according to your Browserstack's credentials.

[Sample of execution](https://drive.google.com/open?id=1GHQz2p6o0nejflo-PRB7UAMkAaXgzarK)

#### Browserstack Successful Execution:
Login credentials: [configuration.properties](https://github.com/prat3ik/EasyWeather_Appium_Tests/blob/master/src/test/resources/configuration.properties)
1) [verifyUserCanSeeTheWeatherOfCities](https://app-automate.browserstack.com/builds/bb4e176491c203a36128a025681b9ca6efb7df14/sessions/ddd3108dacf6dbf32cb38ed8eb95eb63fd4674b7#automate_button)
2) [verifyUserCanAddAndRemoveTheCities](https://app-automate.browserstack.com/builds/bb4e176491c203a36128a025681b9ca6efb7df14/sessions/8e196667c8e7c24a633325239158596eab753cdc#automate_button)

### Manual Test Cases: 
https://docs.google.com/spreadsheets/d/1oyFgM1UdaCyfoxHjOs-VLOhjHVZfN7deuGVZ1nC9OfI/edit#gid=0
