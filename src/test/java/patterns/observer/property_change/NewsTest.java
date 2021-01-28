package patterns.observer.property_change;

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
        assertEquals("Stock prices are stable.", news.getAnnouncement());
    }
    @Test
    void shouldAnnouncePricesUpBy10Percent() {
        stockExchange.setSharePrice(11.0);
        assertEquals("Stock prices go up by 10%.", news.getAnnouncement());
    }
}