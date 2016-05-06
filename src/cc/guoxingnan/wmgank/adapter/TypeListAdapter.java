package cc.guoxingnan.wmgank.adapter;

import android.content.Context;

import java.util.List;

import cc.guoxingnan.wmgank.R;
import cc.guoxingnan.wmgank.entity.GankModel;
import cc.guoxingnan.wmgank.util.ViewHolder;

public class TypeListAdapter extends CommonAdapter<GankModel> {


    public TypeListAdapter(Context context, List<GankModel> gankModels) {
        super(context, gankModels, R.layout.item_type);
    }


    @Override
    public void convert(ViewHolder holder, GankModel model, int position) {
        holder.setText(R.id.tv_who, "via: " + model.getWho())
                .setText(R.id.tv_desc, model.getDesc())
                .setText(R.id.tv_url, model.getUrl())
                .setText(R.id.tv_time, model.getPublishedAt().substring(0, 10));
    }
}
