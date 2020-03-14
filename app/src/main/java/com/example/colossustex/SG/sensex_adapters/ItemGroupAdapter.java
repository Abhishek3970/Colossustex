package com.example.colossustex.SG.sensex_adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colossustex.R;
import com.example.colossustex.SG.model.ItemData;
import com.example.colossustex.SG.model.ItemGroup;

import java.util.List;

public class ItemGroupAdapter extends RecyclerView.Adapter<ItemGroupAdapter.MyViewHolder> {

    private Context context;
    private List<ItemGroup> dataList;

    public ItemGroupAdapter(Context context, List<ItemGroup> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.activity_sensex, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        MyViewHolder.headtitle.setText(dataList.get(position).getHeadTitle());
        List<ItemData> itemData = dataList.get(position).getListelements();
        MyItemAdapter itemListAdapter = new MyItemAdapter(context, itemData);
        MyViewHolder.recycler_view_item_list.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        MyViewHolder.recycler_view_item_list.setAdapter(itemListAdapter);

        MyViewHolder.recycler_view_item_list.setNestedScrollingEnabled(false);

        MyViewHolder.Live_sensex.setText(dataList.get(position).getLivesensex());

    }

    @Override
    public int getItemCount() {
        return (dataList != null ? dataList.size() : 0);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        static TextView headtitle;
        static TextView Live_sensex;
        static RecyclerView recycler_view_item_list;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            headtitle = itemView.findViewById(R.id.head_sensex);
            Live_sensex = itemView.findViewById(R.id.Live_sensex);
            recycler_view_item_list = itemView.findViewById(R.id.sub_list);

        }
    }
}
