package com.example.myphone;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.Random;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class UnDoiTest {
    private static final String BASIC_SAMPLE_PACKAGE
            = "com.undoi.android";

    private static final int LAUNCH_TIMEOUT = 3000;
    private static final String STRING_TO_BE_TYPED = "UiAutomator";
    private UiDevice device;

    @Test
    public void loginUnDoi() throws Exception {
        // Context of the app under test.
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
//        device.pressHome();

        // Wait for launcher
        final String launcherPackage = device.getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        device.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)),
                LAUNCH_TIMEOUT);

        // Launch the app
        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE);
        // Clear out any previous instances
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        // Wait for the app to appear
        device.wait(Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
                LAUNCH_TIMEOUT);

        device.findObject(new UiSelector().text("Nume")).setText("md25");
        device.findObject(new UiSelector().text("Parolă")).setText("test12");
        device.findObject(new UiSelector().text("LOGIN")).click();
    }

    @Test
    public void cancelTransaction() throws Exception {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        final String launcherPackage = device.getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        device.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)),
                LAUNCH_TIMEOUT);

        device.findObject(new UiSelector().index(0).className("android.widget.ImageView")).click();
        device.findObject(new UiSelector().text("Anulează tranzacții")).click();
        device.findObject(new UiSelector().text("Filtrează")).click();
        device.findObject(new UiSelector().text("Marchează spre anulare")).click();
        device.findObject(new UiSelector().text("OK")).click();
        device.pressBack();

        device.findObject(new UiSelector().text("Incarcare cu PIN")).click();
        device.findObject(new UiSelector().text("Plati Facturi")).click();
        device.findObject(new UiSelector().text("Filtrează")).click();
        device.findObject(new UiSelector().text("Marchează spre anulare")).click();
        device.findObject(new UiSelector().text("Selectați motivul de anulare")).clickAndWaitForNewWindow(3000);
        Random randomReason = new Random();
        int low = 400;
        int high = 2000;
        int i = randomReason.nextInt(high - low) + low;
        device.click(100, i);
        device.findObject(new UiSelector().text("Da")).click();
        device.findObject(new UiSelector().text("Chitanță netipărită")).click();
        device.click(80, 2080);// bifa termeni si conditii
        device.findObject(new UiSelector().className("android.widget.ScrollView")).swipeUp(8);
        device.findObject(new UiSelector().text("Marchează spre anulare")).click();
        device.findObject(new UiSelector().text("OK")).click();
        device.pressBack();
        device.pressBack();
    }

    @Test
    public void logoutUnDoi() throws Exception {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        final String launcherPackage = device.getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        device.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)),
                LAUNCH_TIMEOUT);

        device.findObject(new UiSelector().index(0).className("android.widget.ImageView")).click();
        device.findObject(new UiSelector().text("Delogare")).click();

        device.pressHome();
    }
}