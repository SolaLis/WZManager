package gjp.com.wzmanager.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jp on 2017/4/22.
 */

public class ActivityCollector {
    public static List<Activity> activities=new ArrayList<>();

    /**
     * 将当前activity加入到activities
     * @param activity
     */
    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    /**
     * 将当前activity从activities移除
     * @param activity
     */
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    /**
     * finish activities中的所有activity
     */
    public static void finishAll(){
        for (Activity activity:activities){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
