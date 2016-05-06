package cc.guoxingnan.wmgank;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Window;
import android.widget.TextView;
import cc.guoxingnan.wmgank.adapter.ViewPagerAdapter;
import cc.guoxingnan.wmgank.entity.Girl;


public class ImageGalleryActivity extends Activity {

    private ViewPager mViewPager;
    private TextView mCount;
    private Context mContext;
    private ArrayList<Girl> data;
    private int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.image_gallery_layout);
        mContext = this;
        initData();
        initView();
    }

    
    @SuppressWarnings("unchecked")
	private void initData() {
    	data = (ArrayList<Girl>) getIntent().getSerializableExtra("girls");
        position = getIntent().getIntExtra("position", 0);
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mCount = (TextView) findViewById(R.id.count);
        mCount.setText((position + 1) + "/" + data.size());

        mViewPager.setAdapter(new ViewPagerAdapter(mContext, data));
        mViewPager.setCurrentItem(position);
        mViewPager.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mCount.setText((position + 1) + "/" + data.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    
    
    public static void launch(Context context, ArrayList<Girl> girls, int position) {
        Intent intent = new Intent(context, ImageGalleryActivity.class);
        intent.putExtra("girls", (ArrayList<Girl>) girls);
        intent.putExtra("position", position);
        context.startActivity(intent);
    }

}
