package com.cslong.app.basic_exercises.test;

import com.blankj.utilcode.util.StringUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

//将字符串key-value 添加到json字符串数组中。。统计模块使用测试

public class CharTest {


    public static void main(String[] args) {

        String content = "content=123&goodid=1234";

        Map<String, String> split = urlSplit(content);


        JsonObject object = new JsonObject();
        for (Map.Entry<String, String> entry : split.entrySet()) {
            //Map.entry<Integer,String> 映射项（键-值对）  有几个方法：用上面的名字entry
            //entry.getKey() ;entry.getValue(); entry.setValue();
            //map.entrySet()  返回此映射中包含的映射关系的 Set视图。
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());

            object.addProperty(entry.getKey(), entry.getValue());

        }


        System.out.println(object.toString());


        String testString = "{\"app_session_timestamp\":\"1553243082\",\"brand\":\"Xiaomi\",\"carrier\":\"中国联通\"}";


//        String testString = "";


        JsonObject object1 = new JsonObject().getAsJsonObject("{app_session_timestamp:1553243082,brand:Xiaomi,carrier:中国联通}");

        try {
            JsonObject objects = new JsonObject();
            if (!StringUtils.isEmpty(testString)) {
                objects = (JsonObject) new JsonParser().parse(testString);
            }


            System.out.println(objects.toString());


            for (Map.Entry<String, String> entry : split.entrySet()) {
                //Map.entry<Integer,String> 映射项（键-值对）  有几个方法：用上面的名字entry
                //entry.getKey() ;entry.getValue(); entry.setValue();
                //map.entrySet()  返回此映射中包含的映射关系的 Set视图。
                System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());

                objects.addProperty(entry.getKey(), entry.getValue());

            }

            System.out.println("添加后：" + objects.toString());

        } catch (Exception e) {
            System.out.println("扑街");
        }


    }

    /**
     * 解析出url参数中的键值对
     * 如 "index.jsp?Action=del&id=123"，解析出Action:del,id:123存入map中
     *
     * @param URL url地址
     * @return url请求参数部分
     * @author lzf
     */
    public static Map<String, String> urlSplit(String URL) {
        Map<String, String> mapRequest = new HashMap<String, String>();
        String[] arrSplit = null;
        String strUrlParam = URL;
        if (strUrlParam == null) {
            return mapRequest;
        }
        arrSplit = strUrlParam.split("[&]");
        for (String strSplit : arrSplit) {
            String[] arrSplitEqual = null;
            arrSplitEqual = strSplit.split("[=]");
            //解析出键值
            if (arrSplitEqual.length > 1) {
                //正确解析
                mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);
            } else {
                if (arrSplitEqual[0] != "") {
                    //只有参数没有值，不加入
                    mapRequest.put(arrSplitEqual[0], "");
                }
            }
        }
        return mapRequest;
    }

}
