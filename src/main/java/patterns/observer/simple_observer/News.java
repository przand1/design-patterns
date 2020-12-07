package patterns.observer.simple_observer;

public class News implements StockExchangeObserverIf {

    private String announcement;

    @Override
    public void update(double priceChange) {
        StringBuilder builder = new StringBuilder("Stock prices ");
        if (priceChange == 0) {
            builder.append("are stable.");
        } else if (priceChange > 0) {
            builder.append("go up by ")
                    .append(Math.round(priceChange))
                    .append("%.");
        } else {
            builder.append("go down by ")
                    .append(Math.round(0 - priceChange))
                    .append("%.");
        }
        announcement = builder.toString();
    }

    public String getAnnouncement() {
        return announcement;
    }
}
