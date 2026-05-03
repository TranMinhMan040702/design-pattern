package creational.factory;

import java.util.HashMap;
import java.util.Map;

public class NotificationServiceRegistry {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = null;
        String typeNotify = args[0];

        if (typeNotify.isEmpty()) {
            System.out.println("Please provide a notification type");
        }

        notificationFactory = NotificationRegistry.getFactory(typeNotify);

        if (notificationFactory == null) {
            System.out.println("Not Found");
            return;
        }

        notificationFactory.sendNotification();
    }
}

class NotificationRegistry {
    public static Map<String, NotificationFactory> registry = new HashMap<>();
    
    static {
        registry.put("SMS", new SMSNotificationFactory());
        registry.put("MAIL", new MAILNotificationFactory());
    }

    public static NotificationFactory getFactory(String typeNotify) {
        NotificationFactory factory = registry.get(typeNotify.toUpperCase());

        if (factory == null) {
            System.out.println("Notification type is not exist");
        }

        return factory;
    }

    public static void registerFactory(String type, NotificationFactory factory) {
        registry.put(type.toUpperCase(), factory);
    }
}

abstract class NotificationFactory {
    abstract public Notification createNotification();

    public void sendNotification() {
        Notification notification = createNotification();
        notification.receive();
        notification.handle();
        notification.send();
    }
}

class SMSNotificationFactory extends NotificationFactory {

    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
    
}

class MAILNotificationFactory extends NotificationFactory {

    @Override
    public Notification createNotification() {
        return new MailNotification();
    }

}

interface Notification {
    void receive();
    void handle();
    void send();
}

class SMSNotification implements Notification {

    @Override
    public void receive() {
        System.out.println("Checking SMS");
    }

    @Override
    public void handle() {
        System.out.println("Get phone number");
    }

    @Override
    public void send() {
        System.out.println("Send by SMS");
    }

}

class MailNotification implements Notification {

    @Override
    public void receive() {
        System.out.println("Checking EMAIL");
    }

    @Override
    public void handle() {
        System.out.println("Get email");
    }

    @Override
    public void send() {
        System.out.println("Send by EMAIL");
    }

}