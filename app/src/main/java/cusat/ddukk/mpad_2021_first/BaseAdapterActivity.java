package cusat.ddukk.mpad_2021_first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class BaseAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter);

        ListView baseListView;

        String [] country = {"India","America","France","Japan"};
        int flags [] ={R.mipmap.ic_india,R.mipmap.ic_us,R.mipmap.ic_france,R.mipmap.ic_jappan};

        baseListView = (ListView)findViewById(R.id.baseListView);

        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),country,flags);

        baseListView.setAdapter(customAdapter);

        baseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // TextView tvBase=(TextView)findViewById(R.id.tvBaseAdapter);
                Toast.makeText(getApplicationContext(),country[position],Toast.LENGTH_SHORT).show();
            }
        });


    }

    private class CustomAdapter extends BaseAdapter {

        Context context;
        String [] country;
        int [] flags;
        LayoutInflater inflater;

        public CustomAdapter() {
        }

        public CustomAdapter(Context applicationContext, String[] country, int[] flags) {
           this.context=applicationContext;
           this.country = country;
           this.flags = flags;
           inflater = (LayoutInflater.from(applicationContext));
        }


        @Override
        public int getCount() {
            return country.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = inflater.inflate(R.layout.base_adapter_list_view_layout,null);
            TextView country = (TextView)convertView.findViewById(R.id.tvBaseAdapter);
            ImageView icon=(ImageView)convertView.findViewById(R.id.ivBaseAdapter);

            country.setText(this.country[position]);
            icon.setImageResource(flags[position]);


            return convertView;
        }
    }
}