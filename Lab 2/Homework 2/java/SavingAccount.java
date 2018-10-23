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
public class SavingAccount {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Account account = new Account(0);
       Thread a = new Person(account);
       Thread b = new Person(account);
       Thread c = new Company(account);
       a.setName("alice");
       b.setName("bob");
       c.setName("company");
       a.start();
       b.start();
       c.start();
       
    }
    
}
