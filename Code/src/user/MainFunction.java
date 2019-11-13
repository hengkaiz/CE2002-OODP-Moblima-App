package user;

import Cinema.ShowTime;

import java.util.Scanner;

public class MainFunction {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserDatabase udb = new UserDatabase();
		UserFunctions uf = new UserFunctions();

		SearchByDate sd = new SearchByDate();

		sd.searchResult();
	}

}
