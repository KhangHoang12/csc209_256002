package co.kulwadee.csc209.lect01;

import java.util.Arrays;

public class AccountInfClient {
	public static void main(String[] args) {
		AccountInf[] accounts = new AccountInf[3];
		
		accounts[0] = new AccountInf("A", 200);
		accounts[1] = new AccountInf("B", 100);
		accounts[2] = new AccountInf("C", 300);
		
		System.out.println("Before sorting...");
		
		for (AccountInf acc : accounts)
			System.out.println(acc);
		
		Arrays.sort(accounts);
		
		System.out.println("After sorting...");		
		for (AccountInf acc : accounts)
			System.out.println(acc);
	}

}
