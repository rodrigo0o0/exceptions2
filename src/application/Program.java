package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.IllegalWithdrawException;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		try {
			
			System.out.println("Enter account data: ");
			System.out.print("Number : ");
			int number = sc.nextInt();
			System.out.print("Holder : ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial balance : ");
			double initialBalance = sc.nextDouble();
			System.out.print("Withdraw Limit : ");
			double withdrawLimit = sc.nextDouble();
			Account account = new Account(number,holder,initialBalance,withdrawLimit);
			
			System.out.println();
			System.out.println();
			System.out.print("Enter amount for withdraw : ");
			double withdrawValue = sc.nextDouble();
			account.withdraw(withdrawValue);
			System.out.println("New Balance : " + String.format("%.2f",account.getBalance()));
			
		}catch(IllegalWithdrawException e) {
			System.out.println(e.getMessage());
		}catch(InputMismatchException e) {
			System.out.println("Error : The value is invalid!");
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
}
