/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import bus.MovieBUS;
import dto.MovieDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
public class WindowQLPhim extends JFrame{
    
    private JLabel label1;
    private JLabel lbMaPhim;
    private JLabel lbTenPhim;
    private JLabel lbThoiLuong;
    private JLabel lbTheLoai;
    private JLabel lbMoTaNgan;
    private JLabel lbHangSanXuat;
    private JPanel paneltotal;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel subpanel;
    private JTable table;
    private JLabel image;
    private JButton buttonThem;
    private JButton buttonCapNhat;
    private JButton buttonXoa;
    private JButton buttonThoat;
    private JScrollPane scroll;
    private JTextField txtMaPhim;
    private JTextField txtTenPhim;
    private JTextField txtThoiLuong;
    private JTextField txtTheLoai;
    private JTextField txtMoTaNgan;
    private JTextField txtHangSanXuat;
    
    MovieBUS movieBUS = new MovieBUS();
    
    public WindowQLPhim(){
        setSize(1288,720);
        setTitle("Quản lý bán vé xem phim");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents();
    }

    public JTable getTable() {
        return table;
    }
    
    private void initComponents() {
        paneltotal = new JPanel();
        
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(242,242,242));
        panel1.setPreferredSize(new Dimension(1600, 40));
        label1 = new JLabel(" QUẢN LÝ THÔNG TIN PHIM ");
        label1.setForeground(Color.blue);
        label1.setFont(new Font("Serif", Font.BOLD, 30));
        label1.setBounds(550, 0, 700, 40);
        panel1.add(label1);
        
        panel2 = new JPanel();
        panel2.setLayout((LayoutManager) new BorderLayout());
        
        ImageIcon icon = new ImageIcon("qlphim.jpg"); 
        image = new JLabel();  
        image.setIcon(icon);
        
        subpanel = new JPanel();
        subpanel.setBackground(new Color(204, 230, 255));
        subpanel.setLayout(null);

        lbMaPhim = new JLabel(" Mã phim ");
        lbMaPhim.setFont(new Font("Serif", Font.BOLD, 20));
        lbMaPhim.setBounds(30,5,150,60);
        
        txtMaPhim = new JTextField(100);
        txtMaPhim.setBounds(150,20,150,30);
        
        lbTenPhim = new JLabel(" Tên phim ");
        lbTenPhim.setFont(new Font("Serif", Font.BOLD, 20));
        lbTenPhim.setBounds(30,95,150,60);
        
        txtTenPhim = new JTextField(100);
        txtTenPhim.setBounds(150,110,150,30);  
        
        lbThoiLuong = new JLabel(" Thời lượng ");
        lbThoiLuong.setFont(new Font("Serif", Font.BOLD, 20));
        lbThoiLuong.setBounds(30,180,150,60);
        
        txtThoiLuong = new JTextField(100);
        txtThoiLuong.setBounds(150,195,150,30);  
        
        lbTheLoai = new JLabel(" Thể loại ");
        lbTheLoai.setFont(new Font("Serif", Font.BOLD, 20));
        lbTheLoai.setBounds(30,265,150,60);
        
        txtTheLoai = new JTextField(100);
        txtTheLoai.setBounds(150,280,150,30);  
        
        lbMoTaNgan = new JLabel(" Mô tả ngắn ");
        lbMoTaNgan.setFont(new Font("Serif", Font.BOLD, 20));
        lbMoTaNgan.setBounds(330,55,150,60);
        
        txtMoTaNgan = new JTextField(100);
        txtMoTaNgan.setBounds(470,60,160,50);  
        
        lbHangSanXuat = new JLabel(" Hãng sản xuất ");
        lbHangSanXuat.setFont(new Font("Serif", Font.BOLD, 20));
        lbHangSanXuat.setBounds(330,150,200,60);
        
        txtHangSanXuat = new JTextField(100);
        txtHangSanXuat.setBounds(470,160,160,50);  
        
        buttonThem = new JButton(" Thêm ");
        buttonThem.setFont(new Font("", Font.BOLD,15));
        buttonThem.setBounds(20,355,120,40);
        buttonThem.setBackground(new Color(51, 153, 255));
        buttonThem.setForeground(Color.white);     
        buttonThem.addActionListener((ActionEvent e) -> {
            buttonThemActionPerformed();
        });
        
        buttonCapNhat = new JButton(" Cập nhật ");
        buttonCapNhat.setFont(new Font("", Font.BOLD, 15));
        buttonCapNhat.setBounds(170,355,120,40);
        buttonCapNhat.setBackground(new Color(51, 153, 255));
        buttonCapNhat.setForeground(Color.white);     
        buttonCapNhat.addActionListener((ActionEvent e) ->{
            buttonCapNhatActionPerformed();
        });
        
        buttonXoa = new JButton(" Xóa ");
        buttonXoa.setFont(new Font("", Font.BOLD, 15));
        buttonXoa.setBounds(320,355,120,40);
        buttonXoa.setBackground(new Color(51, 153, 255));
        buttonXoa.setForeground(Color.white);     
        buttonXoa.addActionListener((ActionEvent e) ->{
            buttonXoaActionPerformed();
        });
        
        buttonThoat = new JButton(" Thoát ");
        buttonThoat.setFont(new Font("", Font.BOLD, 15));
        buttonThoat.setBounds(470,355,120,40);
        buttonThoat.setBackground(new Color(51, 153, 255));
        buttonThoat.setForeground(Color.red);     
        buttonThoat.addActionListener((ActionEvent evt) -> {
            this.setVisible(false);
        });
        
