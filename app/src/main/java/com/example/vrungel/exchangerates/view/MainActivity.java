package com.example.vrungel.exchangerates.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.vrungel.exchangerates.Constants;
import com.example.vrungel.exchangerates.R;
import com.example.vrungel.exchangerates.model.remote.ExchangeEntity;
import com.example.vrungel.exchangerates.model.remote.ExchangeRate;
import com.example.vrungel.exchangerates.presenter.MainActivityPresenter;

public class MainActivity extends BaseActivity implements IMainActivityView {
  @InjectPresenter MainActivityPresenter mMainActivityPresenter;
  @BindView(R.id.fabSend) FloatingActionButton fabSend;
  @BindView(R.id.rvCurrency) RecyclerView rvCurrency;
  @BindView(R.id.toolbar) Toolbar mToolbar;
  private CurrencyAdapter mCurrencyAdapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    setContentView(R.layout.activity_main);
    super.onCreate(savedInstanceState);
    setSupportActionBar(mToolbar);

    mCurrencyAdapter = new CurrencyAdapter(this);
    rvCurrency.setLayoutManager(new LinearLayoutManager(this));
    rvCurrency.setItemAnimator(new DefaultItemAnimator());
    rvCurrency.setAdapter(mCurrencyAdapter);
  }

  @Override public void showCurrency(ExchangeRate exchangeRate) {
    mCurrencyAdapter.addCurrencyEntity(exchangeRate);
  }

  @OnClick(R.id.fabSend)
  public void fabSendClicked(){
    mMainActivityPresenter.makeQuery(Constants.CurrencyType.USD);
  }
}
