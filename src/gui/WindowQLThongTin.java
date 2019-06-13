/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import bus.ChairBUS;
import bus.ChairTypeBUS;
import bus.MovieBUS;
import bus.MovieTimesBUS;
import bus.RoomBUS;
import bus.ShowtimesBUS;
import dto.ChairDTO;
import dto.ChairTypeDTO;
import dto.MovieDTO;
import dto.MovieTimesDTO;
import dto.RoomDTO;
import dto.ShowtimesDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
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
public class WindowQLThongTin extends JPanel{
    
    private JPanel paneltotal;
    private JButton btPhim;
    private JButton btLichChieu;
    private JButton btGhe;
    private JLabel labeltitle;
    private JPanel panel1;
    private JPanel panelContent;
    private JLabel image;
    private ImageIcon icon;
    
    MovieBUS movieBUS = new MovieBUS();
    MovieTimesBUS movieTimesBUS = new MovieTimesBUS();
    RoomBUS roomBUS = new RoomBUS();
    ShowtimesBUS showtimesBUS = new ShowtimesBUS();
    ChairTypeBUS chairTypeBUS = new ChairTypeBUS();
    ChairBUS chairBUS = new ChairBUS();
    
    public WindowQLThongTin(){
        setSize(1283, 720);
        initComponents();
    }
    
     private void initComponents() {
        paneltotal = new JPanel();

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(242, 242, 242));
        panel1.setPreferredSize(new Dimension(1600, 40));
        labeltitle = new JLabel(" Quản lí thông tin ");
        labeltitle.setForeground(Color.blue);
        labeltitle.setFont(new Font("Serif", Font.BOLD, 30));
        labeltitle.setBounds(600, -5, 700, 40);
        panel1.add(labeltitle);

        panelContent = new JPanel();
        panelContent.setBackground(new Color(204, 230, 255,50));
        panelContent.setLayout(null);

        btPhim = new JButton(" Phim ");
        btPhim.setFont(new Font("", Font.BOLD, 30));
        btPhim.setForeground(Color.blue);
        btPhim.setBounds(270,250,250,100);
        btPhim.addActionListener((ActionEvent e) ->{
            btPhimActionPerformed();
        });

        btLichChieu = new JButton(" Lịch chiếu ");
        btLichChieu.setFont(new Font("", Font.BOLD, 30));
        btLichChieu.setForeground(Color.blue);
        btLichChieu.setBounds(620,250,250,100);
        btLichChieu.addActionListener((ActionEvent e) ->{
            btLichChieuActionPerformed();
        });

        btGhe = new JButton(" Ghế ");
        btGhe.setFont(new Font("", Font.BOLD, 30));
        btGhe.setForeground(Color.blue);
        btGhe.setBounds(970,250,250,100);
        btGhe.addActionListener((ActionEvent e) ->{
            btGheActionPerformed();
        });

        panelContent.add(btPhim);
        panelContent.add(btLichChieu);
        panelContent.add(btGhe);

        image = new JLabel();        
        icon = new ImageIcon("qlthongtin.jpg"); 
        image.setLayout((LayoutManager) new BorderLayout());    
        image.setIcon(icon);

        image.setLayout((LayoutManager) new BorderLayout());
        image.add(panel1, BorderLayout.NORTH);
        image.add(panelContent, BorderLayout.CENTER);

        paneltotal.add(image);
        add(paneltotal);
    }
     
    public void btPhimActionPerformed(){
        WindowQLPhim windowQLPhim = new WindowQLPhim();
        DefaultTableModel model = (DefaultTableModel) windowQLPhim.getTable().getModel();
        ArrayList<MovieDTO> movies = movieBUS.findAll();
        for (MovieDTO movie : movies) {
            model.addRow(new Object[]{movie.getId(), movie.getMovieCode(),
            movie.getMovieName(),movie.getCategory(), movie.getTime(),
            movie.getProducer(), movie.getShortDescription()});
        }
            windowQLPhim.setVisible(true);
    }
     
    public void btLichChieuActionPerformed(){
        WindowQLLichChieu windowQLLichChieu = new WindowQLLichChieu();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for(MovieTimesDTO m : movieTimesBUS.findAll()){
            model.addElement(m.getMovieTimesCode());
        }
        windowQLLichChieu.getCbCaChieu().setModel(model);
        DefaultComboBoxModel model1 = new DefaultComboBoxModel();
        for(MovieDTO movie : movieBUS.findAll()){
            model1.addElement(movie.getMovieCode());
        }
        windowQLLichChieu.getCbPhim().setModel(model1);
        DefaultComboBoxModel model2 = new DefaultComboBoxModel();
        for(RoomDTO room : roomBUS.findAll()){
            model2.addElement(room.getRoomCode());
        }
        windowQLLichChieu.getCbPhongChieu().setModel(model2);
        DefaultTableModel tableModel = (DefaultTableModel) windowQLLichChieu.getTable().getModel();
        ArrayList<ShowtimesDTO> showtimes = showtimesBUS.findAll();
        for(ShowtimesDTO s : showtimes){
            RoomDTO room = roomBUS.findById(s.getRoomId());
            MovieDTO movie = movieBUS.findById(s.getMovieId());
            MovieTimesDTO movieTimesDTO = movieTimesBUS.findById(s.getMovieTimesId());
            tableModel.addRow(new Object[]{s.getId(), s.getShowTimesCode(), s.getProjectionDate(),
                 movieTimesDTO.getMovieTimesCode(), room.getRoomCode(), movie.getMovieCode()});

        }
        windowQLLichChieu.getTable().setModel(tableModel);
        windowQLLichChieu.setVisible(true);
    }
    
    public void btGheActionPerformed(){
        WindowQLGhe windowQLGhe = new WindowQLGhe();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for(ChairTypeDTO p : chairTypeBUS.findAll()){
            model.addElement(p.getChairTypeCode());
        }
        windowQLGhe.getCbLoaiGhe().setModel(model);
        DefaultTableModel tableModel = (DefaultTableModel) windowQLGhe.getTable().getModel();
        for(ChairDTO chair : chairBUS.findAll()){
            tableModel.addRow(new Object[]{chair.getId(),chair.getChairCode(),
                chair.getStatus(),chairTypeBUS.findById(chair.getChairTypeId()).getChairTypeCode()});
        }
        windowQLGhe.setVisible(true);
    }
    
}
