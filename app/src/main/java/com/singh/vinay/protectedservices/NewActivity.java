package com.singh.vinay.protectedservices;
import android.app.Activity;
import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.easyandroidanimations.library.AnimationListener;
import com.easyandroidanimations.library.FlipHorizontalAnimation;

/**
 * Created by sharadsingh on 29/05/17.
 */
public class NewActivity extends Activity {
    ImageView card,card1;
    private long SPLASH_TIME_OUT =400;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_one);
        Button button_unistall = (Button) findViewById(R.id.UnInstall);
        Button button_cancel = (Button) findViewById(R.id.Cancel);
        button_unistall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri packageURI = Uri.parse("package:"+"com.singh.vinay.protectedservices");
                Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
                startActivity(uninstallIntent);
            }
        });
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }


}
