package com.petermiklosko.rssreader.utils;

import android.widget.ImageView;

import com.novoda.imageloader.core.ImageManager;
import com.novoda.imageloader.core.model.ImageTagFactory;

public class ImageLoader {

    private static final int INITIAL_WIDTH = 145;
    private static final int INITIAL_HEIGHT = 30;

    private final ImageManager imageManager;

    private int imageWidth = INITIAL_WIDTH;
    private int imageHeight = INITIAL_HEIGHT;
    private int defaulImageId = android.R.drawable.ic_dialog_info;
    private int errorImageId = android.R.drawable.ic_dialog_info;

    public ImageLoader(ImageManager imageManager) {
        this.imageManager = imageManager;
    }

    public void setImageDimensions(int width, int height) {
        this.imageWidth = width;
        this.imageHeight = height;
    }

    public void setDefaultImages(int resourceId) {
        this.defaulImageId = resourceId;
        this.errorImageId = resourceId;
    }

    public void loadImage(ImageView imageView, String gravatarUrl) {
        imageView.setTag(createImageTagFactory().build(gravatarUrl, imageView));
        imageManager.getLoader().load(imageView);
    }

    private ImageTagFactory createImageTagFactory() {
        ImageTagFactory imageTagFactory = ImageTagFactory.newInstance(imageWidth, imageHeight, defaulImageId);
        return setupImageTagFactory(imageTagFactory);
    }

    private ImageTagFactory setupImageTagFactory(ImageTagFactory imageTagFactory) {
        imageTagFactory.setErrorImageId(errorImageId);
        return imageTagFactory;
    }
}
