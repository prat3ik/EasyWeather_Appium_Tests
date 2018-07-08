# EasyWeather_Appium_Tests
Automation of EasyWeather Android app


## IntelliJ
### Prerequisites
- Make sure Appilum local server is running on http://127.0.0.1:4723/ (Or you can change the url on [configuration.properties](https://github.com/prat3ik/EasyWeather_Appium_Tests/blob/master/src/test/resources/configuration.properties))
- TestNG plugin must be installed on IntelliJ Idea

### Steps
1. New Project from version control > git > copy this url: https://github.com/prat3ik/EasyWeather_Appium_Tests.git
2. Run build.gradle successfully
3. Move to [configuration.properties](https://github.com/prat3ik/EasyWeather_Appium_Tests/blob/master/src/test/resources/configuration.properties) and change the properties according to your connected Physical Android Device/Emulator
3. Move to [TestCases.java](https://github.com/prat3ik/EasyWeather_Appium_Tests/blob/master/src/test/java/testcases/TestCases.java)
4. Run as a TestNG test
