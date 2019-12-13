package com.sharewithapp;

import com.facebook.react.ReactActivity;

import com.facebook.react.ReactActivityDelegate;
import android.content.Intent;
import android.os.Bundle;
import android.net.Uri;

public class MainActivity extends ReactActivity {

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  @Override
  protected String getMainComponentName() {
    return "ShareWithApp";
  }

  @Override
    protected ReactActivityDelegate createReactActivityDelegate() {
        return new ReactActivityDelegate(this, getMainComponentName()) {
           
            @Override
            protected Bundle getLaunchOptions() {

                Intent intent = MainActivity.this.getIntent();
                Bundle bundle = new Bundle();
                Uri imageUri = intent.getParcelableExtra(Intent.EXTRA_STREAM);
                if (imageUri != null) {
                    bundle.putString("image", imageUri.toString());
                }else{
                    bundle.putString("image", "");
                }
                
                return bundle;
            }

        };
    }
}
