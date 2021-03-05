package cusat.ddukk.mpad_2021_first;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String boad = intent.getStringExtra("broad");

//        Toast.makeText(context,intent.getAction()+" Received", Toast.LENGTH_SHORT).show();

      //  if(intent.getAction().contains("AIRPLANE"))

        if(boad == null)
        {
            Toast.makeText(context,"Airplane mode changed", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(context,boad, Toast.LENGTH_SHORT).show();

    }
}
