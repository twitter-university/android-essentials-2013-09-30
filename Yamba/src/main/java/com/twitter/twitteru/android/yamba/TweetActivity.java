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
    YambaClient mYambaClient;
    Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (BuildConfig.DEBUG) Log.v(TAG, "onCreate() invoked");

        setContentView(R.layout.activity_tweet);
        mEditTweet = (EditText) findViewById(R.id.edit_tweet);
        Button buttonPost = (Button) findViewById(R.id.button_post);
        buttonPost.setOnClickListener(this);

        // Initialize a reusable Toast
        mToast = Toast.makeText(this, null, Toast.LENGTH_LONG);

        mYambaClient = new YambaClient("student", "password");
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

    /* Old AsyncTask implementation
    class PostToTwitter extends AsyncTask<String, Void, Integer> {
        @Override
        protected Integer doInBackground(String... params) {
            int result = R.string.post_tweet_fail;
            if (params.length > 0) {
                try {
                    mYambaClient.postStatus(params[0]);
                    result = R.string.post_tweet_success;
                } catch (YambaClientException e) {
                    Log.e(TAG, "Failed to post tweet", e);
                }
            }
            return result;
        }

        @Override
        protected void onPostExecute(Integer result) {
            mToast.setText(result);
            mToast.show();
        }
    }
    */


    @Override
    protected void onStart() {
        super.onStart();
        if (BuildConfig.DEBUG) Log.v(TAG, "onStart() invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (BuildConfig.DEBUG) Log.v(TAG, "onPause() invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (BuildConfig.DEBUG) Log.v(TAG, "onResume() invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (BuildConfig.DEBUG) Log.v(TAG, "onStop() invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (BuildConfig.DEBUG) Log.v(TAG, "onRestart() invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (BuildConfig.DEBUG) Log.v(TAG, "onDestroy() invoked");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tweet, menu);
        return true;
    }

}
