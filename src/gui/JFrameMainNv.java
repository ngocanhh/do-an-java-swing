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
import dao.MovieDAO;
import dao.MovieTimesDAO;
import dao.RoomDAO;
import dto.ChairDTO;
import dto.ChairTypeDTO;
import javax.swing.DefaultComboBoxModel;
import dto.MovieDTO;
import dto.MovieTimesDTO;
import dto.RoomDTO;
import dto.ShowtimesDTO;
import dto.TicketDTO;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ngọc Anh
 */
public class JFrameMainNv extends javax.swing.JFrame {

    /**
     * Creates new form JFrameMain
     */
    public JFrameMainNv() {
        initComponents();
        jPanelQLThongTin.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanelQLThongTin = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btBanVe = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chương trình quản lý bán vé xem phim");
        setLocation(new java.awt.Point(200, 100));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ BÁN VÉ XEM PHIM");

        jPanelQLThongTin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton5.setText("Phim");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton6.setText("Lịch chiếu");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton7.setText("Ghế");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelQLThongTinLayout = new javax.swing.GroupLayout(jPanelQLThongTin);
        jPanelQLThongTin.setLayout(jPanelQLThongTinLayout);
        jPanelQLThongTinLayout.setHorizontalGroup(
            jPanelQLThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQLThongTinLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanelQLThongTinLayout.setVerticalGroup(
            jPanelQLThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQLThongTinLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanelQLThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(129, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Quản lý thông tin");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Xem lịch chiếu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btBanVe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btBanVe.setText("Bán vé");
        btBanVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBanVeActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setText("Tìm kiếm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btBanVe)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4))
                            .addComponent(jPanelQLThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(btBanVe)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelQLThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        JFrameQLLichChieu jFrameQLLichChieu = new JFrameQLLichChieu();
        MovieTimesDAO movieTimesDAO = new MovieTimesDAO();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for(MovieTimesDTO m : movieTimesDAO.findAll()){
            model.addElement(m.getMovieTimesCode());
        }
        jFrameQLLichChieu.getCaChieu().setModel(model);
        DefaultComboBoxModel model1 = new DefaultComboBoxModel();
        MovieDAO movieDAO = new MovieDAO();
        for(MovieDTO movie : movieDAO.findAll()){
            model1.addElement(movie.getMovieCode());
        }
        jFrameQLLichChieu.getCbPhim().setModel(model1);
        
        DefaultComboBoxModel model2 = new DefaultComboBoxModel();
        RoomDAO roomDAO = new RoomDAO();
        for(RoomDTO room : roomDAO.findAll()){
            model2.addElement(room.getRoomCode());
        }
        jFrameQLLichChieu.getCbRoom().setModel(model2);
        DefaultTableModel tableModel = (DefaultTableModel) jFrameQLLichChieu.getjTable().getModel();
        ShowtimesBUS showtimesBUS = new ShowtimesBUS();
        ArrayList<ShowtimesDTO> showtimes = showtimesBUS.findAll();
        RoomBUS roomBUS = new RoomBUS();
        MovieBUS movieBUS = new MovieBUS();
        MovieTimesBUS movieTimesBUS = new MovieTimesBUS();
        for(ShowtimesDTO s : showtimes){
            RoomDTO room = roomBUS.findById(s.getRoomId());
            MovieDTO movie = movieBUS.findById(s.getMovieId());
            MovieTimesDTO movieTimesDTO = movieTimesBUS.findById(s.getMovieTimesId());
            tableModel.addRow(new Object[]{s.getId(), s.getShowTimesCode(), s.getProjectionDate(),
            movieTimesDTO.getMovieTimesCode(), room.getRoomCode(), movie.getMovieCode()});
            
        }
        jFrameQLLichChieu.getjTable().setModel(tableModel);
        jFrameQLLichChieu.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          jPanelQLThongTin.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        JFrameQLPhim jFrameNhapPhim = new JFrameQLPhim();
        DefaultTableModel model = (DefaultTableModel) jFrameNhapPhim.getjTable().getModel();
        MovieBUS movieBUS = new MovieBUS();
        ArrayList<MovieDTO> movies = movieBUS.findAll();
        for (MovieDTO m : movies) {
                    model.addRow(new Object[]{m.getId(), m.getMovieCode(), m.getMovieName(),
                    m.getCategory(), m.getTime(), m.getProducer(), m.getShortDescription()});
        }
        jFrameNhapPhim.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        JFrameQLGhe jFrameQLGhe = new JFrameQLGhe();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        ChairTypeBUS chairTypeBUS = new ChairTypeBUS();
        for(ChairTypeDTO p : chairTypeBUS.findAll()){
            model.addElement(p.getChairTypeCode());
        }
        jFrameQLGhe.getCbLoaiGhe().setModel(model);
        jFrameQLGhe.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btBanVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBanVeActionPerformed

        jPanelQLThongTin.setVisible(false);
        JFrameBanVe jFrameBanVe = new JFrameBanVe();
        ChairBUS chairBUS = new ChairBUS();
        ShowtimesBUS showtimesBUS = new ShowtimesBUS();
        UserBUS userBUS = new UserBUS();
        DefaultComboBoxModel cbBoxModel = new DefaultComboBoxModel();
        for(ChairDTO p : chairBUS.findAll()){
            cbBoxModel.addElement(p.getChairCode());
        }
        jFrameBanVe.getCbMaGhe().setModel(cbBoxModel);
        DefaultComboBoxModel cbBoxModelMaLC = new DefaultComboBoxModel();
        for(ShowtimesDTO p : showtimesBUS.findAll()){
            cbBoxModelMaLC.addElement(p.getShowTimesCode());
        }
        jFrameBanVe.getCbMaLichChieu().setModel(cbBoxModelMaLC);
        jFrameBanVe.getTxtUserId().setText(txtUserId.getText()); 
        TicketBUS ticketBUS = new TicketBUS();
        DefaultTableModel model = (DefaultTableModel) jFrameBanVe.getjTable1().getModel();
        for(TicketDTO ticket : ticketBUS.findAll()){
            model.addRow(new Object[]{ticket.getId(), chairBUS.findById(ticket.getChairId()).getChairCode(),
            showtimesBUS.findById(ticket.getShowtimesId()).getShowTimesCode(), userBUS.findById(ticket.getUserId()).getUserCode()});
        }
        jFrameBanVe.setVisible(true);
        
    }//GEN-LAST:event_btBanVeActionPerformed

    @SuppressWarnings("FieldMayBeFinal")
    private JTextField txtUserId = new JTextField();
    public JTextField getTxtUserId(){
        return txtUserId;
    }
    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("Convert2Lambda")
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameMainNv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameMainNv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameMainNv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameMainNv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JFrameMainNv().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBanVe;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelQLThongTin;
    // End of variables declaration//GEN-END:variables
}