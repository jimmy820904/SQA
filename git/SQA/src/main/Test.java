package main;

/**
 * Created by acer on 2017/6/15.
 */
public class Test
{
    public static void main(String[] args)
    {
        String s = "_____1a___";
        AccountSystem a = new AccountSystem();
        System.out.print(s.length());
        System.out.print(a.checkAccount(s));
    }
}
