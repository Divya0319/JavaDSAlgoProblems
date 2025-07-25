package main.java.NarasimhaKarumanchi.java.t005_Trees;

public class ListNode<T> {
    private T data;
    private ListNode<T> next;
    public ListNode(T data) {
        this.data = data;
    }
    
    public void setData(T data) {
        this.data = data;
    }
    
    public T getData() {
        return data;
    }
    
    public void setNext(ListNode<T> next) {
        this.next = next;
    }
    
    public ListNode<T> getNext() {
        return next;
    }
}
