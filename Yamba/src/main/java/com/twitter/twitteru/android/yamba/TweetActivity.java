package com.twitter.twitteru.android.yamba;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class TweetActivity extends Activity {
    private static final String TAG = "TweetActivity";

    EditText mEditTweet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (BuildConfig.DEBUG) Log.v(TAG, "onCreate() invoked");
        setContentView(R.layout.activity_tweet);
    }

}
