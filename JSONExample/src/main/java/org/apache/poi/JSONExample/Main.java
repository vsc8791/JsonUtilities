package org.apache.poi.JSONExample;

import java.util.Scanner;

import org.json.JSONException;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "D:\\new.json";
		int choice;
		System.out.println("======WELCOME TO WORLD OF JAVA AND JSON======");
		

		do {
			System.out.println("1.Writing JSON Data in File");
			System.out.println("2.Reading JSON Data in File");
			System.out.println("3.Searching JSON Data in File");
			System.out.println("4.Exit");	
			System.out.println("Please Enter Your Choice-->");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("---------WRITING----------");
				WriteJSON write = new WriteJSON();
				write.jsonFileWrite(fileName);
				break;
			case 2:
				System.out.println("---------READING----------");
				ReadJSON read = new ReadJSON();
				try {
					read.jsonFileRead(fileName);
				} catch (JSONException e) {
				
					System.out.println("FILE NOT NOUND");
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("---------SEARCHING----------");
				SearchJSON searchJSON=new SearchJSON();
				try {
					searchJSON.jsonFileSearch(fileName);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				System.exit(0);

			default:
				System.out.println("INVALID CHOICE !! ENTER APPROPIATELY");

			}
		} while (choice > 0 && choice < 5);

	}

}
