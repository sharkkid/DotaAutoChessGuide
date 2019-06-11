package com.example.dotaautochessguide.Model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

import com.example.dotaautochessguide.Controller.ChampionsViewFragment;
import com.example.dotaautochessguide.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainModel {
    //資料排序
    public static <T extends Comparable<T>> void concurrentSort(
            final List<T> key, List<?>... lists){
            // Create a List of indices
            List<Integer> indices = new ArrayList<Integer>();
            for(int i = 0; i < key.size(); i++)
                indices.add(i);

            // Sort the indices list based on the key
            Collections.sort(indices, new Comparator<Integer>(){
                @Override public int compare(Integer i, Integer j) {
                    return key.get(i).compareTo(key.get(j));
                }
            });

            // Create a mapping that allows sorting of the List by N swaps.
            // Only swaps can be used since we do not know the type of the lists
            Map<Integer,Integer> swapMap = new HashMap<Integer, Integer>(indices.size());
            List<Integer> swapFrom = new ArrayList<Integer>(indices.size()),
                    swapTo   = new ArrayList<Integer>(indices.size());
            for(int i = 0; i < key.size(); i++){
                int k = indices.get(i);
                while(i != k && swapMap.containsKey(k))
                    k = swapMap.get(k);

                swapFrom.add(i);
                swapTo.add(k);
                swapMap.put(i, k);
            }

            // use the swap order to sort each list by swapping elements
            for(List<?> list : lists)
                for(int i = 0; i < list.size(); i++)
                    Collections.swap(list, swapFrom.get(i), swapTo.get(i));


    }
    public static void SetColor(TextView ChampionsNameView,String ColorID){
        ChampionsNameView.setTextColor(Color.parseColor(ColorID));
    }
    //切換Fragment
    public static void TransactionGoer(FragmentTransaction transaction, int from_fragment, Fragment target_fragment){
        try {
            transaction.replace(from_fragment, target_fragment);
            transaction.commitNowAllowingStateLoss();
        }
        catch (Exception e){

        }
    }

    //圓角轉換函式，帶入Bitmap圖片及圓角數值則回傳圓角圖，回傳Bitmap再置入ImageView
    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float roundPx)
    {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(),
                bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    //設定文字顏色
    public static void SetColor(TextView ChampionsNameView, TextView ChampionsEngNameView, String ColorID){
        ChampionsNameView.setTextColor(Color.parseColor(ColorID));
        ChampionsEngNameView.setTextColor(Color.parseColor(ColorID));
    }

    public static int[] RaceJobSelectorForChampionsView(String race, String job){
        int img_race = 0;
        int img_job = 0;
        if((race.split(",").length) == 1) {
            switch (race) {
                //洞洞族	不眠族	哥布林	冰川族	海族	野獸	光羽族	人族	龍族	靈族	惡魔	基拉	矮人族
                case "洞洞族":
                    img_race = Data.RaceImage.get(0);
                    break;
                case "不眠族":
                    img_race = Data.RaceImage.get(1);
                    break;
                case "哥布林":
                    img_race = Data.RaceImage.get(2);
                    break;
                case "冰川族":
                    img_race = Data.RaceImage.get(3);
                    break;
                case "海族":
                    img_race = Data.RaceImage.get(4);
                    break;
                case "野獸":
                    img_race = Data.RaceImage.get(5);
                    break;
                case "光羽族":
                    img_race = Data.RaceImage.get(6);
                    break;
                case "人族":
                    img_race = Data.RaceImage.get(7);
                    break;
                case "龍族":
                    img_race = Data.RaceImage.get(8);
                    break;
                case "靈族":
                    img_race = Data.RaceImage.get(9);
                    break;
                case "惡魔":
                    img_race = Data.RaceImage.get(10);
                    break;
                case "基拉":
                    img_race = Data.RaceImage.get(11);
                    break;
                case "矮人族":
                    img_race = Data.RaceImage.get(12);
                    break;
            }
        }
        else{
            switch (race) {
                //精靈,龍  人類,野獸  人類,龍
                case "龍族,光羽族":
                    img_race = Data.RaceImage.get(6);
                    break;
                case "人族,野獸":
                    img_race = Data.RaceImage.get(7);
                    break;
                case "人族,龍族":
                    img_race = Data.RaceImage.get(7);
                    break;
            }
        }
        //戰士	德魯伊	法師	獵人	刺客	工匠	騎士	術士	薩滿祭司	惡魔獵手
        switch (job) {
            case "戰士":
                img_job = Data.JobImage.get(0);
                break;
            case "德魯伊":
                img_job = Data.JobImage.get(1);
                break;
            case "法師":
                img_job = Data.JobImage.get(2);
                break;
            case "獵人":
                img_job = Data.JobImage.get(3);
                break;
            case "刺客":
                img_job = Data.JobImage.get(4);
                break;
            case "工匠":
                img_job = Data.JobImage.get(5);
                break;
            case "騎士":
                img_job = Data.JobImage.get(6);
                break;
            case "術士":
                img_job = Data.JobImage.get(7);
                break;
            case "薩滿":
                img_job = Data.JobImage.get(8);
                break;
            case "惡魔獵手":
                img_job = Data.JobImage.get(9);
                break;
        }
        return new  int[] {img_race,img_job};
    }
}
