/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import bus.UserBUS;
import dto.UserDTO;
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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
public class WindowQLNhanVien extends JPanel{
    
    private JPanel paneltotal;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel label1;
    private JLabel labelMaNV;
    private JLabel labelTenNV;
    private JLabel labelNgaySinh;
    private JLabel labelGioiTinh;
    private JLabel labelDiaChi;
    private JLabel labelSoDT;
    private JLabel image1;
    private JPanel subpanel;
    private JTable table;
    private JScrollPane scroll;
    private JButton buttonThem;
    private JButton buttonCapNhat;
    private JButton buttonXoa;
    private JTextField txtMaNV;
    private JTextField txtTenNV;
    private JTextField txtNgaySinh;
    private JTextField txtDiaChi;
    private JTextField txtSoDT;
    private JRadioButton rbNam;
    private JRadioButton rbNu;
    private ButtonGroup buttonGroup;
    
    UserBUS userBUS = new UserBUS();
    
    public WindowQLNhanVien(){
        setSize(1283,720);      
        initComponents();
    }
    
     public JTable getTable1() {
        return table;
    }
     
     private void initComponents() {
        paneltotal = new JPanel();

        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(242,242,242));
        panel1.setPreferredSize(new Dimension(1600, 40));
        label1 = new JLabel(" QUẢN LÝ THÔNG TIN NHÂN VIÊN ");
        label1.setForeground(Color.blue);
        label1.setFont(new Font("Serif", Font.BOLD, 30));
        label1.setBounds(550, 0, 700, 40);
        panel1.add(label1);

        panel2 = new JPanel();
        panel2.setBackground(Color.white);
        panel2.setLayout((LayoutManager) new BorderLayout());

        labelMaNV = new JLabel(" Mã nhân viên ");
        labelMaNV.setBounds(160, 30, 170, 50);
        labelMaNV.setFont(new Font("Serif", Font.BOLD, 20));

        txtMaNV = new JTextField(30);
        txtMaNV.setBounds(350, 40, 120, 30);

        labelTenNV = new JLabel(" Tên nhân viên ");
        labelTenNV.setBounds(160, 120, 170, 50);
        labelTenNV.setFont(new Font("Serif", Font.BOLD, 20));

        txtTenNV = new JTextField(30);
        txtTenNV.setBounds(350, 130, 120, 30);

        labelNgaySinh = new JLabel(" Ngày sinh ");
        labelNgaySinh.setBounds(160, 210, 170, 50);
        labelNgaySinh.setFont(new Font("Serif", Font.BOLD, 20));

        txtNgaySinh = new JTextField(30);
        txtNgaySinh.setBounds(350, 220, 120, 30);

        labelGioiTinh = new JLabel(" Giới tính  ");
        labelGioiTinh.setBounds(520, 30, 170, 50);
        labelGioiTinh.setFont(new Font("Serif", Font.BOLD, 20));

        rbNam = new JRadioButton(" Nam ");
        rbNam.setBounds(660, 40, 70, 30);
        rbNam.setBackground(new Color(204, 230, 255));
        rbNam.setFont(new Font("Serif", Font.BOLD, 15));
        rbNam.setSelected(true);

        rbNu = new JRadioButton(" Nữ ");
        rbNu.setBounds(760, 40, 70, 30);
        rbNu.setBackground(new Color(204, 230, 255));
        rbNu.setFont(new Font("Serif", Font.BOLD, 15));
        
        buttonGroup = new ButtonGroup();
        buttonGroup.add(rbNam);
        buttonGroup.add(rbNu);

        labelDiaChi = new JLabel("Địa chỉ");
        labelDiaChi.setBounds(520, 120, 170, 50);
        labelDiaChi.setFont(new Font("Serif", Font.BOLD, 20));

        txtDiaChi = new JTextField(30);
        txtDiaChi.setBounds(700, 130, 120, 30);

