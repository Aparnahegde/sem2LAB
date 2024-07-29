package lab4;

interface MediaPlayer{
	void play(String audioType,String fileName);
}

interface AdvancedMediaPlayer{
	void playVlc(String fileName);
	void playMp4(String fileName);
}
class VlcPlayer implements AdvancedMediaPlayer{
	public void playVlc(String fileName) {
		System.out.println("Paying vlc file Name : "+fileName);
		}
	public void playMp4(String fileName) {
		System.out.println("Paying mp4 file Name : "+fileName);
		}
}

class Mp4Player implements AdvancedMediaPlayer{
	public void playVlc(String fileName) {
		System.out.println("Paying vlc file Name : "+fileName);
		}
	public void playMp4(String fileName) {
		System.out.println("Paying mp4 file Name : "+fileName);
		}
}
class MediaAdapter implements MediaPlayer{
	AdvancedMediaPlayer  advancedPlayer;
	
	public MediaAdapter(String audioType) {
		if(audioType.equalsIgnoreCase("vlc")) {
			advancedPlayer = new VlcPlayer();
		}
		else {
			advancedPlayer = new Mp4Player();
		}
	}
	
	public void play(String audioType,String fileName) {
		if(audioType.equalsIgnoreCase("vlc")) {
			advancedPlayer.playVlc(fileName);
		}
		else {
			advancedPlayer.playMp4(fileName);
		}
	}
}

class AudioPlayer implements MediaPlayer{
	MediaAdapter mediaAdapter;
	
	public void play(String audioType,String fileName) {
		if(audioType.equalsIgnoreCase("mp3")) {
			System.out.println("Playing mp3 file Name : "+fileName);
		}
		else if(audioType.equalsIgnoreCase("mp4") || audioType.equalsIgnoreCase("vlc")) {
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		}
		else {
			System.out.println("Invalid file format name: "+fileName);
		}
	}
}

public class Audiomain {

	public static void main(String[] args) {
		AudioPlayer audio = new AudioPlayer();
		audio.play("mp4", "abcd");
		audio.play("mp3", "abcd");
		audio.play("vlc", "abcd");
		audio.play("abcd", "abcd");
	}

}
