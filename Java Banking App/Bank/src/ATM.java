import java.io.IOException;
import java.util.Scanner;

public class ATM {

  public static void main(String[] args){
  
    try(Scanner input = new Scanner(System.in)){

      BankAccount account = new BankAccount("hoge", "password");

      System.out.println("=======================");
      System.out.println("Welcome to ABC Bank");
      System.out.println("=======================");
      
      while(true){
        clrscr();
        System.out.println("Please enter your name");
        String user = input.nextLine();
        System.out.println("Please enter your password");
        String pass = input.nextLine();

        if(user.equals(account.getCustomerName()) && pass.equals(account.getCustomerPassword())){
          System.out.println("Welcome," + user);
          break;
        }

        System.out.println("Invalid credentials\nPlease press [enter] key to try again or press [Q] to exit");

        if(input.nextLine().toLowerCase().equals("q")){
          System.out.println("Thank you for banking with us");
          System.exit(0);
        }
      }

      //call show menu
      clrscr(); //x
      account.showMenu();
    }
  }

  public static void clrscr(){
    //Clears Screen in Java
    try{
      if(System.getProperty("os.name").contains("Windows"))
        new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
      else
        Runtime.getRuntime().exec("clear");
        System.out.println("\033\143");
    }catch(IOException | InterruptedException ex){}
  }
}
