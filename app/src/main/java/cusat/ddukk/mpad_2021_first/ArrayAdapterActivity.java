package cusat.ddukk.mpad_2021_first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter);

        String [] courses = {"Android","Swift","C++","Java","Kotlin","Python","Dart","Flutter","GO"};
        ArrayList<String> course=new ArrayList<>();

        course.addAll(Arrays.asList(courses));

        ListView listView = (ListView)findViewById(R.id.listView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,courses);

        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.list_view_layout,R.id.tvListView,course);

        listView.setAdapter(listAdapter);

        Button btnListAdd = (Button)findViewById(R.id.btnAddList);
        EditText etAddText = (EditText)findViewById(R.id.etAddList);

        btnListAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                course.add(etAddText.getText().toString());
                etAddText.setText("");
                listAdapter.notifyDataSetChanged();

            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                course.remove(position);
                listAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}