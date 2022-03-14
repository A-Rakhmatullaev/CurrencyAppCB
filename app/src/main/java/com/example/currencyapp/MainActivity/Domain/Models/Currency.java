package com.example.currencyapp.MainActivity.Domain.Models;

public class Currency
{
    private String ID;
    private int NumCode;
    private String CharCode;
    private int Nominal;
    private String Name;
    private double Value;

    Currency (String ID, int NumCode, String CharCode,
              int Nominal, String Name, double Value)
    {
        this.ID = ID;
        this.NumCode = NumCode;
        this.CharCode = CharCode;
        this.Nominal = Nominal;
        this.Name = Name;
        this.Value = Value;
    }

    public String getID()
    {
        String id = ID;
        return id;
    }

    public String getCharCode()
    {
        String charCode = CharCode;
        return charCode;
    }

    public int getNumCode()
    {
        int numCode = NumCode;
        return numCode;
    }

    public String getName()
    {
        String name = Name;
        return name;
    }

    public int getNominal()
    {
        int nominal = Nominal;
        return nominal;
    }

    public double getValue()
    {
        double value = Value;
        return value;
    }
}
