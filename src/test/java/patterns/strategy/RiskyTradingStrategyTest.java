package patterns.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import patterns.observer.TraderAction;
import patterns.observer.property_change.StockExchange;

import static org.junit.jupiter.api.Assertions.*;

class RiskyTradingStrategyTest {
    private StockExchange stockExchange;
    private Trader trader;

    @BeforeEach
    void init() {
        stockExchange = new StockExchange(100);
        trader = new Trader(new RiskyTradingStrategy());
        stockExchange.addObserver(trader);
    }

    @Test
    void TraderWithRiskyStrategyShouldBuyWhenPriceDrops5Percent() {
        stockExchange.setSharePrice(95);
        assertEquals(TraderAction.BUY,trader.getAction());
    }
    @Test
    void TraderWithRiskyStrategyShouldBuyWhenPriceIsStable() {
        stockExchange.setSharePrice(100);
        assertEquals(TraderAction.BUY,trader.getAction());
    }
    @Test
    void TraderWithRiskyStrategyShouldBuyWhenPriceRises3Percent() {
        stockExchange.setSharePrice(103);
        assertEquals(TraderAction.BUY,trader.getAction());
    }
    @Test
    void TraderWithRiskyStrategyShouldBuyWhenPriceRises4Percent() {
        stockExchange.setSharePrice(104);
        assertEquals(TraderAction.BUY,trader.getAction());
    }
    @Test
    void TraderWithRiskyStrategyShouldHoldWhenPriceRises5Percent() {
        stockExchange.setSharePrice(105);
        assertEquals(TraderAction.HOLD,trader.getAction());
    }
    @Test
    void TraderWithRiskyStrategyShouldHoldWhenPriceRises7Percent() {
        stockExchange.setSharePrice(107);
        assertEquals(TraderAction.HOLD,trader.getAction());
    }
    @Test
    void TraderWithRiskyStrategyShouldSellWhenPriceRises8Percent() {
        stockExchange.setSharePrice(108);
        assertEquals(TraderAction.SELL,trader.getAction());
    }
    @Test
    void TraderWithRiskyStrategyShouldSellWhenPriceRises15Percent() {
        stockExchange.setSharePrice(115);
        assertEquals(TraderAction.SELL,trader.getAction());
    }
}