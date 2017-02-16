package com.example.vrungel.exchangerates.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.OnClick;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.vrungel.exchangerates.Constants;
import com.example.vrungel.exchangerates.R;
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

  @OnClick(R.id.fabSend) public void fabSendClicked() {
    mMainActivityPresenter.makeQueryWithTimeline(Constants.CurrencyType.USD, "24.12.2016", "31.12.2016");
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main_activity_menu, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == R.id.menu_USD) {
      mMainActivityPresenter.makeQueryWithTimeline(Constants.CurrencyType.USD, "24.12.2016", "31.12.2016");
    }
    if (item.getItemId() == R.id.menu_EUR) {
      mMainActivityPresenter.makeQueryWithTimeline(Constants.CurrencyType.EUR, "24.12.2016", "31.12.2016");
    }
    if (item.getItemId() == R.id.menu_RUB) {
      mMainActivityPresenter.makeQueryWithTimeline(Constants.CurrencyType.RUB, "24.12.2016", "31.12.2016");
    }
    return true;
  }
}
