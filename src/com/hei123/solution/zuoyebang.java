package com.hei123.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class zuoyebang {
    public static HashMap<Integer, Integer> map = new HashMap<>();
    public static HashMap<Integer, String> idName = new HashMap<>();

    public static HashMap<String,Integer> nameId=new HashMap<>();

    public static void main(String[] args) {
        ArrayList<Data> data = new ArrayList<>();


    }

    public String getFullName(String name){
        Integer curId = nameId.get(name);
        if (curId==null){
            return "";
        }
        LinkedList<String> result = new LinkedList<>();
        while (true){
            Integer parentId = map.get(curId);
            if (parentId==null){
                break;
            }
            result.add(idName.get(parentId));
            curId=parentId;
        }
        StringBuilder sb = new StringBuilder();
        while (!result.isEmpty()){
            String s = result.pollLast();
            sb.append(s);
        }
        return sb.toString();
    }

    public void buildMap(List<Data> dataList){
        for (int i = 0; i < dataList.size(); i++) {
            idName.put(dataList.get(i).id, dataList.get(i).name);
            nameId.put(dataList.get(i).name,dataList.get(i).id);
            for (int j = 0; j < dataList.get(i).subId.length; j++) {
                map.put(dataList.get(i).subId[j], dataList.get(i).id);
            }
        }
    }


    public static class Data {
        int id;
        String name;
        int[] subId;
    }


}
