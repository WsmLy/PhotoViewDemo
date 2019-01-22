package teotw.com.photoviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PhotoView photoView = findViewById(R.id.photoview);
        PhotoViewAttacher attacher = new PhotoViewAttacher(photoView);
        photoView.setImageResource(R.mipmap.world);
        attacher.update();
    }
}
