package creational.factory;

public class NotificationServiceReflection {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = null;
        String typeNotify = args[0];

        if (typeNotify.isEmpty()) {
            System.out.println("Please provide a notification type");
        }

        try {
            String classNotification = "creational.factory." + typeNotify + "NotificationFactory";
            Class<?> clazz = Class.forName(classNotification);
            notificationFactory = (NotificationFactory) clazz.getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
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
