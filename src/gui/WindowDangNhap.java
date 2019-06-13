/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import bus.RoleBUS;
import bus.UserBUS;
import dto.UserDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ADMIN
 */
public class WindowDangNhap extends JPanel{
    
    private JLabel label1;
    private JLabel lbUserName;
    private JLabel lbPassword;
    private JTextField txtUserName;
    private JTextField txtPassword;
    private JButton btConnect;
    private JLabel lbThumb;
    private JPanel panel2;
    private JPanel panel1;
    private JPanel panelTotal;
    private FrameMain frameMain;
    
    public WindowDangNhap(FrameMain frameMain){
        setSize(1600, 800);
        this.frameMain = frameMain;
        initComponents();
    }
    
     @SuppressWarnings("Convert2Lambda")
    private void initComponents(){
        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setPreferredSize(new Dimension(500,800));
        panel2.setBackground(new Color(230, 243, 255));
        
        label1 = new JLabel("Đăng nhập");
        label1.setBounds(160, 50, 300, 50);
        label1.setFont(new Font("Serif", Font.HANGING_BASELINE, 40));
        panel2.add(label1);

        lbUserName = new JLabel("Tên đăng nhập" );
        lbUserName.setBounds(25, 130, 250, 30);
        lbUserName.setFont(new Font("Serif", Font.PLAIN, 20));
        panel2.add(lbUserName);
        
        lbPassword = new JLabel(" Mật khẩu ");
        lbPassword.setBounds(25, 220, 150, 30);
        lbPassword.setFont(new Font("Serif", Font.PLAIN, 20));
        panel2.add(lbPassword);

        txtUserName = new JTextField(30);
        txtUserName.setBounds(30, 170, 450, 40);
        txtUserName.setFont(new Font(null, Font.PLAIN, 16));
        panel2.add(txtUserName);

        txtPassword = new JPasswordField(30);
        txtPassword.setBounds(30, 260, 450, 40);
        txtPassword.setFont(new Font(null, Font.BOLD, 16));
        panel2.add(txtPassword);

        btConnect = new JButton("Đăng nhập");
        btConnect.setFont(new Font("Serif", Font.BOLD, 25));
        btConnect.setBackground(new Color(51, 153, 255));
        btConnect.setForeground(Color.white);      
        btConnect.setHorizontalAlignment(JButton.CENTER);
        btConnect.setBounds(170, 340, 150, 50);
        btConnect.addActionListener(new ActionListener() {
            @Override
            // xử lý sự kiện
            public void actionPerformed(ActionEvent evt) {
                btConnectActionPerformed();
            }
        });
        panel2.add(btConnect);
        
        ImageIcon icon = new ImageIcon("xxx.png"); 
        lbThumb = new JLabel();
        lbThumb.setIcon(icon);
        panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(1100,800));
        panel1.add(lbThumb);
                
        panelTotal = new JPanel((LayoutManager) new BorderLayout());       
        panelTotal.add(panel1,BorderLayout.CENTER);
        panelTotal.add(panel2,BorderLayout.EAST);
        add(panelTotal);
    }
    
    @SuppressWarnings("ConvertToStringSwitch")
    private void btConnectActionPerformed(){
        UserDTO userDTO = new UserDTO();
        UserBUS userBUS = new UserBUS();
        RoleBUS roleBUS = new RoleBUS();
        userDTO.setUserName(txtUserName.getText());
        userDTO.setPassword(txtPassword.getText());
        userDTO = userBUS.findByUserNameAndPassword(userDTO);
        if(userDTO != null){
            userDTO.setRoleDTO(roleBUS.findById(userDTO.getRoleId()));
            if(userDTO.getRoleDTO().getCode().equals("quan-ly")){
                this.setVisible(false);
                WindowForQuanLy windowForQuanLy = new WindowForQuanLy(frameMain);
                frameMain.add(windowForQuanLy);
            }else if(userDTO.getRoleDTO().getCode().equals("nhan-vien")){
                this.setVisible(false);
                WindowForNhanVien windowForNhanVien = new WindowForNhanVien(frameMain);
                windowForNhanVien.setUserId(userDTO.getId());
                frameMain.add(windowForNhanVien);
            }
        }else{
            JOptionPane.showMessageDialog(btConnect, "Không thể đăng nhập");
        }
    }
    
}
