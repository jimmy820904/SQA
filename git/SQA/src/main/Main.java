package main;
import java.util.Scanner;
/**
 * Created by acer on 2017/6/15.
 */
public class Main
{
    public static void main(String[] args)
    {
        AccountSystem system = new AccountSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;
        String account;
        String password;
        String state;
        while(true)
        {
            if(system.login == false)
            {
                System.out.println("★★★Welcome to SQA online Class★★★");
                System.out.println("What do you want to do?");
                System.out.println("1.Sign Up");
                System.out.println("2.Sign In");
                System.out.println("3.Forget Password");
                System.out.println("4.Exit");
                System.out.print("★★★★★★★★★★★★★★★★★★★★\n>");
                choice = scanner.nextInt();

                switch(choice)
                {
                    case 1:
                        System.out.print("Please enter your accout:\n>");
                        account = scanner.next();
                        System.out.print("Please enter your password:\n>");
                        password = scanner.next();
                        state = system.signUp(account, password);
                        System.out.println(state);
                        break;
                    case 2:
                        System.out.print("Please enter your accout:\n>");
                        account = scanner.next();
                        System.out.print("Please enter your password:\n>");
                        password = scanner.next();
                        state = system.signIn(account, password);
                        System.out.println(state);
                        break;
                    case 3:
                        System.out.print("Please enter your accout:\n>");
                        account = scanner.next();
                        state = system.forgetPassword(account);
                        System.out.println(state);
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        break;
                }

            }

            if(system.login == true)
            {
                System.out.println("★★★★★★★★★★★★★★★★★★★★");
                System.out.print("Hello, " + system.currentUser + ". ");
                System.out.println("What do you want to do?");
                System.out.println("1.Change Password");
                System.out.println("2.Log out");
                System.out.print("★★★★★★★★★★★★★★★★★★★★\n>");
                choice = scanner.nextInt();

                switch(choice)
                {
                    case 1:
                        System.out.print("Please enter your old password:\n>");
                        password = scanner.next();
                        System.out.print("Please enter your new password:\n>");
                        String newPassword = scanner.next();
                        state = system.changePassword(system.currentUser, password, newPassword);
                        System.out.println(state);
                        break;
                    case 2:
                        system.logOut();
                        System.out.println("登出成功");
                        break;
                    default:
                        break;
                }
            }
        }

    }
}
