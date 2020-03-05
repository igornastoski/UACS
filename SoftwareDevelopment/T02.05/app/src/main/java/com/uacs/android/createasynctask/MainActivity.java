package com.uacs.android.createasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.AsyncTask;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.uacs.android.createasynctask.utilities.NetworkUtils;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private EditText mSearchBoxEditText;

    private TextView mUrlDisplayTextView;

    private TextView mSearchResultsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchBoxEditText = (EditText) findViewById(R.id.et_search_box);

        mUrlDisplayTextView = (TextView) findViewById(R.id.tv_url_display);
        mSearchResultsTextView = (TextView) findViewById(R.id.tv_github_search_results_json);
    }

    /**
     * This method retrieves the search text from the EditText, constructs the URL
     * (using {@link NetworkUtils}) for the github repository you'd like to find, displays
     * that URL in a TextView, and finally fires off an AsyncTask to perform the GET request using
     * our (not yet created) {@link GithubQueryTask}
     */
    private void makeGithubSearchQuery() {
        String githubQuery = mSearchBoxEditText.getText().toString();
        URL githubSearchUrl = NetworkUtils.buildUrl(githubQuery);
        mUrlDisplayTextView.setText(githubSearchUrl.toString());

        // TODO (4) Create a new GithubQueryTask and call its execute method, passing in the url to query
        new GithubQueryTask().execute(githubSearchUrl);
    }

    // TODO (1) Create a class called GithubQueryTask that extends AsyncTask<URL, Void, String>
    public class GithubQueryTask extends AsyncTask<URL, Void, String> {
        // TODO (2) Override the doInBackground method to perform the query. Return the results. (Hint: You've already written the code to perform the query)
        @Override
        protected String doInBackground(URL... urls) {
            URL searchUrl = urls[0];
            String githubSearchResults = null;
            try {
                githubSearchResults = NetworkUtils.getResponseFromHttpUrl(searchUrl);
            } catch (IOException e){
                e.printStackTrace();

            }
            return githubSearchResults;
        }

        // TODO (3) Override onPostExecute to display the results in the TextView

        @Override
        protected void onPostExecute(String s) {

            if (s != null && !s.equals("")) {
                mSearchResultsTextView.setText(s);
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();
        if (itemThatWasClickedId == R.id.action_search) {
            makeGithubSearchQuery();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
