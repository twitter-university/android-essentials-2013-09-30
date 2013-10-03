package com.twitter.twitteru.android.yamba;

import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.twitter.twitteru.android.yamba.svc.YambaServiceHelper;

/**
 * Created by kennethj on 10/2/13.
 */
public class TweetFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "TweetFragment";

    EditText mEditTweet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (BuildConfig.DEBUG) Log.v(TAG, "onCreateView() invoked");

        View top = inflater.inflate(R.layout.fragment_tweet, container, false);

        mEditTweet = (EditText) top.findViewById(R.id.edit_tweet);
        Button buttonPost = (Button) top.findViewById(R.id.button_post);
        buttonPost.setOnClickListener(this);
        return top;
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
            YambaServiceHelper.post(getActivity(), msg);
        }
    }

}
