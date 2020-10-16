/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kareem
 */
public class Find {
    public static void main(String[] args){
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.addFirst(3);
        numbers.addFirst(1);
        numbers.addFirst(0);
        numbers.addLast(30);
        numbers.addLast(40);
        System.out.println("is memeber "+ numbers.isMember(50));
        
        LinkedList<Integer> letters = new LinkedList<>();
        letters.addFirst(20);
        letters.addFirst(5);
        letters.addFirst(1);
        letters.addFirst(0);

        System.out.println("is memeber "+ letters.isMember(15));

        
    }
}
