package cc.guoxingnan.wmgank;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import cc.guoxingnan.wmgank.entity.NewResultModel;
import cc.guoxingnan.wmgank.util.StringUtils;

import com.alibaba.fastjson.JSON;

public class GankApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static NewResultModel getOldGank(Context context) {
        NewResultModel newResultModels;
        SharedPreferences preferences = context.getSharedPreferences("gank", MODE_PRIVATE);
        String gankStr = preferences.getString("old_gank", "");
        if (StringUtils.isEmpty(gankStr)) {
            newResultModels = new NewResultModel();
        } else {
            newResultModels = JSON.parseObject(gankStr, NewResultModel.class);
        }
        return newResultModels;
    }

    public static void setOldGank(Context context, String json) {
        SharedPreferences preferences = context.getSharedPreferences("gank", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("old_gank", json);
        editor.commit();
    }

}
