package com.example.mybeloved;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;

   private Context c=this;
   Intent intent;
    private MediaPlayer mediaPlayer;
    private MediaPlayer mediaPlayer2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this, R.raw.kukisound);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.tvaritokyocafe);
        mediaPlayer2.start();
        b1=findViewById(R.id.hope);
        intent=new Intent(c, hope.class);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer2.stop();
                int[] x={R.drawable.hope1,R.drawable.hope2};
                intent.putExtra("login",x);
                finish();
                startActivity(intent);
            }
        });
    }
}