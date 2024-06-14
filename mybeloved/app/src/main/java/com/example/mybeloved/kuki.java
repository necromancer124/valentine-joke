package com.example.mybeloved;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class kuki extends AppCompatActivity {

    private String[] s = {"Привет! крыса Надеюсь у тебя счастливый День святого Валентина.",
            "и спасибо что помогла с проектом", "<3",
            " Ты такой милый, дружелюбный и весёлый человек.",
            " с тобой очень приятно и весело общятся", " поэтому я рад,что мы стали друзьями.",
            "шучу >:3", "давай удачи сучка.", "с любовю некро.","ps","КАНЧАЮ СТРАШНО ПЕРЕЧЕСТЬ"};

    private ImageButton talk;
    private Button b;
    private ImageView image;

    private TextView T;
    private int x = 0;
    private ImageView necrotalk;
    private MediaPlayer m;
    private MediaPlayer m2;
    private Context c = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuki);
        T = findViewById(R.id.T);  // Corrected line
        b = findViewById(R.id.button);
        talk = findViewById(R.id.talk);
        necrotalk = findViewById(R.id.imageView);
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

}