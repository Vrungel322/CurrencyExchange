package com.example.vrungel.exchangerates.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.example.vrungel.exchangerates.App;
import com.example.vrungel.exchangerates.model.DataManager;
import com.example.vrungel.exchangerates.model.remote.ExchangeEntity;
import com.example.vrungel.exchangerates.presenter.interfaces.IMainActivityPresenter;
import com.example.vrungel.exchangerates.view.IMainActivityView;
import javax.inject.Inject;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Vrungel on 25.01.2017.
 */
@InjectViewState public class MainActivityPresenter extends BasePresenter<IMainActivityView>
    implements IMainActivityPresenter {
  @Inject DataManager mDataManager;
  private ExchangeEntity mExchangeEntity;

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    //makeQuery();
  }

  @Override public void makeQuery(String currencyType) {
    //Log.d("response", "makeQuery");
    Subscription subscriptionMakeQuery = mDataManager.makeQuery("01.12.2014")
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map(ExchangeEntity::getExchangeRate)
        .flatMap(Observable::from)
        .filter(exchangeRate -> exchangeRate.getCurrency().equals(currencyType))
        .subscribe(exchangeEntity -> {
          getViewState().showCurrency(exchangeEntity);
        }, throwable -> {
        });
    addToUnsubscription(subscriptionMakeQuery);
  }
}
