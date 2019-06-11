package com.example.dotaautochessguide.View;
import java.util.Date;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dotaautochessguide.Model.MainModel;
import com.example.dotaautochessguide.R;
import com.example.dotaautochessguide.View.ChampionsView;

@SuppressLint("ValidFragment")
public class ChampionsIntroView extends Fragment {
    private Context context;
    private Integer ChampionsImage;
    private Integer ChampionsRaceImage;
    private Integer ChampionsRaceImage2;
    private Integer ChampionsJobImage;
    private Integer ChampionsSkillImage;
    private Integer ChampionsLevel;
    private String ChampionsName;
    private String ChampionsEngName;
    private String ChampionsHp;
    private String ChampionsDamage;
    private String ChampionsArmor;
    private String ChampionsAttackSpeed;
    private String ChampionsRace;
    private String ChampionsJob;
    private String ChampionsSkillName;
    private String ChampionsSkillIntro;
    private String ChampionsRaceIntro;
    private String ChampionsRaceIntro2;
    private String ChampionsJobIntro;
    private boolean AreRaceOver;
    private String title = "";
    public ChampionsIntroView(Context context,String ChampionsName, Integer ChampionsImage, String ChampionsEngName, String ChampionsHp, String ChampionsDamage, String ChampionsArmor, String ChampionsAttackSpeed,String ChampionsRace,
                                      String ChampionsJob,String ChampionsSkillName,String ChampionsSkillIntro,Integer ChampionsRaceImage,Integer ChampionsJobImage,String ChampionsRaceIntro,String ChampionsJobIntro,boolean AreRaceOver,Integer ChampionsSkillImage,Integer ChampionsLevel,Integer ChampionsRaceImage2,String ChampionsRaceIntro2) {
        super();
        this.context = context;
        this.ChampionsImage = ChampionsImage;
        this.ChampionsRaceImage = ChampionsRaceImage;
        this.ChampionsRaceImage2 = ChampionsRaceImage2;
        this.ChampionsJobImage = ChampionsJobImage;
        this.ChampionsSkillImage = ChampionsSkillImage;
        this.ChampionsLevel = ChampionsLevel;
        this.ChampionsName = ChampionsName;
        this.ChampionsEngName = ChampionsEngName;
        this.ChampionsHp = ChampionsHp;
        this.ChampionsDamage = ChampionsDamage;
        this.ChampionsArmor = ChampionsArmor;
        this.ChampionsAttackSpeed = ChampionsAttackSpeed;
        this.ChampionsRace = ChampionsRace;
        this.ChampionsJob = ChampionsJob;
        this.ChampionsSkillName = ChampionsSkillName;
        this.ChampionsSkillIntro = ChampionsSkillIntro;
        this.ChampionsRaceIntro = ChampionsRaceIntro;
        this.ChampionsRaceIntro2 = ChampionsRaceIntro2;
        this.ChampionsJobIntro = ChampionsJobIntro;
        this.AreRaceOver = AreRaceOver;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //初始化Layout元件,並將對應資料放進所屬元件中
        View view = inflater.inflate(R.layout.champions_intro_fragment, null);
        initView(view);





//		return super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }
    public void initView(View view){
        ImageView ChampionsImageView = (ImageView) view.findViewById(R.id.ChampionsIntroImage);//棋子圖片
        ImageView RaceImageView = (ImageView) view.findViewById(R.id.ChampionsIntroSkillImage);//種族圖片
        ImageView RaceImage2View = (ImageView) view.findViewById(R.id.ChampionsIntroSkillImage4);//種族圖片
        ImageView JobImageView = (ImageView) view.findViewById(R.id.ChampionsIntroSkillImage2);//職業圖片
        ImageView SkillImageView = (ImageView) view.findViewById(R.id.ChampionsIntroSkillImage3);//技能圖片

        TextView ChampionsNameView = (TextView) view.findViewById(R.id.ChampionsIntroName);//棋子名稱
        TextView ChampionsEngNameView = (TextView) view.findViewById(R.id.ChampionsIntroEngName);//棋子英文名稱
        TextView ChampionsHpView = (TextView) view.findViewById(R.id.ChampionsIntroHp);//棋子血量
        TextView ChampionsDamageView = (TextView) view.findViewById(R.id.ChampionsIntroDamage);//棋子傷害
        TextView ChampionsArmorView = (TextView) view.findViewById(R.id.ChampionsIntroArmor);//棋子護甲
        TextView ChampionsAttackSpeedView = (TextView) view.findViewById(R.id.ChampionsIntroAttackSpeed);//棋子攻擊速度
        TextView ChampionsIntroRace = (TextView) view.findViewById(R.id.ChampionsIntroRace);//種族
        TextView ChampionsIntroJob = (TextView) view.findViewById(R.id.ChampionsIntroJob);//職業
        TextView ChampionsIntroRaceView = (TextView) view.findViewById(R.id.ChampionsIntroSkill);//種族介紹
        TextView ChampionsIntroRace2View = (TextView) view.findViewById(R.id.ChampionsIntroSkill4);//種族介紹
        TextView ChampionsIntroJobView = (TextView) view.findViewById(R.id.ChampionsIntroSkill2);//職業介紹
        TextView ChampionsIntroSkillNameView = (TextView) view.findViewById(R.id.ChampionsIntroSkillName);//技能介紹
        TextView ChampionsIntroSkillView = (TextView) view.findViewById(R.id.ChampionsIntroSkill3);//技能名稱

//        ChampionsImageView.setImageResource(ChampionsImage);
        ChampionsImageView.setImageBitmap(MainModel.getRoundedCornerBitmap(
                BitmapFactory.decodeResource(
                        context.getResources(), ChampionsImage), 15.0f));
        RaceImageView.setImageResource(ChampionsRaceImage);
        JobImageView.setImageBitmap(MainModel.getRoundedCornerBitmap(
                BitmapFactory.decodeResource(
                        context.getResources(), ChampionsJobImage), 10.0f));
        SkillImageView.setImageBitmap(MainModel.getRoundedCornerBitmap(
                BitmapFactory.decodeResource(
                        context.getResources(), ChampionsSkillImage), 10.0f));
        ChampionsNameView.setText(ChampionsName);
        ChampionsEngNameView.setText(ChampionsEngName);
        ChampionsHpView.setText(ChampionsHp);
        ChampionsDamageView.setText(ChampionsDamage);
        ChampionsArmorView.setText(ChampionsArmor);
        ChampionsAttackSpeedView.setText(ChampionsAttackSpeed);
        ChampionsIntroRace.setText(ChampionsRace);
        ChampionsIntroJob.setText(ChampionsJob);
        ChampionsIntroRaceView.setText(ChampionsRaceIntro);
        ChampionsIntroJobView.setText(ChampionsJobIntro);
        ChampionsIntroSkillNameView.setText(ChampionsSkillName);
        ChampionsIntroSkillView.setText(ChampionsSkillIntro);

        //如果種族只有1種,隱藏Layout
        if(AreRaceOver){
            //超過的話,執行動作
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ChampionsIntroSkillLayout4);//棋子圖片
            linearLayout.setVisibility(View.VISIBLE);
            RaceImage2View.setImageResource(ChampionsRaceImage2);
            ChampionsIntroRace2View.setText(ChampionsRaceIntro2);
        }
        else{
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ChampionsIntroSkillLayout4);//棋子圖片
            linearLayout.setVisibility(View.GONE);
        }
        //依照棋等上該星等之顏色
        switch(ChampionsLevel){
            case 1:
                MainModel.SetColor(ChampionsNameView,ChampionsEngNameView,"#4f4f4f");
                break;
            case 2:
                MainModel.SetColor(ChampionsNameView,ChampionsEngNameView,"#2894ff");
                break;
            case 3:
                MainModel.SetColor(ChampionsNameView,ChampionsEngNameView,"#0000FF");
                break;
            case 4:
                MainModel.SetColor(ChampionsNameView,ChampionsEngNameView,"#DD15E0");
                break;
            case 5:
                MainModel.SetColor(ChampionsNameView,ChampionsEngNameView,"#EF9227");
                break;
        }
    }


}
