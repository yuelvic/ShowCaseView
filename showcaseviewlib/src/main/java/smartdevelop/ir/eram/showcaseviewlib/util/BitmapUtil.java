package smartdevelop.ir.eram.showcaseviewlib.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;

public class BitmapUtil {

    public static RequestOptions requestConfig() {
        return new RequestOptions()
                .transform(new RoundedCorners(45));
    }

    public static void loadImage(String imageUrl, ImageView imageView, Context context) {
        Glide.with(context)
                .load(imageUrl)
                .apply(requestConfig())
                .into(imageView);
    }

    public static Bitmap get(String url, Context context) {
        final Bitmap[] bitmap = {null};
        RequestOptions options = new RequestOptions()
                .transform(new RoundedCorners(30));
        Glide.with(context)
                .asBitmap()
                .load(url)
                .apply(options)
                .into(new Target<Bitmap>() {
                    @Override
                    public void onLoadStarted(Drawable placeholder) {

                    }

                    @Override
                    public void onLoadFailed(Drawable errorDrawable) {

                    }

                    @Override
                    public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                        bitmap[0] = resource;
                    }

                    @Override
                    public void onLoadCleared(Drawable placeholder) {

                    }

                    @Override
                    public void getSize(SizeReadyCallback cb) {
                        cb.onSizeReady(50, 50);
                    }

                    @Override
                    public void removeCallback(SizeReadyCallback cb) {

                    }

                    @Override
                    public void setRequest(Request request) {

                    }

                    @Override
                    public Request getRequest() {
                        return null;
                    }

                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onStop() {

                    }

                    @Override
                    public void onDestroy() {

                    }
                });
        return bitmap[0];
    }

}
