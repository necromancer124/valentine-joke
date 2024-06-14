package com.example.mybeloved;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class roma extends AppCompatActivity {

    private String[] s = {"Привет! ром Надеюсь у тебя счастливый День святого Валентина.",
            "Я действительно счастлив что встретил тебя мой сладкий.",
            " Ты такой милый, дружелюбный и весёлый фурии <3.",
            " с тобой очень приятно и весело общятся", " поэтому я рад,что мы стали друзьями.",
            " Надеюсь, что мы сможем продолжить это дружбу на долгое время!",
            " С Днём святого Валентина! Надеюсь увидеть тебя скоро."};
    private ImageButton talk;
    private Button b;
    private TextView T;
    private int x = 0;
    private MediaPlayer m;
    private MediaPlayer m2;
    private Context c = this;
    private ImageView necrotalk;
    Handler handler = new Handler();
    private ImageView skeletim;
    private int[] imagearry;
    private  int skeletgif=0;
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
        setContentView(R.layout.activity_roma);

        T = findViewById(R.id.T);  // Corrected line
        b = findViewById(R.id.button);
        talk = findViewById(R.id.talk);
        necrotalk = findViewById(R.id.imageView);
        imagearry=new int[]{R.drawable.roma1,R.drawable.roma2};
        m = MediaPlayer.create(c, R.raw.talksoundtrack);
        m2 = MediaPlayer.create(c, R.raw.necrovoice);
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
        skeletim=findViewById(R.id.imageroma);
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