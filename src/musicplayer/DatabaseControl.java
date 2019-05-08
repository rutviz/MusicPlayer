package musicplayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rutviz
 */
public class DatabaseControl {
    Connection conn;
    DatabaseControl()
    {
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Songs",null,null);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AddToDatabase(String path, int Songs) {
        try{
            
            path = path.replace("\\", "\\\\");
            String sql = "INSERT INTO APP.LIST (ID, \"PATH\", PLAYLIST) \n" + "VALUES ("+(Songs+1)+", '"+path+"', 'Library')\n";
            PreparedStatement st=conn.prepareStatement(sql);
            st.executeUpdate();
        }
        catch(SQLException e)
        {
           
        }
        
    }
    public void AddToDatabase(String path, int Songs, String name) {
        System.err.println("importing "+name + " in "+path);
        try{
            if(!path.contains("\\\\"))
            path = path.replace("\\", "\\\\");
            String sql = "INSERT INTO APP.LIST (ID, \"PATH\", PLAYLIST) \n" + "VALUES ("+(Songs+1)+", '"+path+"', '"+name+"')\n";
            String sql1 = "INSERT INTO APP.LIST (ID, \"PATH\", PLAYLIST) \n" + "VALUES ("+(Songs+1)+", '"+path+"', 'Library')\n";
            PreparedStatement st=conn.prepareStatement(sql);  
            PreparedStatement st1=conn.prepareStatement(sql1);
            st.executeUpdate();
            st1.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        
    }
    
    public void AddPlaylist(String name) 
    {
        try{
            String sql = "INSERT INTO APP.PLAYLIST (ID, \"NAME\") VALUES (null, '"+name+"')";
            PreparedStatement st=conn.prepareStatement(sql);
            st.executeUpdate();
        }catch(SQLException e)
        {
            
        }
    }
    
    public String[][] updateList(){
        String[][] abc = null;
        try{
            Statement stm;
            stm = conn.createStatement();
            String sql = "SELECT * FROM APP.LIST WHERE PLAYLIST = 'Library'";
            ResultSet rst;
            rst = stm.executeQuery(sql);
            int song = NumberofSongs();
            if(song<1)
                song = 1;
            abc = new String[song][7];
            int i=0;
            while(rst.next()){
                abc[i][0] = rst.getString("PATH");
                i++;
            }
        }
        catch(SQLException e){}
        return abc;
    }
    
    public String[][] updateList(String playlist){
        String[][] abc = null;
        try{
            Statement stm;
            stm = conn.createStatement();
            String sql = "SELECT * FROM APP.LIST WHERE PLAYLIST = '"+playlist+"'";
            ResultSet rst;
            rst = stm.executeQuery(sql);
            int song = NumberofSongs(playlist);
            if(song<1)
                song = 1;
            abc = new String[song][7];
            int i=0;
            while(rst.next()){
                abc[i][0] = rst.getString("PATH");
                i++;
            }
        }
        catch(SQLException e){
            System.out.println("error");
        }
        return abc;
    }
    
    public String[] getPlaylistName()
    {
        String[] abc = null;
        try{
            Statement stm;
            stm = conn.createStatement();
            String sql = "SELECT * FROM APP.PLAYLIST";
            ResultSet rst;
            int playlist = NumberofPlaylist();
            rst = stm.executeQuery(sql);
            abc = new String[playlist];
            int i=0;
            while(rst.next()){
                abc[i] = rst.getString("NAME");
                i++;
            }
        }
        catch(SQLException e){}
        return abc;
    }
    
    
    
    public void delete(String path)
    {
        System.out.println("Deleting");
        try{
            String sql = "DELETE FROM APP.LIST WHERE PATH = '"+path+"'";
            System.out.println(sql);
            PreparedStatement st=conn.prepareStatement(sql);
            int a = st.executeUpdate();
            System.out.print(a);
        }
        catch(SQLException e)
        {
           System.out.println(e.getMessage());
        }
    }
    
    public int NumberofPlaylist()
    {
        try {
            Statement stm = conn.createStatement();
            String query = "SELECT COUNT(NAME) FROM APP.PLAYLIST"; 
            ResultSet rst = stm.executeQuery(query);
            while(rst.next())
            {
                return rst.getInt("1");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public int NumberofSongs()
    {
        try {
            Statement stm = conn.createStatement();
            String query = "SELECT COUNT(PATH) FROM APP.LIST WHERE PLAYLIST = 'Library'"; 
            ResultSet rst = stm.executeQuery(query);
            while(rst.next())
            {
                return rst.getInt("1");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int NumberofSongs(String name)
    {
        try {
            Statement stm = conn.createStatement();
            String query = "SELECT COUNT(PATH) FROM APP.LIST WHERE PLAYLIST = '"+name+"'"; 
            ResultSet rst = stm.executeQuery(query);
            while(rst.next())
            {
                return rst.getInt("1");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    void deletePlaylist(String CurrentPlaylist) {
        System.out.println("Deleting");
        try{
            String sql = "DELETE FROM APP.PLAYLIST WHERE NAME = '"+CurrentPlaylist+"'";
            System.out.println(sql);
            PreparedStatement st=conn.prepareStatement(sql);
            int a = st.executeUpdate();
            System.out.print(a);
            String sql1 = "DELETE FROM APP.LIST WHERE PLAYLIST = '"+CurrentPlaylist+"'";
            System.out.println(sql);
            PreparedStatement st1=conn.prepareStatement(sql1);
            int a1 = st1.executeUpdate();
        }
        catch(SQLException e)
        {
           System.out.println(e.getMessage());
        }
    }

    void delete(String string, String CurrentPlaylist) {
        System.out.println("Deleting");
        try{
            String sql = "DELETE FROM APP.LIST WHERE PATH = '"+string+"' AND PLAYLIST = '"+CurrentPlaylist+"'";

            System.out.println(sql);
            PreparedStatement st=conn.prepareStatement(sql);
            int a = st.executeUpdate();
            System.out.print(a);
        }
        catch(SQLException e)
        {
           System.out.println(e.getMessage());
        }
    }
}
