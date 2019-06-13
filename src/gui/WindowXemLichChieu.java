/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import bus.MovieBUS;
import bus.MovieTimesBUS;
import bus.RoomBUS;
import bus.ShowtimesBUS;
import dto.ShowtimesDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class WindowXemLichChieu extends JPanel{
    
    private JPanel paneltotal;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel subpanel;
    private JLabel labeltitle;
    private JLabel image1;
    private JLabel lbChonPhim;
    private JLabel lbChonPhimCanXemLich;
    private JComboBox combobox;
    private JButton btXem;
    
    ArrayList<Long> movieIds = new ArrayList<>();
    ShowtimesBUS showtimesBUS = new ShowtimesBUS();
    MovieTimesBUS movieTimesBUS = new MovieTimesBUS();
    RoomBUS roomBUS = new RoomBUS();
    MovieBUS movieBUS = new MovieBUS();
    
    public WindowXemLichChieu(){
        setSize(1283, 720);
        initComponents();
    }

    public JComboBox getCombobox() {
        return combobox;
    }
    
     private void initComponents() {
        paneltotal = new JPanel();
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(242,242,242));
        panel1.setPreferredSize(new Dimension(1600, 50));
        labeltitle = new JLabel(" XEM LỊCH CHIẾU ");
        labeltitle.setForeground(Color.blue);
        labeltitle.setFont(new Font("Serif", Font.BOLD, 30));
        labeltitle.setBounds(550, 0, 700, 40);
        panel1.add(labeltitle);

        panel2 = new JPanel();
        panel2.setBackground(Color.white);
        panel2.setLayout((LayoutManager) new BorderLayout());

        ImageIcon icon = new ImageIcon("xemlichchieu.jpg");
        image1 = new JLabel();
        image1.setIcon(icon);

        lbChonPhimCanXemLich = new JLabel("Chọn phim cần xem lịch");
        lbChonPhimCanXemLich.setBounds(200, 50, 350, 40);
        lbChonPhimCanXemLich.setFont(new Font("Serif", Font.BOLD, 30));
        
        lbChonPhim = new JLabel("Chọn phim");
        lbChonPhim.setBounds(180, 150, 150, 40);
        lbChonPhim.setFont(new Font("Serif", Font.ITALIC, 22));
        
        combobox = new JComboBox();
        combobox.setBounds(190, 200, 350, 40);
        combobox.setFont(new Font("Serif", Font.BOLD, 22));
        
        btXem = new JButton(" Xem ");
        btXem.setBounds(270, 330, 150, 60);
        btXem.setBackground(new Color(51, 153, 255));
        btXem.setForeground(Color.white);   
        btXem.setFont(new Font("Serif", Font.BOLD, 22));
        btXem.addActionListener((ActionEvent e) ->{
            btXemActionPerformed();
        });

        subpanel = new JPanel();
        subpanel.setLayout(null);
        subpanel.add(lbChonPhimCanXemLich);
        subpanel.add(lbChonPhim);
        subpanel.add(combobox);
        subpanel.add(btXem);

        panel2.add(subpanel, BorderLayout.CENTER);
        panel2.add(image1, BorderLayout.EAST);

        paneltotal.setLayout((LayoutManager) new BorderLayout());
        paneltotal.add(panel1, BorderLayout.NORTH);
        paneltotal.add(panel2, BorderLayout.CENTER);
        add(paneltotal);
    }
     
    public void btXemActionPerformed(){
        WindowTTLichChieu windowTTLichChieu = new WindowTTLichChieu();
        long movieId = movieIds.get(combobox.getSelectedIndex());
        DefaultTableModel tableModel = (DefaultTableModel) windowTTLichChieu.getTable().getModel();
        for(ShowtimesDTO showtimesDTO : showtimesBUS.findByMovieId(movieId)){
            tableModel.addRow(new Object[]{showtimesDTO.getShowTimesCode(), showtimesDTO.getProjectionDate(),
            movieTimesBUS.findById(showtimesDTO.getMovieTimesId()).getMovieTimesCode(),
            movieTimesBUS.findById(showtimesDTO.getMovieTimesId()).getProjectionTime(),
            roomBUS.findById(showtimesDTO.getRoomId()).getRoomCode(),
            movieBUS.findById(showtimesDTO.getMovieId()).getMovieName()});
        }
        windowTTLichChieu.setVisible(true);
    }
     
}
