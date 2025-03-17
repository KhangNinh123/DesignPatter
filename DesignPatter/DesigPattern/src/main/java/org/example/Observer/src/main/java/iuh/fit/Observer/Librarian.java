package iuh.fit.Observer;

public class Librarian implements Observer {
    @Override
    public void update(String message) {
        System.out.println("[Thủ thư] Nhận được thông báo: " + message);
    }
}