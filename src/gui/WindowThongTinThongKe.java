/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class WindowThongTinThongKe extends JFrame{
    
    private JPanel paneltotal;
    private JLabel lbThongKe;
    private JLabel lbThang;
    private JLabel lbThang1;
    private JLabel lbNam;
    private JLabel lbNam1;
    private JLabel lbSLVeDaBan;
    private JLabel lbSLVeDaBan1;
    private JLabel lbTongTien;
    private JLabel lbTongTien1;
    private JLabel lbGachNgang;
    private JLabel lbTPHCM;
    private JLabel lbNhanVienLapBaoCao;
    private JLabel lbKyTen;
    
    public WindowThongTinThongKe(){
        setTitle("QUẢN LÝ BÁN VÉ XEM PHIM");
        setSize(750, 900);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }
    
     private void initComponents() {
        paneltotal = new JPanel();
        paneltotal.setLayout(null);
        
        lbThongKe = new JLabel("THỐNG KÊ DOANH THU THEO THÁNG");
        lbThongKe.setFont(new Font("Serif", Font.BOLD, 30));
        lbThongKe.setBounds(90, 80, 750, 30);
        
        lbThang = new JLabel("Tháng");
        lbThang.setFont(new Font("Serif", Font.TYPE1_FONT, 25));
        lbThang.setBounds(100, 200, 150, 30);
        
        lbThang1 = new JLabel("tháng");
        lbThang1.setFont(new Font("Serif", Font.ITALIC, 20));
        lbThang1.setBounds(240, 200, 150, 30);
        
        lbNam = new JLabel("Năm");
        lbNam.setFont(new Font("Serif", Font.TYPE1_FONT, 25));
        lbNam.setBounds(400, 200, 150, 30);
        
        lbNam1 = new JLabel("năm");
        lbNam1.setFont(new Font("Serif", Font.ITALIC, 20));
        lbNam1.setBounds(540, 200, 150, 30);
        
        lbSLVeDaBan = new JLabel("Số lượng vé đã bán");
        lbSLVeDaBan.setFont(new Font("Serif", Font.TYPE1_FONT, 25));
        lbSLVeDaBan.setBounds(100, 330, 400, 30);
        
        lbSLVeDaBan1 = new JLabel("số lượng");
        lbSLVeDaBan1.setFont(new Font("Serif", Font.ITALIC, 20));
        lbSLVeDaBan1.setBounds(400, 330, 400, 30);
        
        lbTongTien = new JLabel("Tổng tiền");
        lbTongTien.setFont(new Font("Serif", Font.TYPE1_FONT, 25));
        lbTongTien.setBounds(100, 460, 200, 30);
        
        lbTongTien1 = new JLabel("tổng tiền");
        lbTongTien1.setFont(new Font("Serif", Font.ITALIC, 20));
        lbTongTien1.setBounds(400, 460, 200, 30);
        
        lbGachNgang = new JLabel("-------------------------------------------------------------------------");
        lbGachNgang.setFont(new Font("Serif", Font.TYPE1_FONT, 25));
        lbGachNgang.setBounds(90, 570, 900, 30);
                
        lbTPHCM = new JLabel(" TPHCM, ngày...tháng...năm..");
        lbTPHCM.setFont(new Font("Serif", Font.ITALIC, 20));
        lbTPHCM.setBounds(400, 610, 900, 30);
        
        lbNhanVienLapBaoCao = new JLabel("Nhân viên lập báo cáo");
        lbNhanVienLapBaoCao.setFont(new Font("Serif", Font.ITALIC, 20));
        lbNhanVienLapBaoCao.setBounds(425, 640, 900, 30);
        
        lbKyTen = new JLabel("Ký tên");
        lbKyTen.setFont(new Font("Serif", Font.ITALIC, 20));
        lbKyTen.setBounds(485, 670, 900, 30);
        
        paneltotal.add(lbThongKe);
        paneltotal.add(lbThang);
        paneltotal.add(lbThang1);
        paneltotal.add(lbNam);
        paneltotal.add(lbNam1);
        paneltotal.add(lbSLVeDaBan);
        paneltotal.add(lbSLVeDaBan1);
        paneltotal.add(lbTongTien);
        paneltotal.add(lbTongTien1);
        paneltotal.add(lbGachNgang);
        paneltotal.add(lbTPHCM);
        paneltotal.add(lbNhanVienLapBaoCao);
        paneltotal.add(lbKyTen);
        
        add(paneltotal);
    }
     
     public static void main(String[] args) {
        WindowThongTinThongKe windowThongTinThongKe = new WindowThongTinThongKe();
        windowThongTinThongKe.setVisible(true);
    }
}
