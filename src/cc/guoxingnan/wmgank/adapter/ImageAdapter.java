package cc.guoxingnan.wmgank.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cc.guoxingnan.wmgank.R;
import cc.guoxingnan.wmgank.entity.Girl;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class ImageAdapter extends BaseAdapter {
	private Context context;
	private LayoutInflater inflater;
	private ArrayList<Girl> data;

	public ImageAdapter(Context context) {
		super();
		this.context = context;
	}

	public ImageAdapter(Context context, ArrayList<Girl> girls) {
		this.context = context;
		setData(girls);
		inflater = LayoutInflater.from(this.context);
	}

	public void setData(ArrayList<Girl> data) {
		if (data == null) {
			data = new ArrayList<Girl>();
		}
		this.data = data;
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	class ViewHolder {
		TextView tvName, tvTime;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		final ImageView imageView;
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.welfare_item, null);
			imageView = (ImageView) convertView.findViewById(R.id.imageView);
			holder.tvTime = (TextView) convertView
					.findViewById(R.id.girl_tv_time);
			convertView.setTag(holder);
		} else {
			imageView = (ImageView) convertView.findViewById(R.id.imageView);
			holder = (ViewHolder) convertView.getTag();
		}
		final Girl girl = data.get(position);
		holder.tvTime.setText(girl.getCreatedAt().trim().substring(0, 10));
		
		// œ‘ æÕº∆¨
		
		Glide.with(context).load(girl.getUrl()).placeholder(R.color.stay_color).diskCacheStrategy(DiskCacheStrategy.ALL).centerCrop().into(imageView);
        
		return convertView;
	}

	public void update(ArrayList<Girl> girls) {
		data.clear();
		data.addAll(girls);
		notifyDataSetChanged();
	}
}
