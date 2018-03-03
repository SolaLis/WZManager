package gjp.com.wzmanager.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/19.
 */

public class GsonUtil {
    // 将Json数据解析成相应的映射对象
    public static <T> T parseJsonWithGson(String jsonData, Class<T> type) {
        Gson gson = new Gson();
        T result = gson.fromJson(jsonData, type);
        return result;
    }

  /*  // 将Json数组解析成相应的映射对象列表
    public static <T> List<T> parseJsonArrayWithGson(String jsonData, Class<T> type) {
        Gson gson = new Gson();
        List<T> result = gson.fromJson(jsonData, new TypeToken<List<T>>() {
        }.getType());
        return result;
    }*/
  public static <T> List<T> getObjectList(String jsonString, Class<T> cls){
      List<T> list = new ArrayList<T>();
      try {
          Gson gson = new Gson();
          JsonArray arry = new JsonParser().parse(jsonString).getAsJsonArray();
          for (JsonElement jsonElement : arry) {
              list.add(gson.fromJson(jsonElement, cls));
          }
      } catch (Exception e) {
          e.printStackTrace();
      }
      return list;
  }

}
