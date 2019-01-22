package teotw.com.photoviewdemo.photoviewpager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

import teotw.com.photoviewdemo.PhotoView;

/**
 * Created by Administrator on 2015/12/30.
 */

public class MyViewPager extends PagerAdapter {

    int [] ids;
    public MyViewPager( int [] ids){
        this.ids=ids;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {
        PhotoView photoView = new PhotoView(container.getContext());
        position %= ids.length;
        if (position<0){
            position = ids.length+position;
        }
        photoView.setImageResource(ids[position]);

        // Now just add PhotoView to ViewPager and return it
        container.addView(photoView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        //对ViewPager页号求模取出View列表中要显示的项

        return photoView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
