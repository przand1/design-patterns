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
}