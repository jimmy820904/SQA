package test.main; 

import main.AccountSystem;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before; 
import org.junit.After; 

public class AccountSystemTest
{
    /*
    @Before
    public void before() throws Exception
    {
    }

    @After
    public void after() throws Exception
    {
    }
    */
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


} 
