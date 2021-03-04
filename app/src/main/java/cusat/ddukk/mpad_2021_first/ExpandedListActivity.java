package cusat.ddukk.mpad_2021_first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cusat.ddukk.mpad_2021_first.Model.CustomExapandableAdapter;
import cusat.ddukk.mpad_2021_first.Model.ExpandableListModel;

public class ExpandedListActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String,List<String>> expandableListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expanded_list);

        expandableListView = (ExpandableListView)findViewById(R.id.elvList);
        expandableListData= ExpandableListModel.getData();
        expandableListTitle = new ArrayList<>(expandableListData.keySet());
        expandableListAdapter = new CustomExapandableAdapter(this,expandableListTitle,expandableListData);

        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                String title = expandableListTitle.get(groupPosition);

                Toast.makeText(getApplicationContext(),title + "Clicked",Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                String title = expandableListTitle.get(groupPosition);
                String child = expandableListData.get(title).get(childPosition);
                Toast.makeText(getApplicationContext(),title +" --> "+ child, Toast.LENGTH_LONG).show();

                return false;
            }
        });

    }
}