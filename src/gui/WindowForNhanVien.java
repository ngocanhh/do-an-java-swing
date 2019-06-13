/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import bus.ChairBUS;
import bus.MovieBUS;
import bus.ShowtimesBUS;
import bus.TicketBUS;
import bus.UserBUS;
import dto.ChairDTO;
import dto.MovieDTO;
import dto.ShowtimesDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class WindowForNhanVien extends JPanel{
    private JPanel paneltotal;
    private JButton btQLThongTin;
    private JButton btXemLichChieu;
    private JButton btBanVe;
    private JLabel image ;
    private ImageIcon icon;
    private JPanel panel1;
    private JPanel panel3;
    private JPanel panel4;
    private JButton btDangXuat;
    private FrameMain frameMain;
    private long userId;
    
    ChairBUS chairBUS = new ChairBUS();
    ShowtimesBUS showtimesBUS = new ShowtimesBUS();
    TicketBUS ticketBUS = new TicketBUS();
    UserBUS userBUS = new UserBUS();
    WindowBanVe windowBanVe = new WindowBanVe();
    WindowQLThongTin windowQLThongTin = new WindowQLThongTin();
    WindowXemLichChieu windowXemLichChieu = new WindowXemLichChieu();
    MovieBUS movieBUS = new MovieBUS();
    
    public WindowForNhanVien(FrameMain frameMain){
        setSize(1600,800);
        initComponents();
        this.frameMain = frameMain;
    }
    
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
    
    @SuppressWarnings("Convert2Lambda")
    private void initComponents(){
        paneltotal = new JPanel();
        panel1 = new JPanel();
        panel1.setBackground(new Color(0, 89, 179,150));
        panel1.setLayout(null);    
        panel1.setPreferredSize(new Dimension(400,800));
        
        btQLThongTin = new JButton(" Quản lý thông tin ");
        btQLThongTin.setFont(new Font("Serif", Font.BOLD, 22));
        btQLThongTin.setBounds(100, 130, 295, 50);
        btQLThongTin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btQLThongTinActionPerformed();
            }
        });
        
        btXemLichChieu = new JButton(" Xem lịch chiếu ");
        btXemLichChieu.setFont(new Font("Serif", Font.BOLD, 22));
        btXemLichChieu.setBounds(103, 240, 290, 50);
        btXemLichChieu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btXemLichChieuActionPerformed();
            }
        });
        
        panel4 = new JPanel();
        panel4.setPreferredSize(new Dimension(200,200));
        panel4.setVisible(false);
        
        btBanVe = new JButton(" Bán vé ");
        btBanVe.setFont(new Font("Serif", Font.BOLD, 22));
        btBanVe.setBounds(103, 350, 290, 50);
        btBanVe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               btBanVeActionPerformed();
            }
        });
        
        panel1.add(btQLThongTin);
        panel1.add(btXemLichChieu);
        panel1.add(btBanVe);
        
        image = new JLabel();        
        image.setSize(1600,800);
        icon = new ImageIcon("mainNV.jpg"); 
        image.setLayout((LayoutManager) new BorderLayout());    
        image.setIcon(icon);
    
        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBackground(new Color(0, 89, 179));
        panel3.setPreferredSize(new Dimension(1600,80));
        JLabel label2 = new JLabel(" QUẢN LÝ BÁN VÉ XEM PHIM ");
        label2.setForeground(new Color(255, 255, 255));
        label2.setFont(new Font("Serif", Font.BOLD, 40));
        btDangXuat = new JButton("Đăng Xuất");
        btDangXuat.setForeground(Color.red);   
        btDangXuat.setFont(new Font("Serif", Font.BOLD, 24));
        btDangXuat.setBounds(1530,25,140,32);
        btDangXuat.addActionListener((ActionEvent e) ->{
            btDangXuatActionPerformed();
        });
        label2.setBounds(580, 0, 600, 83);
        panel3.add(label2);
        panel3.add(btDangXuat);
        
        image.add(panel1,BorderLayout.WEST);
        image.add(panel3,BorderLayout.NORTH);
        image.add(panel4,BorderLayout.CENTER);
        paneltotal.add(image); 
        add(paneltotal);
    }
    
    public void btBanVeActionPerformed(){
        DefaultComboBoxModel cbBoxModelPhim = new DefaultComboBoxModel();
        for(MovieDTO movie : movieBUS.findAll()){
            cbBoxModelPhim.addElement(movie.getMovieName());
            windowBanVe.movieIds.add(movie.getId());
        }
        windowBanVe.getCbChonPhim().setModel(cbBoxModelPhim);
        DefaultComboBoxModel cbBoxModelLichChieu = new DefaultComboBoxModel();
        for(ShowtimesDTO showtimes : showtimesBUS.findByMovieId(movieBUS.findAll().get(0).getId())){
            cbBoxModelLichChieu.addElement(showtimes.getShowTimesCode());
        }
        windowBanVe.getCbMaLichChieu().setModel(cbBoxModelLichChieu);
        DefaultComboBoxModel cbBoxModel = new DefaultComboBoxModel();
        for(ChairDTO chair : chairBUS.findAll()){
            cbBoxModel.addElement(chair.getChairCode());
        }
        windowBanVe.getCbMaGhe().setModel(cbBoxModel);
        windowBanVe.setUserId(userId);
        windowQLThongTin.setVisible(false);
        windowXemLichChieu.setVisible(false);
        panel4.add(windowBanVe);
        windowBanVe.setVisible(true);
        panel4.setVisible(true);
    }
    
    public void btQLThongTinActionPerformed(){
        windowBanVe.setVisible(false);
        windowXemLichChieu.setVisible(false);
        windowQLThongTin.setVisible(true);
        panel4.add(windowQLThongTin);
        panel4.setVisible(true);
    }
    
    public void btDangXuatActionPerformed(){
        this.setVisible(false);
        WindowDangNhap windowDangNhap = new WindowDangNhap(frameMain);
        windowDangNhap.setVisible(true);
        frameMain.add(windowDangNhap);
    }
    
    public void btXemLichChieuActionPerformed(){
        for(MovieDTO movie : movieBUS.findAll()){
            windowXemLichChieu.getCombobox().addItem(movie.getMovieName());
            windowXemLichChieu.movieIds.add(movie.getId());
        }
        windowBanVe.setVisible(false);
        windowQLThongTin.setVisible(false);
        windowXemLichChieu.setVisible(true);
        panel4.add(windowXemLichChieu);
        panel4.setVisible(true);
    }
    
}
