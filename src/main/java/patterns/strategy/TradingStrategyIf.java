package patterns.strategy;

import patterns.observer.TraderAction;

public interface TradingStrategyIf {
    TraderAction chooseAction(double priceChange);
}
