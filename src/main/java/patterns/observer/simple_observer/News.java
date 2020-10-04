package patterns.observer.simple_observer;

public class News implements StockExchangeObserverIf {

    private String announcement;

    @Override
    public void update(double priceChange) {
        StringBuilder builder = new StringBuilder("Stock prices ");
        if (priceChange == 0) {
            builder.append("are stable");
        } else if (priceChange > 0) {
            builder.append("go up by ")
                    .append(priceChange)
                    .append(" %.");
        } else {
            builder.append(" go down by ")
                    .append(0 - priceChange)
                    .append(" %.");
        }
    }

    public String getAnnouncement() {
        return announcement;
    }
}
