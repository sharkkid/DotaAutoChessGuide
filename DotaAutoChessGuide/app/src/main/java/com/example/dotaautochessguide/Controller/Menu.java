package com.example.dotaautochessguide.Controller;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Window;
import android.view.WindowManager;

import com.example.dotaautochessguide.Model.MenuPojo;
import com.example.dotaautochessguide.R;
import com.example.dotaautochessguide.View.MenuCardVideAdapter;
import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {
    @SuppressLint("NewApi")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = this.getWindow();
        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        // finally change the color
        window.setStatusBarColor(Color.parseColor("#2a50bd"));
        setContentView(R.layout.activity_menu);
        init();


    }
    private void init(){
        List<MenuPojo> menuList = new ArrayList<>();
        menuList.add(new MenuPojo(R.drawable.menu_1, getString(R.string.menu__title1), getString(R.string.menu_subtitle1)));
        menuList.add(new MenuPojo(R.drawable.menu_2, getString(R.string.menu__title2), getString(R.string.menu_subtitle2)));
        menuList.add(new MenuPojo(R.drawable.menu_3, getString(R.string.menu__title3), getString(R.string.menu_subtitle3)));
        menuList.add(new MenuPojo(R.drawable.menu_4, getString(R.string.menu__title4), getString(R.string.menu_subtitle4)));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MenuCardVideAdapter(this, menuList));
    }
}

