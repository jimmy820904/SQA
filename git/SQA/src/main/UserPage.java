package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by acer on 2017/6/16.
 */
public class UserPage extends JFrame
{
    AccountSystem system = AccountSystem.getInstance();
    public JButton changePasswordButton = new JButton("修改密碼");
    public JButton logOutButton = new JButton("登出");
    public JLabel welcomeLabel;

    public UserPage()
    {
        super("使用者頁面");
        setSize(400,200);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setButtonListener();

        welcomeLabel = new JLabel("Welcome, " + system.currentUser);

        changePasswordButton.setFont(new Font("新細明體", Font.BOLD, 24));
        logOutButton.setFont(new Font("新細明體", Font.BOLD, 24));
        welcomeLabel.setFont(new Font("新細明體", Font.BOLD, 24));


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(changePasswordButton);
        buttonPanel.add(logOutButton);

        this.add(welcomeLabel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);
    }
    private void setButtonListener()
    {
        changePasswordButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                ChangePasswordPage changePasswordPage = new ChangePasswordPage();
                changePasswordPage.setVisible(true);
            }
        } );

        logOutButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(null, "Goodbye, " + system.currentUser );
                system.logOut();
                setVisible(false);
            }
        } );
    }
}
