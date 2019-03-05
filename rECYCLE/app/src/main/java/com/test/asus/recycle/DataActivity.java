package com.test.asus.recycle;
import java.util.ArrayList;
public class DataActivity {
    private static String[] title = new String[]{"Zeon","Anaheim","Londo Bell",
            "Amuro Ray"};

    private static String[] detail = new String[]{"Zeon, This is the name of the Neo Zeon remnants are known as. After the second Neo Zeon movement, the remaining Neo Zeon troops are gathered by Full Frontal at the ruins of a resource asteroid.",
            "Anaheim, Anaheim Electronics is a fictional civilian manufacturing company originally produced a wide range of technological applications from consumer electronics to battleships and even space colonies. Bow Anaheim Electronics creating advanced mobile weapons for any faction that would be willing to pay, then selling the same technology to the former's enemy.",

            "Londo Bell, Londo Bell is the Earth Federation Forces' special forces unit in during the UC 0090s. It formed not long after the First Neo Zeon War.",
            "Amuro Ray, Amuro is the hero of the anime series Mobile Suit Gundam."
            };

    private static int[] thumbnail = new int[]{R.drawable.zeon,R.drawable.anaheim,
            R.drawable.londo,R.drawable.amuro};

    public static ArrayList<ModelActivity> getListData(){
       ModelActivity Model = null;
        ArrayList<ModelActivity> list = new ArrayList<>();
        for (int i = 0; i <title.length; i++){
            Model = new ModelActivity();
            Model.setThumbnail(thumbnail[i]);
            Model.setTitle(title[i]);
            Model.setDetail(detail[i]);
            list.add(Model);
        }
        return list;
    }









}
