package com.uacs.android.datafrominternet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;


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

    // Do 2 - 7 in menu.xml ///////////////////////////////////////////////////////////////////////
    // TODO (2) Create a menu xml called 'main.xml' in the res->menu folder
    // TODO (3) Add one menu item to your menu
    // TODO (4) Give the menu item an id of @+id/action_search
    // TODO (5) Set the orderInCategory to 1
    // TODO (6) Show this item if there is room (use app:showAsAction, not android:showAsAction)
    // TODO (7) Set the title to the search string ("Search") from strings.xml
    // Do 2 - 7 in menu.xml ///////////////////////////////////////////////////////////////////////


    // TODO (8) Override onCreateOptionsMenu
    // TODO (9) Within onCreateOptionsMenu, use getMenuInflater().inflate to inflate the menu
    // TODO (10) Return true to display your menu


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    // TODO (11) Override onOptionsItemSelected
    // TODO (12) Within onOptionsItemSelected, get the ID of the item that was selected
    // TODO (13) If the item's ID is R.id.action_search, show a Toast and return true to tell Android that you've handled this menu click
    // TODO (14) Don't forgot to call .show() on your Toast
    // TODO (15) If you do NOT handle the menu click, return super.onOptionsItemSelected to let Android handle the menu click

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuItemThatWasSelected = item.getItemId();
        if (menuItemThatWasSelected == R.id.action_search) {
            Context context = MainActivity.this;
            String message = "Search Clicked!";
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
