package com.example.currencyapp.MainActivity.Presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.currencyapp.MainActivity.Data.Repository.CurrencyRepositoryImpl;
import com.example.currencyapp.MainActivity.Domain.Models.Currency;
import com.example.currencyapp.MainActivity.Domain.UseCases.GetCurrencyUseCase;
import com.example.currencyapp.MainActivity.Presentation.Adapters.CurrencyListAdapter;
import com.example.currencyapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    //Variables Declaration
    RecyclerView recyclerView;
    MainViewModel mainViewModel;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        varInit();
        setRefresher();
        getCurrency();
        //TODO Save retrieved results
        //TODO Renew Activity by user
    }

    private void varInit()
    {
        //SwipeRefresh
        swipeRefreshLayout = findViewById(R.id.swipeRefresh);

        //RecyclerView
        recyclerView = findViewById(R.id.recView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //ViewModel
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        mainViewModel.mutableLiveData.observe(this, new Observer<ArrayList<Currency>>()
        {
            @Override
            public void onChanged(ArrayList<Currency> currencyArrayList)
            {
                CurrencyListAdapter currencyListAdapter = new CurrencyListAdapter(currencyArrayList, MainActivity.this);
                recyclerView.setAdapter(currencyListAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }
        });
    }

    private void setRefresher()
    {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh()
            {
                getCurrency();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
    private void getCurrency()
    {
        mainViewModel.getCurrencyVM();
    }
}