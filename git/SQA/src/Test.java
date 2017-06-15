/**
 * Created by acer on 2017/6/15.
 */
public class Test
{
    public static void main(String[] args)
    {
        String s = "1Ba";

        for(int i = 0; i < s.length(); i++)
        {
            char temp = s.charAt(i);
            if( Character.isUpperCase(temp) )
                System.out.print("大寫");
            if( Character.isLowerCase(temp) )
                System.out.print("小寫");
            if( Character.isDigit(temp) )
                System.out.print("數字");
            System.out.println();
        }
    }
}
