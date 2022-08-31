package com.example.libraryapp;

import static org.junit.Assert.*;

import android.widget.Button;
import android.widget.TextView;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mActivity = null;

    @Before
    public void setUp() throws Exception {
        mActivity = mainActivityTestRule.getActivity();
    }

    @Test
    public void buttonsShouldBeIntialized(){
        Button userLoginBtn = mActivity.findViewById(R.id.googleLoginBtn);
        Button adminLoginBtn = mActivity.findViewById(R.id.btn_adminLoginPage);

        assertNotNull(userLoginBtn);
        assertNotNull(adminLoginBtn);
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}


