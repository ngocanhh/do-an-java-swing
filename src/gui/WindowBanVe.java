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
import bus.TicketBUS;
import bus.UserBUS;
import dto.ChairDTO;
import dto.MovieDTO;
import dto.MovieTimesDTO;
import dto.RoomDTO;
import dto.ShowtimesDTO;
import dto.TicketDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class WindowBanVe extends JPanel{
    
    private JPanel paneltotal;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JLabel labeltitle;
    private JLabel labelMaLichChieu;
    private JLabel labelMaGhe;
    private JLabel labelThongTinVe;
    private JLabel labelNgayChieu;
    private JLabel labelCaChieu;
    private JLabel labelGioChieu;
    private JLabel labelPhongChieu;
    private JLabel labelTenPhim;
    private JLabel image;
    private JLabel lbTenPhim;
    private JLabel lbNgayChieu;
    private JLabel lbGioChieu;
    private JLabel lbPhongChieu;
    private JLabel lbCaChieu;
    private JButton btInVe;
    private JComboBox cbMaLichChieu;
    private JComboBox cbMaGhe;
    private JLabel lbChonPhim;
    private JComboBox cbChonPhim;
    private long userId;
   
    ChairBUS chairBUS = new ChairBUS();
    TicketBUS ticketBUS = new TicketBUS();
    ShowtimesBUS showtimesBUS = new ShowtimesBUS();
    UserBUS userBUS = new UserBUS();
    MovieTimesBUS movieTimesBUS = new MovieTimesBUS();
    RoomBUS roomBUS = new RoomBUS();
    MovieBUS movieBUS = new MovieBUS();
    ChairTypeBUS chairTypeBUS = new ChairTypeBUS();
    ArrayList<Long> movieIds = new ArrayList<>();
    
     public WindowBanVe() {
        setSize(1283,720);         
        initComponents();
    }

    public JComboBox getCbMaLichChieu() {
        return cbMaLichChieu;
    }

    public JComboBox getCbMaGhe() {
        return cbMaGhe;
    }

    public JComboBox getCbChonPhim() {
        return cbChonPhim;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
    
    private void initComponents() {
        paneltotal = new JPanel();
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(242,242,242));
        panel1.setPreferredSize(new Dimension(1600,40));
        labeltitle = new JLabel(" Nhập thông tin vé ");
        labeltitle.setForeground(Color.blue);
        labeltitle.setFont(new Font("Serif", Font.BOLD, 30));
        labeltitle.setBounds(750, 0, 350, 40);
        panel1.add(labeltitle);
        
        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(new Color(204, 230, 255));
        panel2.setPreferredSize(new Dimension(600,200));
                        
        labelThongTinVe = new JLabel(" Thông tin vé ");
        labelThongTinVe.setBounds(290,0, 170, 50);
        labelThongTinVe.setFont(new Font("Serif", Font.ITALIC, 20));
        
        lbChonPhim = new JLabel(" Chọn phim ");
        lbChonPhim.setBounds(290, 100, 170, 50);
        lbChonPhim.setFont(new Font("Serif", Font.BOLD, 19));
        
        cbChonPhim= new JComboBox();
        cbChonPhim.setBounds(420, 110, 150, 30);
        cbChonPhim.addItemListener((ItemEvent e) ->{
            long movieId = movieIds.get(cbChonPhim.getSelectedIndex());
            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
            for(ShowtimesDTO showtimes : showtimesBUS.findByMovieId(movieId)){
                comboBoxModel.addElement(showtimes.getShowTimesCode());
            }
            cbMaLichChieu.setModel(comboBoxModel);
        });
        
        labelMaLichChieu = new JLabel(" Mã lịch chiếu ");
        labelMaLichChieu.setBounds(290, 200, 170, 50);
        labelMaLichChieu.setFont(new Font("Serif", Font.BOLD, 19));              
        
        cbMaLichChieu = new JComboBox();
        cbMaLichChieu.setBounds(420, 210, 150, 30);
        cbMaLichChieu.addItemListener((ItemEvent e) -> {
            cbMaLichChieuItemStateChange(e);
        });
                
        labelMaGhe = new JLabel(" Mã ghế ");
        labelMaGhe.setBounds(290, 320, 170, 50);
        labelMaGhe.setFont(new Font("Serif", Font.BOLD, 20));
        
        cbMaGhe = new JComboBox();
        cbMaGhe.setBounds(420, 330, 150, 30);
        
        btInVe = new JButton("Tạo vé");
        btInVe.setFont(new Font("", Font.BOLD,15));
        btInVe.setBounds(390,440,110,40);
        btInVe.setBackground(new Color(51, 153, 255));
        btInVe.setForeground(Color.white);   
        btInVe.addActionListener((ActionEvent e) -> {
            btInVeActionPerformed();
        });
        
        panel2.add(labelThongTinVe);
        panel2.add(labelMaLichChieu);
        panel2.add(labelMaGhe);
        panel2.add(cbMaLichChieu);
        panel2.add(cbMaGhe);
        panel2.add(btInVe);
        panel2.add(lbChonPhim);
        panel2.add(cbChonPhim);
        
        panel5 = new JPanel();
        ImageIcon icon = new ImageIcon("banve.jpg"); 
        image = new JLabel();  
        image.setIcon(icon);
        panel5.add(image);
        
        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBackground(new Color(204, 230, 255));
        panel3.setPreferredSize(new Dimension(700,200));
        
        labelThongTinVe = new JLabel(" Thông tin lịch chiếu ");
        labelThongTinVe.setBounds(10,0, 250, 50);
        labelThongTinVe.setFont(new Font("Serif", Font.ITALIC, 20));       
        
        labelTenPhim = new JLabel(" Tên phim ");
        labelTenPhim.setBounds(10,50, 200, 50);
        labelTenPhim.setFont(new Font("Serif", Font.BOLD, 20));
        
        lbTenPhim = new JLabel();
        lbTenPhim.setBounds(140,50, 200, 50);
        lbTenPhim.setFont(new Font("Serif", Font.BOLD, 20));
        
        labelNgayChieu = new JLabel(" Ngày chiếu ");
        labelNgayChieu.setBounds(10,120, 200, 50);
        labelNgayChieu.setFont(new Font("Serif", Font.BOLD, 20));
        
        lbNgayChieu = new JLabel();
        lbNgayChieu.setBounds(140,120, 200, 50);
        lbNgayChieu.setFont(new Font("Serif", Font.BOLD, 20));
        
        labelGioChieu = new JLabel(" Giờ chiếu ");
        labelGioChieu.setBounds(10,200, 200, 50);
        labelGioChieu.setFont(new Font("Serif", Font.BOLD, 20));
        
        lbGioChieu = new JLabel();
        lbGioChieu.setBounds(140,200, 200, 50);
        lbGioChieu.setFont(new Font("Serif", Font.BOLD, 20));
        
        labelPhongChieu = new JLabel(" Phòng chiếu ");
        labelPhongChieu.setBounds(10,280, 200, 50);
        labelPhongChieu.setFont(new Font("Serif", Font.BOLD, 20));
        
        lbPhongChieu = new JLabel();
        lbPhongChieu.setBounds(140,280, 200, 50);
        lbPhongChieu.setFont(new Font("Serif", Font.BOLD, 20));
        
        labelCaChieu = new JLabel(" Ca chiếu ");
        labelCaChieu.setBounds(10,370, 200, 50);
        labelCaChieu.setFont(new Font("Serif", Font.BOLD, 20));
        
        lbCaChieu = new JLabel();
        lbCaChieu.setBounds(140,370, 200, 50);
        lbCaChieu.setFont(new Font("Serif", Font.BOLD, 20));
        
        panel3.add(labelThongTinVe);
        panel3.add(labelNgayChieu);
        panel3.add(labelCaChieu);
        panel3.add(labelGioChieu);
        panel3.add(labelPhongChieu);
        panel3.add(labelTenPhim);
        panel3.add(lbTenPhim);
        panel3.add(lbNgayChieu);
        panel3.add(lbGioChieu);
        panel3.add(lbPhongChieu);
        panel3.add(lbCaChieu);
        
        panel4 = new JPanel();
        panel4.setLayout(null);
        panel4.setPreferredSize(new Dimension(1600,200));

        paneltotal.setLayout((LayoutManager) new BorderLayout());
        paneltotal.add(panel1,BorderLayout.NORTH);
        paneltotal.add(panel2,BorderLayout.WEST);
        paneltotal.add(panel3,BorderLayout.EAST);
        paneltotal.add(panel4,BorderLayout.SOUTH);  
        paneltotal.add(panel5,BorderLayout.CENTER);
        add(paneltotal);
    }
    
    public void cbMaLichChieuItemStateChange(ItemEvent evt){
        ShowtimesDTO showTimes = new ShowtimesDTO();    
        if(evt.getStateChange() == ItemEvent.SELECTED){
            showTimes.setShowTimesCode((String)cbMaLichChieu.getSelectedItem());
            showTimes = showtimesBUS.findByCode(showTimes);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            lbNgayChieu.setText(sdf.format(showTimes.getProjectionDate()));
            MovieTimesDTO movieTimesDTO = movieTimesBUS.findById(showTimes.getMovieTimesId());
            lbCaChieu.setText(movieTimesDTO.getMovieTimesCode());
            SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
            lbGioChieu.setText(sdf1.format(movieTimesDTO.getProjectionTime()));
            RoomDTO room = roomBUS.findById(showTimes.getRoomId());
            lbPhongChieu.setText(room.getRoomCode());
            MovieDTO movie = movieBUS.findById(showTimes.getMovieId());
            lbTenPhim.setText(movie.getMovieName());
        }
    }
    
    public void btInVeActionPerformed(){
        TicketDTO ticketDTO = new TicketDTO();
        ShowtimesDTO showtimesDTO = new ShowtimesDTO();
        ChairDTO chairDTO = new ChairDTO();
        chairDTO.setChairCode(cbMaGhe.getSelectedItem().toString());
        chairDTO = chairBUS.findByCode(chairDTO);
        ticketDTO.setChairId(chairDTO.getId());
        showtimesDTO.setShowTimesCode(cbMaLichChieu.getSelectedItem().toString());
        showtimesDTO = showtimesBUS.findByCode(showtimesDTO);
        ticketDTO.setShowtimesId(showtimesDTO.getId());
        ticketDTO.setDateOfSale(new Timestamp(System.currentTimeMillis()));
        ticketDTO.setUserId(userId);
        if(ticketBUS.findByChairIdAndShowtimesId(ticketDTO) != null){
            JOptionPane.showMessageDialog(paneltotal, "Ghế đã được đặt");
        }else{
            ticketDTO = ticketBUS.save(ticketDTO);
            if(ticketDTO != null){
            int click = JOptionPane.showConfirmDialog(null, "Bạn có muốn in vé?",null, JOptionPane.YES_NO_OPTION);
            if(click == JOptionPane.YES_OPTION){
                TicketGUI ticketGUI = new TicketGUI();
                MovieDTO movieDTO = movieBUS.findById(showtimesDTO.getMovieId());
                ticketGUI.getLbTenPhim().setText(movieDTO.getMovieName());
                SimpleDateFormat ngayChieu = new SimpleDateFormat("dd/MM/yyyy");
                ticketGUI.getLbNgayChieu().setText(ngayChieu.format(showtimesDTO.getProjectionDate()));
                MovieTimesDTO movieTimesDTO = movieTimesBUS.findById(showtimesDTO.getMovieTimesId());
                SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
                ticketGUI.getLbGioChieu().setText(sdf1.format(movieTimesDTO.getProjectionTime()));
                ticketGUI.getLbGhe().setText(chairDTO.getChairCode());
                ticketGUI.getLbMaPhong().setText(roomBUS.findById(showtimesDTO.getRoomId()).getRoomCode());
                Long id = ticketDTO.getId();
                ticketGUI.getLbMaVe().setText(id.toString());
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss       dd/MM/yyyy");
                ticketGUI.getLbThoiGianInVe().setText(sdf.format(ticketDTO.getDateOfSale()));
                ticketGUI.getLbNhanVien().setText(userBUS.findById(ticketDTO.getUserId()).getFullName());
                long chairTypeId = chairDTO.getChairTypeId();
                ticketGUI.getLbGiaVe().setText(""+chairTypeBUS.findById(chairTypeId).getCostOfTicket()+"  VNĐ");
                ticketGUI.setVisible(true);
                }
            }
        }
    }
    
}
