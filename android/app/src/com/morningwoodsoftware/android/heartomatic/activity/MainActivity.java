package com.morningwoodsoftware.android.heartomatic.activity;

import android.util.Log;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

import com.actionbarsherlock.app.SherlockActivity;

import com.morningwoodsoftware.android.heartomatic.R;
import com.morningwoodsoftware.android.heartomatic.HeartOMaticApplication;

public class MainActivity extends SherlockActivity implements OnClickListener
{
    private HeartOMaticApplication app;

    private TextView textMessage;
    private Button buttonPrefs;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        this.app = (HeartOMaticApplication) getApplication();

        textMessage = (TextView)findViewById(R.id.textMessage);
        if (isConfigured()) {
            textMessage.setText(R.string.configured_message);
        }
        else {
            textMessage.setText(R.string.unconfigured_message);
        }
        buttonPrefs = (Button)findViewById(R.id.buttonPrefs);
        buttonPrefs.setOnClickListener(this);

        Log.d(HeartOMaticApplication.TAG, "Main.onCreate");
    }

    public boolean isConfigured()
    {
        //[TODO]
        return false;
    }

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

    public void onClick(View view)
    {
        if (view == (View)this.buttonPrefs) {
            Log.d(HeartOMaticApplication.TAG, "Main.buttonPrefs clicked");
            this.startActivity(new Intent(this, PrefsActivity.class));
            //[FIXME: do we need Intent flags here?]
        }
    }
}


