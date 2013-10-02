package com.twitter.twitteru.android.yamba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.twitter.twitteru.android.yamba.svc.YambaContract;

/**
 * Created by kennethj on 10/2/13.
 */
public class PostCompleteReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        boolean result = intent.getBooleanExtra(YambaContract.Service.PARAM_POST_SUCCEEDED, false);
        Toast.makeText(
                context,
                (result) ? R.string.post_tweet_success : R.string.post_tweet_fail,
                Toast.LENGTH_LONG)
                .show();
    }
}
