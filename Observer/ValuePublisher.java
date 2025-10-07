import java.util.ArrayList;
import java.util.List;

public class ValuePublisher {
    private List<NumericBaseObserver> observers = new ArrayList<>();

    public void subscribe(NumericBaseObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(NumericBaseObserver observer) {
        observers.remove(observer);
    }

    public void updateState(int value) {
        for (NumericBaseObserver observer : observers) {
            observer.updateState(value);
        }
    }
}

