package aume.htwg.emoteapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    public static String filename = "testfile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        String lastVote = loadFileContent();
        TextView txtView = (TextView) findViewById(R.id.textView);
        if(lastVote.isEmpty())
            txtView.setText("Not voted Yet");
        else
            txtView.setText("Last Vote:" + lastVote);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    String loadFileContent()
    {
        String ret = "";
        File f = getFileStreamPath(filename);
        StringBuilder str = new StringBuilder();
        Log.v("MainActivity", "Start!");
        if(f.exists())
        {
            Log.v("MainActivity", "File Exists");
            try {
                BufferedReader bf = new BufferedReader(new FileReader(f));
                String line = "";
                while((line = bf.readLine()) != null)
                {
                    str.append(line);
                }
                bf.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        ret = str.toString();
        return ret;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void openSelectorView(View v) {
        Intent intent = new Intent(this, EmoteSelector.class);
        startActivity(intent);
    }
}
