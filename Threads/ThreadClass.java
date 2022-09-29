package Threads;

import java.util.ArrayList;

public class ThreadClass implements Runnable {

    private int firstNumber = 1;

    private final Object LOCK = new Object();

    private ArrayList <Integer> list = new ArrayList<>();
    private ArrayList <Integer> list2 = new ArrayList<>();
    private ArrayList <Integer> list3 = new ArrayList<>();
    private ArrayList <Integer> list4 = new ArrayList<>();
    private ArrayList <Integer> oddNumbers = new ArrayList<>();
    private ArrayList <Integer> evenNumbers = new ArrayList<>();

    public ThreadClass () {}

    @Override
    public void run() {
       
        synchronized (LOCK) {
            System.out.println(getFirstNumber());

            if (this.firstNumber <= 2500) {
                this.list.add(this.firstNumber);
                System.out.println(this.firstNumber + " added to List1");
            } else if (this.firstNumber > 2500 && this.firstNumber <= 5000) {
                this.list2.add(this.firstNumber);
                System.out.println(this.firstNumber + " added to List2");
            } else if (this.firstNumber > 5000 && this.firstNumber <= 7500) {
                this.list3.add(this.firstNumber);
                System.out.println(this.firstNumber + " added to List3");
            } else {
                this.list4.add(this.firstNumber);
                System.out.println(this.firstNumber + " added to List4");
            }

            if (this.firstNumber % 2 == 0) {
                this.evenNumbers.add(this.firstNumber);
                System.out.println(this.firstNumber + " added to Even Number List");
            } else {
                this.oddNumbers.add(this.firstNumber);
                System.out.println(this.firstNumber + " added to Odd Number List");
            }

            this.firstNumber++;
        }
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public ArrayList<Integer> getList() {
        return list;
    }

    public ArrayList<Integer> getList2() {
        return list2;
    }

    public ArrayList<Integer> getList3() {
        return list3;
    }

    public ArrayList<Integer> getList4() {
        return list4;
    }

    public synchronized ArrayList<Integer> getOddNumbers() {
        return oddNumbers;
    }

    public synchronized ArrayList<Integer> getEvenNumbers() {
        return evenNumbers;
    }

}
