package com.example.dotaautochessguide.Controller;
import java.util.Date;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dotaautochessguide.Model.Data;
import com.example.dotaautochessguide.Model.MainModel;
import com.example.dotaautochessguide.R;
import com.example.dotaautochessguide.View.ChampionsIntroView;
import com.example.dotaautochessguide.View.ChampionsView;

@SuppressLint("ValidFragment")
public class ChampionsViewFragment extends Fragment{
    public static GridView ChampionsGridView;
    public static ChampionsView ChampionsViewAdapter;
    private Integer[] ChampionsImage;
    private Integer[] RaceImage;
    private Integer[] JobImage;
    private Integer[] SkillImage;
    private Integer[] ChampionsLevel;
    private String[] ChampionsName;
    private String[] ChampionsEngName;
    private String[] ChampionsHp;
    private String[] ChampionsDamage;
    private String[] ChampionsArmor;
    private String[] ChampionsAttackSpeed;
    public static ChampionsIntroView fragment;
    private String[] ChampionsRace;
    private String[] ChampionsJob;
    private String[] ChampionsSkill;
    private String[] ChampionsSkillIntro;
    private String[] RaceIntro;
    private String[] JobIntro;
    private String title = "";
    private Integer RaceImageContent;
    private Integer RaceImageContent2;
    private Integer JobImageContent;
    private String RaceIntroContent = "";
    private String RaceIntroContent2 = "";
    private String JobIntroContent = "";
    private boolean AreRaceOver = false;
    public ChampionsViewFragment() {
        super();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //顯示漂浮按鈕
        com.example.dotaautochessguide.Controller.MainActivity.fab_filter.show();
        //初始化Layout元件
        View view = inflater.inflate(R.layout.championslist_fragment, null);
        ChampionsGridView = (GridView)view.findViewById(R.id.ChampionsIcon);
        init(getActivity());

//		return super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }
    public void init(final Context context){
        this.ChampionsImage = Data.ChampionsImage.toArray(new Integer[Data.ChampionsImage.size()]);
        this.RaceImage = Data.RaceImage.toArray(new Integer[Data.RaceImage.size()]);
        this.JobImage = Data.JobImage.toArray(new Integer[Data.JobImage.size()]);
        this.SkillImage = Data.SkillImage.toArray(new Integer[Data.SkillImage.size()]);
        this.ChampionsLevel = Data.ChampionsLevel.toArray(new Integer[Data.ChampionsLevel.size()]);
        this.ChampionsName = Data.ChampionsName.toArray(new String[Data.ChampionsName.size()]);
        this.ChampionsEngName = Data.ChampionsEngName.toArray(new String[Data.ChampionsEngName.size()]);
        this.ChampionsHp = Data.ChampionsHp.toArray(new String[Data.ChampionsHp.size()]);
        this.ChampionsDamage = Data.ChampionsDamage.toArray(new String[Data.ChampionsDamage.size()]);
        this.ChampionsArmor = Data.ChampionsArmor.toArray(new String[Data.ChampionsArmor.size()]);
        this.ChampionsAttackSpeed = Data.ChampionsAttackSpeed.toArray(new String[Data.ChampionsAttackSpeed.size()]);
        this.ChampionsRace = Data.ChampionsRace.toArray(new String[Data.ChampionsRace.size()]);
        this.ChampionsJob = Data.ChampionsJob.toArray(new String[Data.ChampionsJob.size()]);
        this.ChampionsSkill = Data.ChampionsSkill.toArray(new String[Data.ChampionsSkill.size()]);
        this.ChampionsSkillIntro = Data.ChampionsSkillIntro.toArray(new String[Data.ChampionsSkillIntro.size()]);
        this.RaceIntro = Data.RaceIntro.toArray(new String[Data.RaceIntro.size()]);
        this.JobIntro = Data.JobIntro.toArray(new String[Data.JobIntro.size()]);
        ChampionsViewAdapter = new ChampionsView(context, Data.ChampionsName.toArray(new String[Data.ChampionsName.size()]), Data.ChampionsImage.toArray(new Integer[Data.ChampionsImage.size()]), Data.ChampionsLevel.toArray(new Integer[Data.ChampionsLevel.size()]),
                Data.ChampionsRace.toArray(new String[Data.ChampionsRace.size()]),Data.ChampionsJob.toArray(new String[Data.ChampionsJob.size()]));
        ChampionsGridView.setAdapter(ChampionsViewAdapter);
        //設定點選監聽物件
        ChampionsGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.IsViewChampion = 3;
                //顯示選取誰
                //Toast.makeText(getActivity(), "你選取了" + ChampionsName[+position], Toast.LENGTH_SHORT).show();
                com.example.dotaautochessguide.Controller.MainActivity.fab_filter.hide();
                Toast.makeText(getActivity(), "你選取了" + ChampionsName[+position], Toast.LENGTH_SHORT).show();
                //將棋子資料傳入ChampionsIntroViewFragment並跳轉過去
                RaceJobSelector(ChampionsRace[+position],ChampionsJob[+position]);

                fragment = new ChampionsIntroView(context,ChampionsName[+position], ChampionsImage[+position], ChampionsEngName[+position],
                        ChampionsHp[+position], ChampionsDamage[+position], ChampionsArmor[+position], ChampionsAttackSpeed[+position],ChampionsRace[+position],
                        ChampionsJob[+position],ChampionsSkill[+position],ChampionsSkillIntro[+position],RaceImageContent,JobImageContent,RaceIntroContent,JobIntroContent,AreRaceOver,SkillImage[+position],ChampionsLevel[+position],RaceImageContent2,RaceIntroContent2);
                //轉換英雄簡介之Fragment
                MainModel.TransactionGoer(getFragmentManager().beginTransaction(),R.id.main_frameLayout,fragment);
            }
        });
    }

    private void RaceJobSelector(String race,String job){
        if((race.split(",").length) == 1) {
            AreRaceOver = false;
            switch (race) {
                //洞洞族	不眠族	哥布林	冰川族	海族	野獸	光羽族	人族	龍族	靈族	惡魔	基拉	矮人族
                case "洞洞族":
                    RaceImageContent = RaceImage[0];
                    RaceIntroContent = RaceIntro[0];
                    break;
                case "不眠族":
                    RaceImageContent = RaceImage[1];
                    RaceIntroContent = RaceIntro[1];
                    break;
                case "哥布林":
                    RaceImageContent = RaceImage[2];
                    RaceIntroContent = RaceIntro[2];
                    break;
                case "冰川族":
                    RaceImageContent = RaceImage[3];
                    RaceIntroContent = RaceIntro[3];
                    break;
                case "海族":
                    RaceImageContent = RaceImage[4];
                    RaceIntroContent = RaceIntro[4];
                    break;
                case "野獸":
                    RaceImageContent = RaceImage[5];
                    RaceIntroContent = RaceIntro[5];
                    break;
                case "光羽族":
                    RaceImageContent = RaceImage[6];
                    RaceIntroContent = RaceIntro[6];
                    break;
                case "人族":
                    RaceImageContent = RaceImage[7];
                    RaceIntroContent = RaceIntro[7];
                    break;
                case "龍族":
                    RaceImageContent = RaceImage[8];
                    RaceIntroContent = RaceIntro[8];
                    break;
                case "靈族":
                    RaceImageContent = RaceImage[9];
                    RaceIntroContent = RaceIntro[9];
                    break;
                case "惡魔":
                    RaceImageContent = RaceImage[10];
                    RaceIntroContent = RaceIntro[10];
                    break;
                case "基拉":
                    RaceImageContent = RaceImage[11];
                    RaceIntroContent = RaceIntro[11];
                    break;
                case "矮人族":
                    RaceImageContent = RaceImage[12];
                    RaceIntroContent = RaceIntro[12];
                    break;
            }
        }
        else{
            AreRaceOver = true;
            switch (race) {
                //精靈,龍  人類,野獸  人類,龍
                case "龍族,光羽族":
                    RaceImageContent = RaceImage[6];
                    RaceImageContent2 = RaceImage[8];
                    RaceIntroContent = RaceIntro[6];
                    RaceIntroContent2 = RaceIntro[8];
                    break;
                case "人族,野獸": RaceImageContent = RaceImage[7];
                    RaceImageContent2 = RaceImage[5];
                    RaceIntroContent = RaceIntro[7];
                    RaceIntroContent2 = RaceIntro[5];
                    break;
                 case "人族,龍族": RaceImageContent = RaceImage[7];
                    RaceImageContent2 = RaceImage[8];
                    RaceIntroContent = RaceIntro[7];
                    RaceIntroContent2 = RaceIntro[8];
                    break;
            }
        }
            //戰士	德魯伊	法師	獵人	刺客	工匠	騎士	術士	薩滿祭司	惡魔獵手
            switch (job) {
                case "戰士":
                    JobImageContent = JobImage[0];
                    JobIntroContent = JobIntro[0];
                    break;
                case "德魯伊":
                    JobImageContent = JobImage[1];
                    JobIntroContent = JobIntro[1];
                    break;
                case "法師":
                    JobImageContent = JobImage[2];
                    JobIntroContent = JobIntro[2];
                    break;
                case "獵人":
                    JobImageContent = JobImage[3];
                    JobIntroContent = JobIntro[3];
                    break;
                case "刺客":
                    JobImageContent = JobImage[4];
                    JobIntroContent = JobIntro[4];
                    break;
                case "工匠":
                    JobImageContent = JobImage[5];
                    JobIntroContent = JobIntro[5];
                    break;
                case "騎士":
                    JobImageContent = JobImage[6];
                    JobIntroContent = JobIntro[6];
                    break;
                case "術士":
                    JobImageContent = JobImage[7];
                    JobIntroContent = JobIntro[7];
                    break;
                case "薩滿":
                    JobImageContent = JobImage[8];
                    JobIntroContent = JobIntro[8];
                    break;
                case "惡魔獵手":
                    JobImageContent = JobImage[9];
                    JobIntroContent = JobIntro[9];
                    break;
            }
    }

}
