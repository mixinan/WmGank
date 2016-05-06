package cc.guoxingnan.wmgank.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cc.guoxingnan.wmgank.R;
import cc.guoxingnan.wmgank.entity.Android;

public class AndroidAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<Android> data;
	
	public AndroidAdapter(Context context, ArrayList<Android> data) {
		super();
		this.context = context;
		if (data==null) data = new ArrayList<Android>();
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

	
	class ViewHolder{
		TextView who,from,url,desc,time;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.item_android, null);
			holder = new ViewHolder();
			holder.desc = (TextView) convertView.findViewById(R.id.desc);
			holder.time = (TextView) convertView.findViewById(R.id.time);
			convertView.setTag(holder);
		}else {
			holder = (ViewHolder) convertView.getTag();
		}
			Android item = data.get(position);
			holder.desc.setText(item.getDesc());
			holder.time.setText(item.getTime().substring(0, 10));
			
		return convertView;
	}
	
	public void reflash(ArrayList<Android> list){
		data = list;
		notifyDataSetChanged();
	}

}
