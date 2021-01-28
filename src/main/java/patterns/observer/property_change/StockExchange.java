package patterns.observer.property_change;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class StockExchange {
    private static final String PRICE_CHANGE = "PRICE_CHANGE";
    private final PropertyChangeSupport propertyChangeSupport;
    private double sharePrice;

    public StockExchange(double initialSharePrice) {
        propertyChangeSupport = new PropertyChangeSupport(this);
        sharePrice = initialSharePrice;
    }
    public void addObserver(PropertyChangeListener observer) {
        propertyChangeSupport.addPropertyChangeListener(PRICE_CHANGE,observer);
    }
    public void removeObserver(PropertyChangeListener observer) {
        propertyChangeSupport.removePropertyChangeListener(observer);
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
        propertyChangeSupport.firePropertyChange(PRICE_CHANGE,0,computePriceChange(priceChange));
    }

}
