/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savingaccount;

/**
 *
 * @author carlos
 */
public class Account {
    private int balance = 0;
    //private final int max;
    public Account(int initial){
        this.balance=initial;
    }
    
    public synchronized void deposit(int amount){
            balance=balance+amount;
            System.out.println(Thread.currentThread().getName() + " has deposited " + amount);
            print_account();
            notifyAll();
    }
    
    public synchronized void withdraw(int amount) throws InterruptedException{
        while(balance<amount){
             System.out.println(Thread.currentThread().getName() + " has to wait");
            wait();
        }
        balance=balance-amount;
        System.out.println(Thread.currentThread().getName() + " has withdrawn " + amount);
         print_account();
    }    
    
    
    public synchronized void print_account() {
        System.out.println("Balance: " + balance);
    }
}

