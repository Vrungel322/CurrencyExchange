package com.example.vrungel.exchangerates.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.example.vrungel.exchangerates.App;
import com.example.vrungel.exchangerates.presenter.interfaces.IMainActivityPresenter;
import com.example.vrungel.exchangerates.view.IMainActivityView;

/**
 * Created by Vrungel on 25.01.2017.
 */
@InjectViewState public class MainActivityPresenter extends BasePresenter<IMainActivityView>
    implements IMainActivityPresenter {

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
  }

  @Override public void showTestText(String str) {
    getViewState().showText(str);
  }
}
