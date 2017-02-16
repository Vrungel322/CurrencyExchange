package com.example.vrungel.exchangerates.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.example.vrungel.exchangerates.R;

public class MainActivity extends BaseActivity implements IMainActivityView {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override public void showText(String string) {

  }
}
