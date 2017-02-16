package com.example.vrungel.exchangerates.view;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by Vrungel on 16.02.2017.
 */

@StateStrategyType(AddToEndSingleStrategy.class) public interface IMainActivityView
    extends IActivityView {
}
