/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class WindowThongKeDoanhThu extends JPanel{
    
    private JPanel paneltotal;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel subpanel;
    private JLabel labeltitle;
    private JLabel image1;
    private JLabel lbThang;
    private JLabel lbNam;
    private JLabel lbChonNgayCanThongKe;
    private JComboBox cbThang;
    private JComboBox cbNam;
    private JButton btXem;
    
    public WindowThongKeDoanhThu(){
        setSize(1283, 720);
        initComponents();
    }

    public JComboBox getCbThang() {
        return cbThang;
    }

    public JComboBox getCbNam() {
        return cbNam;
    }
    
   private void initComponents() {
        paneltotal = new JPanel();

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(242, 242, 242));
        panel1.setPreferredSize(new Dimension(1600, 45));
        labeltitle = new JLabel("Thống kê doanh thu");
        labeltitle.setForeground(Color.blue);
        labeltitle.setFont(new Font("Serif", Font.BOLD, 30));
        labeltitle.setBounds(570, 0, 700, 40);
        panel1.add(labeltitle);

        panel2 = new JPanel();
        panel2.setBackground(Color.white);
        panel2.setLayout((LayoutManager) new BorderLayout());

        ImageIcon icon = new ImageIcon("thongkedoanhthu.jpg");
        image1 = new JLabel();
        image1.setIcon(icon);

        lbChonNgayCanThongKe = new JLabel("Chọn tháng cần thống kê");
        lbChonNgayCanThongKe.setFont(new Font("Serif", Font.ITALIC, 25));
        lbChonNgayCanThongKe.setBounds(170, 50, 300, 40);

        lbThang = new JLabel("Tháng");
        lbThang.setFont(new Font("Serif", Font.BOLD, 30));
        lbThang.setBounds(170, 170, 120, 40);

        lbNam= new JLabel("Năm");
        lbNam.setFont(new Font("Serif", Font.BOLD, 30));
        lbNam.setBounds(170, 270, 120, 40);
        
        cbThang= new JComboBox();
        cbThang.setBounds(320, 170, 230, 40);
        
        cbNam = new JComboBox();
        cbNam.setBounds(320, 270, 230, 40);
        
        btXem = new JButton(" Xem ");
        btXem.setFont(new Font("Serif", Font.BOLD, 30));
        btXem.setBackground(new Color(77, 166, 255));
        btXem.setForeground(Color.white);
        btXem.setBounds(355, 400, 150, 60);
        btXem.addActionListener((ActionEvent e) ->{
            btXemActionPerformed();
        });
        
        subpanel = new JPanel();
        subpanel.setLayout(null);

        subpanel.add(lbChonNgayCanThongKe);
        subpanel.add(lbThang);
        subpanel.add(lbNam);
        subpanel.add(cbThang);
        subpanel.add(cbNam);
        subpanel.add(btXem);

        panel2.add(subpanel, BorderLayout.CENTER);
        panel2.add(image1, BorderLayout.EAST);

        paneltotal.setLayout((LayoutManager) new BorderLayout());
        paneltotal.add(panel1, BorderLayout.NORTH);
        paneltotal.add(panel2, BorderLayout.CENTER);
        add(paneltotal);
    }
   
   public void btXemActionPerformed(){
       WindowThongTinThongKe windowThongTinThongKe = new WindowThongTinThongKe();
       windowThongTinThongKe.setVisible(true);
   } 
}
