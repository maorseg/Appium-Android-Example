package utilities;

import java.io.File;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

/**
 * Created by Maor on 5/9/2018.
 * Start - Start Appium Server via node.js
 * Stop - Stop Appium Server via node.js
 */

public class StartStopAppiumServerByNodeJS {

    private AppiumDriverLocalService appiumService;
    private DesiredCapabilities capabilities;
    private AppiumServiceBuilder builder;
    String node_js_Path = "C:\\Program Files (x86)\\Appium\\node.exe";

    @Test
    public void Start() {

        // Set Capabilities
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("AppiumserviceReset", false);

        // Build the Appium Service
        builder = new AppiumServiceBuilder();
        builder.usingDriverExecutable(new File(node_js_Path));
        builder.withAppiumJS(new File("C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js"));
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "info");
        builder.usingPort(4723);
        builder.withIPAddress("127.0.0.1");

        // Start the service
        appiumService = AppiumDriverLocalService.buildService(builder);
        appiumService.start();
    }

    @Test
    public void Stop() {
        appiumService.stop();
    }
}

