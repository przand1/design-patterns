package patterns.observer.property_change;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class News implements PropertyChangeListener {

    private String announcement;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        double priceChange = (double) evt.getNewValue();

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
