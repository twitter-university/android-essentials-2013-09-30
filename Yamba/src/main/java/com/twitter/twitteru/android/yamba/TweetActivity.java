package com.twitter.twitteru.android.yamba;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class TweetActivity extends Activity {
    public static final String TAG = "TweetActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, "onCreate() invoked");

        setContentView(R.layout.activity_tweet);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "onStart() invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "onPause() invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "onResume() invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "onStop() invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG, "onRestart() invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "onDestroy() invoked");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tweet, menu);
        return true;
    }

}
