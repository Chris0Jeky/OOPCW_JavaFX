
package djmusicplayer;

import static djmusicplayer.SongClass.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DJMusicPlayer extends Application {
    
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        
        Stage window = primaryStage;    

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setStyle("-fx-background-color: #cabc9b;");
        Scene scene = new Scene(grid, 1280, 780);
        
        //Add songs to library
        Text scenetitle = new Text("YoYoDJ!");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label addS = new Label("Song to add to library");
        grid.add(addS, 0, 1);
        Button btnSbmtAddSongToLibrary = new Button("Add");
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.CENTER_RIGHT);
        hbBtn1.getChildren().add(btnSbmtAddSongToLibrary);
        grid.add(hbBtn1, 6, 2);
        
        Label nameL = new Label("Title");
        grid.add(nameL, 0, 2);
        TextField nameLTF = new TextField();
        grid.add(nameLTF, 1, 2);
        Label songN = new Label("Artist");
        grid.add(songN, 2, 2);
        TextField songNTFF = new TextField();
        grid.add(songNTFF, 3, 2);
        Label dur = new Label("duration (double number)");
        grid.add(dur, 4, 2);
        TextField durTF = new TextField();
        grid.add(durTF, 5, 2);
        
        Label addS2 = new Label("Root Folder to add songs from, to library");
        grid.add(addS2, 0, 3);
        Button btnSbmtAddSongToLibrary2 = new Button("Add");
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.CENTER_RIGHT);
        hbBtn2.getChildren().add(btnSbmtAddSongToLibrary2);
        grid.add(hbBtn2, 2, 3);

        TextField addS2TF = new TextField();
        grid.add(addS2TF, 1, 3);
        
        
        //Search Songs
        Label srchByArtN = new Label("Search a song in the library by artist name");
        grid.add(srchByArtN, 0, 4);
        Button srch1 = new Button("Search");
        HBox hbBtn3 = new HBox(10);
        hbBtn3.setAlignment(Pos.CENTER_RIGHT);
        hbBtn3.getChildren().add(srch1);
        grid.add(hbBtn3, 2, 4);

        TextField srchTF = new TextField();
        grid.add(srchTF, 1, 4);
        
        //add to playlist
        Label addToPlst1 = new Label("Add a song to the Playlist, by its name or Artist");
        grid.add(addToPlst1, 0, 5);
        Button addToPlst11 = new Button("Add");
        HBox hbBtn4 = new HBox(10);
        hbBtn4.setAlignment(Pos.CENTER_RIGHT);
        hbBtn4.getChildren().add(addToPlst11);
        grid.add(hbBtn4, 2, 5);

        TextField addTF1 = new TextField();
        grid.add(addTF1, 1, 5);
        
        Label addToPlst2 = new Label("Add a song to the Playlist, by its name or Artist");
        grid.add(addToPlst2, 0, 6);
        Label addToPlst21 = new Label("And select a position");
        grid.add(addToPlst21, 2, 6);
        Button addToPlst12 = new Button("Add");
        HBox hbBtn5 = new HBox(10);
        hbBtn5.setAlignment(Pos.CENTER_RIGHT);
        hbBtn5.getChildren().add(addToPlst12);
        grid.add(hbBtn5, 4, 6);

        TextField addTF2 = new TextField();
        grid.add(addTF2, 1, 6);
        TextField addTF21 = new TextField();
        grid.add(addTF21, 3, 6);
        
        Label reorder1 = new Label("Re-allocate song at index (can accept artist name too): ");
        grid.add(reorder1, 0, 7);
        Label reorder2 = new Label("And select a position");
        grid.add(reorder2, 2, 7);
        Button btnReo1 = new Button("reorder");
        HBox btnReo10 = new HBox(10);
        btnReo10.setAlignment(Pos.CENTER_RIGHT);
        btnReo10.getChildren().add(btnReo1);
        grid.add(btnReo10, 4, 7);

        TextField reoTF1 = new TextField();
        grid.add(reoTF1, 1, 7);
        TextField reoTF2 = new TextField();
        grid.add(reoTF2, 3, 7);
        
        Label remove = new Label("Remove song from Playlist by artist name");
        grid.add(remove, 0, 8);
        Button rmvBtn = new Button("REMOVE");
        HBox rmvBtn01 = new HBox(10);
        rmvBtn01.setAlignment(Pos.CENTER_RIGHT);
        rmvBtn01.getChildren().add(rmvBtn);
        grid.add(rmvBtn01, 2, 8);

        TextField rmvTF = new TextField();
        grid.add(rmvTF, 1, 8);
        
        //NEXT button
        Button next = new Button("Play Next Song");
        HBox hbBtn001 = new HBox(10);
        hbBtn001.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn001.getChildren().add(next);
        grid.add(hbBtn001, 1, 10);
        
        Button stop = new Button("Stop Music");
        HBox hbBtn002 = new HBox(10);
        hbBtn002.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn002.getChildren().add(stop);
        grid.add(hbBtn002, 2, 10);
        
        //Retrieve info from Playlist
        Button rtrvPlst = new Button("Retrieve Playlist");
        HBox hbBtn01 = new HBox(10);
        hbBtn01.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn01.getChildren().add(rtrvPlst);
        grid.add(hbBtn01, 0, 10);
        
        Text actiontarget = new Text();
        grid.add(actiontarget, 0, 11);
        
        next.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent e) {
                if (playlist.isEmpty()){
                     actiontarget.setText("Try adding some music to the playlist first!");                           
                }
                
                else {
                
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Now playing: " + playlist.get(0).getFullView());
                    play(0);
                    playNextSong();
                
                }
            }
        });
        
        stop.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Music player action aborted");
                play(1);
            }
        });
        
        rtrvPlst.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                String display = new String();
                for (int i = 0; i < playlist.size(); i++) {
                
                    display = display + "\n" + playlist.get(i).getFullView();
                
                }
                actiontarget.setText(display);
            }
        });
        
        btnSbmtAddSongToLibrary.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent e) {
                
                actiontarget.setFill(Color.FIREBRICK);
                SongClass.addSongToLibrary(nameLTF.getText(), songNTFF.getText() ,  Double.parseDouble(durTF.getText()) , ".mp3");
                System.out.println(songNTFF.getText());
                actiontarget.setText(songNTFF.getText() + ".mp3 from " + nameLTF.getText() + ", duration: " + durTF.getText() + " minute(s) has been added to the library!");
                
            }
        });
        
        btnSbmtAddSongToLibrary2.setOnAction(new EventHandler<ActionEvent>() {
        
            @Override
            public void handle (ActionEvent e) {
                
                actiontarget.setFill(Color.FIREBRICK);
                try {
                    getAllSongs(addS2TF.getText());
                    actiontarget.setText("Library Updated with the songs from the file!");
                } catch (FileNotFoundException | MalformedURLException ex) {
                    actiontarget.setText("try: dj_sample_song_data");
                    Logger.getLogger(DJMusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
            }
        });
        
        srch1.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                String bogus = searchSongInLibraryByArtist(srchTF.getText()).getFullView();
                actiontarget.setText(bogus);
            }
        });
        
        addToPlst11.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent e) {
                
                int i = 0;
                actiontarget.setFill(Color.FIREBRICK);
                i = addSongToPlaylist(addTF1.getText());
                if(i == 0) {
                    actiontarget.setText("There are no songs matching this criteria");
                }
                else if (i == 1) {
                
                    SongClass bogus = retrieveSongFromPlaylistByIndex(0);
                    String str = bogus.getFullView();
                    actiontarget.setText(str + " added!");
                    
                }
                
                else if (i == 2){
            
                    SongClass bogus = retrieveSongFromPlaylistByIndex((playlist.size() - 1));
                    String str = bogus.getFullView();
                    actiontarget.setText(str + " added!");
            
                }
            }
        });
        
        addToPlst12.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent e) {
                
                int i = 0;
                actiontarget.setFill(Color.FIREBRICK);
                i = addSongToPlaylistAtPosition(addTF2.getText(), Integer.parseInt(addTF21.getText()));
                if(i == 0) {
                    actiontarget.setText("There are no songs matching this criteria");
                }
                else if (i == 1) {
                
                    SongClass bogus = retrieveSongFromPlaylistByIndex(0);
                    String str = bogus.getFullView();
                    actiontarget.setText(str + " added!");
                    
                }
                
                else if (i == 2){
            
                    SongClass bogus = retrieveSongFromPlaylistByIndex((playlist.size() - 1));
                    String str = bogus.getFullView();
                    actiontarget.setText(str + " added!");
            
                }
                
                else if (i == 3){
                
                    SongClass bogus = retrieveSongFromPlaylistByIndex(Integer.parseInt(addTF21.getText()));
                    String str = bogus.getFullView();
                    actiontarget.setText(str + " added!");
                
                }
            }
        });
        
        btnReo1.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Song reallocated!");
                if ((int)Integer.parseInt(reoTF1.getText()) == Integer.parseInt(reoTF1.getText()) && (int)Integer.parseInt(reoTF2.getText()) == Integer.parseInt(reoTF2.getText())) {
                reorderSongsInPlaylistByPosition(Integer.parseInt(reoTF1.getText()), Integer.parseInt(reoTF2.getText()));
                }
                else if ((int)Integer.parseInt(reoTF2.getText()) == Integer.parseInt(reoTF2.getText())) {
                reorderSongsInPlaylistBySelectingArtist(reoTF1.getText(), Integer.parseInt(reoTF2.getText()));
                actiontarget.setText("Song reallocated!");
                }
            }
        });
        
        rmvBtn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                removeSongFromPlaylistByArtist(rmvTF.getText());
                actiontarget.setText("Song Removed!");
            }
        });
        
        window.setTitle("Hello World!");
        window.setScene(scene);
        window.show();
        
    }
    
     private static void play(int i) {
         
         String path = DJMusicPlayer.class.getResource("test.mp3").toString();
         Media media = new Media(path);
         MediaPlayer mp = new MediaPlayer(media);
         mp.play();
         
         if (i == 1) {
             mp.stop();
         }        
    }

    public static void main(String[] args) {
        launch(args);        
    }
    
    public static ArrayList<String[]> createFileFromExtFile(String fileName) throws FileNotFoundException, MalformedURLException {
    
        File file = new File(GetPath(fileName));
        Scanner scan = new Scanner(file);
        ArrayList<String[]> musicPara = new ArrayList<>();

        while(scan.hasNextLine()) {
            
            String allParameters = scan.nextLine();
            String[] parameters = allParameters.split("\t");
            String songTitle = parameters[0];
            String artist = parameters[1];
            double playTime = Double.parseDouble(parameters[2]);
            String mp3FileName = parameters[3];
            musicPara.add(parameters);
            
        }
        return(musicPara);
    }
    
    public static String GetPath(String fileName) throws FileNotFoundException {
        
        File file = new File(fileName);
        return file.getAbsolutePath();     
                
    }
    
     public static void getAllSongs(String fileName) throws FileNotFoundException, MalformedURLException {
       
        ArrayList<String[]> songs;
        songs = DJMusicPlayer.createFileFromExtFile(fileName);  
        
        for (int i = 0; i < songs.size(); i++) {
            addSongToLibrary(songs.get(i)[0],
                                       songs.get(i)[1],
                                       Double.parseDouble(songs.get(i)[2]),
                                       songs.get(i)[3]);
            
          }
       }
}
