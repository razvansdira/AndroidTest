package com.example.myphone;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.List;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

//      private static final String STRING="UiAutomator";

    private static final String BASIC_SAMPLE_PACKAGE
            = "com.sec.android.app.popupcalculator";
//    private static final String BASIC_SAMPLE_PACKAGE
//            = "com.google.android.apps.maps";
//    private static final String BASIC_SAMPLE_PACKAGE
//            = "com.samsung.android.sm";
//    private static final String BASIC_SAMPLE_PACKAGE
//            = "com.samsung.android.app.memo";
//    private static final String BASIC_SAMPLE_PACKAGE
//            = "com.sec.android.gallery3d";
//    private static final String BASIC_SAMPLE_PACKAGE
//            = "com.sec.android.app.clockpackage";

    private static final int LAUNCH_TIMEOUT = 3000;
    private static final String STRING_TO_BE_TYPED = "UiAutomator";
    private UiDevice device;

    @Test
    public void useCalc() throws Exception {
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
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        context.startActivity(intent);

        // Wait for the app to appear
        device.wait(Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
                LAUNCH_TIMEOUT);

        device.findObject(new UiSelector().text("4")).click();
        device.findObject(new UiSelector().index(30)).click();
        device.findObject(new UiSelector().text("6")).click();
        device.findObject(new UiSelector().index(45)).click();
//        String rez = device.findObject(By.res("com.android.calculator2", "com.android.calculator2:id/formula")).getText().split("=")[1];
        String rez = device.findObject(new UiSelector().index(1)).getText();
        assertEquals(rez, "10");
    }

    @Test
    public void useMsg() throws Exception {
        // Context of the app under test.

        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        device.pressHome();
        try {
            device.findObject(new UiSelector().description("2")).click();
            device.findObject(new UiSelector().description("2")).click();
            device.findObject(new UiSelector().description("0")).click();
            device.findObject(new UiSelector().description("0")).click();
            device.findObject(new UiSelector().description("Intr.")).click();
        } catch (Exception e) {
        }

        // Wait for launcher
        final String launcherPackage = device.getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        device.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)),
                LAUNCH_TIMEOUT);

        // Launch the app
        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage("com.android.mms");
        // Clear out any previous instances
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        // Wait for the app to appear
        device.wait(Until.hasObject(By.pkg("com.android.mms").depth(0)),
                LAUNCH_TIMEOUT);

        String text = new String("TestAutomatCret");
        device.findObject(new UiSelector().text("Marius Nechifor")).click();
        device.findObject(new UiSelector().className("android.widget.ImageButton")).click();
        device.findObject(new UiSelector().text("Adăugare destinatar")).click();
        device.findObject(new UiSelector().resourceId("com.android.mms:id/recipients_editor_to")).setText("0748364345");
        device.findObject(new UiSelector().resourceId("com.android.mms:id/btn_add_recipient")).click();

        // device.findObject(new UiSelector().resourceId("com.android.mms:id/edit_text_bottom")).click();
        device.findObject(new UiSelector().resourceId("com.android.mms:id/edit_text_bottom")).setText(text);

        Object lock = new Object();
        synchronized (lock) {
            lock.wait(2000);
        }

        device.findObject(new UiSelector().resourceId("com.android.mms:id/send_button_01")).click();

