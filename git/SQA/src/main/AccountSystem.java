package main;

import java.util.HashMap;

/**
 * Created by acer on 2017/6/15.
 */
public class AccountSystem
{
    private HashMap<String, String> database = new HashMap<String, String>();
    /*
    public String signUp(String account, String password)
    {

        if( database.containsKey(account) )
            return "此帳號已存在";
        if(checkAccount(account) != "collect" )
            return checkAccount(account);
        if(checkPassword(password) != "collect" )
            return checkPassword(password);

        database.put(account, password);

        return "註冊完成";
    }
    */

    public String checkAccount(String account)
    {
        if(account.length() < 8 || account.length() > 16)
            return "帳號不符合規定長度";

        assert (account.length() >= 8 && account.length() <=16) : "wrong  account length";
        String regex = "[a-zA-Z0-9]+$";

        if(account.matches(regex) == true)
        {
            boolean letter = false;
            boolean digit = false;
            for(int i = 0 ; i < account.length() ; i++ )
            {
                if( (letter && digit) == true)
                {
                    return "correct";
                }

                char temp = account.charAt(i);

                if(Character.isLetter(temp))
                {
                    letter = true;
                    continue;
                }

                if(Character.isDigit(temp))
                {
                    digit = true;
                    continue;
                }
            }
        }
        assert account.matches(regex) == false : "illegal account";
        return "帳號需包含英文字母及數字，不能使用符號";
    }

    public String checkPassword(String password)
    {
        if(password.length() < 8 || password.length() > 16)
            return "密碼不符合規定長度";

        assert (password.length() >= 8 && password.length() <=16) : "wrong password length";
        String regex = "[a-zA-Z0-9]+$";

        if(password.matches(regex) == true)
        {
            boolean upperCase = false;
            boolean lowerCase = false;
            boolean digit = false;
            for(int i = 0 ; i < password.length() ; i++ )
            {
                if( (upperCase && lowerCase && digit) == true)
                {
                    return "correct";
                }

                char temp = password.charAt(i);

                if(Character.isUpperCase(temp))
                {
                    upperCase = true;
                    continue;
                }

                if(Character.isLowerCase(temp))
                {
                    lowerCase = true;
                    continue;
                }

                if(Character.isDigit(temp))
                {
                    digit = true;
                    continue;
                }
            }
        }
        assert password.matches(regex) == false : "illegal password";
        return "密碼需包含大小寫英文字母及數字，不能使用符號";
    }
}
