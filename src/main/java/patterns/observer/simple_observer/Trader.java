package patterns.observer.simple_observer;

import patterns.observer.TraderAction;

class Trader implements StockExchangeObserverIf {

    private TraderAction action;

    @Override
    public void update(double priceChange) {
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