package com.example.vrungel.exchangerates.di.modules;

import com.example.vrungel.exchangerates.model.BankApi;
import com.example.vrungel.exchangerates.model.DataManager;
import com.example.vrungel.exchangerates.model.RestApi;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import retrofit2.Retrofit;

/**
 * Created by Vrungel on 26.01.2017.
 */

@Module(includes = { RetrofitModule.class }) public class DataModule {

  @Provides @Singleton BankApi provideSalonApi(Retrofit retrofit) {
    return retrofit.create(BankApi.class);
  }

  @Provides @Singleton RestApi provideRestApi(BankApi api) {
    return new RestApi(api);
  }

  @Provides @Singleton DataManager provideDataManager(RestApi restApi) {
    return new DataManager(restApi);
  }
}
