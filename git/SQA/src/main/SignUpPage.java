package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by acer on 2017/6/16.
 */
public class SignUpPage extends JFrame
{
    AccountSystem system = AccountSystem.getInstance();

    private JLabel accountLabel = new JLabel("帳號：");
    private JLabel passwordLabel = new JLabel("密碼：");
    private JLabel passwordLabel2 = new JLabel("重複輸入密碼：");

    public JTextField accountField = new JTextField(16);
    public JPasswordField passwordField = new JPasswordField(16);
    public JPasswordField passwordField2 = new JPasswordField(16);
    public JButton signupButton = new JButton("註冊");

    String state;

    public SignUpPage()
    {
        super("註冊頁面");

        this.setSize(400, 250);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setButtonListener();

        accountLabel.setFont(new Font("新細明體", Font.BOLD, 24));
        passwordLabel.setFont(new Font("新細明體", Font.BOLD, 24));
        passwordLabel2.setFont(new Font("新細明體", Font.BOLD, 24));
        signupButton.setFont(new Font("新細明體", Font.BOLD, 24));

        JPanel accountPanel = new JPanel();
        accountPanel.setLayout(new FlowLayout());
        accountPanel.add(accountLabel);
        accountPanel.add(accountField);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new FlowLayout());
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        passwordPanel.add(passwordLabel2);
        passwordPanel.add(passwordField2);

        this.add(accountPanel, BorderLayout.NORTH);
        this.add(passwordPanel, BorderLayout.CENTER);
        this.add(signupButton, BorderLayout.SOUTH);
    }

    private void setButtonListener()
    {
        signupButton.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String account = accountField.getText();
                String password = new String( passwordField.getPassword() );
                String password2 = new String( passwordField2.getPassword() );

                if( account.equals("") || password.equals("") || password2.equals("") )
                {
                    JOptionPane.showMessageDialog(null, "資料未填寫完成", "錯誤訊息", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if( !password.equals(password2) )
                {
                    JOptionPane.showMessageDialog(null, "兩次密碼輸入不同", "錯誤訊息", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                state = system.signUp(account, password);

                if( state.equals("註冊成功") )
                {
                    JOptionPane.showMessageDialog(null, account + " 註冊成功");
                    setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, state, "錯誤訊息", JOptionPane.ERROR_MESSAGE);
                }

            }
        } );
    }
}
