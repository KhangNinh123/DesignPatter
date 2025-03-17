package iuh.fit.Observer;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Khởi tạo thư viện
        Library library = new Library();

        // Khởi tạo các observers
        Librarian librarian = new Librarian();
        User user1 = new User("Alice");
        User user2 = new User("Bob");

        // Đăng ký observers vào thư viện
        library.attach(librarian);
        library.attach(user1);
        library.attach(user2);

        // Thêm sách mới
        library.addNewBook("Design Patterns");

        // Sách hết hạn mượn
        library.bookExpired("Clean Code");

        // Hủy đăng ký một observer
        library.detach(user2);

        // Thêm sách mới sau khi hủy đăng ký
        library.addNewBook("Refactoring");
    }
}