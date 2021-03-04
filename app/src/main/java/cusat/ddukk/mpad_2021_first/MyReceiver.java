package cusat.ddukk.mpad_2021_first;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

//        Log.e("ERROR","**********BRoadcast Received****************");

        intent.getAction();

        Toast.makeText(context,intent.getAction()+" Received", Toast.LENGTH_SHORT).show();

    }
}