        labelSoDT = new JLabel(" Số điện thoại ");
        labelSoDT.setBounds(520, 210, 170, 50);
        labelSoDT.setFont(new Font("Serif", Font.BOLD, 20));

        txtSoDT = new JTextField(30);
        txtSoDT.setBounds(700, 220, 120, 30);

        buttonThem = new JButton(" Thêm ");
        buttonThem.setFont(new Font("", Font.BOLD, 15));
        buttonThem.setBounds(170, 460, 120, 40);
        buttonThem.setBackground(new Color(51, 153, 255));
        buttonThem.setForeground(Color.white);     
        buttonThem.addActionListener((ActionEvent e) -> {
            buttonThemActionPerformed();
        });

        buttonCapNhat = new JButton(" Cập nhật ");
        buttonCapNhat.setFont(new Font("", Font.BOLD, 15));
        buttonCapNhat.setBounds(310, 460, 120, 40);
        buttonCapNhat.setBackground(new Color(51, 153, 255));
        buttonCapNhat.setForeground(Color.white);   
        buttonCapNhat.addActionListener((ActionEvent e) ->{
            buttonCapNhatActionPerformed();
        });

        buttonXoa = new JButton(" Xóa ");
        buttonXoa.setFont(new Font("", Font.BOLD, 15));
        buttonXoa.setBounds(450, 460, 120, 40);
        buttonXoa.setBackground(new Color(51, 153, 255));
        buttonXoa.setForeground(Color.white);   
        buttonXoa.addActionListener((ActionEvent e) ->{
            buttonXoaActionPerformed();
        });

        ImageIcon icon = new ImageIcon("qlnhanvien.jpg");
        image1 = new JLabel();
        image1.setIcon(icon);

        subpanel = new JPanel();
        subpanel.setBackground(new Color(204, 230, 255));
        subpanel.setLayout(null);

        subpanel.add(labelMaNV);
        subpanel.add(txtMaNV);
        subpanel.add(labelTenNV);
        subpanel.add(txtTenNV);
        subpanel.add(labelNgaySinh);
        subpanel.add(txtNgaySinh);
        subpanel.add(labelGioiTinh);
        subpanel.add(rbNam);
        subpanel.add(rbNu);
        subpanel.add(labelDiaChi);
        subpanel.add(txtDiaChi);
        subpanel.add(labelSoDT);
        subpanel.add(txtSoDT);
        subpanel.add(buttonThem);
        subpanel.add(buttonCapNhat);
        subpanel.add(buttonXoa);

        panel2.add(subpanel, BorderLayout.CENTER);
        panel2.add(image1, BorderLayout.EAST);

        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setPreferredSize(new Dimension(1600, 200));

