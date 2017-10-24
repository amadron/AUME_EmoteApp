package aume.htwg.emoteapp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toolbar;

import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import model.Data;
import model.Entry;

public class EmoteSelector extends AppCompatActivity {

    private final List<Integer> colorGradien;
    private int currentModeValue;
    private String currentTitle;

    public EmoteSelector() {
        currentModeValue = 5;
        currentTitle = "";
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
        final EditText test = (EditText)findViewById(R.id.titelInput);
        test.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                currentTitle= s.toString();
            }
        });


        setTextValueWithProgress(textValue,currentModeValue);
        setSliderColorForNewValue(seekBar,currentModeValue);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub

                currentModeValue = progress;
                setTextValueWithProgress(textValue,progress);
                setSliderColorForNewValue(seekBar,progress);

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

    public void sendElement(View view) {
        Log.d("title",currentTitle);
        int id = Data.getEntryNumbers();
        Date dt = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        Entry entry = new Entry(id, currentTitle, currentModeValue, format.format(dt));
        Data.addEntry(entry);
        Log.d("EmoteSelector", Data.getEntryListJson().toString());
    }

    public void goBack(View view)
    {
        finish();
    }
}
