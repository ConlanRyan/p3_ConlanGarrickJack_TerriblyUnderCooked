import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class playMusic {

	public static String Music = "frenchmusic8bit.mp3";
	public String Current;
	public playMusic(String str) {
		if (str == ("title")) {
			Current = str;
			Music = "frenchmusic8bit.mp3";
		}
		else if(str == ("breakfast")){
			Current = str;
			Music = "";
		}
		else if(str == ("spaghetti")){
			Current = str;
			Music = "";
		}
		else if(str == ("burgers")){
			Current = str;
			Music = "";
		}
		
		
	}
	public static void main(String[] args) {
		try {
			FileInputStream fileInputStream = new FileInputStream(Music);
			Player player = new Player(fileInputStream);
			player.play();
			System.out.println("song is playing");
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (JavaLayerException e) {
				e.printStackTrace();
			}	
	}
	public String getMusic() {
		return Music;
	}
	public String getCurrent() {
		return Current;
	}

}
