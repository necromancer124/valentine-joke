package com.example.mybeloved;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.List;

public class login extends AppCompatActivity {
    private final List<String> passwords = Arrays.asList("321205", "192091411", "1691919", "241913", "621181825", "26");
    // cute, stinki, piss, bdsm, furry, bf

    private Context context = this;
    private Button loginButton;
    private Button b1;
    private EditText passwordEditText;
    private ImageView top;
    private ImageView down;
    int[] imagearry;
    Handler handler = new Handler();
    private  int skeletgif=0;
    private MediaPlayer m;
    private void updateImage() {

        if (top != null && imagearry != null && imagearry.length > 0) {
            if (skeletgif < imagearry.length - 1) {
                skeletgif++;
            } else {
                skeletgif = 0;
            }
            top.setImageResource(imagearry[skeletgif]);
            if(skeletgif==0)
            down.setImageResource(imagearry[skeletgif+1]);
            else down.setImageResource(imagearry[skeletgif-1]);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = findViewById(R.id.b);
        passwordEditText = findViewById(R.id.editTextTextPassword);
        b1 = findViewById(R.id.button2);
        imagearry= getIntent().getIntArrayExtra("login");
        top=findViewById(R.id.imagecorner1);
        down=findViewById(R.id.imagecorner2);
        top.setImageResource(imagearry[0]);
        down.setImageResource(imagearry[0]);
        if(imagearry[0]!=R.drawable.malif1)
        down.setScaleX(-1);
        else top.setScaleX(-1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                startActivity(new Intent(context, MainActivity.class));
            }
        });

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                updateImage();
                handler.postDelayed(this, 1000); // 1000 milliseconds = 1 second
            }


        }, 1000); // Initial delay before the first update
        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String enteredPassword = s.toString();

                if (passwords.contains(enteredPassword)) {
                    loginButton.setVisibility(View.VISIBLE);
                    setOnClickListenerForActivity(enteredPassword);
                } else {
                    loginButton.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    private void setOnClickListenerForActivity(String enteredPassword) {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class<?> targetActivity = determineTargetActivity(enteredPassword);
                if (targetActivity != null) {
                    startActivity(new Intent(context, targetActivity));
                }
            }
        });
    }

    private Class<?> determineTargetActivity(String enteredPassword) {
        switch (enteredPassword) {
            case "321205":
                return hope.class;
            case "192091411":
                return kuki.class;
            case "1691919":
                return seynara.class;
            case "241913":
                return malif.class;
            case "621181825":
                return roma.class;
            case "26":
                return skelet.class;
            default:
                return null;
            // cute, stinki, piss, bdsm, furry, bf
        }
    }

}









