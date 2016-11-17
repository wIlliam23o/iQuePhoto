package net.iquesoft.iquephoto.presentation.view.share;

import android.graphics.Bitmap;
import android.support.annotation.StringRes;

public interface ShareView {
    void initImageSizes(String small, String medium, String original);

    void share(Bitmap bitmap, String applicationId);

    void showAlert(@StringRes int messageBody, String applicationId);
}