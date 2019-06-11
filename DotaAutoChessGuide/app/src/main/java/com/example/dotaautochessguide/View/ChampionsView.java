package com.example.dotaautochessguide.View;


import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dotaautochessguide.Model.MainModel;
import com.example.dotaautochessguide.R;

import java.util.List;

public class ChampionsView extends BaseAdapter {
    private Context context;
    private String[] ChampionsName,ChampionsRace,ChampionsJob;
    private Integer[] imageId, ChampionsLevel;
    LayoutInflater layoutInflater;

    public ChampionsView(Context context, String[] ChampionsName, Integer[] imageId, Integer[] ChampionsLevel,String[] ChampionsRace,String[] ChampionsJob) {
        this.context = context;
        this.ChampionsName = ChampionsName;
        this.imageId = imageId;
        this.ChampionsLevel = ChampionsLevel;
        this.ChampionsRace = ChampionsRace;
        this.ChampionsJob = ChampionsJob;
        layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return ChampionsName.length;
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
        View grid;
        grid = layoutInflater.inflate(R.layout.champions_gridview, null);
        TextView ChampionsLevelText = (TextView) grid.findViewById(R.id.grid_level);
        TextView ChampionsLevelBg = (TextView) grid.findViewById(R.id.level_bg);
        TextView ChampionsNameView = (TextView) grid.findViewById(R.id.grid_text);
        ImageView imageView = (ImageView) grid.findViewById(R.id.grid_image);
        ImageView RaceimageView = (ImageView) grid.findViewById(R.id.grid_race_image);
        ImageView JobimageView = (ImageView) grid.findViewById(R.id.grid_job_image);
//      將圖片及圓角數值帶入getRoundedCornerBitmap()並放入mImg1內
        switch (ChampionsLevel[position]) {
            case 1:
                ChampionsLevelText.setText("普通");
                ChampionsLevelBg.setBackgroundResource(R.drawable.level_bg_1);
//                MainModel.SetColor(ChampionsNameView, "#4f4f4f");
                break;
            case 2:
                ChampionsLevelText.setText("罕見");
                ChampionsLevelBg.setBackgroundResource(R.drawable.level_bg_2);
//                MainModel.SetColor(ChampionsNameView, "#2894ff");
                break;
            case 3:
                ChampionsLevelText.setText("稀有");
                ChampionsLevelBg.setBackgroundResource(R.drawable.level_bg_3);
//                MainModel.SetColor(ChampionsNameView, "#0000FF");
                break;
            case 4:
                ChampionsLevelText.setText("神話");
                ChampionsLevelBg.setBackgroundResource(R.drawable.level_bg_4);
//                MainModel.SetColor(ChampionsNameView, "#DD15E0");
                break;
            case 5:
                ChampionsLevelText.setText("傳說");
                ChampionsLevelBg.setBackgroundResource(R.drawable.level_bg_5);
//                MainModel.SetColor(ChampionsNameView, "#EF9227");
                break;
        }
        RaceimageView.setImageResource(MainModel.RaceJobSelectorForChampionsView(ChampionsRace[position],ChampionsJob[position])[0]);
        JobimageView.setImageResource(MainModel.RaceJobSelectorForChampionsView(ChampionsRace[position],ChampionsJob[position])[1]);
        ChampionsNameView.setText(ChampionsName[position]);
        imageView.setImageBitmap(MainModel.getRoundedCornerBitmap(
                BitmapFactory.decodeResource(
                        context.getResources(), imageId[position]), 15.0f));
        return grid;
    }

}