        subpanel.add(lbMaPhim);
        subpanel.add(txtMaPhim);
        subpanel.add(lbTenPhim);
        subpanel.add(txtTenPhim);
        subpanel.add(lbThoiLuong);
        subpanel.add(txtThoiLuong);
        subpanel.add(lbTheLoai);
        subpanel.add(txtTheLoai);
        subpanel.add(lbMoTaNgan);
        subpanel.add(txtMoTaNgan);
        subpanel.add(lbHangSanXuat);
        subpanel.add(txtHangSanXuat);
        subpanel.add(buttonThem);
        subpanel.add(buttonCapNhat);
        subpanel.add(buttonXoa);
        subpanel.add(buttonThoat);   
        
        panel2.add(subpanel,BorderLayout.CENTER);
        panel2.add(image,BorderLayout.EAST);
        
        table = new JTable();
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setColumnIdentifiers(new Object[]{"Id", "Mã phim", "Tên phim", "Thể loại","Thời lượng(phút)","Hãng sản xuất","Mô tả ngắn"});
        scroll = new JScrollPane(table);
        scroll.setBounds(1, 0, 1280, 230);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                tableMouseClicked(e);
            }
        });
        
        JPanel panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setPreferredSize(new Dimension(1600, 200));
        panel3.add(scroll);
        
        paneltotal.setLayout((LayoutManager) new BorderLayout());
        paneltotal.add(panel1,BorderLayout.NORTH);
        paneltotal.add(panel2,BorderLayout.CENTER);
        paneltotal.add(panel3,BorderLayout.SOUTH);       
        add(paneltotal); 
    }
    
    public void tableMouseClicked(MouseEvent e){
        int indexRow = table.getSelectedRow();
        txtMaPhim.setText((String)table.getValueAt(indexRow, 1));
        txtTenPhim.setText((String)table.getValueAt(indexRow, 2));
        txtTheLoai.setText((String)table.getValueAt(indexRow, 3));
        txtThoiLuong.setText(table.getValueAt(indexRow, 4).toString());
        txtHangSanXuat.setText((String)table.getValueAt(indexRow, 5));
        txtMoTaNgan.setText((String)table.getValueAt(indexRow, 6));
    }
    
    public void reset(){
        txtHangSanXuat.setText("");
        txtMaPhim.setText("");
        txtTenPhim.setText("");
        txtMoTaNgan.setText("");
        txtTheLoai.setText("");
        txtThoiLuong.setText("");
    }
    
    public void setValue(MovieDTO movie){
        movie.setMovieCode(txtMaPhim.getText());
        movie.setMovieName(txtTenPhim.getText());
        movie.setTime(Integer.parseInt(txtThoiLuong.getText()));
        movie.setCategory(txtTheLoai.getText());
        movie.setShortDescription(txtMoTaNgan.getText());
        movie.setProducer(txtHangSanXuat.getText());
    }
    
     public void buttonThemActionPerformed(){
        if(!txtThoiLuong.getText().matches("^\\d+$")){
            JOptionPane.showMessageDialog(rootPane, "Thời lượng không đúng");
        }else{
        MovieDTO movie = new MovieDTO();
        setValue(movie);
        movie = movieBUS.save(movie);
        if(movie != null){
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.addRow(new Object[]{movie.getId(), movie.getMovieCode(),movie.getMovieName(),
            movie.getCategory(), movie.getTime(), movie.getProducer(), movie.getShortDescription()});
            reset();
        }else{
            JOptionPane.showMessageDialog(rootPane, "Không thành công");
        }
        }
     }
     
    public void buttonCapNhatActionPerformed(){
        int click = JOptionPane.showConfirmDialog(paneltotal, "Bạn có muốn cập nhật?");
        if(click == JOptionPane.YES_OPTION){
            MovieDTO movie = new MovieDTO();
            movie.setId((long) table.getValueAt(table.getSelectedRow(), 0));
            setValue(movie);
            movie = movieBUS.update(movie);
            if(movie != null){
                int indexRow = table.getSelectedRow();
                table.setValueAt(movie.getMovieCode(), indexRow, 1);
                table.setValueAt(movie.getMovieName(), indexRow, 2);
                table.setValueAt(movie.getCategory(), indexRow, 3);
                table.setValueAt(movie.getTime(), indexRow, 4);
                table.setValueAt(movie.getProducer(), indexRow, 5);
                table.setValueAt(movie.getShortDescription(), indexRow, 6);
                reset();
            }
        }else if(click == JOptionPane.NO_OPTION){
            reset();
        }
        
    }
     
    public void buttonXoaActionPerformed(){
        int click = JOptionPane.showConfirmDialog(paneltotal, "Bạn có muốn xóa?",null,JOptionPane.YES_NO_OPTION);
        if(click == JOptionPane.YES_OPTION){
            MovieDTO movie = new MovieDTO();
            movie.setId((long)table.getValueAt(table.getSelectedRow(), 0));
            movieBUS.delete(movie);
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            tableModel.removeRow(table.getSelectedRow());
            reset();
        }else {
            
        }
    }
     
      public static void main(String[] args) {
        WindowQLPhim windowQLPhim = new WindowQLPhim();
        windowQLPhim.setVisible(true);
    }
}
