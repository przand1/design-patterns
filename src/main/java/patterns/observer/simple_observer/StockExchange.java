package patterns.observer.simple_observer;

import java.util.HashSet;
import java.util.Set;

public class StockExchange {

    public StockExchange(double initialSharePrice) {
        sharePrice = initialSharePrice;
    }

    private Set<StockExchangeObserverIf> observers = new HashSet<>();
    private double sharePrice;

    public void addObserver(StockExchangeObserverIf observer) {
        observers.add(observer);
    }
    public void removeObserver(StockExchangeObserverIf observerIf) {
        observers.remove(observerIf);
    }

    public void setSharePrice(double newPrice) {
        double priceChangePercent = computePriceChange(newPrice);
        notifyAllObservers(priceChangePercent);
        sharePrice = newPrice;
    }

    private double computePriceChange(double newPrice) {
        return (sharePrice - newPrice) / sharePrice * (-100);
    }

    private void notifyAllObservers(double priceChange) {
        observers.forEach(observerIf -> observerIf.update(priceChange));
    }

}