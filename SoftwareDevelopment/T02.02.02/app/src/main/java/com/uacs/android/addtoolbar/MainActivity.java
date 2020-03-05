package com.uacs.android.addtoolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar =  (Toolbar) findViewById(R.id.toolbar);
        //setActionBar(toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Welcome!");
        toolbar.setSubtitle("Folks!");

        //we can add features as in ActionBar
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setLogo(R.drawable.logo);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String msg = "";

        switch (item.getItemId()) {

            case R.id.discard:
                msg = getString(R.string.delete);
                break;

            case R.id.search:
                msg = getString(R.string.search);
                break;

            case R.id.edit:
                msg = getString(R.string.edit);
                break;

            case R.id.settings:
                msg = getString(R.string.settings);
                break;

            case R.id.Exit:
                msg = getString(R.string.exit);
                break;
        }

        Toast.makeText(this, msg + " clicked !", Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }
}
