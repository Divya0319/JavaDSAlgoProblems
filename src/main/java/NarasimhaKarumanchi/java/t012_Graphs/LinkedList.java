package main.java.NarasimhaKarumanchi.java.t012_Graphs;

import main.java.NarasimhaKarumanchi.java.t002_LinkedList.ListNode;

public class LinkedList<T> implements LinkedListService<T> {
    public LinkedList() {
        length = 0;
    }
    
    ListNode<T> head;
    ListNode<T> tail;
    private int length = 0;
    
    public synchronized ListNode<T> getHead() {
        return head;
    }
    
    @Override
    public synchronized void insert(T data) {
    	ListNode<T> newNode = new ListNode<>(data);
    	
    	// checking if list is empty
    	
    	if(head == null) {
    		head = newNode;
    		tail = newNode;
    	} else {
    		tail.setNext(newNode);
    		tail = newNode;
        
    	}
    	length++;
    }
    
    @Override
    public synchronized void insert(T data, int position) {
        ListNode<T> temp = head;
        int pos = 1;
        while(pos != position-1) {
            temp = temp.getNext();
            pos++;
        }
        
    	ListNode<T> newNode = new ListNode<>(data);
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
        length++;
    }
    
    public synchronized void insertAndCreateLoop(T data, int position) {
        ListNode<T> temp = head;
        int pos = 1;
        while(pos != position-1) {
            temp = temp.getNext();
            pos++;
        }
        
    	ListNode<T> newNode = new ListNode<>(data);
        temp.setNext(newNode);
        newNode.setNext(temp);
        length++;
        
        System.out.println("Loop created from " + temp.getData() + " to " + newNode.getData());
    }
    
    @Override
    public synchronized ListNode<T> deleteAtBegin() {
    	ListNode<T> nodeToDelete = null;
        if(head == null) {
            System.out.println("List is empty");
        }
        else {
            
        nodeToDelete = head;
        head = head.getNext();
        length--;
        
        }
        
        return nodeToDelete;
    }
    
    @Override
    public synchronized ListNode<T> deleteAtEnd() {
    	ListNode<T> nodeToDelete = null;
        if(head == null) {
            System.out.println("List is empty");
        }
        else {
            
        ListNode<T> temp = head;
        while(temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }
        nodeToDelete = temp.getNext();
        temp.setNext(null);
        length--;
        
        }
        
        return nodeToDelete;
    }
    
    @Override
    public synchronized ListNode<T> delete(int position) {
    	
    	ListNode<T> nodeToDelete = null;
        if(head == null) {
            System.out.println("List is empty");
        } 
        else {
            ListNode<T> temp = head;
        
        if(position < 0) 
            position = 1;
        if(position > getLength()) 
            position = getLength();
        
        if(position == 0) {
        	nodeToDelete = head;
            head = head.getNext();
        } 
        else {
            for(int i = 2; i <= position-1; i++) {
                temp = temp.getNext();
            }
            
            nodeToDelete = temp;
            temp.setNext(temp.getNext().getNext());            
            
        }
        length--;
        
        }  
        
        return nodeToDelete;
    }
    
    @Override
    public int getLength() {
        return length;
    }
    
    public int getPosition(T data) {
        ListNode<T> temp = head;
        int pos = 1;
        while(temp != null) {
            if(temp.getData() == data) {
                return pos;
            }
            
            pos++;
            temp = temp.getNext();
        }
        
        return -1;
    }
    
    @Override
    public boolean isEmpty() {
    	return head == null;
    }
    
    
    public String toString() {
        String result = "[";
        if(head == null) {
            return result + "]";
        }
        result = result + head.getData();
        ListNode<T> temp = head.getNext();
        while(temp != null) {
           result = result + ", " + temp.getData();
           temp = temp.getNext();
        }
        
        return result + "]";
    }
    
    public String toString(ListNode<T> head) {
        String result = "[";
        if(head == null) {
            return result + "]";
        }
        result = result + head.getData();
        ListNode<T> temp = head.getNext();
        while(temp != null) {
           result = result + ", " + temp.getData();
           temp = temp.getNext();
        }
        
        return result + "]";
    }
    
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.insert(1);
        System.out.println(ll.toString());
        ll.insert(2);
        System.out.println(ll.toString());
        ll.insert(3);
        System.out.println(ll.toString());
        ll.insert(4);
        System.out.println(ll.toString());
        ll.insert(5);
        System.out.println(ll.toString());
        ll.insert(6);
        System.out.println(ll.toString());

    }
}



