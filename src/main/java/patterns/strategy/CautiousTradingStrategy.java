package patterns.strategy;

import patterns.observer.TraderAction;

public class CautiousTradingStrategy implements TradingStrategyIf {

    @Override
    public TraderAction chooseAction(double priceChange) {
        if (priceChange >= 10) {
            return TraderAction.SELL;
        } else if (priceChange <= -10) {
            return TraderAction.BUY;
        } else {
            return TraderAction.HOLD;
        }
    }
}
