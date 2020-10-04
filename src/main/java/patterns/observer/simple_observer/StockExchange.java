package patterns.observer.simple_observer;

import java.util.ArrayList;
import java.util.List;

public class StockExchange {

    public StockExchange(double initialSharePrice) {
        sharePrice = initialSharePrice;
    }

    private List<StockExchangeObserverIf> observers = new ArrayList<>();
    private double sharePrice;

    public void addObserver(StockExchangeObserverIf observer) {
        observers.add(observer);
    }
    public void removeObserver(StockExchangeObserverIf observerIf) {
        observers.remove(observerIf);
    }

    public void setSharePrice(double newPrice) {
        double priceChangePercent = computePriceChange(sharePrice, newPrice);
        notifyAllObservers(priceChangePercent);
        sharePrice = newPrice;
    }

    private double computePriceChange(double sharePrice, double newPrice) {
        return (sharePrice - newPrice) / sharePrice * 100;
    }

    private void notifyAllObservers(double priceChange) {
        observers.forEach(observerIf -> observerIf.update(priceChange));
    }

}