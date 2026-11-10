package com.example.losowanko;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Random random = new Random();
        int liczba = random.nextInt(12);
        Toast.makeText(this, ""+ liczba, Toast.LENGTH_SHORT).show();

        Button[] przyciski = {
                findViewById(R.id.button1),
                findViewById(R.id.button2),
                findViewById(R.id.button3),
                findViewById(R.id.button4),
                findViewById(R.id.button5),
                findViewById(R.id.button6),
                findViewById(R.id.button7),
                findViewById(R.id.button8),
                findViewById(R.id.button9),
                findViewById(R.id.button10),
                findViewById(R.id.button11),
                findViewById(R.id.button12),
        };
        TextView wynik = findViewById(R.id.textView1);
        int proba = 0;
        for (int i = 0; i<12; i++) {
            int button = i + 1;
            proba++;
            int finalProba = proba;
            przyciski[i].setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (button == liczba) {
                                Toast.makeText(MainActivity.this, "Brawo zgadles za " + finalProba + " razem!!",
                                        Toast.LENGTH_SHORT).show();
                                        przyciski[button-1].setBackgroundColor(Color.GREEN);
                                        finish();

                            } else {
                                Toast.makeText(MainActivity.this,
                                        "Zle, sproboj ponownie!", Toast.LENGTH_SHORT).show();
                                        przyciski[button-1].setBackgroundColor(Color.RED);
                            }

                        }
                    }
            );
        }
    }
}