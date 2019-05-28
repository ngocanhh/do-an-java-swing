import bus.RoleBUS;
import bus.UserBUS;
import dto.UserDTO;
import gui.JFrameMainNv;
import gui.JFrameMainQl;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Personal Computer
 */
public class WindowDangNhap extends JFrame {

    private JLabel label1;
    private JLabel lbUserName;
    private JLabel lbPassword;
    private JTextField txtUserName;
    private JTextField txtPassword;
    private JButton btConnect;
    private JLabel lbThumb;
    private JPanel panel2;
    private JPanel panel1;
    private JPanel panelTotal;
    
    public WindowDangNhap() throws IOException{
        setTitle("Quản lý bán vé xem phim");
        setSize(1600, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }
    
    @SuppressWarnings("Convert2Lambda")
    private void initComponents() throws IOException {
        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setPreferredSize(new Dimension(500,800));
        panel2.setBackground(new Color(230, 243, 255));
        
        label1 = new JLabel(" Sign-in ");
        label1.setBounds(180, 50, 160, 50);
        label1.setFont(new Font("Serif", Font.HANGING_BASELINE, 40));
        panel2.add(label1);

        lbUserName = new JLabel(" Username ");
        lbUserName.setBounds(25, 130, 150, 30);
        lbUserName.setFont(new Font("Serif", Font.PLAIN, 20));
        panel2.add(lbUserName);
        
        lbPassword = new JLabel(" Password ");
        lbPassword.setBounds(25, 220, 150, 30);
        lbPassword.setFont(new Font("Serif", Font.PLAIN, 20));
        panel2.add(lbPassword);

        txtUserName = new JTextField(30);
        txtUserName.setBounds(30, 170, 450, 40);
        txtUserName.setFont(new Font(null, NORMAL, 16));
        panel2.add(txtUserName);

        txtPassword = new JPasswordField(30);
        txtPassword.setBounds(30, 260, 450, 40);
        txtPassword.setFont(new Font(null, NORMAL, 16));
        panel2.add(txtPassword);

        btConnect = new JButton("Connect");
        btConnect.setFont(new Font("Serif", Font.BOLD, 25));
        btConnect.setBackground(new Color(51, 153, 255));
        btConnect.setForeground(Color.white);      
        btConnect.setHorizontalAlignment(JButton.CENTER);
        btConnect.setBounds(170, 340, 150, 50);
        btConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btConnectActionPerformed();
            }
        });
        panel2.add(btConnect);
        
        ImageIcon icon = new ImageIcon("xxx.png"); 
        lbThumb = new JLabel();
        lbThumb.setIcon(icon);
        panel1 = new JPanel();
        panel1.add(lbThumb);
                
        panelTotal = new JPanel((LayoutManager) new BorderLayout());       
        panelTotal.add(panel1,BorderLayout.CENTER);
        panelTotal.add(panel2,BorderLayout.EAST);
        add(panelTotal);
    }

    @SuppressWarnings("ConvertToStringSwitch")
    private void btConnectActionPerformed(){
        UserDTO userDTO = new UserDTO();
        UserBUS userBUS = new UserBUS();
        RoleBUS roleBUS = new RoleBUS();
        userDTO.setUserName(txtUserName.getText());
        userDTO.setPassword(txtPassword.getText());
        userDTO = userBUS.findByUserNameAndPassword(userDTO);
        if(userDTO != null){
            userDTO.setRoleDTO(roleBUS.findById(userDTO.getRoleId()));
            if(userDTO.getRoleDTO().getCode().equals("quan-ly")){
                JFrameMainQl jFrameMainQl = new JFrameMainQl();
                jFrameMainQl.setVisible(true);
                this.setVisible(false);
            }else if(userDTO.getRoleDTO().getCode().equals("nhan-vien")){
                JFrameMainNv jFrameMainNv = new JFrameMainNv();
                Long userId = userDTO.getId();
                String userId1 = userId.toString();
                JTextField txtUserId = new JTextField();
                txtUserId.setText(userId1);
                jFrameMainNv.getTxtUserId().setText(userId1);
                jFrameMainNv.add(jFrameMainNv.getTxtUserId());
                this.setVisible(false);
                jFrameMainNv.setVisible(true);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Đăng nhập không thành công!");
        }
    }
     
    public static void main(String[] args) throws IOException {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(WindowDangNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        WindowDangNhap windowDangNhap = new WindowDangNhap();
        windowDangNhap.setVisible(true);
    }

}
