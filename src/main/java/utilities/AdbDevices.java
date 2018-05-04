package utilities;

import org.testng.annotations.Test;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * Created by Maor on 5/3/2018.
 */

/**
 * Open ADB and list Android connected device
 * This will make sure your computer and Android device are communicating
 * If everything is ok, will get a serial number:
 * List of devices attached
 * 06cddb839b162851    device
 */

public class AdbDevices  {

    @Test
    public static void ConnectedDevices() throws IOException, InterruptedException {

        String line = "nuimport java.io.InputStreamReader;ll";
        String cmd = "adb devices";

        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);

        pr.waitFor();

        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        while ((line = buf.readLine()) != null) {
            System.out.println(line);

        }
    }
}