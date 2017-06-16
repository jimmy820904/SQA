package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by acer on 2017/6/16.
 */
public class LoginPage extends JFrame
{
    AccountSystem system = AccountSystem.getInstance();
    SignUpPage signUpPage = new SignUpPage();
    ForgetPasswordPage forgetPasswordPage = new ForgetPasswordPage();

    private JTextField accountField = new JTextField(20);
    private JPasswordField passwordField = new JPasswordField(20);

    private JLabel accountLabel = new JLabel("帳號：");
    private JLabel passwordLabel = new JLabel("密碼：");

    private JButton signInButton = new JButton("登入");
    private JButton signUpButton = new JButton("註冊");
    private JButton forgetButton = new JButton("忘記密碼");
    String state;
    public LoginPage()
    {
        super("登入頁面");

        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setButtonListener();
        //this.setLayout(new BorderLayout());

        accountLabel.setFont(new Font("新細明體", Font.BOLD, 24));
        passwordLabel.setFont(new Font("新細明體", Font.BOLD, 24));
        signInButton.setFont(new Font("新細明體", Font.BOLD, 20));
        signUpButton.setFont(new Font("新細明體", Font.BOLD, 20));
        forgetButton.setFont(new Font("新細明體", Font.BOLD, 20));
        JPanel accountPanel = new JPanel();
        accountPanel.setLayout(new FlowLayout());
        accountPanel.add(accountLabel);
        accountPanel.add(accountField);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new FlowLayout());
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(signInButton);
        buttonPanel.add(signUpButton);
        buttonPanel.add(forgetButton);


        this.add(accountPanel, BorderLayout.NORTH);
        this.add(passwordPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void setButtonListener()
    {
        signInButton.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String account = accountField.getText();
                String password = new String( passwordField.getPassword() );

                if( (state = system.signIn(account, password)).equals("登入成功") )
                {
                    accountField.setText("");
                    passwordField.setText("");
                    JOptionPane.showMessageDialog(null, account + "登入成功！");
                    UserPage userPage = new UserPage();
                    userPage.setVisible(true);
                }
                else
                {
                    accountField.setText("");
                    passwordField.setText("");
                    JOptionPane.showMessageDialog(null, state, "錯誤訊息", JOptionPane.ERROR_MESSAGE);
                }
            }
        } );


        signUpButton.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                signUpPage.setVisible(true);
            }
        } );

        forgetButton.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // System.out.println("忘記密碼");
                forgetPasswordPage.setVisible(true);
            }
        } );

    }
}
