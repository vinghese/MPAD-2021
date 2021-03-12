package cusat.ddukk.mpad_2021_first;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cusat.ddukk.mpad_2021_first.Model.RecyclerDataModel;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        List<RecyclerDataModel> dataModels = new ArrayList<>();
        dataModels.add(new RecyclerDataModel("Email", android.R.drawable.ic_dialog_email));
        dataModels.add(new RecyclerDataModel("Info", android.R.drawable.ic_dialog_info));
        dataModels.add(new RecyclerDataModel("Delete", android.R.drawable.ic_delete));
        dataModels.add(new RecyclerDataModel("Alert", android.R.drawable.ic_dialog_alert));
        dataModels.add(new RecyclerDataModel("Map", android.R.drawable.ic_dialog_map));
        dataModels.add(new RecyclerDataModel("Email", android.R.drawable.ic_dialog_email));
        dataModels.add(new RecyclerDataModel("Info", android.R.drawable.ic_dialog_info));
        dataModels.add(new RecyclerDataModel("Delete", android.R.drawable.ic_delete));
        dataModels.add(new RecyclerDataModel("Alert", android.R.drawable.ic_dialog_alert));
        dataModels.add(new RecyclerDataModel("Map", android.R.drawable.ic_dialog_map));
        dataModels.add(new RecyclerDataModel("Email", android.R.drawable.ic_dialog_email));
        dataModels.add(new RecyclerDataModel("Info", android.R.drawable.ic_dialog_info));
        dataModels.add(new RecyclerDataModel("Delete", android.R.drawable.ic_delete));
        dataModels.add(new RecyclerDataModel("Alert", android.R.drawable.ic_dialog_alert));
        dataModels.add(new RecyclerDataModel("Map", android.R.drawable.ic_dialog_map));

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerViewList);
        CustomRecyclerAdapter adapter = new CustomRecyclerAdapter(dataModels);
        recyclerView.setHasFixedSize(true);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }

    private class CustomRecyclerAdapter extends RecyclerView.Adapter<ViewHolder>{
        private final List<RecyclerDataModel> dataModels;

        public CustomRecyclerAdapter(List<RecyclerDataModel> dataModels) {
            this.dataModels = dataModels;
        }


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View listItem = inflater.inflate(R.layout.recycler_layout,null);
            ViewHolder viewHolder = new ViewHolder(listItem);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            RecyclerDataModel recyclerDataItem = dataModels.get(position);
            holder.textView.setText(recyclerDataItem.getDescription());
            holder.imageView.setImageResource(recyclerDataItem.getImgId());
        }

        @Override
        public int getItemCount() {
            return dataModels.size();
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
       // public RelativeLayout relativeLayout;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView =(ImageView)itemView.findViewById(R.id.tvrImage);
            this.textView =(TextView)itemView.findViewById(R.id.tvrName);

        }
    }
}