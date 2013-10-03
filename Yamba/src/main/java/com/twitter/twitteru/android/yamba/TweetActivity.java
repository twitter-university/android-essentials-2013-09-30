package com.twitter.twitteru.android.yamba;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.twitter.twitteru.android.yamba.svc.YambaServiceHelper;

import com.marakana.android.yamba.clientlib.YambaClient;
import com.marakana.android.yamba.clientlib.YambaClientException;

public class TweetActivity extends Activity implements View.OnClickListener {
    public static final String TAG = "TweetActivity";

    EditText mEditTweet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (BuildConfig.DEBUG) Log.v(TAG, "onCreate() invoked");

        setContentView(R.layout.activity_tweet);
        mEditTweet = (EditText) findViewById(R.id.edit_tweet);
        Button buttonPost = (Button) findViewById(R.id.button_post);
        buttonPost.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.button_post:
                if (BuildConfig.DEBUG) Log.v(TAG, "Tweet button clicked");
                postTweet();
                break;
            default:
                // We should never get here!
                Log.w(TAG, "Unknown view clicked?");
        }
    }

    private void postTweet() {
        String msg = mEditTweet.getText().toString();
        mEditTweet.setText(null);
        if (!TextUtils.isEmpty(msg)) {
            if (BuildConfig.DEBUG) Log.v(TAG, "User entered: " + msg);
            // Post the tweet on a worker thread using an AsyncTask
            YambaServiceHelper.post(this, msg);
        }
    }

}
