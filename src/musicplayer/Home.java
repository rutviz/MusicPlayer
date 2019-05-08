/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v1Tag;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.awt.Dimension;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.DropMode;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.TransferHandler;
import static javax.swing.TransferHandler.COPY_OR_MOVE;
import static javax.swing.TransferHandler.MOVE;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;
import org.w3c.dom.NameList;
 

/**
 *
 * @author rutviz
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    int CurrentSelectedRow = 0;    
    String CurrentPlaylist = "";
    int Songs = 0;
    String[][] abc = null;
    private int status = 0;
    BasicPlayerTest Player;
    DatabaseControl database;
    private int autoplay = 0;
    boolean mouseclicktree = true;
    ArrayList<PlayList> tabs;
    
    public Home() {
        this.tabs = new ArrayList<>();
        initComponents();
        Player = new BasicPlayerTest();
        database = new DatabaseControl();
        abc = database.updateList();
        Songs = database.NumberofSongs();
        setSongDetail(abc);
        Player.setVolume(80);
        setupTree();
        setListener();
//        int width = this.getWidth();
//        int height = this.getHeight();
//        System.err.println("width "+width+" height "+height);
//        jScrollPane3.setSize(new Dimension(width/4,jTree2.getPreferredSize().height));
//        jScrollPane1.setPreferredSize(new Dimension(width*4/8,jTable1.getPreferredSize().height));
//        System.err.println("width "+jScrollPane3.getPreferredSize().width+" height "+height);  
            
        this.pack();
    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        play = new javax.swing.JButton();
        next = new javax.swing.JButton();
        prev = new javax.swing.JButton();
        stop = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        Song_name = new javax.swing.JLabel();
        vol = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTree2 = new javax.swing.JTree();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Music Player");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        play.setText("Play");
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });

        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        prev.setText("Prev");
        prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevActionPerformed(evt);
            }
        });

        stop.setText("Stop");
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });

        jSlider1.setToolTipText("");
        jSlider1.setValue(80);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        Song_name.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        Song_name.setText("Select any song and click on Play");

        vol.setText("80%");

        jLabel1.setText("Now Playing....");

        jScrollPane3.setViewportView(jTree2);

        jMenu1.setText("File");

        jMenuItem1.setText("Open");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setText("Add File To library");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem5.setText("Create Playlist");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem4.setText("Delete");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1))
            .addGroup(layout.createSequentialGroup()
                .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(play, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(stop, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(vol, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(Song_name, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(Song_name)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prev)
                    .addComponent(play)
                    .addComponent(next)
                    .addComponent(stop)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vol)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playActionPerformed
      if(status == 1){
          Player.pause();
          play.setText("Resume");
          status = 2;
      }else if(status == 2)
      {
          Player.resume();
          play.setText("Pause");
          status = 1;
          
      }else{
        Player.play(abc[CurrentSelectedRow][0]);
        play.setText("Pause");
        status = 1;
        jTable1.setRowSelectionInterval(CurrentSelectedRow, CurrentSelectedRow);
        String[] s_list = abc[CurrentSelectedRow][0].split("\\\\");
        Song_name.setText(s_list[s_list.length-1]);
      }
     Player.setVolume(jSlider1.getValue());
      
    }//GEN-LAST:event_playActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        if((Songs-1) == CurrentSelectedRow){
            JOptionPane.showMessageDialog(this, "No next Song");
        }else{
            Player.play(abc[CurrentSelectedRow+1][0]);
            CurrentSelectedRow++;
        }
        String[] s_list = abc[CurrentSelectedRow][0].split("\\\\");
        Song_name.setText(s_list[s_list.length-1]);
        jTable1.setRowSelectionInterval(CurrentSelectedRow, CurrentSelectedRow);
        Player.setVolume(jSlider1.getValue());
    }//GEN-LAST:event_nextActionPerformed

    private void prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevActionPerformed
       if(CurrentSelectedRow==0){
            JOptionPane.showMessageDialog(this, "No Previous Song");
       }else{
            Player.play(abc[CurrentSelectedRow-1][0]);
            CurrentSelectedRow--; 
       }
       String[] s_list = abc[CurrentSelectedRow][0].split("\\\\");
       Song_name.setText(s_list[s_list.length-1]);
       jTable1.setRowSelectionInterval(CurrentSelectedRow, CurrentSelectedRow);
       Player.setVolume(jSlider1.getValue());
    }//GEN-LAST:event_prevActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        playFile();        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        vol.setText(jSlider1.getValue()+"%");
        Player.setVolume(jSlider1.getValue());
    }//GEN-LAST:event_jSlider1StateChanged

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        Player.stop();
        Song_name.setText("Select any song and click on Play");
        play.setText("Play");
        status = 0;
    }//GEN-LAST:event_stopActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        String[] s_list = abc[CurrentSelectedRow][0].split("\\\\");
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete "+s_list[s_list.length-1], "Alert", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            System.out.println(abc[CurrentSelectedRow][0]+" Delete this");
            System.err.println("deleting.....");
           database.delete(abc[CurrentSelectedRow][0]);
           Songs = database.NumberofSongs();
           abc = database.updateList();
           setSongDetail(abc);
            
           updateAll();
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        openFile();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
         String playlist= JOptionPane.showInputDialog("Enter name of the Playlist ");
         String[] a = database.getPlaylistName();
         int x =0 ;
         for(String str : a)
         {
             if(str.equals(playlist))
             {
                 x=1;
             }
         }
         if(x==0){
         database.AddPlaylist(playlist);
         UpdateTree(playlist);
         }else{
             JOptionPane.showMessageDialog(this, "Playlist Alerady exists");
         }

    }//GEN-LAST:event_jMenuItem5ActionPerformed

   /* Main Method */
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Song_name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTree jTree2;
    private javax.swing.JButton next;
    private javax.swing.JButton play;
    private javax.swing.JButton prev;
    private javax.swing.JButton stop;
    private javax.swing.JLabel vol;
    // End of variables declaration//GEN-END:variables
    JPopupMenu popup;
    JPopupMenu libpopup;
    JMenu i3;
    JMenuItem i1,i2;
    JMenuItem menu,menu1,menu2;
    protected DefaultMutableTreeNode rootNode; 
    protected DefaultTreeModel treeModel; 
    
    
    
       /* Other Methods */
    private void setListener() {
        libpopup = new JPopupMenu();
        popup = new JPopupMenu();
        i3 = new JMenu("Add to playList");
        i1 = new JMenuItem("Open in New Window");
        i2 = new JMenuItem("Delete Playlist");
        menu = new JMenuItem("Delete");      
        menu1 = new JMenuItem("Add Song");   
        menu2 = new JMenuItem("P1");
        String[] list = database.getPlaylistName();
        for(String str : list){
            JMenuItem j = new JMenuItem(str);
            i3.add(j);
            j.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    database.AddToDatabase(abc[CurrentSelectedRow][0], Songs, str);
                    updateAll();
                    System.err.println("Adding to playlist");
                }
            });
        }
        libpopup.add(i1);
        libpopup.add(i2);
        popup.add(menu);    
        popup.add(menu1);
        popup.add(i3);
        
        jTree2.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener(){
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree2.getLastSelectedPathComponent();
                if(selectedNode != null){
                String name = selectedNode.getUserObject().toString();
                CurrentPlaylist = name;
                System.out.println(CurrentPlaylist+"------current");
                System.out.println(name+"----name");
                
//               if(mouseclicktree)
               {
                if(name.equals("Library"))
                {
                    Songs = database.NumberofSongs();
                    abc = database.updateList();
                    setSongDetail(abc);
                }
                else if(!name.equals("Playlist"))
                    UpdateTable(name);
               }    
            }
            }
        });
        //jTree2.setComponentPopupMenu(libpopup);
       //jTable1.setComponentPopupMenu(popup);
       MouseListener mouseListenertree = new MouseAdapter() {
           @Override
           public void mouseReleased(MouseEvent e)
           {
               mouseclicktree = true;
               if(e.getButton() != MouseEvent.BUTTON1)
               {
                mouseclicktree = false;   
               }
               TreePath row = jTree2.getPathForLocation(e.getX(), e.getY());
                    jTree2.setSelectionPath(row);
                if (e.isPopupTrigger() && e.getSource() instanceof JTree ) {
                    if(CurrentPlaylist != "Playlist")
                    libpopup.show((JTree)e.getSource(), e.getX(), e.getY());
                }
           }
};
        MouseListener mouseListener = new MouseAdapter() {
            //this will print the selected row index when a user clicks the table
           @Override
            public void mouseReleased(MouseEvent e) {
              //System.out.println("press ");
                //if(e.getButton() == MouseEvent.BUTTON3) {
                     int r = jTable1.rowAtPoint(e.getPoint());
                if (r >= 0 && r < jTable1.getRowCount()) {
                   // jTable1.setRowSelectionInterval(r, r);
                } else {
                    //jTable1.clearSelection();
                }
//                TreePath row = jTable1.getPopupLocation(e.getX(), e.getY());
                jTable1.setRowSelectionInterval(r, r);
                int rowindex = jTable1.getSelectedRow();
                System.out.println(rowindex);
                if (rowindex < 0)
                    return;
                System.out.println(e.isPopupTrigger());
                if (e.isPopupTrigger() && e.getComponent() instanceof JTable ) {
                    popup.show(e.getComponent(), e.getX(), e.getY());
                }
                  //}
                  CurrentSelectedRow = jTable1.getSelectedRow();
               System.out.println("Selected index = " + CurrentSelectedRow);
               //jTable1.setRowSelectionInterval(CurrentSelectedRow, CurrentSelectedRow);
            }
        };
        jTable1.addMouseListener(mouseListener);
        jTree2.addMouseListener(mouseListenertree);
        menu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] s_list = abc[CurrentSelectedRow][0].split("\\\\");
                int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete "+s_list[s_list.length-1], "Alert", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    System.out.println(abc[CurrentSelectedRow][0]+" Delete this");
                   
                   if(jTree2 != null && jTree2.getSelectionRows()[0]!=0){
                       database.delete(abc[CurrentSelectedRow][0],CurrentPlaylist);
                         Songs = database.NumberofSongs(CurrentPlaylist);
                        abc = database.updateList(CurrentPlaylist);
                        setSongDetail(abc);}
                   else{
                       database.delete(abc[CurrentSelectedRow][0]);
                        Songs = database.NumberofSongs();
                        abc = database.updateList();
                        setSongDetail(abc);
                        
                   }updateAll();
                }
            }
       });
        menu1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              openFile(); 
            }
       });
       i1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                                Songs = database.NumberofSongs();
                abc = database.updateList();
                setSongDetail(abc);
                PlayList pl = new PlayList(CurrentPlaylist,Home.this);
                tabs.add(pl);
               pl.setVisible(true);
               jTree2.setSelectionRow(0);

            }
        });
       i2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               database.deletePlaylist(CurrentPlaylist);
               closeTabs(CurrentPlaylist);
                UpdateTree(jTree2.getSelectionRows()[0]-2);
            }

          
        });
       dragDrop();
    }
    
    private void setSongDetail(String[][] abc) {
        Mp3File mp3file = null;
        if(abc.length != 0){
            for(int i=0;i<Songs;i++)
            {
                try 
                 {
                     System.err.println(abc[i][0]);
                   mp3file = new Mp3File(abc[i][0]);
                 } catch (IOException ex) {
                   Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (UnsupportedTagException ex) {
                   Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (InvalidDataException ex) {
                   Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 if (mp3file.hasId3v2Tag()) 
                 {
                     ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                     abc[i][1] = id3v2Tag.getTitle();
                     abc[i][2] = id3v2Tag.getArtist();
                     abc[i][3] = id3v2Tag.getAlbum();
                     abc[i][4] = id3v2Tag.getYear();
                     abc[i][5] = id3v2Tag.getComment();
                     abc[i][6] = id3v2Tag.getGenreDescription();
                 }
            }
            jTable1.setDefaultEditor(Object.class, null);
            DefaultTableModel model = new DefaultTableModel(
                 abc,
                new String [] {
                    "File", "Title", "Artist", "Album","Year","Comment","Gerne"
                }
                );
            jTable1.setModel(model);
        }
    }
    
    public void playNext()
    {
        if((Songs-1) == CurrentSelectedRow || autoplay == 0){
//            JOptionPane.showMessageDialog(this, "No next Song");
        }else{
            Player.play(abc[CurrentSelectedRow+1][0]);
            CurrentSelectedRow++;
        }
        String[] s_list = abc[CurrentSelectedRow][0].split("\\\\");
        Song_name.setText(s_list[s_list.length-1]);
        jTable1.setRowSelectionInterval(CurrentSelectedRow, CurrentSelectedRow);
    }
    
    private void openFile(){
        JFileChooser choice = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "MP3 Files", "mp3");
        choice.setFileFilter(filter);
        int option = choice.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            String path = choice.getSelectedFile().getPath();
            AddToDatabase(path);
        }
    }
    
    private void playFile() {
         JFileChooser choice = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "MP3 Files", "mp3");
        choice.setFileFilter(filter);
        int option = choice.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            String path = choice.getSelectedFile().getPath();
            Song_name.setText(path);
            Player.play(path);
            play.setText("Pause");
            status = 1;
        }
    }
    
    private void AddToDatabase(String path) {
       database.AddToDatabase(path,Songs);
       Songs = database.NumberofSongs();
       abc = database.updateList();
       setSongDetail(abc);
    }
    private void AddToDatabase(String path, String play) {
       database.AddToDatabase(path,Songs,play);
       Songs = database.NumberofSongs(play);
       abc = database.updateList(play);
       setSongDetail(abc);
        updateAll();
    }
    private void UpdateTable(String name)
    {
       Songs = database.NumberofSongs(name);  
       System.out.println(name+"====updating");
       abc = database.updateList(name);
       System.out.println(abc.length +" "+database.NumberofSongs(name));
       if(database.NumberofSongs(name)!=0)
        setSongDetail(abc);
       else{
        jTable1.setDefaultEditor(Object.class, null);
            jTable1.setModel(new DefaultTableModel(
                 abc,
                new String [] {
                    "File", "Title", "Artist", "Album","Year","Comment","Gerne"
                }
                ));
        }
    
    }
    
    private void dragDrop(){
        TransferHandler th;
        th = new TransferHandler(){
             DatabaseControl database;
             @Override
            protected Transferable createTransferable(JComponent c) {
                return new StringSelection(exportString(c));
            }
            @Override
            public int getSourceActions(JComponent c) 
            {
                return COPY_OR_MOVE;
            }

            @Override
            public boolean importData(JComponent c, Transferable t) {

                if (canImport(c, t.getTransferDataFlavors())) {
                   if(t.isDataFlavorSupported(DataFlavor.javaFileListFlavor))
                   {
                      try {
                    List<File> files = (List<File>) t.getTransferData(DataFlavor.javaFileListFlavor);
                    for (File file : files) {
                        System.out.println(file.getAbsolutePath());
                        if(jTree2.getSelectionRows()[0]!=0)
                        AddToDatabase(file.getAbsolutePath(),CurrentPlaylist);
                        else
                            AddToDatabase(file.getAbsolutePath());
        //                DatabaseControl db = new DatabaseControl();
        //                db.AddToDatabase(path, NONE);
                    }
                } catch (UnsupportedFlavorException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
                      return true;
                   }
                    try {
                        String str = (String)t.getTransferData(DataFlavor.stringFlavor);
                        importString(c, str);
                        return true;
                    } catch (UnsupportedFlavorException ufe) {
                    } catch (IOException ioe) {
                    }


                }

                return false;
            }
            @Override
            public boolean canImport(JComponent c, DataFlavor[] flavors) {

                 JTable table = (JTable)c;         
                 int selColIndex = table.getSelectedColumn();
                for (int i = 0; i < flavors.length; i++) {
                    if ((DataFlavor.stringFlavor.equals(flavors[i]))&& (selColIndex !=0)) {
                        return true;
                    }
                }        
                return true;
            }
                private int[] rows = null;
            private int addIndex = -1; //Location where items were added
            private int addCount = 0;  //Number of items added.

            protected String exportString(JComponent c) {
                JTable table = (JTable)c;
                //rows = table.getSelectedRows();  

                StringBuffer buff = new StringBuffer();
                //int selRowIndex = table.getSelectedRow();
               int rows[] = table.getSelectedRows();
               //int selColIndex = table.getSelectedColumn();
                //System.out.println(selRowIndex);
               //int colcount = table.getColumnCount();
               String val="";
//               for(int i=0; i<colcount;i++)
//               {
//                   //System.err.println("row" + selRowIndex +" "+i);
//                    val += table.getValueAt(selRowIndex,i)+ ";";
//               }
               for(int row:rows)
               {
                   val += table.getValueAt(row,0)+ ";";
               }
               buff.append(val);       

                return buff.toString();
            }

            protected void importString(JComponent c, String str)
            {

                JTable target = (JTable)c;
                DefaultTableModel model = (DefaultTableModel)target.getModel();
                //int index = target.getSelectedRow();
                int row = target.getSelectedRow();

                //int column = target.getSelectedColumn();
                System.out.print("Hello imported"+str);
                String [] s = str.split(";");
                for(int col=0;col<target.getColumnCount();col++)
                {
                    target.setValueAt(s[col], row, col);
                    col++;
                }
            }
    };

            jTable1.setDragEnabled(true);
            jTable1.setDropMode(DropMode.INSERT_ROWS);
            jTable1.setTransferHandler(th);
    }

    private void setupTree()
    {
        rootNode = new DefaultMutableTreeNode("Root");
        rootNode.add(new DefaultMutableTreeNode("Library"));
        DefaultMutableTreeNode playlist = new DefaultMutableTreeNode("Playlist");
        String[] list = database.getPlaylistName();
        for(String str : list)
            playlist.add(new DefaultMutableTreeNode(str));
        System.out.println("Done updating");
        rootNode.add(playlist);
        jTree2.setRootVisible(false);
        
        treeModel = new DefaultTreeModel(rootNode);
        jTree2.setModel(treeModel);
        jTree2.setSelectionRow(0);
        jTree2.expandRow(1);
    }
    private void UpdateTree(String name)
    {
        
         treeModel = (DefaultTreeModel) jTree2.getModel();
        DefaultMutableTreeNode playlist = (DefaultMutableTreeNode) treeModel.getRoot();
        DefaultMutableTreeNode playlist1 = (DefaultMutableTreeNode) playlist.getChildAt(1);
        playlist1.add(new DefaultMutableTreeNode(name));
        treeModel.reload(rootNode);
        jTree2.expandRow(1);
        System.out.print(playlist1.getChildCount()+1);
       jTree2.setSelectionRow(playlist1.getChildCount()+1);
       popup.remove(i3);
       i3 = new JMenu("Add to Playlist");
        String[] list = database.getPlaylistName();
        for(String str : list){
            JMenuItem j = new JMenuItem(str);
            i3.add(j);
            j.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    database.AddToDatabase(abc[CurrentSelectedRow][0], Songs, str);
                    updateAll();
                    System.err.println("Adding to playlist");
                }
            });
        }
        popup.add(i3);

    }
     private void UpdateTree(int index)
    {
         treeModel = (DefaultTreeModel) jTree2.getModel();
        DefaultMutableTreeNode playlist = (DefaultMutableTreeNode) treeModel.getRoot();
        DefaultMutableTreeNode playlist1 = (DefaultMutableTreeNode) playlist.getChildAt(1);
        playlist1.remove(index);
        treeModel.reload(rootNode);
        jTree2.expandRow(1);
        jTree2.setSelectionRow(0);
        Songs = database.NumberofSongs();
        abc = database.updateList();
        setSongDetail(abc);
        popup.remove(i3);
       i3 = new JMenu("Add to Playlist");
         String[] list = database.getPlaylistName();
        for(String str : list){
            JMenuItem j = new JMenuItem(str);
            i3.add(j);
            j.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    database.AddToDatabase(abc[CurrentSelectedRow][0], Songs, str);
                    updateAll();
                    System.err.println("Adding to playlist");
                }
            });
        }
        
                popup.add(i3);

    }
     
      private void closeTabs(String CurrentPlaylist) {
          for(PlayList pl : tabs)
          {
              if(pl.getName().equals(CurrentPlaylist))
              {
                  Player.stop();
                  pl.dispose();
              }
          }
      }
      public void updateAll()
      {
          System.err.println("Called");
          UpdateTable(CurrentPlaylist);
          for(PlayList pl : tabs)
          {
                pl.UpdateTable(pl.getName());

          }
      }
}