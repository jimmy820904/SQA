package main;

/**
 * Created by acer on 2017/6/15.
 */
public class Test
{
    public static void main(String[] args)
    {
        String s = "111111";
        AccountSystem a = new AccountSystem();
        String state;

        System.out.println(a.signUp("chenci111","AAAaaaaa11"));
        System.out.println(a.signUp("chenci222","BBBbbbbb22"));
        System.out.println(a.signUp("chenci333","CCCccccc33"));
        System.out.println(a.database.replace("chenci111","AAaaaaa11","RRRrrrrr55"));
        System.out.println(a.database.get("chenci111"));

    }
}
