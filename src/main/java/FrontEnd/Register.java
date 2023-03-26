package FrontEnd;

import BusinessLogic.LoginAndRegisterService;
import BusinessLogic.User;

import java.util.Scanner;

public class Register {
    public static void UserReg() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the First name of the customer: ");
        String fname = scanner.nextLine();
        System.out.print("Enter the Middle name of the customer: ");
        String mname = scanner.nextLine();
        System.out.print("Enter the Last name of the customer: ");
        String lname = scanner.nextLine();
        System.out.print("Enter the Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter the Pincode: ");
        int pincode = scanner.nextInt();
        System.out.print("Enter the city: ");
        scanner.nextLine();
        String city = scanner.nextLine();
        System.out.print("Enter A USERNAME: ");
        String username = scanner.nextLine();
        System.out.print("Enter A PASSWORD: ");
        String password = scanner.nextLine();
        System.out.print("Enter A Date of birth: ");
        String dob = scanner.nextLine();
        System.out.print("Enter PAN Card number: ");
        String pan = scanner.nextLine();
        System.out.print("Enter AADHAR Card number: ");
        int aadhar = scanner.nextInt();
        System.out.print("Enter Amount to deposite: ");
        int amount = scanner.nextInt();

        User user = new User();
        user.setFname(fname);
        user.setMname(mname);
        user.setLname(lname);
        user.setAddress(address);
        user.setPincode(pincode);
        user.setCity(city);
        user.setPan(pan);
        user.setAadhar(aadhar);
        user.setAmount(amount);
        user.setUsername(username);
        user.setPassword(password);
        user.setDob(dob);

        LoginAndRegisterService loginAndRegisterService = new LoginAndRegisterService();
        try {
            loginAndRegisterService.registerValidate(user);
            System.out.println("User registered successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
