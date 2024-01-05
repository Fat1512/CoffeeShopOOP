package Interface;

import java.util.List;
import java.util.function.Consumer;

public interface Checkable <T> {
    //Dung khi ket qua tim kiem tra ra 1 doi tuong
    default void kiemTraTrong(T t,Consumer<T> consumer, String message) {
        if (t!=null) {
            consumer.accept(t);
        } else {
            System.out.println(message);
        }
    }
    //Dung khi ket qua tim kiem tra ra 1 danh sach
    default void kiemTraTrong(List<T> t, Consumer<List<T>> consumer, String message) {
        if (t == null || !t.isEmpty()) {
            consumer.accept(t);
        } else {
            System.out.println(message);
        }
    }
    //Kiem tra danh sach cac class quan ly rong
    boolean kiemTraTrong(String message);
}