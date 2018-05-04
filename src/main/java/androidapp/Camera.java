package androidapp;

import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/**
 * Created by Maors on 04/09/2017.
 */

public class Camera extends setUp {

    @Test
    // findElement(By.xpath)
    public void getCameraInfo() {

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.View[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[3]\n")).click();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[5]/android.widget.TextView\n")).click();

        // Check if test finished with JSON's result or with an error
        String result = driver.findElement(By.id("android:id/alertTitle")).getText();
        s_assert.assertEquals(result, "Test Finished", "Test Finished did not match with Actual test result: " + result);
        s_assert.assertAll();

        // Go back to main  app categories screen
        driver.findElement(By.id("android:id/button1")).click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
    }

    @Test
    public void checkFrontCamera() {

        // findElement(By.xpath)
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.View[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[3]\n")).click();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[6]/android.widget.TextView\n")).click();

        // Check if test finished with JSON's result or with an error
        String result = driver.findElement(By.id("android:id/alertTitle")).getText();
        s_assert.assertEquals(result, "Test Finished", "Test Finished did not match with Actual test result: " + result);
        s_assert.assertAll();

        // Print the JSON's test results
        String result2 = driver.findElement(By.id("android:id/message")).getText();
        System.out.println(result2);

        // Go back to main  app categories screen
        driver.findElement(By.id("android:id/button1")).click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
    }

    @Test
    public void checkBackCamera() {

        // findElement(By.xpath)
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.View[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[3]\n")).click();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[7]/android.widget.TextView\n")).click();

        // Check if test finished with JSON's result or with an error
        String result = driver.findElement(By.id("android:id/alertTitle")).getText();
        s_assert.assertEquals(result, "Test Finished", "Test Finished did not match with Actual test result: " + result);
        s_assert.assertAll();

        // Print the JSON's test results
        String result2 = driver.findElement(By.id("android:id/message")).getText();
        System.out.println(result2);

        // Go back to main  app categories screen
        driver.findElement(By.id("android:id/button1")).click();
        driver.sendKeyEvent(AndroidKeyCode.BACK);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}