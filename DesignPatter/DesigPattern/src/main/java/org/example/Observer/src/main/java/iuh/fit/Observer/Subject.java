package iuh.fit.Observer;

import iuh.fit.Observer.Observer;

import java.util.ArrayList;
import java.util.List;

// Subject Interface
public abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    // Đăng ký observer
    public void attach(Observer observer) {
        observers.add(observer);
    }

    // Hủy đăng ký observer
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    // Thông báo đến tất cả observers
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}