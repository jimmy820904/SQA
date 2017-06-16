package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by acer on 2017/6/16.
 */
public class ChangePasswordPage extends JFrame
{
    AccountSystem system = AccountSystem.getInstance();
    private JLabel oldPasswordLabel = new JLabel("舊密碼：");
    private JLabel newPasswordLabel = new JLabel("新密碼：");
    private JLabel newPasswordLabel2 = new JLabel("重複輸入新密碼：");

    public JPasswordField oldPasswordField = new JPasswordField(16);
    public JPasswordField newPasswordField = new JPasswordField(16);
    public JPasswordField newPasswordField2 = new JPasswordField(16);

    public JButton enterButton = new JButton("修改密碼");
    public String state;

    public ChangePasswordPage()
    {
        super("修改密碼");
        setSize(400,300);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setButtonListener();

        oldPasswordLabel.setFont(new Font("新細明體", Font.BOLD, 24));
        newPasswordLabel.setFont(new Font("新細明體", Font.BOLD, 24));
        newPasswordLabel2.setFont(new Font("新細明體", Font.BOLD, 24));
        enterButton.setFont(new Font("新細明體", Font.BOLD, 24));

        JPanel oldPasswordPanel = new JPanel();
        oldPasswordPanel.setLayout(new FlowLayout());
        oldPasswordPanel.add(oldPasswordLabel);
        oldPasswordPanel.add(oldPasswordField);

        JPanel newPasswordPanel = new JPanel();
        newPasswordPanel.add(newPasswordLabel);
        newPasswordPanel.add(newPasswordField);

        newPasswordPanel.add(newPasswordLabel2);
        newPasswordPanel.add(newPasswordField2);

        this.add(oldPasswordPanel, BorderLayout.NORTH);
        this.add(newPasswordPanel, BorderLayout.CENTER);
        this.add(enterButton, BorderLayout.SOUTH);
    }

    private void setButtonListener()
    {
        enterButton.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String oldPassword = new String( oldPasswordField.getPassword() );
                String newPassword = new String( newPasswordField.getPassword() );
                String newPassword2 = new String( newPasswordField2.getPassword() );

                if( oldPassword.equals("") || newPassword.equals("") || newPassword2.equals("") )
                {
                    JOptionPane.showMessageDialog(null, "資料未填寫完成", "錯誤訊息", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if( !oldPassword.equals(system.database.get(system.currentUser)) )
                {
                    JOptionPane.showMessageDialog(null, "舊密碼輸入錯誤", "錯誤訊息", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if( !newPassword.equals(newPassword2) )
                {
                    JOptionPane.showMessageDialog(null, "兩次密碼輸入不同", "錯誤訊息", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(!(state = system.checkPassword(newPassword)).equals("correct"))
                {
                    JOptionPane.showMessageDialog(null, state, "錯誤訊息", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                state = system.changePassword(system.currentUser, oldPassword, newPassword);
                JOptionPane.showMessageDialog(null, state);
                setVisible(false);

            }
        } );
    }
}