        table = new JTable();
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setColumnIdentifiers(new Object[]{"ID", "Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Giới tính", "Địa chỉ", "Số điện thoại"});
        scroll = new JScrollPane(table);
        scroll.setBounds(156, 0, 1280, 200);
        panel3.add(scroll);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt){
                table1MouseClicked(evt);
            }
        });
        
        paneltotal.setLayout((LayoutManager) new BorderLayout());
        paneltotal.add(panel1, BorderLayout.NORTH);
        paneltotal.add(panel2, BorderLayout.CENTER);
        paneltotal.add(panel3, BorderLayout.SOUTH);

        add(paneltotal);
    }
     
     public void setValue(UserDTO userDTO){
            userDTO.setUserCode(txtMaNV.getText());
            userDTO.setFullName(txtTenNV.getText());
            userDTO.setAddress(txtDiaChi.getText());
            userDTO.setPhoneNumber(txtSoDT.getText());
            if(rbNam.isSelected()){
                userDTO.setSex("Nam");
            }else if(rbNu.isSelected()){
                userDTO.setSex("Nữ");
            }
     }
     
     public void table1MouseClicked(MouseEvent evt){
            int indexRow = table.getSelectedRow();
            txtMaNV.setText((String)table.getValueAt(indexRow, 1));
            txtTenNV.setText((String)table.getValueAt(indexRow, 2));
            Date ngaySinh = (Date)table.getValueAt(indexRow, 3);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            txtNgaySinh.setText(sdf.format(ngaySinh));
            Object object = table.getModel().getValueAt(indexRow, 4);
            String gioiTinh = object.toString();
            if(gioiTinh.matches("^.*Nam.*$")){
                rbNam.setSelected(true);
            }else{
                rbNu.setSelected(true);
            }
            txtDiaChi.setText((String)table.getValueAt(indexRow, 5));
            txtSoDT.setText((String)table.getValueAt(indexRow, 6));
     }
     
    @SuppressWarnings("CallToPrintStackTrace")
     public void buttonThemActionPerformed(){
          try {
            UserDTO userDTO = new UserDTO();
            userDTO.setRoleId(2);
            setValue(userDTO);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date date = sdf.parse(txtNgaySinh.getText());
            java.sql.Date dateOfBirth = new java.sql.Date(date.getTime());
            userDTO.setDateOfBirth(dateOfBirth);
            userDTO.setUserName(txtMaNV.getText());
            userDTO.setPassword("123456");
            userDTO = userBUS.save(userDTO);
            if(userDTO != null){
                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                tableModel.addRow(new Object[]{userDTO.getId(), userDTO.getUserCode(), userDTO.getFullName(), 
                userDTO.getDateOfBirth(), userDTO.getSex(), userDTO.getAddress(), userDTO.getPhoneNumber()});
                reset();
            }else {
                JOptionPane.showMessageDialog(paneltotal, "Không thành công");
            }
        }catch(ParseException e){
            e.printStackTrace();
        }
     }
     
     public void reset(){
        txtDiaChi.setText("");
        txtMaNV.setText("");
        txtNgaySinh.setText("");
        txtSoDT.setText("");
        txtTenNV.setText("");
        rbNam.setSelected(true);
     }
     
    @SuppressWarnings("CallToPrintStackTrace")
     public void buttonCapNhatActionPerformed(){
          try {
            int click = JOptionPane.showConfirmDialog(paneltotal, "Bạn có muốn cập nhật?");
            if(click == JOptionPane.YES_OPTION){
                UserDTO userDTO = new UserDTO();
                userDTO.setId((long)table.getValueAt(table.getSelectedRow(), 0));
                setValue(userDTO);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date date = sdf.parse(txtNgaySinh.getText());
                java.sql.Date dateOfBirth = new java.sql.Date(date.getTime());
                userDTO.setDateOfBirth(dateOfBirth);
                userDTO = userBUS.update(userDTO);
                if(userDTO != null){
                    int indexRow = table.getSelectedRow();
                    table.setValueAt(userDTO.getUserCode(), indexRow, 1);
                    table.setValueAt(userDTO.getFullName(), indexRow, 2);
                    table.setValueAt(userDTO.getDateOfBirth(), indexRow, 3);
                    table.setValueAt(userDTO.getSex(), indexRow, 4);
                    table.setValueAt(userDTO.getAddress(), indexRow, 5);
                    table.setValueAt(userDTO.getPhoneNumber(), indexRow, 6);
                    reset();
                }
            }else if(click == JOptionPane.NO_OPTION){
                reset();
            }else{
                
            }
        }catch(ParseException e){
            e.printStackTrace ();
        }
     }
     
     public void buttonXoaActionPerformed(){
        int click = JOptionPane.showConfirmDialog(paneltotal, "Bạn có muốn xóa", null, JOptionPane.YES_NO_OPTION);
        if(click == JOptionPane.YES_OPTION){
            UserDTO user = new UserDTO();
            user.setId((long)table.getValueAt(table.getSelectedRow(), 0));
            userBUS.delete(user);
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            model.removeRow(table.getSelectedRow());
            reset();
        }else{
            
        }
     }
     
}
