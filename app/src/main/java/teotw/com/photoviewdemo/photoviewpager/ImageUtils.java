package teotw.com.photoviewdemo.photoviewpager;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by Administrator on 2015/12/30.
 */
public class ImageUtils {


    public static Bitmap decodeSampledBitmapFromResource(Resources res,
                                                         int resId, int reqWidth, int reqHeight) {
        //  第一次解析将inJustDecodeBounds设置为true，来获取图片大小
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        //  调用上面定义的方法计算inSampleSize值
        options.inSampleSize = myCalculateInSampleSize(options, reqWidth,
                reqHeight);
        //  使用获取到的inSampleSize值再次解析图片
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);

    }

    public static int myCalculateInSampleSize(BitmapFactory.Options options,
                                              int reqWidth, int reqHeight) {
        // 源图片的高度和宽度
        int Height = options.outHeight;
        int Width = options.outWidth;
        int inSampleSize = 1;
        // 如果源图片过大
        if (Height > reqHeight || Width > reqWidth) {
            int heightRatio = Math.round((float) Height / (float) reqHeight);
            int widthRatio = Math.round((float) Width / (float) reqWidth);
            //  选择宽和高中最小的比率作为inSampleSize的值，这样可以保证最终图片的宽和高
            //  一定都会大于等于目标的宽和高。
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        return inSampleSize;
    }
}
