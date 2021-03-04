package cusat.ddukk.mpad_2021_first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BroadcastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        Button btnSend = (Button)findViewById(R.id.btnBroadcast);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IntentFilter filter = new IntentFilter();
                filter.addAction(getPackageName() + ".CLASS_ENDS");

               // Toast.makeText(getApplicationContext(),getPackageName()+".CLASS_ENDS",Toast.LENGTH_SHORT).show();

                IntentFilter filter1 = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);

                MyReceiver myReceiver = new MyReceiver();
                registerReceiver(myReceiver, filter);

                registerReceiver(myReceiver, filter1);

                Intent send = new Intent();
                send.setAction("cusat.ddukk.mpad_2021_first.CLASS_ENDS");
                sendBroadcast(send);
                Log.e("ERROR","**********BRoadcast Toast****************");

            }
        });

    }


}
