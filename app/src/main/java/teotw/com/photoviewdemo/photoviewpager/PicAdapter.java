package teotw.com.photoviewdemo.photoviewpager;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import teotw.com.photoviewdemo.R;

/**
 * Created by Administrator on 2015/12/30.
 */
public class PicAdapter extends BaseAdapter {
    private Context context;
    int[] ids;
    public PicAdapter(Context context,int[] ids){
        this.context=context;
        this.ids=ids;
    }
    @Override
    public int getCount() {
        if (ids!=null){
            return ids.length;
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return ids[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView==null){
            convertView=View.inflate(context, R.layout.item_pic,null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        //计算图片的大小,防止OOM
        Bitmap bitmap=ImageUtils.decodeSampledBitmapFromResource(context.getResources(), ids[position], 180, 240);
        viewHolder.imageView.setImageBitmap(bitmap);
        return convertView;
    }

    public static class ViewHolder{
        ImageView imageView;
        public ViewHolder(View view){

            imageView = (ImageView) view.findViewById(R.id.iv);
        }
    }

}
