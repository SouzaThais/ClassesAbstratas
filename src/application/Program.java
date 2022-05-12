package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {
		//Não é possível instanciar uma classe abstrata ->
		//Account acc1 = new Account(1001, "Alex", 1000.0);
		
		//Exemplos que funcionam usando polimorfismo:
		//Account acc2 = new SavingsAccount(1002, "Maria", 1000.0, 0.01);
		//Account acc3 = new BusinessAccount(1003, "Bob", 1000.0, 500.0);
		Locale.setDefault(Locale.US);
		List<Account> list = new ArrayList<Account>();
		
		list.add(new SavingsAccount(1001, "Alex", 500.0, 0.01));
		list.add(new BusinessAccount(1002, "Maria", 1000.0, 400.0));
		list.add(new SavingsAccount(1003, "Bob", 300.0, 0.01));
		list.add(new BusinessAccount(1004, "Anna", 500.0, 500.0));
		
		double sum = 0.0;
		for (Account acc: list) {
			sum += acc.getBalance();
		}
		System.out.printf("Total Balance: %.2f%n", sum);
		
		for (Account acc: list) {
			acc.deposit(10.0);;
		}
		
		for(Account acc : list) {
			System.out.printf("Updated balance for account %d: %.2f%n", acc.getNumber(), acc.getBalance());
		}
	}

}
