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
public class Company extends Thread{
    Account account;
    int amount = 250;
    public Company(Account account){
        this.account=account;
    }
    public void run (){
        while (true){
                System.out.println(Thread.currentThread().getName() + " wants to deposit "+amount);
                try{
                    Thread.sleep(1000);
                    account.deposit(amount);
                }catch(InterruptedException e) {};
        }
    }
}