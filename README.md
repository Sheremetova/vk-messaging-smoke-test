# vk-messaging-smoke-test
    !!! ATTENTION !!! You should keep in mind that you must login with excisting pre-configured test account before runing the scenario (ask me for creds). Such implementation is explained by the fact that you will encounter the appearance of CAPTCHA. 
    Another acc used by the test has no problems with CAPTCHA (for this reason it is used directly inside the autotest). Nevertheless you should also ask me for these creds and after that add them to MessagingSteps.java instead of "your_login" and "your_pass" respectively after cloning the repository to your local machine.
    
    If you don't want to ask me about anything - follow these 5 steps before running the test:
    1. Configure 2 accounts - first of them (let me call it USER1) has no requirements regarding the presence or absence of a CAPTCHA on it, but the second one (USER2) must be a kind of "real" - without CAPTCHA - because it participates in automation.
    2. Create a chat between users (USER1 and USER2), this chat must be on the top of the list of chats for both users.
    3. Replace creds hardcoded in MessagingSteps.java with USER2 creds.
    4. Install the app - you may install the app from gplay (4.6.1 version) or via terminal: cd to the root of the vk-messaging-smoke-test project directory and run 'adb install src/test/app/com.vkontakte.android.apk'.
    5. Login as USER1.
    
    The test uses Appium to get access to the app on a device (I used AVD emulator with android 8.0). So you should setup Appium on your local machine (see the instruction on http://appium.io/). To execute the whole feature you should run 'mvn test' in you terminal (e.g. in intelliJ IDEA).
    The feature file (src/test/resources/vksmoke/Smoke.feature) consists of 1 scenario checking the ability to send and receive messages.
