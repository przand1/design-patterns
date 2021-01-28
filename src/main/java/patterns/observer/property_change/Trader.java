package patterns.observer.property_change;

import patterns.observer.TraderAction;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Trader implements PropertyChangeListener {
    private TraderAction action;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        double priceChange = (double) evt.getNewValue();

        if (priceChange > 0) {
            action = TraderAction.SELL;
        } else if (priceChange < 0) {
            action = TraderAction.BUY;
        } else {
            action = TraderAction.HOLD;
        }

    }

    public TraderAction getAction() {
        return action;
    }
}
