package creational.factory;

public class NotificationService {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = null;
        String typeNotify = args[0];

        if (typeNotify.isEmpty()) {
            System.out.println("Please provide a notification type");
        }

        switch (typeNotify) {
            case "SMS":
                notificationFactory = new SMSNotificationFactory();
                break;
            case "MAIL":
                notificationFactory = new MailNotificationFactory();
                break;
            default:
                break;
        }

        if (notificationFactory == null) {
            System.out.println("Not Found");
            return;
        }

        notificationFactory.sendNotification();
    }
}

abstract class NotificationFactory {
    abstract public Notification createNotification();

    public void sendNotification() {
        Notification notification = createNotification();
        notification.receive();
        notification.handle();
        notification.notify();
    }
}

class SMSNotificationFactory extends NotificationFactory {

    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
    
}

class MailNotificationFactory extends NotificationFactory {

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
