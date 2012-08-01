package com.morningwoodsoftware.android.heartomatic.activity;

import android.util.Log;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.app.SherlockActivity;

import com.morningwoodsoftware.android.heartomatic.R;
import com.morningwoodsoftware.android.heartomatic.HeartOMaticApplication;

public class MainActivity extends SherlockActivity
{
    private HeartOMaticApplication app;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        this.app = (HeartOMaticApplication) getApplication();

        Button buttonStartWorkout = (Button)findViewById(R.id.buttonStartWorkout);
        buttonStartWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Log.d(HeartOMaticApplication.TAG, "Main.buttonStartWorkout clicked");
                Intent intent = new Intent(MainActivity.this, WorkoutActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        /*
        TextView textMessage = (TextView)findViewById(R.id.textMessage);
        if (isConfigured()) {
            textMessage.setText(R.string.configured_message);
        }
        else {
            textMessage.setText(R.string.unconfigured_message);
        }
        */

        TextView statusText;
        ImageView icon;

        // Popluate status panel
        statusText = (TextView)findViewById(R.id.statusPanelZonesText);
        icon = (ImageView)findViewById(R.id.statusPanelZonesIcon);
        if (areZonesConfigured()) {
            icon.setImageResource(android.R.drawable.presence_online);
            statusText.setText(R.string.zones_configured);
        }
        else {
            icon.setImageResource(android.R.drawable.presence_busy);
            statusText.setText(R.string.zones_not_configured);
        }

        statusText = (TextView)findViewById(R.id.statusPanelHRBeltText);
        icon = (ImageView)findViewById(R.id.statusPanelHRBeltIcon);
        if (isHeartRateBeltConfigured()) {
            icon.setImageResource(android.R.drawable.presence_online);
            statusText.setText(R.string.hr_belt_configured);
        }
        else {
            icon.setImageResource(android.R.drawable.presence_busy);
            statusText.setText(R.string.hr_belt_not_configured);
        }
        Log.d(HeartOMaticApplication.TAG, "Main.onCreate");
    }

    public boolean isHeartRateBeltConfigured()
    {
        //TODO
        return true;
    }

    public boolean areZonesConfigured()
    {
        int moderateZoneHigh = getModerateZoneHigh();
        int moderateZoneLow  = getModerateZoneLow();
        if (moderateZoneHigh < 0 || moderateZoneHigh < 0) {
            return false;
        }
        return true;
    }

    public int getModerateZoneHigh()
    {
        try {
            return Integer.parseInt(app.getPrefs().getString(getString(R.string.moderate_zone_high), "-1"));
        }
        catch (NumberFormatException ex) {
            return -1;
        }
    }

    public int getModerateZoneLow()
    {
        try {
            return Integer.parseInt(app.getPrefs().getString(getString(R.string.moderate_zone_low), "-1"));
        }
        catch (NumberFormatException ex) {
            return -1;
        }
    }

    public boolean isConfigured()
    {
        //[TODO]
        /* check:
           - zones are configured
           - a hr belt is configured
           - a hr belt is connected
                - implies bluetooth
        */
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Log.d(HeartOMaticApplication.TAG, "Main.buttonPrefs clicked: " + item.getItemId());
        switch (item.getItemId()) {
            case R.id.menuPreferences:
                Intent intent = new Intent(this, PrefsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /* Lifecycle methods [TODO: remove if uneeded?] */
    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d(HeartOMaticApplication.TAG, "Main.onPause");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d(HeartOMaticApplication.TAG, "Main.onResume");
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d(HeartOMaticApplication.TAG, "Main.onStart");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d(HeartOMaticApplication.TAG, "Main.onRestart");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d(HeartOMaticApplication.TAG, "Main.onStop");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d(HeartOMaticApplication.TAG, "Main.onDestroy");
    }
}


