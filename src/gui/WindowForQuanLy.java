/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import bus.TicketBUS;
import bus.UserBUS;
import dto.TicketDTO;
import dto.UserDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class WindowForQuanLy extends JPanel{
    
    private JPanel paneltotal;
    private JButton btQLNhanVien;
    private JButton btThongKe;
    private JLabel image ;
    private ImageIcon icon;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JButton btDangXuat;
    private FrameMain frameMain;
    
    WindowQLNhanVien windowQLNhanVien = new WindowQLNhanVien();
    WindowThongKeDoanhThu windowThongKeDoanhThu = new WindowThongKeDoanhThu();
    TicketBUS ticketBUS = new TicketBUS();
    
    public WindowForQuanLy(FrameMain frameMain){
        setSize(1600, 800);
        initComponents();
        this.frameMain = frameMain;
    }
    
    @SuppressWarnings("Convert2Lambda")
    private void initComponents()
    {
        paneltotal = new JPanel();
        // panel chuyen muc
        panel1 = new JPanel();
        panel1.setBackground(new Color(0, 89, 179,180));
        panel1.setLayout(null);    
        panel1.setPreferredSize(new Dimension(430,800));
   
        panel3 = new JPanel();
        panel3.setPreferredSize(new Dimension(200,200));
        panel3.setLayout(null);
        panel3.setVisible(false);
        
        btQLNhanVien = new JButton(" Quản lý nhân viên ");
        btQLNhanVien.setFont(new Font("Serif", Font.BOLD, 22));
        btQLNhanVien.setBounds(103, 165, 290, 50);
        btQLNhanVien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btQuanLyNhanVienActionPerformed();
            }
        });
        
        btThongKe = new JButton("Thống kê doanh thu");
        btThongKe.setFont(new Font("Serif", Font.BOLD, 22));
        btThongKe.setBounds(103, 350, 290, 50);
        btThongKe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               btThongKeDoanhThuActionPerformed();
            }
        });
        
        panel1.add(btQLNhanVien);
        panel1.add(btThongKe);        
        
        image = new JLabel();        
        icon = new ImageIcon("mainNV.jpg"); 
        image.setLayout((LayoutManager) new BorderLayout());    
        image.setIcon(icon);
    
        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(new Color(0, 89, 179));
        panel2.setPreferredSize(new Dimension(1600,80));
        JLabel label2 = new JLabel(" QUẢN LÝ BÁN VÉ XEM PHIM ");
        label2.setForeground(new Color(255, 255, 255));
        label2.setFont(new Font("Serif", Font.BOLD, 40));
        label2.setBounds(600, 0, 600, 83);
        btDangXuat = new JButton("Đăng Xuất");
        btDangXuat.setForeground(Color.red);   
        btDangXuat.setFont(new Font("Serif", Font.BOLD, 24));
        btDangXuat.setBounds(1530,25,140,32);
        btDangXuat.addActionListener((ActionEvent e) ->{
            btDangXuatActionPerformed();
        });
        panel2.add(btDangXuat);
        panel2.add(label2);
        
        image.add(panel1,BorderLayout.WEST);
        image.add(panel2,BorderLayout.NORTH);
        image.add(panel3, BorderLayout.CENTER);
        
        paneltotal.add(image); 
        add(paneltotal);
    }
    
     public void btQuanLyNhanVienActionPerformed(){
        UserBUS userBUS = new UserBUS();
        ArrayList<UserDTO> users = userBUS.findAll();
        DefaultTableModel tableModel = (DefaultTableModel) windowQLNhanVien.getTable1().getModel();
        for(UserDTO user : users){
            tableModel.addRow(new Object[]{user.getId(), user.getUserCode(), user.getFullName(), 
                user.getDateOfBirth(), user.getSex(), user.getAddress(), user.getPhoneNumber()});
        }
        windowThongKeDoanhThu.setVisible(false);
        windowQLNhanVien.setVisible(true);
        panel3.add(windowQLNhanVien);
        panel3.setVisible(true);
    }
     
     public void btDangXuatActionPerformed(){
        this.setVisible(false);
        WindowDangNhap windowDangNhap = new WindowDangNhap(frameMain);
        windowDangNhap.setVisible(true);
        frameMain.add(windowDangNhap);
     }
    
    public void btThongKeDoanhThuActionPerformed(){
        windowQLNhanVien.setVisible(false);
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        for(int i = 1; i < 13; i++){
            comboBoxModel.addElement("                                "+i);
        }
        windowThongKeDoanhThu.getCbThang().setModel(comboBoxModel);
        DefaultComboBoxModel comboBoxModel1 = new DefaultComboBoxModel();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        for(TicketDTO ticket : ticketBUS.findAll()){
            comboBoxModel1.addElement("                            "
                    +simpleDateFormat.format(ticket.getDateOfSale()));
        }
        windowThongKeDoanhThu.getCbNam().setModel(comboBoxModel1);
        windowThongKeDoanhThu.setVisible(true);
        panel3.add(windowThongKeDoanhThu);
        panel3.setVisible(true);
    }
    
}
