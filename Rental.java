package Main_CR;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Rental {
     static double wallet=1723.5;
    public static void my_camera(Scanner s,Map<Integer, camera> map) {
        camera c=new camera();
        System.out.println("1. ADD");
        System.out.println("2. REMOVE");
        System.out.println("3. VIEW MY CAMERAS");
        System.out.println("4. GO TO PREVIOUS MENU");
        System.out.println("Select the operation by the id :");
        int n=s.nextInt();
        while(n>0 && n<5) {
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
                System.out.println("Product List:");
                for (Map.Entry<Integer, camera> e : map.entrySet()) {
                    camera p = e.getValue();
                    System.out.println("ID: " + p.camera_ID + " Name: " + p.brand + " Model: " + p.model + " Price: " + p.price + " Status: " + p.status );
                }
            }
            else if(n==4) { //GO TO PREVIOUS MENU
                my_camera(s,map);

            }
            System.out.println("Select the operation by the id :");
            n=s.nextInt();
        }
    }
    public static void rent_a_camera(Scanner s,Map<Integer, camera> map) {
        for (Map.Entry<Integer, camera> e : map.entrySet()) {
            camera p = e.getValue();
            if((p.status).equals("Available")){
                System.out.println("ID: " + p.camera_ID + " Name: " + p.brand + " Model: " + p.model + " Price: " + p.price + " Status: " + p.status );
            }
        }
        System.out.println("Enter the camera ID you want to rent : ");
        int temp_id=s.nextInt();
        for (Map.Entry<Integer, camera> e : map.entrySet()) {
            camera p = e.getValue();
            if(p.camera_ID==temp_id){
                if(p.price<=wallet) {
                    wallet-=p.price;
                    if(map.containsKey(p.camera_ID)){
                        camera c=map.get(p.camera_ID);
                        c.status="Rented";
                        map.put(p.camera_ID,c);
                        System.out.println("ID: " + p.camera_ID + " Name: " + p.brand + " Model: " + p.model + " Price: " + p.price + " Status: " + p.status );
                    }
                    System.out.println("Your transaction for camera - " + p.brand + " with rent " + p.price + " has successfully completed");
                }
                else{
                    System.out.println("TRANSACTION FAILED DUE TO INSUFFICIENT WALLET BALANCE, PLEASE DEPOSIT THE AMOUNT TO YOUR WALLET");
                }
            }
        }
    }
    public static void view_all_camera(Map<Integer, camera> map) {
        System.out.println("Product List:");
        for (Map.Entry<Integer, camera> e : map.entrySet()) {
            camera p = e.getValue();
            System.out.println("ID: " + p.camera_ID + " Name: " + p.brand + " Model: " + p.model + " Price: " + p.price + " Status: " + p.status );
        }

    }
    public static void my_wallet(Scanner s) {
        System.out.println("YOUR CURRENT WALLET BALANCE IS INR.  "+wallet);
        System.out.println("DO YOU WANT TO DEPOSIT MORE AMOUNT TO YOUR WALLET (1.YES 2.NO)");
        int choice=s.nextInt();
        if(choice==1){
            System.out.println("ENTER THE AMOUNT (INR) :");
            double inr=s.nextDouble();
            wallet+=inr;
            System.out.println("YOUR WALLET BALANCE UPDATED SUCCESSFULLY. CURRENT WALLET BALANCE - INR. "+wallet);
        }
    }
    public static void exit() {
            System.out.println("Thanks for visiting our shop!!!");
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
            camera c1=new camera(1,"Samsung","DS123",500.0,"Available");
            map.put(c1.camera_ID, c1);
            camera c2=new camera(2,"Sony","HD123",500.0,"Available");
            map.put(c2.camera_ID, c2);
            camera c3=new camera(3,"Panasonic","XC",500.0,"Available");
            map.put(c3.camera_ID, c3);
            camera c4=new camera(4,"Canon","XLR",500.0,"Available");
            map.put(c4.camera_ID, c4);
            camera c5=new camera(5,"LG","L123",25000.0,"Available");
            map.put(c5.camera_ID, c5);
            int n=s.nextInt();
            while(n>0 && n<6) {
                if(n==1) {  //MY CAMERA
                    my_camera(s,map);
                }
                else if(n==2) {  //RENT A CAMERA
                    rent_a_camera(s,map);
                }
                else if(n==3) {  //VIEW ALL CAMERAS
                    view_all_camera(map);
                }
                else if(n==4) {  //MY WALLET
                    my_wallet(s);
                }
                else {  //EXIT
                    exit();
                    break;
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

