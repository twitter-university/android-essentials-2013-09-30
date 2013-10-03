package com.twitter.twitteru.android.yamba;

import android.app.Activity;
import android.app.ListActivity;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.app.LoaderManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleCursorAdapter;

import com.twitter.twitteru.android.yamba.svc.YambaContract;

/**
 * Created by kennethj on 10/2/13.
 */
public class TimelineActivity extends ListActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    private static final int TIMELINE_LOADER = 42;

    private static final String[] PROJECTION = {
            YambaContract.Timeline.Columns.ID,
            YambaContract.Timeline.Columns.HANDLE,
            YambaContract.Timeline.Columns.TWEET,
    };

    private static final String[] FROM = {
        YambaContract.Timeline.Columns.HANDLE,
        YambaContract.Timeline.Columns.TWEET,
    };

    private static final int[] TO = {
        android.R.id.text1,
        android.R.id.text2,
    };
    private static final String TAG = "TimelineActivity";

    SimpleCursorAdapter mAdapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize our Timeline loader
        getLoaderManager().initLoader(TIMELINE_LOADER, null, this);

        // Get a CursorAdapter
        mAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, null, FROM, TO, 0);
        setListAdapter(mAdapter);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(
                this,
                YambaContract.Timeline.URI,
                PROJECTION,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (BuildConfig.DEBUG) Log.v(TAG, "Cursor returned " + data.getCount() + " rows");
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.timeline, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_tweet:
                // Display the TweetActivity
                startActivity(new Intent(this, TweetActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}