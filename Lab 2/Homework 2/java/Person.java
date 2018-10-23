/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savingaccount;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author carlos
 */
public class Person extends Thread{
    Account account;
    public Person(Account account){
        this.account=account;
    }
    public void run (){
        while (true){
            int optype = ThreadLocalRandom.current().nextInt(0, 2);
            int amount = ThreadLocalRandom.current().nextInt(0, 1001);
            if (optype==1){
                System.out.println(Thread.currentThread().getName() + " wants to withdraw "+amount + " optype: "+optype);
                try{
                    Thread.sleep(200);
                    account.withdraw(amount);
                }catch(InterruptedException e) {};
            }else{
                System.out.println(Thread.currentThread().getName() + " wants to deposit "+amount+ " optype: "+optype);
                try{
                    Thread.sleep(200);
                    account.deposit(amount);
                }catch(InterruptedException e) {};
            }
        }
    }
    
}
