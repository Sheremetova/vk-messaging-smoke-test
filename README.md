# vk-messaging-smoke-test
    !!! ATTENTION !!! You should keep in mind that you must login with excisting pre-configured test account before runing the scenario (ask me for creds). Such implementation is explained by the fact that you will encounter the appearance of CAPTCHA. 
    Another acc used by the test has no problems with CAPTCHA (for this reason it is used directly inside the autotest). Nevertheless you should also ask me for those creds and after that add them to MessagingSteps.java instead of "your_login" and "your_pass" respectively after cloning the repository to your local machine.
    
    The test uses Appium to get access to the app on a device (I used AVD emulator with android 8.0). So you should setup Appium on your local machine (see the instruction on http://appium.io/). To execute the whole feature you should run 'mvn test' in you terminal (e.g. in intelliJ IDEA).
    The feature file (src/test/resources/vksmoke/Smoke.feature) consists of 1 scenario checking the ability to send and receive messages.
