package com.example.vrungel.exchangerates.view;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.vrungel.exchangerates.model.remote.ExchangeEntity;
import com.example.vrungel.exchangerates.model.remote.ExchangeRate;

/**
 * Created by Vrungel on 16.02.2017.
 */

@StateStrategyType(AddToEndStrategy.class) public interface IMainActivityView
    extends IActivityView {
  void showCurrency(ExchangeRate exchangeRate);
}
