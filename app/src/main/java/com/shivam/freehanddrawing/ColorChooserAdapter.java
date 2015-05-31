package com.shivam.freehanddrawing;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;

public class ColorChooserAdapter extends BaseAdapter {

	private Activity activity;
	public ColorChooserAdapter(Activity activity) {
		this.activity = activity;
	}

	@Override
	public int getCount() {
        return C.COLORS.length;
    }

	@Override
	public Object getItem(int position) {
		return Integer.valueOf(C.COLORS[position]);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = new View(activity);
			convertView.setLayoutParams(new AbsListView.LayoutParams(200, activity.getResources().getInteger(R.integer.height_color_list)));
		}
		convertView.setBackgroundColor(activity.getResources().getColor((Integer)getItem(position)));
		return convertView;
	}
}
