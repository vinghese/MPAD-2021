package cusat.ddukk.mpad_2021_first.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import cusat.ddukk.mpad_2021_first.R;

public class CustomExapandableAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> groupTitle;
    private HashMap<String, List<String>> groupList;

    public CustomExapandableAdapter(Context context, List<String> groupTitle, HashMap<String, List<String>> groupList) {
        this.context = context;
        this.groupTitle = groupTitle;
        this.groupList = groupList;
    }


    @Override
    public int getGroupCount() {
        return this.groupTitle.size();
    }

    @Override
    public int getChildrenCount(int position) {
        return groupList.get(groupTitle.get(position)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupTitle.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groupList.get(groupTitle.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String groupTitle = getGroup(groupPosition).toString();
        if(convertView== null)
        {
            LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.elv_group_layout,null);
        }
        TextView tvTitle = (TextView)convertView.findViewById(R.id.tv_group);
        tvTitle.setText(groupTitle);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final String listTitle = getChild(groupPosition,childPosition).toString();
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.elv_item_layout,null);
        }
        TextView tvList = (TextView)convertView.findViewById(R.id.tv_item);
        tvList.setText(listTitle);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
