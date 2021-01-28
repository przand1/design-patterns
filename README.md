# design-patterns
Implementation and examples of selected design patterns in Java.

### Observer
Example is made of 3 classes: `StockExchange`, responsible for managing share prices, and `News` and `Trader`, which perform some actions when price is changed.

News class forms simple announcement, such as "prices go up by 10%", while Trader chooses one of following actions: buy, sell or hold.

Example contains two implementations. In `simple_observer` package, pattern is implemented manually, classes are marked as observers by implementing common interface `StockExchangeObserverIf`.
The other one, called `property_change`, takes advantage of `PropertyChange` library.
Both implementations pass identical unit tests.