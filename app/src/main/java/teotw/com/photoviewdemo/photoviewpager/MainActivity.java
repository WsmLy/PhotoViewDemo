package teotw.com.photoviewdemo.photoviewpager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import teotw.com.photoviewdemo.R;

public class MainActivity extends AppCompatActivity {
    GridView gr_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pager);
        gr_view= (GridView) findViewById(R.id.gr_view);
        initView();
    }

    /**
     * 初始化数据
     */
    private void initView() {
        final int [] ids=new int[]{
                R.drawable.nana,
                R.drawable.nana1,
                R.drawable.nana2,
                R.drawable.nana3,
                R.drawable.nana4,
                R.drawable.nana5,
                R.drawable.nana6,
                R.drawable.nana7,
                R.drawable.nana8,
                R.drawable.nana9,
                R.drawable.nana10,
                R.drawable.nana11,
                R.drawable.nana12,
                R.drawable.nana13,
                R.drawable.nana14,
                R.drawable.nana15,
                R.drawable.nana16
        };
        PicAdapter adapter=new PicAdapter(MainActivity.this,ids);
        gr_view.setAdapter(adapter);

        gr_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("onItemClick", "点击的位置为" + position);
                Intent intent=new Intent(MainActivity.this, PhotoViewActivity.class);
                intent.putExtra("list",ids);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });
    }
}
