package com.example.currencyapp.MainActivity.Presentation.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.currencyapp.MainActivity.Domain.Models.Currency;
import com.example.currencyapp.R;

import java.util.ArrayList;

public class CurrencyListAdapter extends RecyclerView.Adapter<CurrencyListAdapter.MyViewHolder>
{
    ArrayList<Currency> currencyArrayList;
    Context context;
    Currency currencyForHolder;

    public CurrencyListAdapter(ArrayList<Currency> currencyArrayList, Context context)
    {
        this.currencyArrayList = currencyArrayList;
        this.context = context;
    }



    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView charCode;
        TextView name;
        TextView numCode;
        TextView nominalToValute;
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            charCode = itemView.findViewById(R.id.textView_CharCode);
            name = itemView.findViewById(R.id.textView_Name);
            numCode = itemView.findViewById(R.id.textView_Code);
            nominalToValute = itemView.findViewById(R.id.textView_NominalToValue);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.custom_currency, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        currencyForHolder = currencyArrayList.get(position);
        holder.charCode.setText(currencyForHolder.getCharCode());
        holder.name.setText(currencyForHolder.getName());
        holder.numCode.setText("" + currencyForHolder.getNumCode());
        holder.nominalToValute.setText(currencyForHolder.getNominal() + " = " + currencyForHolder.getValue());
    }

    @Override
    public int getItemCount()
    {
        return currencyArrayList.size();
    }
}
