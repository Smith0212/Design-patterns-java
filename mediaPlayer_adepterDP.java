// Target interface
interface MediaPlayer {
    public void play(String audioType, String fileName);
 }
 
 // Adaptee interface
 interface AdvancedMediaPlayer {
    public void playVlc(String fileName);
    public void playMp4(String fileName);
 }
 
 // Adaptee class
 class VlcPlayer implements AdvancedMediaPlayer{
    public void playVlc(String fileName) {
       System.out.println("Playing vlc file. Name: "+ fileName);        
    }
    public void playMp4(String fileName) {
       // do nothing
    }
 }
 
 // Adaptee class
 class Mp4Player implements AdvancedMediaPlayer{
    public void playVlc(String fileName) {
       // do nothing
    }
    public void playMp4(String fileName) {
       System.out.println("Playing mp4 file. Name: "+ fileName);        
    }
 }
 
 // Adapter class
 class MediaAdapter implements MediaPlayer {
 
    AdvancedMediaPlayer advancedMusicPlayer;
 
    public MediaAdapter(String audioType){
       if(audioType.equalsIgnoreCase("vlc") ){
          advancedMusicPlayer = new VlcPlayer();            
       } else if (audioType.equalsIgnoreCase("mp4")){
          advancedMusicPlayer = new Mp4Player();
       }  
    }
 
    public void play(String audioType, String fileName) {
       if(audioType.equalsIgnoreCase("vlc")){
          advancedMusicPlayer.playVlc(fileName);
       }else if(audioType.equalsIgnoreCase("mp4")){
          advancedMusicPlayer.playMp4(fileName);
       }
    }
 }
 
 // Client class
 class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter; 
 
    public void play(String audioType, String fileName) {    
       // Built-in support to play mp3 music files
       if(audioType.equalsIgnoreCase("mp3")){
          System.out.println("Playing mp3 file. Name: "+ fileName);            
       } 
       // MediaAdapter provides support to play other file formats
       else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")){
          mediaAdapter = new MediaAdapter(audioType);
          mediaAdapter.play(audioType, fileName);
       }
       else{
          System.out.println("Invalid media. " + audioType + " format not supported");
       }
    }
 }
 
 // Example usage
 public class main {
    public static void mediaPlayer_adepterDP(String[] args) {
       AudioPlayer audioPlayer = new AudioPlayer();
 
       audioPlayer.play("mp3", "beyond the horizon.mp3");
       audioPlayer.play("mp4", "alone.mp4");
       audioPlayer.play("vlc", "far far away.vlc");
       audioPlayer.play("avi", "mind me.avi");
    }
 }
 