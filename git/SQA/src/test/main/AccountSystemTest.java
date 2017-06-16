package test.main; 

import main.AccountSystem;
import org.junit.Test;
import static org.junit.Assert.*;


public class AccountSystemTest
{
    @Test
    public void checkAccountTest()
    {
        AccountSystem a = new AccountSystem();
        String s1 = "1111";
        String s2 = "1a1a1a1a1a1a1a1a1";
        String s3  = "11111111";
        String s4 = "aaaaaaaa";
        String s5 = "1a1a1a1a_";
        String s6 = "1a1a1a1a";

        assertEquals("帳號不符合規定長度",a.checkAccount(s1));
        assertEquals("帳號不符合規定長度",a.checkAccount(s2));
        assertEquals("帳號需包含英文字母及數字，不能使用符號",a.checkAccount(s3));
        assertEquals("帳號需包含英文字母及數字，不能使用符號",a.checkAccount(s4));
        assertEquals("帳號需包含英文字母及數字，不能使用符號",a.checkAccount(s5));
        assertEquals("correct",a.checkAccount(s6));
    }

    @Test
    public void checkPasswordTest()
    {
        AccountSystem a = new AccountSystem();
        String s1 = "1111";
        String s2 = "1a1a1a1a1a1a1a1aA";
        String s3  = "11111111";
        String s4 = "aaaaaaaa";
        String s5 = "AAAAAAAA";
        String s6 = "1A1a1a1a_";
        String s7 = "1A1a1a1a";

        assertEquals("密碼不符合規定長度",a.checkPassword(s1));
        assertEquals("密碼不符合規定長度",a.checkPassword(s2));
        assertEquals("密碼需包含大小寫英文字母及數字，不能使用符號",a.checkPassword(s3));
        assertEquals("密碼需包含大小寫英文字母及數字，不能使用符號",a.checkPassword(s4));
        assertEquals("密碼需包含大小寫英文字母及數字，不能使用符號",a.checkPassword(s5));
        assertEquals("密碼需包含大小寫英文字母及數字，不能使用符號",a.checkPassword(s6));
        assertEquals("correct",a.checkPassword(s7));
    }

    @Test
    public void SignUpTest()
    {
        AccountSystem a = new AccountSystem();
        assertEquals(true, a.database.isEmpty());
        assertEquals("註冊成功", a.signUp("jimmy666","Jimmy666"));
        assertEquals("此帳號已存在", a.signUp("jimmy666","Jimmy678"));
        assertEquals(a.checkAccount("yyyyyyyy"), a.signUp("yyyyyyyy","Jimmy678"));
        assertEquals(a.checkPassword("yyyyyyyy"), a.signUp("jimmy777","yyyyyyyy"));
        assertEquals(1, a.database.size());
    }

    @Test
    public void SignInTest()
    {
        AccountSystem a = new AccountSystem();
        a.signUp("jimmy666","Jimmy666");
        assertEquals("登入成功", a.signIn("jimmy666","Jimmy666"));
        assertEquals("jimmy666", a.currentUser);
        assertEquals("密碼錯誤", a.signIn("jimmy666","123"));
        assertEquals("帳號錯誤", a.signIn("123456789","123"));
    }

    @Test
    public void forgetPasswordTest()
    {
        AccountSystem a = new AccountSystem();
        a.signUp("jimmy666","ABCDEf123");
        assertEquals("您的密碼第一個字為A，最後一個字為3", a.forgetPassword("jimmy666"));
        assertEquals("此帳號不存在", a.forgetPassword("jimmy6789"));
    }

    @Test
    public void changePasswordTest()
    {
        AccountSystem a = new AccountSystem();
        a.signUp("jimmy666","ABCDEf123");
        assertEquals("原密碼輸入錯誤", a.changePassword("jimmy666", "123","Qazwsx123"));
        assertEquals(a.checkPassword("123456789"), a.changePassword("jimmy666","ABCDEf123","123456789"));
        assertEquals("修改成功", a.changePassword("jimmy666", "ABCDEf123","Qazwsx123"));
        assertEquals("Qazwsx123", a.database.get("jimmy666"));
    }

    @Test
    public void logOutTest()
    {
        AccountSystem a = new AccountSystem();
        a.signUp("jimmy666","ABCDEf123");
        a.signIn("jimmy666","ABCDEf123");
        assertEquals("jimmy666", a.currentUser);
        a.logOut();
        assertEquals("", a.currentUser);
    }

    @Test
    public void getInstanceTest()
    {
        AccountSystem a = AccountSystem.getInstance();
        a.signUp("jimmy666","ABCDEf123");

        AccountSystem b = AccountSystem.getInstance();
        assertTrue(a==b);

        b.signUp("1qaz2wsx","1qaz2wsX");
        assertTrue(a==b);

        AccountSystem c = new AccountSystem();
        assertFalse(a==c);
     }
} 
