
import java.awt.BorderLayout;
import java.awt.Dimension;
import org.gstreamer.Caps;
import org.gstreamer.Element;
import org.gstreamer.ElementFactory;
import org.gstreamer.Gst;
import org.gstreamer.Pipeline;
import org.gstreamer.State;
import org.gstreamer.swing.VideoComponent;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * chatBox2.java
 *
 * Created on Aug 10, 2011, 1:32:33 PM
 */
/**
 *
 * @author crawdad
 */
public class chatBox2 extends javax.swing.JFrame {

    /** Creates new form chatBox2 */
    public chatBox2() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
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
            java.util.logging.Logger.getLogger(chatBox2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chatBox2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chatBox2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chatBox2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
//        args = Gst.init("chatbox", args);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                chatBox2 chatbox;
                chatbox = new chatBox2();
                //
        Gst.init();
        chatbox.pipe = new Pipeline("pipeline");
        chatbox.videosrc = ElementFactory.make("autovideosrc", "source");
        chatbox.videofilter = ElementFactory.make("capsfilter", "flt");
        chatbox.videofilter.setCaps(Caps.fromString(
                "video/x-raw-yuv,width=352,height=288,framerate=30/1"));
        chatbox.videoComponent = new VideoComponent();
        chatbox.videosink = chatbox.videoComponent.getElement();
//                chatbox.videosink = ElementFactory.make("autovideosink", "sink");                
                chatbox.pipe.addMany(chatbox.videosrc, chatbox.videofilter, chatbox.videosink);
                Element.linkMany(chatbox.videosrc,  chatbox.videofilter, chatbox.videosink);
                chatbox.jPanel1.add(chatbox.videoComponent, BorderLayout.CENTER);
//                chatbox.add(chatbox.videoComponent, BorderLayout.CENTER);
                chatbox.videoComponent.setPreferredSize(new Dimension(720, 576));
                chatbox.pack();

                chatbox.setVisible(true);
                chatbox.pipe.setState(State.PLAYING);
//                pipe.play();
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    Pipeline pipe;
    Element videosrc;
    Element videofilter;
    VideoComponent videoComponent;
    Element videosink;
}
