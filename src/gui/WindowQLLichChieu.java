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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class WindowQLLichChieu extends JFrame{
    
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel subpanel;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel image1;
    private JTable table;
    private JScrollPane scroll;
    private JPanel paneltotal;
    private JButton btThem;
    private JButton btCapNhat;
    private JButton btXoa;
    private JButton btThoat;
    private JTextField txtMaLichChieu;
    private JTextField txtNgayChieu;
    private JComboBox cbPhim;
    private JComboBox cbCaChieu;
    private JComboBox cbPhongChieu;
   
    MovieBUS movieBUS = new MovieBUS();
    RoomBUS roomBUS = new RoomBUS();
    MovieTimesBUS movieTimesBUS = new MovieTimesBUS();
    ShowtimesBUS showtimesBUS = new ShowtimesBUS();
    
    public WindowQLLichChieu(){
        setSize(1600,800);
        setTitle("Quản lí bán vé xem phim");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        initComponents();     
    }

    public JTable getTable() {
        return table;
    }

    public JComboBox getCbPhim() {
        return cbPhim;
    }

    public JComboBox getCbCaChieu() {
        return cbCaChieu;
    }

    public JComboBox getCbPhongChieu() {
        return cbPhongChieu;
    }
    
    private void initComponents() {
        paneltotal = new JPanel();
                
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(0, 89, 179));
        panel1.setPreferredSize(new Dimension(1600,80));
        label1 = new JLabel(" QUẢN LÍ LỊCH CHIẾU ");
        label1.setForeground(new Color(255, 255, 255));
        label1.setFont(new Font("Serif", Font.BOLD, 40));
        label1.setBounds(580, 0, 500, 83);
        panel1.add(label1);
        
        panel2 = new JPanel();
        panel2.setBackground(Color.white);
        panel2.setLayout((LayoutManager) new BorderLayout());
        
        ImageIcon icon = new ImageIcon("qllichchieu.jpg"); 
        image1 = new JLabel();  
        image1.setIcon(icon);
        
        subpanel = new JPanel();
        subpanel.setBackground(new Color(204, 230, 255));
        subpanel.setLayout(null);

        label2 = new JLabel(" Mã lịch chiếu ");
        label2.setBounds(10, 10, 170, 50);
        label2.setFont(new Font("Serif", Font.BOLD, 20));               
        
        txtMaLichChieu = new JTextField(30);
        txtMaLichChieu.setBounds(200, 20, 180, 30);
        
        label3 = new JLabel(" Ngày chiếu ");
        label3.setBounds(10, 100, 150, 50);
        label3.setFont(new Font("Serif", Font.BOLD, 20));
                
        txtNgayChieu = new JTextField(30);
        txtNgayChieu.setBounds(200, 110, 180, 30);
        
        label4 = new JLabel(" Phim ");
        label4.setBounds(450, 10, 150, 50);
        label4.setFont(new Font("Serif", Font.BOLD, 20));
        
        cbPhim = new JComboBox();
        cbPhim.setBounds(620, 20, 180, 30);
                
        label5 = new JLabel(" Ca chiếu ");
        label5.setBounds(450, 190, 160, 50);
        label5.setFont(new Font("Serif", Font.BOLD, 20));
        
        cbCaChieu = new JComboBox();
        cbCaChieu.setBounds(620, 200, 180, 30);
        
        label6 = new JLabel(" Phòng chiếu ");
        label6.setBounds(450, 100, 160, 50);
        label6.setFont(new Font("Serif", Font.BOLD, 20));
        
        cbPhongChieu = new JComboBox();
        cbPhongChieu.setBounds(620, 110, 180, 30);
        
        btThem = new JButton(" Thêm ");
        btThem.setFont(new Font("", Font.BOLD,15));
        btThem.setBounds(60,400,150,40);
        btThem.setBackground(new Color(51, 153, 255));
        btThem.setForeground(Color.white);   
        btThem.addActionListener((ActionEvent e) ->{
            btThemActionPerformed();
        });
        
        btCapNhat = new JButton(" Cập nhật ");
        btCapNhat.setFont(new Font("", Font.BOLD, 15));
        btCapNhat.setBounds(250,400,150,40);
        btCapNhat.setBackground(new Color(51, 153, 255));
        btCapNhat.setForeground(Color.white);   
        btCapNhat.addActionListener((ActionEvent e)->{
            btCapNhatActionPerformed();
        });
        
        btXoa = new JButton(" Xóa ");
        btXoa.setFont(new Font("", Font.BOLD, 15));
        btXoa.setBounds(440,400,150,40);
        btXoa.setBackground(new Color(51, 153, 255));
        btXoa.setForeground(Color.white);   
        btXoa.addActionListener((ActionEvent e) ->{
            btXoaActionPerformed();
        });
        
        btThoat = new JButton(" Thoát ");
        btThoat.setFont(new Font("", Font.BOLD, 15));
        btThoat.setBounds(630,400,150,40);
        btThoat.setBackground(new Color(51, 153, 255));
        btThoat.setForeground(Color.red);   
        btThoat.addActionListener((ActionEvent e) -> {
            this.setVisible(false);
        });
        
        subpanel.add(label2);      
        subpanel.add(txtMaLichChieu);
        subpanel.add(label3);
        subpanel.add(txtNgayChieu);
        subpanel.add(label4);
        subpanel.add(cbPhim);                      
        subpanel.add(label5);
        subpanel.add(cbCaChieu);
        subpanel.add(label6);
        subpanel.add(cbPhongChieu);
        subpanel.add(btThem);
        subpanel.add(btCapNhat);
        subpanel.add(btXoa);
        subpanel.add(btThoat);
        
        panel2.add(subpanel,BorderLayout.CENTER);
        panel2.add(image1,BorderLayout.EAST);
                      
        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setPreferredSize(new Dimension(1600,200));
        
        table = new JTable();
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setColumnIdentifiers(new Object[]{"ID", " Mã lịch chiếu ", "Ngày chiếu", "Ca chiếu" ,"Phòng chiếu","Phim"});
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableMouseClicked();
            }
        });
        scroll = new JScrollPane(table);
        scroll.setBounds(0, 0, 1595, 200);       
        panel3.add(scroll);

        paneltotal.setLayout((LayoutManager) new BorderLayout());
        paneltotal.add(panel1,BorderLayout.NORTH);
        paneltotal.add(panel2,BorderLayout.CENTER);
        paneltotal.add(panel3,BorderLayout.SOUTH);       
        add(paneltotal); 
    }
    
    public void tableMouseClicked(){
        int indexRow = table.getSelectedRow();
        txtMaLichChieu.setText((String)table.getValueAt(indexRow, 1));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date ngayChieu = (Date)table.getValueAt(indexRow, 2);
        txtNgayChieu.setText(sdf.format(ngayChieu));
        cbPhongChieu.setSelectedItem(table.getValueAt(indexRow, 4));
        cbCaChieu.setSelectedItem(table.getValueAt(indexRow, 3));
        cbPhim.setSelectedItem(table.getValueAt(indexRow, 5));
    }
    
    public void reset(){
        txtMaLichChieu.setText("");
        txtNgayChieu.setText("");
        cbCaChieu.setSelectedIndex(0);
        cbPhongChieu.setSelectedIndex(0);
        cbPhim.setSelectedIndex(0);
    }
    
    public void setValue(ShowtimesDTO showtimes){
        try {
            showtimes.setShowTimesCode(txtMaLichChieu.getText());
            String projectionDate = txtNgayChieu.getText();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date date = simpleDateFormat.parse(projectionDate);
            Date date1 = new Date(date.getTime());
            showtimes.setProjectionDate(date1);
            String movieCode = cbPhim.getSelectedItem().toString();
            String roomCode = cbPhongChieu.getSelectedItem().toString();
            String movieTimesCode = cbCaChieu.getSelectedItem().toString();
            showtimes.setMovieId(movieBUS.findIdMovie(movieCode));
            showtimes.setRoomId(roomBUS.findIdByCode(roomCode));
            showtimes.setMovieTimesId(movieTimesBUS.findIdByCode(movieTimesCode));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void btThemActionPerformed(){
        ShowtimesDTO showtimes = new ShowtimesDTO();
        setValue(showtimes);
        showtimes = showtimesBUS.save(showtimes);
        if(showtimes != null){
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.addRow(new Object[]{showtimes.getId(),showtimes.getShowTimesCode(), showtimes.getProjectionDate(),
            movieTimesBUS.findById(showtimes.getMovieTimesId()).getMovieTimesCode(),
            roomBUS.findById(showtimes.getRoomId()).getRoomCode(),
            movieBUS.findById(showtimes.getMovieId()).getMovieCode()});
            txtMaLichChieu.setText("");
            txtNgayChieu.setText("");
        }
    }
    
    public void btCapNhatActionPerformed(){
        int click = JOptionPane.showConfirmDialog(paneltotal, "Bạn có muốn cập nhật");
        if(click == JOptionPane.YES_OPTION){
            ShowtimesDTO showtimes = new ShowtimesDTO();
            setValue(showtimes);
            showtimes.setId((long) table.getValueAt(table.getSelectedRow(), 0));
            showtimes = showtimesBUS.update(showtimes);
            if(showtimes != null){
                int indexRow = table.getSelectedRow();
                table.setValueAt(showtimes.getShowTimesCode(), indexRow, 1);
                table.setValueAt(showtimes.getProjectionDate(), indexRow, 2);
                table.setValueAt(movieTimesBUS.findById(showtimes.getMovieTimesId()).getMovieTimesCode(), indexRow, 3);
                table.setValueAt(roomBUS.findById(showtimes.getRoomId()).getRoomCode(), indexRow, 4);
                table.setValueAt(movieBUS.findById(showtimes.getMovieId()).getMovieCode(), indexRow, 5);
            }
        }else if(click == JOptionPane.NO_OPTION){
            reset();
        }
    }
    
    public void btXoaActionPerformed(){
        int click = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa?",null, JOptionPane.YES_NO_OPTION);
        if(click == JOptionPane.YES_OPTION){
            ShowtimesDTO showtimes = new ShowtimesDTO();
            showtimes.setId((long) table.getValueAt(table.getSelectedRow(), 0));
            showtimesBUS.delete(showtimes);
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.removeRow(table.getSelectedRow());
            reset();
        }else{
            
        }
    }
    
    public static void main(String[] args) {
        WindowQLLichChieu windowQLLichChieu = new WindowQLLichChieu();
        windowQLLichChieu.setVisible(true);
    }
    
}
