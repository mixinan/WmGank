package cc.guoxingnan.wmgank.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
	private Toast toast;
	
	
	public ToastUtil() {
		super();
	}


	public void showToast(Context context,String string){
		if (toast == null) {
			toast = Toast.makeText(context, string, Toast.LENGTH_SHORT);
		}else {
			toast.setText(string);
		}
		toast.show();
	}
	
	public void cancelToast(){
		if (toast!=null) {
		toast.cancel();
		}
	}
	
	
}
