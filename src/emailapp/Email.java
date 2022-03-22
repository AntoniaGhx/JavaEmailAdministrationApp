package emailapp;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    //folosim incapsularea ca sa nu aiba nimeni acces la datele noastre;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String department;
    private String alternateEmail;
    private String companySuffix = "company.com";
    private int mailboxCapacity = 500;
    //added later
    private int defalutPasswordLength = 10;

    //Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        //call a method asking for the department - return the department
        this.department = setDepartment();

        //call a method that returns a random password
        this.password = randomPassword(defalutPasswordLength);
        System.out.println("Your password is " + this.password);

        //combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    //Ask for the department
    private String setDepartment() {
        System.out.println("New worker: " + firstName +  ". Departemnt codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code:");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {return "sales";}
        else if (depChoice == 2) { return "dev";}
        else if (depChoice == 3) { return "acct";}
        else { return "";}
    }

    //Generate a random password
    private String randomPassword(int lenght) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ01234567890!@#$%^&*";
        char[] password = new char[lenght];
        for (int i = 0; i < lenght; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    //Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    //Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return  alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}




