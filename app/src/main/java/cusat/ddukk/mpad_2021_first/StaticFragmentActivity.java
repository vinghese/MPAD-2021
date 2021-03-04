package cusat.ddukk.mpad_2021_first;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;

public class StaticFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_fragment);

        Configuration confi = getResources().getConfiguration();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(confi.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            LeftFragment leftFragment = new LeftFragment();
            fragmentTransaction.replace(android.R.id.content,leftFragment);
        }
        else
        {
            RightFragment rightFragment = new RightFragment();
            fragmentTransaction.replace(android.R.id.content,rightFragment);
        }
            fragmentTransaction.commit();
    }


}