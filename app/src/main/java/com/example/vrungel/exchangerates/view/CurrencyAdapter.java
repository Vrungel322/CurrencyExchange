package com.example.vrungel.exchangerates.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.vrungel.exchangerates.R;
import com.example.vrungel.exchangerates.model.remote.ExchangeRate;
import java.util.ArrayList;

/**
 * Created by Vrungel on 16.02.2017.
 */

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder> {
  private ArrayList<ExchangeRate> mExchangeEntityArrayList = new ArrayList<>();
  private LayoutInflater inflater;
  private Context mContext;

  public CurrencyAdapter(Context context) {
    this.inflater = LayoutInflater.from(context);
    this.mContext = context;
  }

  @Override
  public CurrencyAdapter.CurrencyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = inflater.inflate(R.layout.currency_list_item, parent, false);
    return new CurrencyViewHolder(v);
  }

  @Override public void onBindViewHolder(CurrencyAdapter.CurrencyViewHolder holder, int position) {
    holder.tvSale.setText(String.valueOf(mExchangeEntityArrayList.get(position).getSaleRate()));
    holder.tvBuy.setText(String.valueOf(mExchangeEntityArrayList.get(position).getPurchaseRate()));
    holder.tvCurrency.setText(String.valueOf(mExchangeEntityArrayList.get(position).getCurrency()));
  }

  @Override public int getItemCount() {
    return mExchangeEntityArrayList.size();
  }

  public void addCurrencyEntity(ExchangeRate entity) {
    mExchangeEntityArrayList.add(entity);
    notifyItemInserted(getItemCount());
  }

  static class CurrencyViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tvSale) TextView tvSale;
    @BindView(R.id.tvCurrency) TextView tvCurrency;
    @BindView(R.id.tvBuy) TextView tvBuy;

    CurrencyViewHolder(View view) {
      super(view);
      ButterKnife.bind(this, view);
    }
  }
}
