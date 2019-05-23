/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author ADMIN
 */
public class DemoJFrame extends JFrame{
    
    private JButton btThem;
    private JButton btSua;
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public DemoJFrame(){
        this.setSize(1000, 800);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setTitle("Quản lý nhân viên");
        this.setLocationRelativeTo(null);// hiển thị frame chính giữa màn hình
        init();
    }
    
    public void init(){
        
        btThem = new JButton("Thêm");
        this.add(btThem);
        btSua = new JButton("Sửa");
        this.add(btSua);
        
    }
    
    public static void main(String[] args) {
        DemoJFrame demoJFrame = new DemoJFrame();
        demoJFrame.setVisible(true);
        demoJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
