package com.morningwoodsoftware.android.heartomatic.activity;

import android.util.Log;
import android.os.Bundle;
import android.content.Intent;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

import com.actionbarsherlock.app.SherlockPreferenceActivity;

import com.morningwoodsoftware.android.heartomatic.R;
import com.morningwoodsoftware.android.heartomatic.HeartOMaticApplication;

public class PrefsActivity extends SherlockPreferenceActivity
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Log.d(HeartOMaticApplication.TAG, "Main.buttonPrefs clicked: " + item.getItemId());
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
