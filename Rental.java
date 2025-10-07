package Main_CR;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Rental {
	public static void my_camera(Scanner s,Map<Integer, camera> map) {
		camera c=new camera();
		System.out.println("1. ADD");
		System.out.println("2. REMOVE");
		System.out.println("3. VIEW MY CAMERAS");
		System.out.println("4. GO TO PREVIOUS MENU");
		System.out.println("Select the operation by the id :");
		int n=s.nextInt();
		while(n>0 && n<6) {
		if(n==1) { //Add
			System.out.println("Enter the camera ID : ");
			int camera_ID=s.nextInt();
			System.out.println("Enter the brand : ");
			String brand=s.next();
			System.out.println("Enter the model : ");
			String model=s.next();
			System.out.println("Enter the price : ");
			double prices=s.nextDouble();
			System.out.println("Enter the status : ");
			String status=s.next();
			 c=new camera(camera_ID,brand,model,prices,status);
			map.put(camera_ID,c);
			System.out.println("Your camera has been added successfully!!!");
			System.out.println(map);
		}
		else if(n==2) { //Remove
			System.out.println("Enter the camera ID to remove");
			int rem=s.nextInt();
			if(map.containsKey(rem)) {
				map.remove(rem);
				System.out.println("Camera successfully removed from the list!!!");
			}
			else {
				System.out.println("Camera unavilable!!!");
			}
				
			
		}
		else if(n==3) { //VIEW MY CAMERAS
			c.display();
			
			
		}
		else if(n==4) { //GO TO PREVIOUS MENU

			
		}
		System.out.println("Select the operation by the id :");
		n=s.nextInt();
			
		}
		

	}
	public static void rent_a_camera() {

	}
	public static void view_all_camera() {

	}
	public static void my_wallet() {

	}
	public static void exit() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		String un="admin";
		String ps="admin123";
		System.out.println("USERNAME");
		String user=s.next();
		System.out.println("PASSWORD");
		String pass=s.next();

		if(un.equals(user) && ps.equals(pass)) {
			System.out.println("+----------------------------+");
			System.out.println("|WELCOME TO CAMERA RENTAL APP|");
			System.out.println("+----------------------------+");
			System.out.println("1. MY CAMERA");
			System.out.println("2. RENT A CAMERA");
			System.out.println("3. VIEW ALL CAMERAS");
			System.out.println("4. MY WALLET");
			System.out.println("5. EXIT");
			System.out.println("Select the menu by the id :");
			Map<Integer, camera> map=new HashMap<>(); 
			int n=s.nextInt();
			while(n>0 && n<6) {
				if(n==1) {  //MY CAMERA
					my_camera(s,map);
				}
				else if(n==2) {  //RENT A CAMERA
					rent_a_camera();
				}
				else if(n==3) {  //VIEW ALL CAMERAS
					view_all_camera();
				}
				else if(n==4) {  //MY WALLET
					my_wallet();
				}
				else {  //EXIT
					exit(); 
				}
				System.out.println("Select the menu by the id :");
				n=s.nextInt();

			}


		}
		else {
			System.out.println("Invalid User login");
		}
	}

}
