package patterns.strategy;

import patterns.observer.TraderAction;

public class RiskyTradingStrategy implements TradingStrategyIf {
    @Override
    public TraderAction chooseAction(double priceChange) {
        if (priceChange >= 8) {
            return TraderAction.SELL;
        } else if (priceChange <= 4) {
            return TraderAction.BUY;
        } else {
            return TraderAction.HOLD;
        }
    }
}
