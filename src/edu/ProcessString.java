package edu;

import com.oracle.javafx.jmx.json.JSONWriter;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProcessString {


    public static void main(String args[]) throws JSONException {
        JSONArray jsonArray  = new JSONArray();

        ProcessString obj = new ProcessString();
        ArrayList<String> list=obj.process("cheese,extraSomething/anything,something,oohh/aahhh,fuck,chodu/mc");
        for (String val:list)
        {
        if(val.contains("/")){
            String[] str_chop =val.split("/");
            JSONObject jsonObject=new JSONObject();
           int i=0;
            for (String s:str_chop) {

                jsonObject.put("values"+i,s);
i++;
            }
            jsonArray.put(jsonObject);
        }
        }
        for (int i=0;i<jsonArray.length();i++)
        {
            JSONObject js=jsonArray.getJSONObject(i);
            for(int j=0;j<js.length();j++)
            System.out.println(js.get("values"+j));
            System.out.println("---------");
        }
    }

    ArrayList<String> process(String str){
      ArrayList<String> list = new ArrayList<String>();

      String[] str_chop =str.split(",");
        for (String value: str_chop) {
            list.add(value);
        }
      return list;
    }

}
