package iuh.fit.Observer;

// ConcreteSubject
public class Library extends Subject {
    // Thêm sách mới
    public void addNewBook(String bookName) {
        System.out.println("Sách mới '" + bookName + "' đã được thêm vào thư viện.");
        notifyObservers("Sách mới '" + bookName + "' đã được thêm vào thư viện.");
    }

    // Sách hết hạn mượn
    public void bookExpired(String bookName) {
        System.out.println("Sách '" + bookName + "' đã hết hạn mượn.");
        notifyObservers("Sách '" + bookName + "' đã hết hạn mượn.");
    }
}