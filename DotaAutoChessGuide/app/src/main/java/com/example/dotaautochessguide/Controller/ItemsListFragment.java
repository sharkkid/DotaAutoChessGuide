package com.example.dotaautochessguide.Controller;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dotaautochessguide.Model.Data;
import com.example.dotaautochessguide.R;

public class ItemsListFragment extends Fragment {
    private ListView ItemList;

    public ItemsListFragment() {
        // Requires empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.itemslist_fragment, container, false);
        ItemList = root.findViewById(R.id.item_listview);
        ItemList.setAdapter(new ItemListViewAdapter(getActivity()));
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
class ItemListViewAdapter extends BaseAdapter {
    private LayoutInflater myInflater;

    public ItemListViewAdapter(Context c) {
        myInflater = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return Data.ItemsImage.toArray(new Integer[Data.ItemsImage.size()]).length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return Data.ItemsImage.toArray(new Integer[Data.ItemsImage.size()])[position];
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        convertView = myInflater.inflate(R.layout.items_listview, null);

        ImageView ItemImageView = (ImageView) convertView.findViewById(R.id.item_image);
        TextView ItemNameView = (TextView) convertView.findViewById(R.id.item_title);
        TextView ItemIntroView = (TextView) convertView.findViewById(R.id.item_detail);

        ItemImageView.setImageResource(Data.ItemsImage.toArray(new Integer[Data.ItemsImage.size()])[position]);
        ItemNameView.setText(Data.ItemsName.toArray(new String[Data.ItemsName.size()])[position]);
        ItemIntroView.setText(Data.ItemsIntro.toArray(new String[Data.ItemsIntro.size()])[position]);

        return convertView;
    }

}
