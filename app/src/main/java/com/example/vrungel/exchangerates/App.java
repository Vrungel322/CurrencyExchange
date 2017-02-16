package com.example.vrungel.exchangerates;

import android.app.Application;
import com.example.vrungel.exchangerates.di.components.AppComponent;
import com.example.vrungel.exchangerates.di.components.DaggerAppComponent;
import com.example.vrungel.exchangerates.di.modules.AppModule;

/**
 * Created by Vrungel on 25.01.2017.
 */

public class App extends Application {

  private static AppComponent sAppComponent;

  public static AppComponent getAppComponent() {
    return sAppComponent;
  }

  @Override public void onCreate() {
    super.onCreate();

    sAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
  }
}
