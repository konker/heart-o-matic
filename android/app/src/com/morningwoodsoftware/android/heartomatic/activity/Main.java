package com.morningwoodsoftware.android.heartomatic.activity;

import android.util.Log;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

import com.morningwoodsoftware.android.heartomatic.R;
import com.morningwoodsoftware.android.heartomatic.HeartOMaticApplication;

public class Main extends Activity implements OnClickListener
{
    private HeartOMaticApplication app;

    private Button buttonPrefs;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        this.app = (HeartOMaticApplication) getApplication();

        buttonPrefs = (Button)findViewById(R.id.buttonPrefs);
        buttonPrefs.setOnClickListener(this);

        Log.d(HeartOMaticApplication.TAG, "Main.onCreate");
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


