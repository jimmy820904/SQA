package main;

/**
 * Created by acer on 2017/6/15.
 */
public class AccountSystem
{
    /*
    private HashMap<String, String> database = new HashMap<String, String>();


    public String signUp(String account, String password)
    {

        //String lcAccount = account.toLowerCase();

        if( database.containsKey(account) )
            return "帳號已存在";
        if( !accountOK(lcAccount) )
            return AccountSystem.s3;
        if( !passwordOK(password) )
            return AccountSystem.s4;

        accountPassword.put(lcAccount, password);
        otherData.put(lcAccount, data);
        return AccountSystem.s1;

    }
    */

    public String checkAccount(String account)
    {
        if(account.length() < 8 || account.length() > 16)
            return "帳號不符合規定長度";

        String regex = "[a-zA-Z0-9]+$";

        if(account.matches(regex) == true)
        {
            System.out.print("come in");
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
        return "帳號需包含英文字母及數字，不能使用符號";
    }

}
