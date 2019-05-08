/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;

import java.io.File;
import java.io.PrintStream;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;

/**
 *
 * @author rutviz
 */
public class BasicPlayerTest implements BasicPlayerListener {
    BasicPlayer player;
    BasicController control;
    
    BasicPlayerTest()
    {
        player = new BasicPlayer();
        control = (BasicController) player;
        player.addBasicPlayerListener(this);
    }
   
    public void play(String filename)
    {
        try
        {
            control.open(new File(filename));
            control.play();
        }
        catch (BasicPlayerException e)
        {
          e.printStackTrace();
        }
    }
    
    public void pause()
    {
        try {
            control.pause();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(BasicPlayerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void resume()
    {
        try {
            control.resume();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(BasicPlayerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void stop()
    {
        try {
            control.stop();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(BasicPlayerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setVolume(int volume)
    {
        try 
        {
            control.setGain((float)volume/100);
            System.out.println((float)volume/100+"");
        } catch (BasicPlayerException ex) {
            Logger.getLogger(BasicPlayerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Seek(int sec)
    {
        try {
            control.seek(sec);
        } catch (BasicPlayerException ex) {
            Logger.getLogger(BasicPlayerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     

    public void opened(Object stream, Map properties)
  {
    // Pay attention to properties. It's useful to get duration, 
    // bitrate, channels, even tag such as ID3v2.
//    display("opened : "+properties.toString()); 
  }

  public void progress(int bytesread, long microseconds, byte[] pcmdata, Map properties)
  {
    // Pay attention to properties. It depends on underlying JavaSound SPI
    // MP3SPI provides mp3.equalizer.
    display("progress : "+properties.toString());
  }
  public void stateUpdated(BasicPlayerEvent event)
  {
    // Notification of BasicPlayer states (opened, playing, end of media, ...)
//    display("stateUpdated : "+event.toString());
    if(event.toString().contains("EOM"))
    {
        Home home = new Home();
        home.playNext();
    }
  }
  public void setController(BasicController controller)
  {
//    display("setController : "+controller);
  }

  public void display(String msg)
  {
    System.out.println(msg);
  }
}
