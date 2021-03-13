package gebhardtfe.seii.einzelbeispiel;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.*;
import java.net.*;


public class tcpClient implements Runnable{
    private String input;
    private String answer;
    private Socket clientSocket;

    private TextView tAnswer;

    private Handler response;


    public tcpClient(String input, Handler response, TextView tAnswer){
        this.input = input;
        this.response = response;
        this.tAnswer = tAnswer;
    }

    @Override
    public void run() {
        try {
            openSocketandSend();
        }catch (IOException e){
            Log.e("Test","Kein Verbindungsaufbau möglich!");
        }
        response.post(new Runnable() {
            @Override
            public void run() {
                tAnswer.setText(answer);
                tAnswer.setVisibility(View.VISIBLE);
            }
        });
    }


    public void openSocketandSend() throws IOException{
        clientSocket = new Socket("se2-isys.aau.at", 53212);
        DataOutputStream outToServer =
                new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer =
                new BufferedReader(new
                        InputStreamReader(clientSocket.getInputStream()));

        outToServer.writeBytes(input+"\n");
        answer = inFromServer.readLine();
        Log.d("Test",answer);
        clientSocket.close();
        Log.d("Test",answer);
    }
}
