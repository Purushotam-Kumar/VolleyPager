package com.example.windows.volleypager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<String> list = new ArrayList<>();

    public ViewPagerAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size()/4;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.card,null);
        TextView id = view.findViewById(R.id.id);
        TextView type = view.findViewById(R.id.type);
        TextView upvotes = view.findViewById(R.id.upvotes);
        TextView text = view.findViewById(R.id.text);
        TextView pageNumber = view.findViewById(R.id.pageNumber);

        id.setText(list.get(position*4));
        type.setText(list.get((position*4)+1));
        upvotes.setText(list.get((position*4)+2));
        text.setText(list.get((position*4)+3));
        pageNumber.setText(String.valueOf(position+1));

        ViewPager vp = (ViewPager)container;
        vp.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager vp = (ViewPager)container;
        View view = (View) object;
        vp.removeView(view);

    }
}
