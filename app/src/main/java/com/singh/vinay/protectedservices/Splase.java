package com.singh.vinay.protectedservices;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.easyandroidanimations.library.Animation;
import com.easyandroidanimations.library.AnimationListener;
import com.easyandroidanimations.library.ExplodeAnimation;
import com.easyandroidanimations.library.FlipHorizontalAnimation;
import com.easyandroidanimations.library.FlipVerticalAnimation;
import com.easyandroidanimations.library.FoldAnimation;
import com.easyandroidanimations.library.FoldLayout;
import com.easyandroidanimations.library.RotationAnimation;
import com.easyandroidanimations.library.ScaleInAnimation;
import com.easyandroidanimations.library.SlideInUnderneathAnimation;

/**
 * Created by sharadsingh on 30/05/17.
 */
public class Splase extends AppCompatActivity {
    ImageView top,top_left,top_right,bot_left,bot_right,bottom;
    private long SPLASH_TIME_OUT =400;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_splash);
        top = (ImageView) findViewById(R.id.img1);
        top_left = (ImageView) findViewById(R.id.img2);
        top_right = (ImageView) findViewById(R.id.img3);
        bot_left = (ImageView) findViewById(R.id.img4);
        bot_right = (ImageView) findViewById(R.id.img5);
        bottom = (ImageView) findViewById(R.id.img6);
        startAnimationTop();
    }

  private void  startAnimationTop(){
      new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
              new FlipVerticalAnimation(top).setDuration(1300).setListener(
                      new AnimationListener() {

                          @Override
                          public void onAnimationEnd(Animation animation) {
                             // top.setImageResource(R.mipmap.ic_bot);
                              startanimationTop_left();
                          }
                      }).animate();

          }
      }, SPLASH_TIME_OUT);


  }

    private void startanimationTop_left() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                new SlideInUnderneathAnimation(top_left).setDuration(1300).setDirection(
                        Animation.DIRECTION_DOWN).setListener(new AnimationListener() {
                    @Override
                    public void onAnimationEnd(Animation animation) {
                       // top_left.setImageResource(R.mipmap.ic_left_bot);
                        startanimationTop_right();
                    }
                }).animate();


            }
        }, SPLASH_TIME_OUT);

        }
    private void startanimationTop_right() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                new FlipHorizontalAnimation(top_right).setDuration(1300).setListener(
                        new AnimationListener() {
                            @Override
                            public void onAnimationEnd(com.easyandroidanimations.library.Animation animation) {
                              //  top_right.setImageResource(R.mipmap.ic_right_bot);
                                startanimationBot_left();
                            }
                        }).animate();
            }
        }, SPLASH_TIME_OUT);


    }
    private void startanimationBot_left() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                  new RotationAnimation(bot_left)
                        .setPivot(RotationAnimation.PIVOT_TOP_LEFT).setDuration(1300)
                        .setListener(new AnimationListener() {

                            @Override
                            public void onAnimationEnd(Animation animation) {
                              //  bot_left.setImageResource(R.mipmap.ic_left_top);
                                startanimationBot_Right();
                            }
                        }).animate();

            }
        }, SPLASH_TIME_OUT);



    }
    private void startanimationBot_Right() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                new SlideInUnderneathAnimation(bot_right).setDuration(1300).setDirection(
                        Animation.DIRECTION_UP).setListener(new AnimationListener() {
                    @Override
                    public void onAnimationEnd(Animation animation) {
                       // bot_right.setImageResource(R.mipmap.trux_partner_logo);
                        startanimationBottom();
                    }
                }).animate();
            }
        }, SPLASH_TIME_OUT);

    }

    private void startanimationBottom() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                new ScaleInAnimation(bottom).setDuration(1300).setListener(new AnimationListener() {
                    @Override
                    public void onAnimationEnd(Animation animation) {
                       // bottom.setImageResource(R.mipmap.ic_top);
                        startAnimationTop();
                    }
                }).animate();
            }
        }, SPLASH_TIME_OUT);

    }
}
