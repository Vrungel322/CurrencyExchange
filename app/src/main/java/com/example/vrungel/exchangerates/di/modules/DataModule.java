package com.example.vrungel.exchangerates.di.modules;

import com.example.vrungel.exchangerates.model.DataManager;
import com.example.vrungel.exchangerates.model.SalonApi;
import com.example.vrungel.exchangerates.model.remote.RestApi;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import retrofit2.Retrofit;

/**
 * Created by Vrungel on 26.01.2017.
 */

@Module(includes = { RetrofitModule.class }) public class DataModule {

  @Provides @Singleton SalonApi provideSalonApi(Retrofit retrofit) {
    return retrofit.create(SalonApi.class);
  }

  @Provides @Singleton RestApi provideRestApi(SalonApi api) {
    return new RestApi(api);
  }

  @Provides @Singleton DataManager provideDataManager(RestApi restApi) {
    return new DataManager(restApi);
  }
}
