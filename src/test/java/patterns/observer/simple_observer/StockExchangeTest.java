package patterns.observer.simple_observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockExchangeTest {

    private StockExchange stockExchange;
    private Trader trader1;
    private Trader trader2;
    private Trader trader3;

    @BeforeEach
    void init() {
        stockExchange = new StockExchange(100);
        trader1 = new Trader();
        trader2 = new Trader();
        trader3 = new Trader();
    }

    @Test
    void checkIfObserversWereAddedAndReactToChanges() {
        stockExchange.addObserver(trader1);
        stockExchange.addObserver(trader2);
        stockExchange.addObserver(trader3);

        assertNull(trader1.getAction());
        assertNull(trader2.getAction());
        assertNull(trader3.getAction());

        stockExchange.setSharePrice(101);
        assertNotNull(trader1.getAction());
        assertNotNull(trader2.getAction());
        assertNotNull(trader3.getAction());
    }

    @Test
    void checkIfRemovedObserverStopsReactingToChanges() {
        stockExchange.addObserver(trader1);
        stockExchange.addObserver(trader2);
        stockExchange.addObserver(trader3);

        assertNull(trader1.getAction());
        assertNull(trader2.getAction());
        assertNull(trader3.getAction());

        stockExchange.removeObserver(trader1);
        stockExchange.setSharePrice(99);


        assertNull(trader1.getAction());
        assertNotNull(trader2.getAction());
        assertNotNull(trader3.getAction());
    }
}