package patterns.observer.simple_observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewsTest {

    private StockExchange stockExchange;
    private News news;

    @BeforeEach
    void init() {
        stockExchange = new StockExchange(10.0);
        news = new News();
        stockExchange.addObserver(news);
    }

    @Test
    void shouldAnnounceStable() {
        stockExchange.setSharePrice(10.0);
        assertEquals("Prices are stable.", news.getAnnouncement());
    }
}