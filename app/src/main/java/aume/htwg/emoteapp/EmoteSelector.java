package aume.htwg.emoteapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

public class EmoteSelector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emote_selector);
        /*
        ActionBar ab = getSupportActionBar();
        View men = (View) getLayoutInflater().inflate(R.layout.emote_selector_bar, null);
        ab.setCustomView(men);
        */
    }
}
