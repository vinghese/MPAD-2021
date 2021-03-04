package cusat.ddukk.mpad_2021_first;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ConstraintLayout layout =(ConstraintLayout) findViewById(R.id.homeLayout);
        registerForContextMenu(layout);

        Button btnChange = (Button) findViewById(R.id.btnChangeText);
        TextView tvHaritha = (TextView) findViewById(R.id.tvHaritha);

        Button btnDialog=(Button)findViewById(R.id.btnDialog);

        Button btnStatus = (Button)findViewById(R.id.btnStatusBar);

        btnStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    NotificationManager notificationManager = null;
                    NotificationChannel notificationChannel = null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

                        notificationChannel = new NotificationChannel("5555","Test Channel", NotificationManager.IMPORTANCE_DEFAULT);
                        notificationChannel.enableLights(true);
                        notificationChannel.enableVibration(true);
                        notificationChannel.setDescription("Test notification channel");
                        notificationManager = (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
                        notificationManager.createNotificationChannel(notificationChannel);
                    }

                NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext(),"5555");
                    notification.setTicker("Nofification Tickers ");
                    notification.setContentText("Notification Text");
                    notification.setSmallIcon(android.R.drawable.stat_notify_sync);

                    notification.setStyle(new NotificationCompat.BigPictureStyle().setBigContentTitle("Status bar Notification"));

                    notification.build();
                Intent notificationIntent = new Intent(getApplicationContext(),MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivities(getApplicationContext(),0, new Intent[]{notificationIntent},PendingIntent.FLAG_UPDATE_CURRENT);

                    notification.setContentIntent(pendingIntent);

                    notificationManager.notify(234,notification.build());






            }
        });

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(HomeActivity.this);
                alertDialog.setTitle("Dialog Title");
                alertDialog.setMessage("This is dialog Message");
                alertDialog.setIcon(R.drawable.ic_camera);
                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      Toast.makeText(getApplicationContext(),"Dialog OK Clicked",Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.setNegativeButton("Cancel",null);

                alertDialog.show();


            }
        });

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //  tvHaritha.setText("Hello Class, first text view change");

             //   Toast.makeText(HomeActivity.this, "Hello Class, This is your first toast.", Toast.LENGTH_LONG).show();

                LayoutInflater inflater = getLayoutInflater();
                View toastLayout=inflater.inflate(R.layout.custom_toast_layout,(ViewGroup) findViewById(R.id.cusatomToastLayout));

                TextView toastTV= (TextView)toastLayout.findViewById(R.id.tvCustomToast);
                ImageView toastIV= (ImageView)toastLayout.findViewById(R.id.ivCustomToast);

                toastTV.setText("This is our own custom toast");
                toastIV.setImageResource(R.drawable.ic_camera);

                Toast cToast=new Toast(getApplicationContext());
                cToast.setDuration(Toast.LENGTH_LONG);
                cToast.setView(toastLayout);
                cToast.setGravity(Gravity.TOP,0,0);
                cToast.show();



            }
        });


    }




    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.menuToast:
                Toast.makeText(getApplicationContext(),"Menu Toast",Toast.LENGTH_LONG).show();
                break;
            case R.id.menuMainActiviy:
                Intent mainActivityIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainActivityIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {

            case R.id.menuCut:
                break;
            case R.id.menuCopy:
                break;
            case R.id.menuPaste:
                Toast.makeText(this,"Menu Paste",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}