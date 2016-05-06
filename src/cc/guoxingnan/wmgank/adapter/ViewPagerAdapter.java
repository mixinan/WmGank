package cc.guoxingnan.wmgank.adapter;

import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import cc.guoxingnan.wmgank.R;
import cc.guoxingnan.wmgank.entity.Girl;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;


public class ViewPagerAdapter extends PagerAdapter {

    private List<Girl> data;
    private Context mContext;

    public ViewPagerAdapter(Context context, List<Girl> gankModels) {
    	data = gankModels;
        mContext = context;
    }

    @Override
    public int getCount() {
        if (data != null) {
            return data.size();
        }
        return 0;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.view_pager_item, null);
        ImageView img = (ImageView) view.findViewById(R.id.sdv_view);
        Glide.with(mContext).load(data.get(position).getUrl())
                .placeholder(R.drawable.icon_image_loading).error(R.drawable.icon_image_failure)
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(img);
        container.addView(view);
        return view;
    }

}
