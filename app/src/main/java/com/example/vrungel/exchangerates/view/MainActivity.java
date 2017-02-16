package com.example.vrungel.exchangerates.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.widget.TextView;
import butterknife.BindView;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.vrungel.exchangerates.R;
import com.example.vrungel.exchangerates.presenter.MainActivityPresenter;

public class MainActivity extends BaseActivity implements IMainActivityView {
  @InjectPresenter MainActivityPresenter mMainActivityPresenter;
  @BindView(R.id.tvData) TextView tvData;
  @BindView(R.id.fabSend) FloatingActionButton fabSend;

  @Override protected void onCreate(Bundle savedInstanceState) {
    setContentView(R.layout.activity_main);
    super.onCreate(savedInstanceState);

    //getMvpDelegate().onAttach();
    fabSend.setOnClickListener((v) -> mMainActivityPresenter.makeQuery());
  }

  @Override public void showText(String string) {
    tvData.append(string);
  }
}
