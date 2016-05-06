package cc.guoxingnan.wmgank.adapter;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import cc.guoxingnan.wmgank.R;
import cc.guoxingnan.wmgank.WebViewActivity;
import cc.guoxingnan.wmgank.entity.GankModel;
import cc.guoxingnan.wmgank.util.StringStyleUtils;
import cc.guoxingnan.wmgank.util.ViewHolder;

public class NewListAdapter extends CommonAdapter<GankModel> {

    private Context mContext;
    private List<GankModel> mGankModels;

    public NewListAdapter(Context context, List<GankModel> gankModels) {
        super(context, gankModels, R.layout.item_gank);
        mContext = context;
        mGankModels = gankModels;
    }

    @Override
    public void convert(ViewHolder holder, final GankModel model, int position) {
        TextView tvType = holder.getView(R.id.tv_type);
        TextView tvGank = holder.getView(R.id.tv_title);
        if (position == 0) {
            tvType.setVisibility(View.VISIBLE);
        } else {
            if (model.getType().equals(mGankModels.get(position - 1).getType())) {
                tvType.setVisibility(View.GONE);
            } else {
                tvType.setVisibility(View.VISIBLE);
            }
        }
        tvType.setText(model.getType());
        SpannableStringBuilder builder = new SpannableStringBuilder(model.getDesc())
                .append(StringStyleUtils.format(mContext, " (via: " + model.getWho() + ")",
                        R.style.ViaTextAppearance));
        CharSequence gankText = builder.subSequence(0, builder.length());
        tvGank.setText(gankText);

        tvGank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	//TODO
            }
        });

    }
}
