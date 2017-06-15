package test.main; 

import main.AccountSystem;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before; 
import org.junit.After; 

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
        assertEquals("密碼錯誤", a.signIn("jimmy666","123"));
        assertEquals("帳號錯誤", a.signIn("123456789","123"));
    }
} 
