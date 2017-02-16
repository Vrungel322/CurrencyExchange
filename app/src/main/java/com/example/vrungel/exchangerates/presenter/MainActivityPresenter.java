package com.example.vrungel.exchangerates.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.example.vrungel.exchangerates.App;
import com.example.vrungel.exchangerates.model.DataManager;
import com.example.vrungel.exchangerates.model.remote.ExchangeEntity;
import com.example.vrungel.exchangerates.presenter.interfaces.IMainActivityPresenter;
import com.example.vrungel.exchangerates.view.IMainActivityView;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
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

  @Override public void makeQueryWithTimeline(String currencyType, String startData, String endData) {
    List<String > dates = getDaysBetweenDates(startData, endData);
    //Log.d("response", "makeQueryWithTimeline");
    for (int i = 0; i < dates.size(); i++){
      Subscription subscriptionMakeQuery = mDataManager.makeQuery(dates.get(i))
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

  private static List<String> getDaysBetweenDates(String sStartDate, String sEndDate) {
    List<String> totalDates = new ArrayList<>();

    DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    try {
      Date dStartDate = format.parse(sStartDate);
      Date dEndDate = format.parse(sEndDate);

      Calendar calendar = new GregorianCalendar();
      calendar.setTime(dStartDate);

      while (calendar.getTime().before(dEndDate)) {
        Date result = calendar.getTime();
        totalDates.add(format.format(result));
        calendar.add(Calendar.DATE, 1);
      }
      totalDates.add(sEndDate);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return totalDates;
  }
}
