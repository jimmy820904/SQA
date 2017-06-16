package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by acer on 2017/6/16.
 */
public class ForgetPasswordPage extends JFrame
{
    AccountSystem system = AccountSystem.getInstance();

    private JTextField accountField = new JTextField(25);

    private JLabel accountLabel = new JLabel("帳號：");

    private JButton enterButton = new JButton("確認");

    String state;
    public ForgetPasswordPage()
    {
        super("忘記密碼");

        this.setButtonListener();

        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        accountLabel.setFont(new Font("新細明體", Font.BOLD, 24));
        enterButton.setFont(new Font("新細明體", Font.BOLD, 24));

        JPanel accountPanel = new JPanel();
        accountPanel.setLayout(new FlowLayout());
        accountPanel.add(accountLabel);
        accountPanel.add(accountField);

        this.add(accountPanel, BorderLayout.CENTER);
        this.add(enterButton, BorderLayout.SOUTH);
    }

    private void setButtonListener()
    {
        enterButton.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                String account = accountField.getText();

                if( account.equals("") )
                {
                    JOptionPane.showMessageDialog(null, "請輸入帳號", "錯誤訊息", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if( (state = system.forgetPassword(account)).equals("此帳號不存在") )
                {
                    JOptionPane.showMessageDialog(null, state, "錯誤訊息", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, state);
                    setVisible(false);
                }

            }
        } );
    }
}
