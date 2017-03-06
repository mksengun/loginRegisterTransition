package com.mksengun.loginregistertransition;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;

/**
 * Created by mksengun on 06/03/2017.
 */

public class AnimationHandler {

    final private static int ANIMATION_FADE_IN_DURATION = 1600;
    final private static int ANIMATION_FADE_OUT_DURATION = 2000;
    final private static int ANIMATION_ENTERANCE_DURATION = 2000;
    private View rootView;

    public AnimationHandler(View v) {
        rootView = v;
    }

    public AnimationHandler() {
        rootView = null;
    }

    public TranslateAnimation enterFromLeft(int delay) {
        final TranslateAnimation translation;
        translation = new TranslateAnimation((-1) * (rootView.getMeasuredWidth()), 0f, 0f, 0f);
        translation.setStartOffset(delay); //basıldıktan kac sn sora baslar
        translation.setDuration(ANIMATION_ENTERANCE_DURATION); // ne kadar sürer
        translation.setFillAfter(true);
        translation.setInterpolator(new OvershootInterpolator());
        return translation;
    }

    public Animation fadeIn(int delay) {
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator());
        fadeIn.setDuration(ANIMATION_FADE_IN_DURATION);
        fadeIn.setStartOffset(delay);
        return fadeIn;
    }

    public Animation fadeIn() {
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator());
        fadeIn.setDuration(ANIMATION_FADE_IN_DURATION);
        fadeIn.setStartOffset(10);
        return fadeIn;
    }

    public Animation fadeOut() {
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new DecelerateInterpolator());
        fadeOut.setDuration(ANIMATION_FADE_OUT_DURATION);
        fadeOut.setStartOffset(10);
        return fadeOut;
    }
}
