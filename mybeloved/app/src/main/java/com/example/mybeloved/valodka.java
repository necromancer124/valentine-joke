package com.example.mybeloved;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class valodka extends AppCompatActivity {
    private Button b1;
    private Button b2;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valodka);

        // Initialize UI components
        b1 = findViewById(R.id.Byas);
        textView = findViewById(R.id.textView);
        b2 = findViewById(R.id.Bno);

        // Set click listener for b2
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Change the position of b2 when clicked
                moveButtonRandomly(b2);
            }
        });

        // Set click listener for b1
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Хорошая девочка");
                b2.setVisibility(View.INVISIBLE);
                b1.setText("Пока зайка");
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
            }
        });
    }

    // Method to move a button to a random position
    private void moveButtonRandomly(Button button) {
        // Get the parent layout (assuming it's a ConstraintLayout)
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) button.getLayoutParams();

        // Set new random position
        int newX = (int) (Math.random() * (getWindow().getDecorView().getWidth() - button.getWidth()));
        int newY = (int) (Math.random() * (getWindow().getDecorView().getHeight() - button.getHeight()));

        // Update the layout parameters
        layoutParams.horizontalBias = (float) newX / getWindow().getDecorView().getWidth();
        layoutParams.verticalBias = (float) newY / getWindow().getDecorView().getHeight();

        // Apply the new layout parameters to the button
        button.setLayoutParams(layoutParams);
    }

}
