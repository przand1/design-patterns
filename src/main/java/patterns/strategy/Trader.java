package patterns.strategy;

import patterns.observer.TraderAction;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Trader implements PropertyChangeListener {

    private TradingStrategyIf tradingStrategy;
    private TraderAction action;

    public Trader(TradingStrategyIf strategy) {
        tradingStrategy = strategy;
    }

    public TraderAction getAction() {
        return action;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        double priceChange = (double) evt.getNewValue();

        action = tradingStrategy.chooseAction(priceChange);
    }
}
