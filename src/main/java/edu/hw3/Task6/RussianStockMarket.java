package edu.hw3.Task6;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RussianStockMarket implements StockMarket{

    private PriorityQueue<Stock> stocks;

    public RussianStockMarket() {
        stocks = new PriorityQueue<>(Comparator.comparing(Stock::getValue).reversed());
    }


    @Override
    public void add(Stock stock) {
        stocks.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stocks.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stocks.peek();
    }

    public PriorityQueue<Stock> getStocks() {
        return stocks;
    }
}
