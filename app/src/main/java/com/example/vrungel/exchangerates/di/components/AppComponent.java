package com.example.vrungel.exchangerates.di.components;

import com.example.vrungel.exchangerates.di.modules.AppModule;
import com.example.vrungel.exchangerates.presenter.MainActivityPresenter;
import com.example.vrungel.exchangerates.view.BaseActivity;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by Vrungel on 25.01.2017.
 */
@Singleton @Component(modules = AppModule.class) public interface AppComponent {

  //presenters
  void inject(MainActivityPresenter presenter);

  //activities
  void inject(BaseActivity activity);

}
