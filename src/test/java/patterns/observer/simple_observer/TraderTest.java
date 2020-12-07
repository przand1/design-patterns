package patterns.observer.simple_observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TraderTest {

    private StockExchange stockExchange;
    private Trader trader;

    @BeforeEach
    void init() {
        stockExchange = new StockExchange(10.0);
        trader = new Trader();
        stockExchange.addObserver(trader);
    }

    @Test
    void TraderShouldSell() {
        stockExchange.setSharePrice(20.0);
        assertEquals(TraderAction.SELL,trader.getAction());
    }
    @Test
    void TraderShouldBuy() {
        stockExchange.setSharePrice(5.0);
        assertEquals(TraderAction.BUY,trader.getAction());
    }
    @Test
    void TraderShouldHold() {
        stockExchange.setSharePrice(10.0);
        assertEquals(TraderAction.HOLD,trader.getAction());
    }

}