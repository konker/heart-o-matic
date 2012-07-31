package com.morningwoodsoftware.android.heartomatic.activity;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.morningwoodsoftware.android.heartomatic.R;
import com.morningwoodsoftware.android.heartomatic.HeartOMaticApplication;

public class PrefsActivity extends PreferenceActivity
{
    HeartOMaticApplication app;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        app = (HeartOMaticApplication) getApplication();

        addPreferencesFromResource(R.xml.prefs);
        setContentView(R.layout.prefs);

        Log.d(HeartOMaticApplication.TAG, "PrefsActivity.onCreate");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d(HeartOMaticApplication.TAG, "PrefsActivity.onPause");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d(HeartOMaticApplication.TAG, "PrefsActivity.onResume");
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d(HeartOMaticApplication.TAG, "PrefsActivity.onStart");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d(HeartOMaticApplication.TAG, "PrefsActivity.onRestart");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d(HeartOMaticApplication.TAG, "PrefsActivity.onStop");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d(HeartOMaticApplication.TAG, "PrefsActivity.onDestroy");
    }
}
