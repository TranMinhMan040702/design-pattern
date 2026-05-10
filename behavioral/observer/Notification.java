package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Notification {
    public static void main(String[] args) {
        MessagePublisher mp = new MessagePublisher();
        mp.addObserver(new MailObserver());
        mp.addObserver(new SMSObserver());
        mp.notifyObserver("Hello");
    }
}

interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver(String msg);
}

class MessagePublisher implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver(String msg) {
        for (Observer observer : observers) {
            observer.update(msg);
        }
    }
    
}

interface Observer {
    void update(String msg);
}

class MailObserver implements Observer {

    @Override
    public void update(String msg) {
        System.out.println("[Email] is sending message" + "::::" + msg);
    }

}

class SMSObserver implements Observer {

    @Override
    public void update(String msg) {
        System.out.println("[SMS] is sending message" + "::::" + msg);
    }

}

