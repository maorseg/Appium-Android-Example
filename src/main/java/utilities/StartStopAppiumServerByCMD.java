package utilities;

import org.testng.annotations.Test;
import java.io.IOException;

/**
 * Created by Maor on 5/9/2018.
 * Start - Start Appium by CMD
 * Stop - Stop Appium by CMD
 */
    public class StartStopAppiumServerByCMD {

        @Test
        public void Start() throws IOException, InterruptedException {

            Runtime runtime = Runtime.getRuntime();
            runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723");
            Thread.sleep(10000);
        }

        @Test
        public void Stop() {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("taskkill /F /IM node.exe");
                runtime.exec("taskkill /F /IM cmd.exe");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public static void main(String[] args) throws IOException, InterruptedException {
        StartStopAppiumServerByCMD appiumServer = new StartStopAppiumServerByCMD();
        appiumServer.Stop();
    }
 }
