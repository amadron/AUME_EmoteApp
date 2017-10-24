package aume.htwg.emoteapp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toolbar;

import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

public class EmoteSelector extends AppCompatActivity {

    private final List<Integer> colorGradien;
    private int currentModeValue;

    public EmoteSelector() {
        currentModeValue = 5;
        colorGradien = new LinkedList<>();
        colorGradien.add(Color.parseColor("#ff0000"));
        colorGradien.add(Color.parseColor("#e21506"));
        colorGradien.add(Color.parseColor("#c62a0c"));
        colorGradien.add(Color.parseColor("#aa3f12"));
        colorGradien.add(Color.parseColor("#8d5418"));
        colorGradien.add(Color.parseColor("#716a1f"));
        colorGradien.add(Color.parseColor("#557f25"));
        colorGradien.add(Color.parseColor("#38942b"));
        colorGradien.add(Color.parseColor("#1ca931"));
        colorGradien.add(Color.parseColor("#19ab32"));
        colorGradien.add(Color.parseColor("#00bf38"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emote_selector);


        final SeekBar seekBar = (SeekBar) findViewById(R.id.modeBaar);
        final TextView textValue = (TextView)findViewById(R.id.modeBarText);



        this.setTextValueWithProgress(textValue,currentModeValue);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub

                currentModeValue = progress;
                setTextValueWithProgress(textValue,progress);
                setSliderColorForNewValue(seekBar,progress);
                saveString(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });
    }

    public void setSliderColorForNewValue(SeekBar seekBar, int progress) {
        seekBar.getThumb().setColorFilter(colorGradien.get(progress), PorterDuff.Mode.SRC_IN);
        seekBar.getProgressDrawable().setColorFilter(colorGradien.get(progress), PorterDuff.Mode.SRC_IN);
    }

    public void setTextValueWithProgress(TextView text, int progress) {
        text.setText(String.valueOf(progress));
        text.setTextColor(colorGradien.get(progress));
    }

    void saveString(String str)
    {
        FileOutputStream fout;
        try{
            fout = openFileOutput(MainActivity.filename, Context.MODE_PRIVATE);
            fout.write(str.getBytes());
            fout.close();
            Log.v("MainActivity", "Written");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void goBack(View view)
    {
        finish();
    }
}
