
interface OrderOutput {
    void display(Order order);
}

interface NotificationService {
    void sendNotification(Order order, String message);
}



// Handles displaying the order in the mobile view
class OrderViewPresenter implements OrderOutput {
    @Override
    public void display(Order order) {
        // Existing logic to show order on the mobile app view...
        System.out.println("Displaying order " + order.getId() + " on mobile view.");
    }
}


class EmailPresenter implements OrderOutput   {
    @Override
    public void display(Order order) {
        // New logic to format an email, including total price
        System.out.println("--- Email ---");
        System.out.println("Order ID: " + order.getId());
        System.out.println("Total Price: $" + order.getTotalPrice()); // Address requirement
        System.out.println("-------------");
    }
}

class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(Order order, String recipient) {
        // Logic to connect to an email server and send the order info
        System.out.println("Emailing order " + order.getId() + " to " + recipient);
        EmailPresenter emailView = new EmailPresenter();
        emailView.display(order); // Use the new email view
    }
}

// The controller is now more flexible and uses the abstractions.
class OrderController {
    private OrderDatabase database;

    public OrderController(OrderDatabase database) {
        this.database = database;
    }

    public void showOrder(int orderId, OrderOutput presenter) {
        Order order = database.getOrderById(orderId);
        presenter.display(order); // Uses whatever output implementation is passed in
    }

    public void notifyAboutOrder(int orderId, NotificationService notifier, String destination) {
        Order order = database.getOrderById(orderId);
        notifier.sendNotification(order, destination); // Uses the notification service
    }
}
