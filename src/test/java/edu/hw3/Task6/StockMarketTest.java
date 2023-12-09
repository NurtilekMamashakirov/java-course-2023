package edu.hw3.Task6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StockMarketTest {


    @Test
    void addTest() {
        RussianStockMarket russianStockMarket = new RussianStockMarket();
        Stock gazpromStock = new Stock(100, "Gazprom");
        russianStockMarket.add(gazpromStock);
        assertThat(gazpromStock).isIn(russianStockMarket.getStocks());
    }

    @Test
    void removeTest() {
        RussianStockMarket russianStockMarket = new RussianStockMarket();
        Stock gazpromStock = new Stock(100, "Gazprom");
        russianStockMarket.add(gazpromStock);
        russianStockMarket.remove(gazpromStock);
        assertThat(gazpromStock).isNotIn(russianStockMarket.getStocks());
    }

    @Test
    void mostValuableStockTest() {
        RussianStockMarket russianStockMarket = new RussianStockMarket();
        Stock gazpromStock = new Stock(100, "Gazprom");
        Stock appleStock = new Stock(4235, "Apple");
        Stock samsungStock = new Stock(3245, "Samsung");
        russianStockMarket.add(gazpromStock);
        russianStockMarket.add(appleStock);
        russianStockMarket.add(samsungStock);
        System.out.println(russianStockMarket.getStocks());
        assertThat(russianStockMarket.mostValuableStock()).isEqualTo(appleStock);
    }
}
