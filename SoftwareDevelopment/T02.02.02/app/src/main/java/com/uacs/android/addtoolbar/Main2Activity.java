package com.uacs.android.addtoolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Toast;
import android.view.MenuItem;

public class Main2Activity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Welcome !");
        toolbar.setSubtitle("Folks !");

        toolbar.inflateMenu(R.menu.main);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

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

                Toast.makeText(Main2Activity.this, msg + " clicked !", Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }
}
