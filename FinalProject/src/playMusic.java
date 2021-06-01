import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class playMusic {
	public static void main(String[] args) {
		
		try {
		FileInputStream fileInputStream = new FileInputStream("frenchmusic8bit.mp3");
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

}
