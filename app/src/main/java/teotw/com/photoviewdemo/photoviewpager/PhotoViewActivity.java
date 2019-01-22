package teotw.com.photoviewdemo.photoviewpager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import teotw.com.photoviewdemo.R;

public class PhotoViewActivity extends AppCompatActivity {
    HackyViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photoview);
        viewPager = (HackyViewPager) findViewById(R.id.viewpager);
        int position = getIntent().getExtras().getInt("position", -1);
        final int[] ids = getIntent().getIntArrayExtra("list");
            MyViewPager adapter = new MyViewPager(ids);
            viewPager.setAdapter(adapter);
            //将当前的照片跳转到点击的位置
            viewPager.setCurrentItem(position, false);

    }


}
