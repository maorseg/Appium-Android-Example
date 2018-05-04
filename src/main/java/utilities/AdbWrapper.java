package utilities;

/**
 * Created by Maor on 5/3/2018.
 */

import org.testng.annotations.Test;
import java.io.IOException;
public class AdbWrapper {

    @Test
    // change battery level value to 100%
    public void setBatteryMAX() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set level 100";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();
    }

    @Test
    // change battery level value to 100%
    public void setBatteryHalf() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set level 50";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();
    }

    @Test
    // change battery level value to 0%
    public void setBatteryMin() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set level 0";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();
    }

    @Test
    // change battery level value to Unknown
    public void setBatteryUnknown() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set status 1";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();

    }

    @Test
    // change battery level value to Discharging
    public void setBatteryDischarging() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set status 3";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();

    }

    @Test
    // change battery level value to Charging
    public void setBatteryCharging() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set status 2";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();

    }

    @Test
    // change battery level value to Charging by wireless
    public void setWIFIcharging() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set wireless 1";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();

    }

    @Test
    // change battery level value to Charging by wireless
    public void setACcharging() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set ac 1";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();

    }

    @Test
    // change battery level value to Charging by usb
    public void setUSBcharging() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set usb 1";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();

    }

    @Test
    // make the system think that charger is disconnected
    public void setChargerDisconnect() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set usb 0";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();

    }

    @Test
    // “reset” command in order to return the battery to it's real values
    public void resetBattery() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery reset";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();
    }

}
/*
   ///More example list of commands to impliment...

        // sets battery charge value between to 100%
        SetBatteryFullCharge:
        String cmd = "adb shell dumpsys battery set level 100";

        // sets battery charge value between to 50%
        SetBatteryHalfCharge:
        String cmd = "adb shell dumpsys battery set level 50";

         // sets battery charge value between to 5%
        SetBatteryLowCharge:
        String cmd = "adb shell dumpsys battery set level 5";

        // sets battery status as Unknown
        SetBatteryStatusUnknown:
        String cmd = "adb shell dumpsys battery set status 1";

        SetBatteryStatusCharging:
        String cmd = "adb shell dumpsys battery set status 2";

        // sets battery status as Discharging
        SetBatteryDischarging:
        String cmd = "adb shell dumpsys battery set status 3";

        // sets battery status as Not charging
        SetBatteryNotCharging:
        String cmd = "adb shell dumpsys battery set status 4";

        // sets power source as a wireless charger
        SetBatteryWifiCharge:
        String cmd = "adb shell dumpsys battery set wireless 1";

        // sets power source as an ac charger
        SetBatteryAcCharge:
        String cmd = "adb shell dumpsys battery set ac 1";

        // sets power source as a usb charger
        SetBatteryUsbCharge:
        String cmd = "adb shell dumpsys battery set usb 1";

        // sets all ac/usb/wireless to 0 – mocks no charging at all (available only in Android 6 and up)
        SetBatteryChargerDisconnect:
        String cmd = "adb shell dumpsys battery unplug";

        ResetToBatteryDefaults:
        String cmd = "adb shell dumpsys battery reset";

        BatteryInfo:
        String line = "nuimport java.io.InputStreamReader;ll";
        command = "adb shell dumpsys battery";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(command);
        pr.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        while ((line = buf.readLine()) != null) {
            System.out.println(line);
            report.report(line);
        }

        // Disable Bluetooth to simulate HW problem
        // Set Set Bluetooth to ON
        SetBluetoothOn:
        String cmd = "adb shell service call bluetooth_manager 6";

        // Set Set Bluetooth to OFF
        SetBluetoothOff:
        String cmd = "adb shell service call bluetooth_manager 9";

        DisableBluetooth:
        String cmd = "adb shell pm disable com.android.bluetooth";

        // Reset Bluetooth to defaults
        ResetBluetooth:
        String cmd = "adb shell pm enable com.android.bluetooth";

        // Set Set Wifi to ON
        SetWifiOn:
        String cmd = "adb shell svc wifi enable";

        // Set Set Wifi to OFF
        SetWifiOff:
        String cmd = "adb shell svc wifi disable";

        // Set Set Airplane mode (flight mode) to ON
        SetAirplaneOn:
        String cmd = "adb shell settings put global airplane_mode_on 1";

        // Set Set Airplane mode (flight mode) to OFF
        SetAirplaneOff:
        String cmd = "adb shell settings put global airplane_mode_on 0";

        // Set Location On
        SetLocationOn:
        String cmd = "adb shell settings put secure location_providers_allowed +gps";

        SetLocationOff:
        String cmd = "adb shell settings put secure location_providers_allowed -gps";

        // Set Brightness to 0
        SetBrightnessMin:
        String cmd = "adb shell settings put system screen_brightness 0";

        // Set Brightness to 255
        SetBrightnessMax:
        String cmd = "adb shell settings put system screen_brightness 255";

        // Monkey Stress test for MD apk
        MDAppStress:
        String cmd = "adb shell monkey -p com.cellebrite.shindan -v 2000000";

        // Monkey stress test on MD apk application
        ForceCloseMDApp:
        String cmd =  "adb shell am force-stop com.cellebrite.shindan";

        // Reboot androidapp.Device
        RebootDevice:
        String cmd = "adb reboot";

        AdbDevices:
        String cmd = "adb devices";
        Runtime run1 = Runtime.getRuntime();
        Process pr1 = run1.exec(command);
        pr1.waitFor();
        BufferedReader buf1 = new BufferedReader(new InputStreamReader(pr1.getInputStream()));
        while ((line = buf1.readLine()) != null) {
            System.out.println(line);
            report.report(line);
        }

        // Get any ADB command from the user
        GetUserCommand:
        // create a jframe
        JFrame frame = new JFrame();
        String cmd = JOptionPane.showInputDialog(frame, "Please enter ADB command to execute");

    }

}

*/

