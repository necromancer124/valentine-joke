package com.example.mybeloved;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class skelet extends AppCompatActivity {

    private String[] s = {"Привет! skelet Надеюсь у тебя счастливый День святого Валентина.",
    " ты не забыл поздравить куки?", "смотри мне! посдравить свою жену надо!.",
           " Ты хоть и бываеш мерзким но ты харощый парень",
           "ну и шутки иногда хорошо заходять", " поэтому я рад,что мы стали друзьями.",
           " С Днём святого Валентина! Надеюсь увидеть тебя скоро."};

    private ImageButton talk;
    private Button b;
    private TextView T;
    private int x = 0;
    private MediaPlayer m;
    private MediaPlayer m2;
    private Context c = this;
    private ImageView necrotalk;
    private int skeletgif=0;
    Handler handler = new Handler();
private ImageView skeletim;
private int[] imagearry;
    private void updateImage() {

        if (skeletim != null && imagearry != null && imagearry.length > 0) {
            if (skeletgif < imagearry.length - 1) {
                skeletgif++;
            } else {
                skeletgif = 0;
            }
            skeletim.setImageResource(imagearry[skeletgif]);

        }
        }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        imagearry=new int[]{R.drawable.skelet1,R.drawable.skelet2};

        setContentView(R.layout.activity_skelet);
        m = MediaPlayer.create(c, R.raw.snowfall);
        T = findViewById(R.id.T);  // Corrected line
        b = findViewById(R.id.button);
        talk = findViewById(R.id.talk);
        m2 = MediaPlayer.create(c, R.raw.necrovoice);
        necrotalk = findViewById(R.id.imageView);
        PlaybackParams params = new PlaybackParams();
        params.setSpeed(2f); // Adjust the speed as needed



        // Apply PlaybackParams to MediaPlayer
        m2.setPlaybackParams(params);
        m2.setVolume(5.0f, 5.0f);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.start();
                b.setVisibility(View.GONE);
                talk.setVisibility(View.VISIBLE);
                T.setVisibility(View.VISIBLE);
                necrotalk.setVisibility(View.VISIBLE);
            }
        });

        skeletim=findViewById(R.id.imageskelet);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                updateImage();
                handler.postDelayed(this, 2000); // 1000 milliseconds = 1 second
            }


        }, 1000); // Initial delay before the first update
        talk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m2.start();
                if (x + 1 <= s.length) {
                    T.setText(s[x]);
                } else {

                    m.stop();
                    finish();
                }
                x++;
                if (x % 2 == 0) {
                    necrotalk.setImageResource(R.drawable.necrotalk2);
                } else {
                    necrotalk.setImageResource(R.drawable.necrotalk1);
                }
            }
        });
    }
    protected void onDestroy() {
        // Stop the handler when the activity is destroyed
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}