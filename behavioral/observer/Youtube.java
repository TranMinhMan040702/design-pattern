package behavioral.observer;

import java.util.HashSet;
import java.util.Set;

public class Youtube {
    public static void main(String[] args) {
        Channel tmm = new TMMChannel();
        Subscriber user1 = new User("Ronaldo");
        Subscriber user2 = new User("Messi");

        user1.subscribe(tmm);
        user2.subscribe(tmm);

        tmm.createNewVideo("Java code");

        user2.unsubcribe(tmm);
        System.out.println("==============================");

        tmm.createNewVideo("Design Pattern");
    }
}

interface Channel {
    String getName();
    void createNewVideo(String title);
    void addSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);
    void notifytoUser(String msg);
}

interface Subscriber {
    void subscribe(Channel c);
    void unsubcribe(Channel c);
    void update(String msg);
}

class TMMChannel implements Channel {
    private String name = "TMM Channel";
    private Set<Subscriber> subscribers = new HashSet<>();

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void createNewVideo(String title) {
        System.out.println(name + " is creating a new video" + " :::: " + title);
        notifytoUser("New video is created" + " :::: " + title);
    }

    @Override
    public void notifytoUser(String msg) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(msg);
        }
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }
    
}

class User implements Subscriber {

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void subscribe(Channel channel) {
        channel.addSubscriber(this);
    }

    @Override
    public void unsubcribe(Channel channel) {
        channel.removeSubscriber(this);
        System.out.println(name + " unsubscribed " + channel.getName());
    }

    @Override
    public void update(String msg) {
        System.out.println("Ting ting " + name + " :::: " + msg);
    }
    
}