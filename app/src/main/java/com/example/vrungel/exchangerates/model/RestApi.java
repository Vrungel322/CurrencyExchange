package com.example.vrungel.exchangerates.model;

import com.example.vrungel.exchangerates.model.BankApi;
import com.example.vrungel.exchangerates.model.remote.ExchangeEntity;
import rx.Observable;

/**
 * Created by Vrungel on 26.01.2017.
 */

public class RestApi {
  private final BankApi api;

  public RestApi(BankApi api) {
    this.api = api;
  }

  //public Observable<TokenEntity> login(LoginBody credentials) {
  //  return api.login(credentials);
  //}

   public Observable<ExchangeEntity> makeQuery(String date) {
    return api.makeQuery(date);
  }
}
