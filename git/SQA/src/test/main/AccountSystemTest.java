package test.main; 

import main.AccountSystem;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before; 
import org.junit.After; 

public class AccountSystemTest
{
    @Test
    public void checkAccountTest() throws Exception
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
    public void checkPasswordTest() throws Exception
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
} 
