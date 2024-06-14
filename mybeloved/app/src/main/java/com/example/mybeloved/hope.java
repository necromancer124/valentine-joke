package com.example.mybeloved;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class hope extends AppCompatActivity {

    private String[] s = {"Привет! аня Надеюсь у тебя счастливое Восмого марта.",
             "Я действительно счастлив, что мы стали друзьями.",
            " Ты такой милый, дружелюбный и весёлый человек.",
            " с тобой очень приятно и весело общятся", " поэтому я рад,что мы стали друзьями.",
            "И спасибо тебе за то что ты меня пыталась подбодрить с егзамнном","это было очень мило",
            "Обожаю тебя зай!<3",
            "Я не знаю насколко я смогу продолжать общения свами","у меня тикает время но я некогда не забуду вас.",
            "И конечно я не когда не забуду тебя хвхвхв",
            " С Восмого марта! Надеюсь увидеть тебя скоро."};
    private ImageButton talk;
    private Button b;
    private TextView T;
    private int x = 0;
    private MediaPlayer m;
    private MediaPlayer m2;
    private Context c=this;
    private ImageView necrotalk;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hope);
        m2=MediaPlayer.create(c,R.raw.necrovoice);
        PlaybackParams params = new PlaybackParams();
        params.setSpeed(2f); // Adjust the speed as needed
        // Apply PlaybackParams to MediaPlayer
        m2.setPlaybackParams(params);
        T = findViewById(R.id.T);  // Corrected line
        b = findViewById(R.id.button);
        talk = findViewById(R.id.talk);
necrotalk=findViewById(R.id.imageView);
m=MediaPlayer.create(c,R.raw.talksoundtrack);
        m2.setVolume(5.0f,5.0f);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.start();
                b.setVisibility(View.GONE);
                talk.setVisibility(View.VISIBLE);
                necrotalk.setVisibility(View.VISIBLE);
                T.setVisibility(View.VISIBLE);
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

                 startActivity(new Intent(c,valodka.class));
                 finish();

                }
                x++;
                if(x%2==0)
                {
                    necrotalk.setImageResource(R.drawable.necrotalk2);
                }
                else
                {
                    necrotalk.setImageResource(R.drawable.necrotalk1);
                }
            }
        });
    }
    protected void onDestroy() {
        // Stop the handler when the activity is destroyed

        super.onDestroy();
    }
}