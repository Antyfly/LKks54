package com.example.proba;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class LogoActivity extends Activity {
    private ImageView imageLogo;
    private Animation anim_logo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.logoanim);
        imageLogo = findViewById(R.id.imageView);
        anim_logo = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim);
        imageLogo.startAnimation(anim_logo);

        AnimLogo();

    }

    private void AnimLogo(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //ПЕРЕХОД ОТ ОКНА К ОКНУ!!!!!!!!!!!!!!!!!!!!!!!!!
                Intent intent = new Intent(LogoActivity.this, autoriz_win.class);
                startActivity(intent);
            }
        }).start();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}