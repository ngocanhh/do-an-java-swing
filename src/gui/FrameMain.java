/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ADMIN
 */
public class FrameMain extends JFrame{
    
    public FrameMain(){
        setTitle("Quản lý bán vé xem phim");
        setSize(1600,800);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (InstantiationException | IllegalAccessException | 
                UnsupportedLookAndFeelException | ClassNotFoundException ex) {
           ex.printStackTrace();
        }
        FrameMain frameMain = new FrameMain();
        WindowDangNhap windowDangNhap = new WindowDangNhap(frameMain);
        frameMain.add(windowDangNhap);
//         ý tưởng: sau khi nhấn nút connect đăng nhập thành công thì sẽ
//         add panel mới, để add được panel thì cần có FrameMain, để có
//         FrameMain thì cần truyền FrameMain vào contructor của WindowDangNhap
        frameMain.setVisible(true);
    }
}
