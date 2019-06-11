package com.example.dotaautochessguide.Controller;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.dotaautochessguide.Model.Data;
import com.example.dotaautochessguide.Model.MainModel;
import com.example.dotaautochessguide.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Arrays;
import java.util.List;

import static com.example.dotaautochessguide.Model.MainModel.concurrentSort;

public class MainActivity extends AppCompatActivity{
    public static FloatingActionButton fab,fab_filter;
    public static BottomNavigationView navigation;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private ChampionsViewFragment championsviewfragment;
    private ItemsListFragment itemsListfragment;
    private AdView mAdView;
    public static int IsViewChampion = 1; // 1:主畫面 2:圖鑑 3:角色介紹
    //漂浮按鈕可移動之參數
    private float dX, dY;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = this.getWindow();
// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
// finally change the color
        window.setStatusBarColor(Color.parseColor("#2a50bd"));
        init();
        initView();
        ListenerInit();

    }
    private void init() {
        //初始化排序 - 依照棋子等級排序
        concurrentSort(Data.ChampionsLevel,Data.ChampionsImage,Data.SkillImage,Data.ChampionsLevel,Data.ChampionsName,Data.ChampionsEngName,Data.ChampionsHp,Data.ChampionsDamage,Data.ChampionsArmor,Data.ChampionsAttackSpeed,Data.ChampionsRace,Data.ChampionsJob,Data.ChampionsSkill,Data.ChampionsSkillIntro);
        //concurrentSort(ChampionsRace,ChampionsImage,SkillImage,ChampionsLevel,ChampionsName,ChampionsEngName,ChampionsHp,ChampionsDamage,ChampionsArmor,ChampionsAttackSpeed,ChampionsRace,ChampionsJob,ChampionsSkill,ChampionsSkillIntro);

    }
    private void initView() {
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //fab = findViewById(R.id.fab);
        fab_filter = findViewById(R.id.filter);
//        //廣告置入
//        MobileAds.initialize(this, "ca-app-pub-9996546910295915~9954151889");

//        AdView adView = new AdView(this);
//        adView.setAdSize(AdSize.BANNER);
//        adView.setAdUnitId("ca-app-pub-9996546910295915/8300614278");//我的廣告 ca-app-pub-9996546910295915/8300614278   //測試用廣告ca-app-pub-3940256099942544/6300978111

//        mAdView = findViewById(R.id.adView);
//        mAdView.setBackgroundColor(Color.BLACK);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);

        //初始化Fragment元件
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        championsviewfragment = new ChampionsViewFragment();
        itemsListfragment = new ItemsListFragment();

        transaction.add(R.id.main_frameLayout, championsviewfragment);
        transaction.commit();



    }
    private void ListenerInit(){
        //首頁漂浮按鈕監聽事件
        /*
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                MainModel.TransactionGoer(transaction,R.id.main_frameLayout,championsviewfragment);

            }
        });

        fab.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:

                        dX = view.getX() - event.getRawX();
                        dY = view.getY() - event.getRawY();
                        break;

                    case MotionEvent.ACTION_MOVE:

                        view.animate()
                                .x(event.getRawX() + dX)
                                .y(event.getRawY() + dY)
                                .setDuration(0)
                                .start();
                        break;
                    default:
                        return false;
                }
                return false;
            }
        });*/
        //棋子篩選器漂浮按鈕監聽事件
        fab_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                //Toast.makeText(MainActivity.this,"篩選器建置中....", Toast.LENGTH_SHORT).show();
                PopupMenu popup = new PopupMenu(MainActivity.this,fab_filter);
                popup.getMenuInflater().inflate(R.menu.popup_main,popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getTitle().toString()){
                            case "初始化(依等級)":
                                concurrentSort(Data.ChampionsLevel,Data.ChampionsImage,Data.SkillImage,Data.ChampionsLevel,Data.ChampionsName,Data.ChampionsEngName,Data.ChampionsHp,Data.ChampionsDamage,Data.ChampionsArmor,Data.ChampionsAttackSpeed,Data.ChampionsRace,Data.ChampionsJob,Data.ChampionsSkill,Data.ChampionsSkillIntro);
                                break;
                            case "種族":
                                concurrentSort(Data.ChampionsRace,Data.ChampionsImage,Data.SkillImage,Data.ChampionsLevel,Data.ChampionsName,Data.ChampionsEngName,Data.ChampionsHp,Data.ChampionsDamage,Data.ChampionsArmor,Data.ChampionsAttackSpeed,Data.ChampionsRace,Data.ChampionsJob,Data.ChampionsSkill,Data.ChampionsSkillIntro);
                                break;
                            case "職業":
                                concurrentSort(Data.ChampionsJob,Data.ChampionsImage,Data.SkillImage,Data.ChampionsLevel,Data.ChampionsName,Data.ChampionsEngName,Data.ChampionsHp,Data.ChampionsDamage,Data.ChampionsArmor,Data.ChampionsAttackSpeed,Data.ChampionsRace,Data.ChampionsJob,Data.ChampionsSkill,Data.ChampionsSkillIntro);
                                break;
                            case "名字":
                                concurrentSort(Data.ChampionsName,Data.ChampionsImage,Data.SkillImage,Data.ChampionsLevel,Data.ChampionsName,Data.ChampionsEngName,Data.ChampionsHp,Data.ChampionsDamage,Data.ChampionsArmor,Data.ChampionsAttackSpeed,Data.ChampionsRace,Data.ChampionsJob,Data.ChampionsSkill,Data.ChampionsSkillIntro);
                                break;
                        }
                        championsviewfragment.init(MainActivity.this);
                        return false;
                    }
                });
                popup.show();
            }
        });
        //導覽按鈕設置監聽事件
        navigation.setOnNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.champions_btn:
                        MainModel.TransactionGoer(getSupportFragmentManager().beginTransaction(),R.id.main_frameLayout,championsviewfragment);
                        fab_filter.show();
                        return true;
                    case R.id.items_btn:
                        MainModel.TransactionGoer(getSupportFragmentManager().beginTransaction(),R.id.main_frameLayout,itemsListfragment);
                        fab_filter.hide();
                        return true;
                    case R.id.monsters_btn:
                        Toast.makeText(MainActivity.this,"怪物群建置中....", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment instanceof  ChampionsViewFragment){
            championsviewfragment = (ChampionsViewFragment) fragment;
        }
    }

    @Override
    public void  onBackPressed() {
        MainModel.TransactionGoer(transaction,R.id.main_frameLayout,championsviewfragment);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent myIntent = new Intent();
            switch (IsViewChampion){
                case 1:
                    this.finish();
                    break;
                case 2:
                    MainActivity.IsViewChampion = 1;
                    myIntent = new Intent(this, com.example.dotaautochessguide.Controller.Menu.class);
                    startActivity(myIntent);
                    this.finish();
                    break;
                case 3:
                    MainActivity.IsViewChampion = 2;
                    myIntent = new Intent(this, com.example.dotaautochessguide.Controller.MainActivity.class);
                    startActivity(myIntent);
                    this.finish();
                    break;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}
