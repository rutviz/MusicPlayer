/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DropMode;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.TransferHandler;
import static javax.swing.TransferHandler.COPY_OR_MOVE;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author rutvi
 */
public class PlayList extends javax.swing.JFrame {

    /**
     * Creates new form PlayList
     */
    
    int CurrentSelectedRow = 0;    
    String CurrentPlaylist = "";
    int Songs = 0;
    String[][] abc = null;
    private int status = 0;
    BasicPlayerTest Player;
    DatabaseControl database;
    private int autoplay = 0;
    Home parent;
    
    public PlayList() {
        initComponents();
        init();
        
    }
    public PlayList(String playlist, BasicPlayerTest player)
    {
        System.out.println("In playlist "+playlist);
        Player = player;
        CurrentPlaylist = playlist;
        initComponents();
        init();
    }
 public PlayList(String playlist, Home parent)
    {
        System.out.println("In playlist "+playlist);
        Player = new BasicPlayerTest();
        CurrentPlaylist = playlist;
        this.parent = parent;
        initComponents();
        init();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        play = new javax.swing.JButton();
        next = new javax.swing.JButton();
        prev = new javax.swing.JButton();
        stop = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        Song_name = new javax.swing.JLabel();
        vol = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jLabel1.setText("Now Playing....");

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

        jMenu1.setText("File");

        jMenuItem3.setText("Add File To Playlist");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

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
                .addComponent(prev, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(play, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(next, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stop, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vol, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Song_name, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(Song_name)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(prev)
                        .addComponent(play)
                        .addComponent(next)
                        .addComponent(stop))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(vol)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        Player.stop();
        Song_name.setText("Select any song and click on Play");
        play.setText("Play");
        status = 0;
    }//GEN-LAST:event_stopActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        vol.setText(jSlider1.getValue()+"%");
        Player.setVolume(jSlider1.getValue());
    }//GEN-LAST:event_jSlider1StateChanged

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
         openFile();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Player.stop();
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(PlayList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlayList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Song_name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton next;
    private javax.swing.JButton play;
    private javax.swing.JButton prev;
    private javax.swing.JButton stop;
    private javax.swing.JLabel vol;
    // End of variables declaration//GEN-END:variables

    JPopupMenu popup;
    JMenuItem menu,menu1;
    protected DefaultMutableTreeNode rootNode; 
    protected DefaultTreeModel treeModel; 
    
    private void init()
    {
        setTitle(CurrentPlaylist);
        database = new DatabaseControl();
        abc = database.updateList(CurrentPlaylist);
        Songs = database.NumberofSongs(CurrentPlaylist);
        setSongDetail(abc);
        Player.setVolume(80);
        setListener();
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                Player.stop();

            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
    }
    public String getName()
    {
        return CurrentPlaylist;
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
    
     private void setListener() {
        popup = new JPopupMenu();
        menu = new JMenuItem("Delete");      
        menu1 = new JMenuItem("Add Song"); 
        popup.add(menu);
        popup.add(menu1);
      //  jTable1.setComponentPopupMenu(popup);
                MouseListener mouseListener = new MouseAdapter() {
            //this will print the selected row index when a user clicks the table
           @Override
            public void mouseReleased(MouseEvent e) {
              //System.out.println("press ");
                //if(e.getButton() == MouseEvent.BUTTON3) {
                     int r = jTable1.rowAtPoint(e.getPoint());
                if (r >= 0 && r < jTable1.getRowCount()) {
                    jTable1.setRowSelectionInterval(r, r);
                } else {
                    jTable1.clearSelection();
                }

                int rowindex = jTable1.getSelectedRow();
                System.out.println(rowindex);
                if (rowindex < 0)
                    return;
                System.out.println(e.isPopupTrigger() );
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
        menu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String[] s_list = abc[CurrentSelectedRow][0].split("\\\\");
                int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete "+s_list[s_list.length-1], "Alert", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) 
                {
                    System.out.println(abc[CurrentSelectedRow][0]+" Delete this");
                   database.delete(abc[CurrentSelectedRow][0],CurrentPlaylist);
                   parent.updateAll();
                   Songs = database.NumberofSongs(CurrentPlaylist);
                   abc = database.updateList(CurrentPlaylist);
                   setSongDetail(abc);
                }
            }
       });
        menu1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              openFile(); 
            }
       });
       dragDrop();
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
    
     private void setSongDetail(String[][] abc) {
        Mp3File mp3file = null;
        System.err.println(abc[0][0]);
        if(abc.length != 0){
            for(int i=0;i<Songs;i++)
            {
                try 
                 {
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
            jTable1.setModel(new DefaultTableModel(
                 abc,
                new String [] {
                    "File", "Title", "Artist", "Album","Year","Comment","Gerne"
                }
                ));
        }
    }
    
    private void AddToDatabase(String path) {
        System.out.println("added");
        database.AddToDatabase(path,Songs,CurrentPlaylist);
       Songs = database.NumberofSongs(CurrentPlaylist);
       abc = database.updateList(CurrentPlaylist);
       setSongDetail(abc);
       parent.updateAll();
    }
    
     public void UpdateTable(String name)
    {
       Songs = database.NumberofSongs(name);  
       System.out.println(name);
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
            protected Transferable createTransferable(JComponent c) 
            {
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
                        AddToDatabase(file.getAbsolutePath());
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

            protected void importString(JComponent c, String str) {

                JTable target = (JTable)c;
                DefaultTableModel model = (DefaultTableModel)target.getModel();
                //int index = target.getSelectedRow();
                int row = target.getSelectedRow();

                //int column = target.getSelectedColumn();
                System.err.println(CurrentPlaylist+" while importing");
                System.out.print("Hello imported"+str);
                
                String [] s = str.split(";");
                for(String path:s)
                {
                    AddToDatabase(path);
                }
            }
    };

            jTable1.setDragEnabled(true);
            jTable1.setDropMode(DropMode.INSERT_ROWS);
            jTable1.setTransferHandler(th);
    }
    
    
}
