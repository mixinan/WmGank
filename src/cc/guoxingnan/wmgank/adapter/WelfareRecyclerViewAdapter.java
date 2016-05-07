package cc.guoxingnan.wmgank.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cc.guoxingnan.wmgank.R;
import cc.guoxingnan.wmgank.entity.Girl;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class WelfareRecyclerViewAdapter extends RecyclerView.Adapter<WelfareRecyclerViewAdapter.ViewHolder> {

	private Context mContext;
	private List<Girl> data;


	public WelfareRecyclerViewAdapter(Context context, List<Girl> data) {
		mContext = context;
		this.data = data;
	}

	@Override
	public WelfareRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(mContext).inflate(R.layout.welfare_item, parent, false);
		return new ViewHolder(view);
	}


	@Override
	public void onBindViewHolder(final WelfareRecyclerViewAdapter.ViewHolder holder, final int position) {
		Girl girl = data.get(position);

		holder.tvTime.setText(girl.getCreatedAt().trim().substring(0, 10));

		String url = girl.getUrl();
		Glide.with(mContext).load(url).placeholder(R.color.stay_color).diskCacheStrategy(DiskCacheStrategy.ALL).centerCrop().into(holder.mImageView);
		
		final int pos = holder.getLayoutPosition();
		if (listener != null) {
			holder.itemView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					listener.onItemClick(holder.itemView, pos);
				}

			});

			holder.itemView.setOnLongClickListener(new OnLongClickListener() {

				@Override
				public boolean onLongClick(View v) {
					listener.onItemLongClick(holder.itemView, pos);
					return false;
				}
			});
		}
	}

	@Override
	public int getItemCount() {
		return data.size();
	}


	class ViewHolder extends RecyclerView.ViewHolder {

		ImageView mImageView;
		TextView tvTime;

		public ViewHolder(View itemView) {
			super(itemView);
			mImageView = (ImageView) itemView.findViewById(R.id.imageView);
			tvTime = (TextView) itemView.findViewById(R.id.girl_tv_time);
		}
	}


	public void update(ArrayList<Girl> girls) {
		data.clear();
		data.addAll(girls);
		notifyDataSetChanged();
	}

	/**
	 * ½Ó¿Ú
	 */
	 private OnItemClickListener listener;

	public interface OnItemClickListener{
		void onItemClick(View view, int position);
		void onItemLongClick(View view, int position);
	}

	public void setOnItemClickListener(OnItemClickListener listener){
		this.listener = listener;
	}
}
