package com.example.vrungel.exchangerates.model;

import com.example.vrungel.exchangerates.model.remote.RestApi;

/**
 * Created by Vrungel on 26.01.2017.
 */

public class DataManager {

  private RestApi mRestApi;

  public DataManager(RestApi restApi) {
    this.mRestApi = restApi;
  }

  //public Observable<AccountUser> login(String login, String password) {
  //  return restApi.login(new Credentials(login, password));
  //}
}