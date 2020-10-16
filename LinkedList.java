/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kareem
 */

public class LinkedList <E extends Comparable<E>> {
    private static class Node<E>{
        E element;
        Node<E> nextNode;
        Node<E> prevNode;
        public Node(E element, Node<E> nextNode, Node<E> prevNode){
            this.element = element;
            this.nextNode = nextNode;
            this.prevNode = prevNode;
        }
       
        public E getElement(){
            return element;
        }
        
        public void setNext(Node<E> nextNode){
            this.nextNode = nextNode;
        }
        public Node<E> getNext(){
            return nextNode;
        }
        
        public void setPrev(Node<E> prevNode){
            this.prevNode = prevNode;
        }
        public Node<E> getPrev(){
            return prevNode;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    public int size = 0;

    public boolean isEmpty(){
        return size == 0;
    }
    public int getSize(){
        return size;
    }
    public LinkedList(){
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, null, header);
        header.setNext(trailer);
    }
    
    public E First(){
        if(isEmpty()) return null;
        return header.getNext().getElement();
    }
    
    public E Last(){
        if(isEmpty()) return null;
        return trailer.getPrev().getElement();
    }
    
    private void addBetween(E e, Node<E> predecessor, Node<E> successor){
        Node<E> newNode = new Node<>(e,successor , predecessor);
        predecessor.setNext(newNode);
        successor.setPrev(newNode);
        size++;
    }
    
    public void addFirst(E e){
        addBetween(e, header, header.getNext());      
    }
    public void addLast(E e){
        addBetween(e, trailer.getPrev(), trailer);
    }
    
    public void printAll(){
        Node<E> currentNode = header.getNext();
        while(currentNode.getNext() != null){
            System.out.println(currentNode.getElement());
            currentNode = currentNode.getNext();
        }
    }
    
    private Node<E> getMidElement(Node<E> min, Node<E> max){
       if (min == null) return null;       
       

       Node<E> counter1 = min;
       Node<E> counter2 = min;
       if(counter2 != max){
           counter2 = counter2.getNext();
           if(counter2 != max){
                getMidElement(counter1.getNext(), counter2.getNext());
           }
       }
      /* while(counter2 != max){
           
           counter2 = counter2.getNext();
           if(counter2 != max){
               counter1 = counter1.getNext();
               counter2 = counter2.getNext();
           }
        }*/
       return counter1;
    }
    
    
    public boolean isMember(E target){
        Node<E> start = header.getNext();
        Node<E> last = trailer;

        do{
            Node<E> mid = getMidElement(start, last);
            
            if(mid.getElement().equals(target)) return true;
            
            if((mid.getElement()).compareTo(target) == -1)
                start = mid.getNext();
            
       
            else if((mid.getElement()).compareTo(target) == 1) 
                last = mid;
            
            
        }while(last == null || last != start);
        
        return false;
    }
}   

