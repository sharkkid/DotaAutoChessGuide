package com.example.dotaautochessguide.View;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dotaautochessguide.Controller.MainActivity;
import com.example.dotaautochessguide.Model.MenuPojo;
import com.example.dotaautochessguide.R;

import java.util.List;

public class MenuCardVideAdapter extends RecyclerView.Adapter<MenuCardVideAdapter.ViewHolder> {
    private Context context;
    private List<MenuPojo> manuList;

    public MenuCardVideAdapter(Context context, List<MenuPojo> manuList) {
        this.context = context;
        this.manuList = manuList;
    }

    @Override
    public MenuCardVideAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.manu_carview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuCardVideAdapter.ViewHolder holder, final int position) {
        final MenuPojo Menu_data = manuList.get(position);
        holder.imageId.setImageResource(Menu_data.getImage());
        //將圖片及圓角數值帶入getRoundedCornerBitmap()並放入mImg1內
        holder.text_Menu_Title.setText(String.valueOf(Menu_data.getMenuTitle()));
        holder.text_Menu_SubTitle.setText(Menu_data.getMenuSubTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jump_activity;
                switch (position){
                    case 0:
                        Toast.makeText(context, "努力開發中..敬請期待", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        MainActivity.IsViewChampion = 2;
                        jump_activity = new Intent(context, MainActivity.class);
                        context.startActivity(jump_activity);
                        ((Activity)context).finish();
                        break;
                    case 2:
                        Toast.makeText(context, "努力開發中..敬請期待", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(context, "努力開發中..敬請期待", Toast.LENGTH_SHORT).show();
                        break;


                }

//                Toast.makeText(context, position+"", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return manuList.size();
    }

    //Adapter 需要一個 ViewHolder，只要實作它的 constructor 就好，保存起來的view會放在itemView裡面
    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageId;
        TextView text_Menu_Title, text_Menu_SubTitle;
        ViewHolder(View itemView) {
            super(itemView);
            imageId = (ImageView) itemView.findViewById(R.id.menu_image);
            text_Menu_Title = (TextView) itemView.findViewById(R.id.manu_tile);
            text_Menu_SubTitle = (TextView) itemView.findViewById(R.id.manu_subtile);
        }
    }


}
