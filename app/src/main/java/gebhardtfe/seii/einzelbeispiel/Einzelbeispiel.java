package gebhardtfe.seii.einzelbeispiel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Einzelbeispiel extends AppCompatActivity {

    private TextView tHeadline ;
    private TextView tDiscription;

    private Button bSend;
    private Button bCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Test","Test");

        setContentView(R.layout.activity_einzelbeispiel);

        tHeadline = findViewById(R.id.tHeadline);
        tDiscription = findViewById(R.id.tDiscription);

        bSend = findViewById(R.id.bSend);
        bCalculate = findViewById(R.id.bCalculate);

        bSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MyApp", "FirstClickDone");
            }
        });

        bCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        Log.d("Test","123");

    }
}