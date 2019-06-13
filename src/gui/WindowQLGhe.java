/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import bus.ChairBUS;
import bus.ChairTypeBUS;
import dto.ChairDTO;
import dto.ChairTypeDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class WindowQLGhe extends JFrame{
    
    private JPanel paneltotal;
    private JPanel panel1;
    private JPanel panel2;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel image1;
    private JPanel subpanel;
    private JTable table;
    private JScrollPane scroll;
    private JButton btThem;
    private JButton btCapNhat;
    private JButton btXoa;
    private JButton btThoat;
    private JTextField txtMaGhe;
    private JComboBox cbLoaiGhe;
    private JRadioButton rbSuDungDuoc;
    private JRadioButton rbKhongSuDungDuoc;
    private ButtonGroup buttonGroup;
    
    ChairTypeBUS chairTypeBUS = new ChairTypeBUS();
    ChairBUS chairBUS = new ChairBUS();
    
    public WindowQLGhe(){
        setTitle(" QUẢN LÍ BÁN VÉ XEM PHIM ");
        setSize(1600,800);      
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    public JTable getTable() {
        return table;
    }

    public JComboBox getCbLoaiGhe() {
        return cbLoaiGhe;
    }
    
    private void initComponents() {
        paneltotal = new JPanel();
        
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(0, 89, 179));
        panel1.setPreferredSize(new Dimension(1600,80));
        label1 = new JLabel(" Quản lí thông tin ghế ");
        label1.setForeground(new Color(255, 255, 255));
        label1.setFont(new Font("Serif", Font.BOLD, 40));
        label1.setBounds(560, 0, 550, 83);
        panel1.add(label1);
        
        panel2 = new JPanel();
        panel2.setBackground(Color.white);
        panel2.setLayout((LayoutManager) new BorderLayout());
        
        label2 = new JLabel(" Mã ghế ");
        label2.setBounds(10, 10, 170, 50);
        label2.setFont(new Font("Serif", Font.BOLD, 20));               
        
        txtMaGhe = new JTextField(30);
        txtMaGhe.setBounds(200, 20, 180, 30);
        
        label3 = new JLabel(" Loại ghế ");
        label3.setBounds(10, 100, 170, 50);
        label3.setFont(new Font("Serif", Font.BOLD, 20));
        
        cbLoaiGhe = new JComboBox();
        cbLoaiGhe.setBounds(200, 110, 180, 30);
        
        label4 = new JLabel(" Tình trạng ");
        label4.setBounds(10, 190, 170, 50);
        label4.setFont(new Font("Serif", Font.BOLD, 20));
        
        rbSuDungDuoc = new JRadioButton(" Sử dụng được ");
        rbSuDungDuoc.setBounds(180, 202, 170, 30);
        rbSuDungDuoc.setBackground(new Color(204, 230, 255));
        rbSuDungDuoc.setFont(new Font("Serif", Font.BOLD, 15));
        rbSuDungDuoc.setSelected(true);
        
        rbKhongSuDungDuoc = new JRadioButton(" Không sử dụng được ");
        rbKhongSuDungDuoc.setBounds(370, 202, 250, 30);
        rbKhongSuDungDuoc.setBackground(new Color(204, 230, 255));
        rbKhongSuDungDuoc.setFont(new Font("Serif", Font.BOLD, 15));
        
        buttonGroup = new ButtonGroup();
        buttonGroup.add(rbSuDungDuoc);
        buttonGroup.add(rbKhongSuDungDuoc);
        
        btThem = new JButton(" Thêm ");
        btThem.setFont(new Font("", Font.BOLD,15));
        btThem.setBounds(15,400,150,40);
        btThem.setBackground(new Color(51, 153, 255));
        btThem.setForeground(Color.white);   
        btThem.addActionListener((ActionEvent e) ->{
            btThemActionPerformed();
        });
        
        btCapNhat = new JButton(" Cập nhật ");
        btCapNhat.setFont(new Font("", Font.BOLD, 15));
        btCapNhat.setBounds(185,400,150,40);
        btCapNhat.setBackground(new Color(51, 153, 255));
        btCapNhat.setForeground(Color.white);   
        btCapNhat.addActionListener((ActionEvent e) ->{
            btCapNhatActionPerformed();
        });
        
        btXoa = new JButton(" Xóa ");
        btXoa.setFont(new Font("", Font.BOLD, 15));
        btXoa.setBounds(355,400,150,40);
        btXoa.setBackground(new Color(51, 153, 255));
        btXoa.setForeground(Color.white);   
        btXoa.addActionListener((ActionEvent e) ->{
            btXoaActionPerformed();
        });
        
        btThoat = new JButton(" Thoát ");
        btThoat.setFont(new Font("", Font.BOLD, 15));
        btThoat.setBounds(525,400,150,40);
        btThoat.setBackground(new Color(51, 153, 255));
        btThoat.setForeground(Color.red);   
        btThoat.addActionListener((ActionEvent e) ->{
            this.setVisible(false);
        });
        
        ImageIcon icon = new ImageIcon("qlghe.jpg"); 
        image1 = new JLabel();  
        image1.setIcon(icon);
        
        subpanel = new JPanel();
        subpanel.setBackground(new Color(204, 230, 255));
        subpanel.setLayout(null);
        
        subpanel.add(label2);
        subpanel.add(txtMaGhe);
        subpanel.add(label3);
        subpanel.add(cbLoaiGhe);
        subpanel.add(label4);
        subpanel.add(rbSuDungDuoc);
        subpanel.add(rbKhongSuDungDuoc);
        subpanel.add(btThem);
        subpanel.add(btCapNhat);
        subpanel.add(btXoa);
        subpanel.add(btThoat);
        
        panel2.add(subpanel,BorderLayout.CENTER);
        panel2.add(image1,BorderLayout.EAST);
        
        JPanel panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setPreferredSize(new Dimension(1600,200));
        
        table = new JTable();
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setColumnIdentifiers(new Object[]{"ID", " Mã ghế ", " Tình trạng ", " Loại ghế "});
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
    
     public void setValue(ChairDTO chair){
        chair.setChairCode(txtMaGhe.getText());
        String chairTypeCode = cbLoaiGhe.getSelectedItem().toString();
        chair.setChairTypeId(chairTypeBUS.findIdByCode(chairTypeCode));
        if(rbSuDungDuoc.isSelected()){
            chair.setStatus("Sử dụng được");
        }else if(rbKhongSuDungDuoc.isSelected()){
            chair.setStatus("Không sử dụng được");
        }
    }
    
    public void tableMouseClicked(){
        int indexRow = table.getSelectedRow();
        txtMaGhe.setText((String)table.getValueAt(indexRow, 1));
        String tinhTrang = (String)table.getValueAt(indexRow, 2);
        if(tinhTrang.equals("Sử dụng được")){
            rbSuDungDuoc.setSelected(true);
        }else{
            rbKhongSuDungDuoc.setSelected(true);
        }
        cbLoaiGhe.setSelectedItem(table.getValueAt(indexRow, 3));
    }
    
    public void btThemActionPerformed(){
        ChairDTO chair = new ChairDTO();
        setValue(chair);
        chair = chairBUS.save(chair);
        if(chair != null){
            ChairTypeDTO chairType = chairTypeBUS.findById(chair.getChairTypeId());
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.addRow(new Object[]{chair.getId(),chair.getChairCode(),
            chair.getStatus(),chairType.getChairTypeCode()});
            reset();
        }else{
            JOptionPane.showMessageDialog(rootPane, "Không thành công");
        }
    }
    
    public void btCapNhatActionPerformed(){
        int click = JOptionPane.showConfirmDialog(paneltotal, "Bạn có muốn cập nhật?");
        if(click == JOptionPane.YES_OPTION){
            ChairDTO chair = new ChairDTO();
            chair.setId((long)table.getValueAt(table.getSelectedRow(), 0));
            setValue(chair);
            chair = chairBUS.update(chair);
            if(chair != null){
                int indexRow = table.getSelectedRow();
                table.setValueAt(chair.getChairCode(), indexRow, 1);
                table.setValueAt(chair.getStatus(), indexRow, 2);
                ChairTypeDTO chairType = chairTypeBUS.findById(chair.getChairTypeId());
                table.setValueAt(chairType.getChairTypeCode(), indexRow, 3);
                reset();
            }
        }else if(click == JOptionPane.NO_OPTION){
            reset();
        }
    }
    
    public void btXoaActionPerformed(){
        int click = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa",null,JOptionPane.YES_NO_OPTION);
        if(click == JOptionPane.YES_OPTION){
            long id = (long)table.getValueAt(table.getSelectedRow(), 0);
            chairBUS.delete(id);
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.removeRow(table.getSelectedRow());
            reset();
        }else{
            
        }
    }
    
    public void reset(){
        txtMaGhe.setText("");
        cbLoaiGhe.setSelectedIndex(0);
        rbSuDungDuoc.setSelected(true);
    }
    
    public static void main(String[] args) {
        WindowQLGhe windowQLGhe = new WindowQLGhe();
        windowQLGhe.setVisible(true);
    }
    
}
