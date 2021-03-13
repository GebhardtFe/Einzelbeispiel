package gebhardtfe.seii.einzelbeispiel;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class AlternierendeQuersumme implements Runnable {
    private String mtrk;

    private Handler response;
    private  TextView tAnswer;

    public AlternierendeQuersumme (String mtrk, Handler response, TextView tAnswer){
        this.mtrk = mtrk;
        this.response = response;
        this.tAnswer = tAnswer;
    }

    @Override
    public void run() {
        int alternierdeQuersumme = firstMinusSecondSums();
        printOutIfTheAlternierdeQuersummeOfMtrkIsEven(alternierdeQuersumme);
        Log.d("Quersumme", "run()");
    }

    public void printOutIfTheAlternierdeQuersummeOfMtrkIsEven(int alternierdeQuersumme){
        Log.d("Quersumme", "printOutIfTheAlternierdeQuersummeOfMtrkIsEven(int alternierdeQuersumme)");
        response.post(new Runnable() {
            @Override
            public void run() {
                if(isEven(alternierdeQuersumme)){
                    tAnswer.setText("Die AlternierendeQuersumme: "+ alternierdeQuersumme + " ist gerade!");
                }
                else{
                    tAnswer.setText("Die AlternierendeQuersumme: "+ alternierdeQuersumme + " ist ungerade!");
                }

                tAnswer.setVisibility(View.VISIBLE);
            }
        });
    }

    public boolean isEven(int alternierdeQuersumme){
        Log.d("Quersumme", "isEven(int alternierdeQuersumme)");
        if (alternierdeQuersumme % 2 == 0){
            return true;
        }
        return false;
    }

    public int firstMinusSecondSums(){
        int sum = sumEverySecondNumberBeginningWithTheFirst()- sumEverySecondNumberBeginningWithTheSecond();
        return sum;
    }

    public int sumEverySecondNumberBeginningWithTheFirst(){
        return sumEverySecondNumber(0);
    }

    public int sumEverySecondNumberBeginningWithTheSecond(){
        return sumEverySecondNumber(1);
    }

    public int sumEverySecondNumber(int startNumber){
        int subtotal = 0;
        do{
            subtotal = subtotal + Character.getNumericValue(mtrk.charAt(startNumber));
            startNumber = startNumber + 2;
        }while(startNumber < mtrk.length());
        return subtotal;
    }









}
