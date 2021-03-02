package patterns.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import patterns.observer.TraderAction;
import patterns.observer.property_change.StockExchange;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TraderTest {
    private StockExchange stockExchange;
    private Trader trader;

    @BeforeEach
    void init() {
        stockExchange = new StockExchange(100);
        trader = new Trader(new CautiousTradingStrategy());
        stockExchange.addObserver(trader);
    }

    @Test
    void traderWithCautiousStrShouldBuyWhenPriceDrops15Percent() {
        stockExchange.setSharePrice(85);
        assertEquals(TraderAction.BUY,trader.getAction());
    }
    @Test
    void traderWithCautiousStrShouldBuyWhenPriceDrops10Percent() {
        stockExchange.setSharePrice(90);
        assertEquals(TraderAction.BUY,trader.getAction());
    }
    @Test
    void traderWithCautiousStrShouldHoldWhenPriceDrops9Percent() {
        stockExchange.setSharePrice(91);
        assertEquals(TraderAction.HOLD,trader.getAction());
    }
    @Test
    void traderWithCautiousStrShouldHoldWhenPriceRises9Percent() {
        stockExchange.setSharePrice(109);
        assertEquals(TraderAction.HOLD,trader.getAction());
    }
    @Test
    void traderWithCautiousStrShouldSellWhenPriceRises10Percent() {
        stockExchange.setSharePrice(110);
        assertEquals(TraderAction.SELL,trader.getAction());
    }
    @Test
    void traderWithCautiousStrShouldSellWhenPriceRises15Percent() {
        stockExchange.setSharePrice(115);
        assertEquals(TraderAction.SELL,trader.getAction());
    }
}