//        List<UiObject2> objects = device.findObjects(By.res("com.android.mms", "body_text_view"));
//        assertEquals(objects.get(objects.size() - 1).getText(), text);

        device.pressHome();

        device.wait(Until.hasObject(By.pkg("com.android.mms").depth(0)),
                LAUNCH_TIMEOUT);

        device.sleep();
    }

    @Test
    public void useMaps() throws Exception {
        // Context of the app under test.

        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        device.pressHome();

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

        device.findObject(new UiSelector().resourceId("com.google.android.apps.gmm:id/on_map_action_button")).click();
        device.findObject(new UiSelector().resourceId("com.google.android.apps.gmm:id/directions_startpoint_textbox")).click();
        device.findObject(new UiSelector().resourceId("com.google.android.apps.gmm:id/search_omnibox_edit_text")).setText("Sibiu");
        device.pressEnter();
        device.findObject(new UiSelector().resourceId("com.google.android.apps.gmm:id/directions_endpoint_textbox")).click();
        device.findObject(new UiSelector().resourceId("com.google.android.apps.gmm:id/search_omnibox_edit_text")).setText("Arad");
        device.pressEnter();
        device.findObject(new UiSelector().description("Start navigation")).click();
    }

    @Test
    public void useSmart() throws Exception {
        // Context of the app under test.

        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        device.pressHome();

        try {
            device.findObject(new UiSelector().description("2")).click();
            device.findObject(new UiSelector().description("2")).click();
            device.findObject(new UiSelector().description("0")).click();
            device.findObject(new UiSelector().description("0")).click();
            device.findObject(new UiSelector().description("Intr.")).click();
        } catch (Exception e) {
        }

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

        device.findObject(new UiSelector().resourceId("com.samsung.android.sm:id/tv_clean_now")).click();
        device.wait(Until.hasObject(By.pkg("com.android.mms").depth(0)),
                LAUNCH_TIMEOUT);

        device.pressHome();
        device.wait(Until.hasObject(By.pkg("com.android.mms").depth(0)),
                LAUNCH_TIMEOUT);

        device.sleep();
    }

    @Test
    public void useNote() throws Exception {
        // Context of the app under test.

        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        device.pressHome();

        try {
            device.findObject(new UiSelector().description("2")).click();
            device.findObject(new UiSelector().description("2")).click();
            device.findObject(new UiSelector().description("0")).click();
            device.findObject(new UiSelector().description("0")).click();
            device.findObject(new UiSelector().description("Intr.")).click();
        } catch (Exception e) {
        }

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

        device.findObject(new UiSelector().resourceId("com.samsung.android.app.memo:id/fab_btn")).click();
        device.findObject(new UiSelector().resourceId("com.samsung.android.app.memo:id/editor_title")).setText("TitleTest");
        device.findObject(new UiSelector().resourceId("com.samsung.android.app.memo:id/editor")).setText("SomeTexttest");
        device.findObject(new UiSelector().resourceId("com.samsung.android.app.memo:id/btn_insert")).click();
        device.findObject(new UiSelector().resourceId("com.samsung.android.app.memo:id/camera")).click();

        Object lock = new Object();
        synchronized (lock) {
            lock.wait(2000);
        }
        device.click(270, 900);

        device.findObject(new UiSelector().resourceId("com.sec.android.app.camera:id/okay")).click();
        device.findObject(new UiSelector().resourceId("com.samsung.android.app.memo:id/mitem_done")).click();

        device.wait(Until.hasObject(By.pkg("com.android.mms").depth(0)),
                LAUNCH_TIMEOUT);

        device.pressHome();
        device.wait(Until.hasObject(By.pkg("com.android.mms").depth(0)),
                LAUNCH_TIMEOUT);

        device.sleep();
    }

    @Test
    public void delPhotos() throws Exception {
        // Context of the app under test.

        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        device.pressHome();

        try {
            device.findObject(new UiSelector().description("2")).click();
            device.findObject(new UiSelector().description("2")).click();
            device.findObject(new UiSelector().description("0")).click();
            device.findObject(new UiSelector().description("0")).click();
            device.findObject(new UiSelector().description("Intr.")).click();
        } catch (Exception e) {
        }

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

        device.click(150, 300);
        Object lock = new Object();
        synchronized (lock) {
            lock.wait(2000);
        }

        device.findObject(new UiSelector().description("Mai multe opţiuni")).click();
        synchronized (lock) {
            lock.wait(2000);
        }
        device.findObject(new UiSelector().text("Selectare")).click();
        device.click(250, 300);
        synchronized (lock) {
            lock.wait(2000);
        }
        device.findObject(new UiSelector().resourceId("com.sec.android.gallery3d:id/action_delete")).click();

        synchronized (lock) {
            lock.wait(2000);
        }
        device.findObject(new UiSelector().resourceId("android:id/button1")).click();

        device.wait(Until.hasObject(By.pkg("com.android.mms").depth(0)),
                LAUNCH_TIMEOUT);

        device.pressHome();
        device.wait(Until.hasObject(By.pkg("com.android.mms").depth(0)),
                LAUNCH_TIMEOUT);

        device.sleep();
    }

    @Test
    public void useAlarm() throws Exception {
        // Context of the app under test.

        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        device.pressHome();

        try {
            device.findObject(new UiSelector().description("2")).click();
            device.findObject(new UiSelector().description("2")).click();
            device.findObject(new UiSelector().description("0")).click();
            device.findObject(new UiSelector().description("0")).click();
            device.findObject(new UiSelector().description("Intr.")).click();
        } catch (Exception e) {
        }

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

        device.findObject(new UiSelector().resourceId("com.sec.android.app.clockpackage:id/alarm_item_leftside")).click();
        //  device.findObject(new UiSelector().resourceId("com.sec.android.app.clockpackage:id/increment")).click();
        device.findObject(new UiSelector().resourceId("com.sec.android.app.clockpackage:id/tfscrollview")).swipeUp(8);

        Object lock = new Object();
        synchronized (lock) {
            lock.wait(2000);
        }

        device.findObject(new UiSelector().resourceId("com.sec.android.app.clockpackage:id/alarm_name_box")).click();
        device.findObject(new UiSelector().resourceId("com.sec.android.app.clockpackage:id/alarm_name_edit")).setText("TestAlarm");

        synchronized (lock) {
            lock.wait(2000);
        }

        device.findObject(new UiSelector().resourceId("com.sec.android.app.clockpackage:id/tfscrollview")).swipeDown(6);
        device.findObject(new UiSelector().resourceId("com.sec.android.app.clockpackage:id/timepicker_input")).click();

        synchronized (lock) {
            lock.wait(2000);
        }

        device.findObject(new UiSelector().className("android.widget.EditText")).setText("09");
        device.findObject(new UiSelector().resourceId("com.sec.android.app.clockpackage:id/menu_done")).click();

        synchronized (lock) {
            lock.wait(2000);
        }

        device.findObject(new UiSelector().resourceId("com.sec.android.app.clockpackage:id/toggle_alarm_button")).click();

        device.pressHome();
        device.wait(Until.hasObject(By.pkg("com.android.mms").depth(0)),
                LAUNCH_TIMEOUT);

        device.sleep();
    }
}