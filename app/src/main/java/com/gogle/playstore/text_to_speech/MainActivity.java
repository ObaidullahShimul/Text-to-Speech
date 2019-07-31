package com.gogle.playstore.text_to_speech;

import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends Activity {

    EditText text;
    Button btn;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        text=(EditText)findViewById(R.id.text);
        btn=(Button)findViewById(R.id.btn);

        tts=new TextToSpeech(MainActivity.this,new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.ENGLISH);
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts.speak(text.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }
}
