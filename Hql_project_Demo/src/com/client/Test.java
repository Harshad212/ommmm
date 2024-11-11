package com.client;

import java.util.Scanner;

import com.service.ServiceDaoImpl;

public class Test {
	public static void main(String[] args) {
		ServiceDaoImpl s=new ServiceDaoImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 1 for insert");
		System.out.println("Enter 2 for update");
		System.out.println("Enter 3 for delete");
		System.out.println("Enter 4 for select");
		System.out.println("please enter a choice");
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1:
			
			s.insert();
			break;
			
		case 2:
			
			s.update();
			break;
			
		case 3:
			
			s.delete();
			
			break;
			
		case 4:
			
			s.select();
			break;
			
		default:
			System.out.println("invalid choice");
		
		
		
		
		}
	}

}
