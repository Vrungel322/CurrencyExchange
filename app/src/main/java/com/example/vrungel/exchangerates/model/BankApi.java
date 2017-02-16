package com.example.vrungel.exchangerates.model;

import com.example.vrungel.exchangerates.model.remote.ExchangeEntity;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Vrungel on 26.01.2017.
 */

public interface BankApi {

  //@GET("p24api/exchange_rates?json&date=01.12.2014") Observable<ExchangeEntity> login(@Body LoginBody credentials);
  @GET("p24api/exchange_rates?json") Observable<ExchangeEntity> makeQuery(@Query("date") String date);
}
