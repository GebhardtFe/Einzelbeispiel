package gebhardtfe.seii.einzelbeispiel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.NumberPicker;

public class Einzelbeispiel extends AppCompatActivity {

    private TextView tHeadline ;
    private TextView tDiscription;
    private TextView tAnswer;

    private Button bSend;
    private Button bCalculate;

    private EditText iNumber;

    private Handler response = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Test","Test");

        setContentView(R.layout.activity_einzelbeispiel);

        tHeadline = findViewById(R.id.tHeadline);
        tDiscription = findViewById(R.id.tDiscription);
        tAnswer = findViewById(R.id.tAnswer);

        iNumber = findViewById(R.id.iNumber);

        bSend = findViewById(R.id.bSend);
        bCalculate = findViewById(R.id.bCalculate);

        bSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tcpClient client = new tcpClient(iNumber.getText().toString(), response, tAnswer);
                new Thread(client).start();
            }
        });

        bCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        iNumber.setText("11926537");

        Log.d("Test","123");
    }

}