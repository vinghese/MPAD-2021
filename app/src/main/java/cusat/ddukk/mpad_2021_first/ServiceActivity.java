package cusat.ddukk.mpad_2021_first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        Button btnStart = (Button)findViewById(R.id.btnServiceStart);
        Button btnStop = (Button)findViewById(R.id.btnServiceStop);

        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btnServiceStart:
                startService(new Intent(this,MPlayerService.class));;
                break;
            case R.id.btnServiceStop:
                Intent intent = new Intent(this,MPlayerService.class);
                stopService(intent);
                break;
            default:

        }

    }
}