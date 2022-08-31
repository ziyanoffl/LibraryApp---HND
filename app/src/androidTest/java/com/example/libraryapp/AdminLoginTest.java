package com.example.libraryapp;

import static org.junit.Assert.*;

import android.view.View;
import android.widget.TextView;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class AdminLoginTest {

    @Rule
    public ActivityTestRule<AdminLogin> adActivityTestRule = new ActivityTestRule<AdminLogin>(AdminLogin.class);

    private AdminLogin mActivity = null;

    @Before
    public void setUp() throws Exception {
        mActivity = adActivityTestRule.getActivity();
    }

    @Test
    public void adminShouldBeAbleToLogin(){
        TextView username = mActivity.findViewById(R.id.tvAdminUsername);

        mActivity.GoToAdminHomepage("Admin33","pass");
        assertTrue(mActivity.isLoggedIn());
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}

