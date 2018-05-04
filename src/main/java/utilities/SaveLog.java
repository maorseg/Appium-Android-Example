package utilities;

/**
 * Created by Maor on 5/3/2018.
 */

import org.testng.annotations.Test;

public class SaveLog {

    //  Open cmd in minimized mode and take logcat
    @Test
    public void Logcat() throws Exception {

            {
                {
                    try {
                        Runtime.getRuntime().exec("cmd /c start /min cmd.exe /K \"adb logcat > LOG.txt");

                    } catch (Exception e) {
                        System.out.println("Failure to save log");
                        e.printStackTrace();
                    }
                }
            }
        }
    }