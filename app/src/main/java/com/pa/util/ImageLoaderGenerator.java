package com.pa.util;

import android.content.Context;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.pa.R;

public class ImageLoaderGenerator {
    private static ImageLoader imageLoader = null;

    public static ImageLoader getInstance(Context context) {
        if(imageLoader == null){
            DisplayImageOptions options = new DisplayImageOptions.Builder()
                    //.showStubImage(R.drawable.img_loading)
                    .cacheInMemory(true)
                    .cacheOnDisc(true)
                    .build();

            ImageLoaderConfiguration imageLoaderConfiguration = new ImageLoaderConfiguration.Builder(context)
                    .defaultDisplayImageOptions(options)
                    .threadPoolSize(2)
                    .discCacheSize(50 * 1024 * 1024)
                    .discCacheFileCount(100)
                    .build();

            imageLoader = ImageLoader.getInstance();
            imageLoader.init(imageLoaderConfiguration);
        }

        return imageLoader;
    }
}
