import java.util.ArrayList;
import java.util.List;

public class DecimalBaseObserver implements NumericBaseObserver {
    private List<String> events = new ArrayList<>();

    @Override
    public void updateState(int state) {
        events.add(String.valueOf(state));
    }

    @Override
    public List<String> getEvents() {
        return events;
    }
}
