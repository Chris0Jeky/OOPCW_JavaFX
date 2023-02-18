package djmusicplayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class SongClass {
    
        private static HashMap<String, Object> library = new HashMap<>();
        static ArrayList<SongClass> playlist = new ArrayList<>();
        private static HashMap<String, SongClass> playlistHashed = new HashMap<>();
    
        private String songTitle;
        private String artist;
        private double playTime;
        private String mp3FileName;
        
        public SongClass(String songTitle,
                      String artist,
                      double playTime,
                      String mp3FileName){
            
        this.songTitle = songTitle;
        this.artist = artist;
        this.playTime = playTime;
        this.mp3FileName = mp3FileName;
    }      
       
       public SongClass() {
            throw new UnsupportedOperationException("Not supported yet."); 
       }
        
       public String getSongTitle(){
        return songTitle;
       }
       
       public String getArtist() {
        return artist;
       }
       
       public double getPlayTime() {
        return playTime;
       }
       
       public String getMp3FileNam() {
        return mp3FileName;
       }
       
       public String getFullView() {
           
           String info = this.getSongTitle() + " " + this.getArtist() + " " + this.getPlayTime() + " " + this.getMp3FileNam();
           return info;
       
       }
 
       public static SongClass createSongObject(String sT,String a,double pT,String mp3) {
       
           return(new SongClass(sT, a, pT, mp3));
       
       }
       
    public static void addSongToLibrary(String sT,String a,double pT,String mp3) {
           
           SongClass newSong = createSongObject(sT, a, pT, mp3);
           library.put(newSong.artist, newSong); 
       
       }
    
    public static SongClass searchSongInLibraryByArtist(String artist){
        return (SongClass) library.get(artist);
    }
    
    public static int addSongToPlaylist(String artist) {
            
            int i = 0;
            if(library.containsKey(artist)) {
            
                if (playlist.isEmpty()) {
                    playlist.add((SongClass) library.get(artist));
                    playlistHashed.put(artist, (SongClass) library.get(artist));
                    i = 1;
                  }
                    else {
                    playlist.add((playlist.size() - 1),(SongClass) library.get(artist));
                    playlistHashed.put(artist, (SongClass) library.get(artist));
                    i = 2;
                  }
                
            }
            return i;
    }     
       
    public static int addSongToPlaylistAtPosition(String artist, int position) {        
            int i = 0;
            if(library.containsKey(artist)) {
            
                if (playlist.isEmpty()) {
                    playlist.add(0, (SongClass) library.get(artist));
                    playlistHashed.put(artist, (SongClass) library.get(artist));
                    i = 1;
                  }
                else if ((playlist.size() - 1) < position){
                    playlist.add((playlist.size() - 1),(SongClass) library.get(artist));
                    playlistHashed.put(artist, (SongClass) library.get(artist));
                    i = 2;
                  }
                else {
                
                    playlist.add(position,(SongClass) library.get(artist));
                    playlistHashed.put(artist, (SongClass) library.get(artist));
                    i = 3;
                
                }
                
            }
            return i;
    }
    
    public static void playNextSong() {
    
        playlistHashed.remove(playlist.get(0).artist);
        playlist.remove(0);
    
    }
    
    public static void hashPlaylist() {
    
        for(int i = 0; i<playlist.size(); i++) {
        
            String hashKey = playlist.get(i).artist;
            SongClass objectToAdd = playlist.get(i);
            playlistHashed.put(hashKey, objectToAdd);
            
        }
    }
    
    public static ArrayList<SongClass> retrievePlaylist() {    
        return playlist;
    }
    
    public static SongClass retrieveSongFromPlaylistByIndex(int position) {
        return playlist.get(position);
    }
    
    public static SongClass retrieveSongFromPlaylistByArtist(String artist) {
        return playlistHashed.get(artist);
    }
    
    public static void reorderSongsInPlaylistByPosition(int fromPosition, int toPosition) {
    
        SongClass item = playlist.get(fromPosition);
        playlist.remove(fromPosition);
        playlist.add(toPosition, item);
    
    }
    
    public static void reorderSongsInPlaylistBySelectingArtist(String artist, int toPosition) {
    
        for (int i = 0; i<playlist.size(); i++) {
        
            if (artist.equals(playlist.get(i).artist)) {
            
                i = playlist.size();
                SongClass item = playlist.get(i);
                playlist.remove(i);
                playlist.add(toPosition, item);
            
            }
        }
    }
    
    public static void removeSongFromPlaylistByPosition(int position) {
    
        playlist.remove(position);
        playlistHashed.remove(playlist.get(position).artist);
    
    }
    
    public static void removeSongFromPlaylistByArtist(String artist) {
    
        for (int i = 0; i<playlist.size(); i++) {
        
            if (artist.equals(playlist.get(i).artist)) {
            
                i = playlist.size();
                playlist.remove(i);
                playlistHashed.remove(artist);
                
            }
        }
    }
}
