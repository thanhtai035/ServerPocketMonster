/*
  RMIT University Vietnam
  Course: INTE2512 Object-Oriented Programming
  Semester: 2020B
  Assessment: Final Project
  Created date: 23/09/2020
  By: Le Thanh Tai (s3760615)
  Last modified: 23/09/2020 (21:55)
  By: Le Hoang Cat (s3790029)
  Acknowledgement:
  1. Pokemon SFX Gen7: Sun, Moon, Ultra Sun, Ultra Moon – Attack Sound: https://www.youtube.com/watch?v=edWTFEZe0FY
The link above was used to trim out the sound effect of the monsters’ moves in the game.
2. Pokemon Sword and Shield – Pokemon Center Healing Theme Sound Effect [Free Ringtone Download]:
https://www.youtube.com/watch?v=jto28Ffl4sc&list=PLJK5OsJ44ut6V4F3ktt-AEq6i_UP2O3Gz
3. Sound Effects–Pokemon Anime(#8): Pokemon Return:
https://www.youtube.com/watch?v=OORDWT89XI8&list=PLJK5OsJ44ut6V4F3ktt-AEq6i_UP2O3Gz&index=6
4. Sound Effects-Pokemon Anime(#7): Pokemon Out:
https://www.youtube.com/watch?v=WVNDyQlJJXc&list=PLJK5OsJ44ut6V4F3ktt-AEq6i_UP2O3Gz&index=7
5. Pokemon Healing Sound(Sun/Moon)
https://www.youtube.com/watch?v=g33Rw8IFUZY&list=PLJK5OsJ44ut6V4F3ktt-AEq6i_UP2O3Gz&index=12
The link 2 to 5 was used to create other sound effects for the game.
6. Pokemon Database:
https://pokemondb.net/
This site was used for the image, gif of the monsters in the game. Furthermore, info about the monsters, elements system, items and skills from the game were inspired from this site.
7. Pokeli:
https://www.youtube.com/channel/UC2ccJMFWSbjklOQESSBP_dw
This is a link to a youtuber who extract sound tracks from the original games, we used music made by him on this channel.
8. WallpaperVortex.com
https://www.wallpapervortex.com/
The majority of the background image used in the game was found on this site.
9. Pokemon HD Wallpapers:
https://wallpaperaccess.com/pokemon-hd
	The background images used in the game was found on the websites in link 8 and 9.
10. PhoenixOfLight92:
https://www.deviantart.com/phoenixoflight92
The battle background images used in the game was found on this website.
11. DevianArt:
https://www.deviantart.com/
12. GoogleImage:
https://images.google.com/
The in-game move sprites and gifs were found on the 2 websites in link 11 and 12. They were mostly taken from open-sources links.
*/
package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Random;

public class StartController {
    public Label connectionLabel;
    public Button changeLanguage;
    public Button random;
    public Button normal;
    public MediaView media;
    public MediaView click;

    private Socket socket;
    private DataOutputStream output;
    private DataInputStream input;
    ServerSocket ss;

    boolean eng = true;

    public StartController() {
    }

    @FXML
    public void initialize() {
        media.getMediaPlayer().setAutoPlay(true);
    }
// Method to switch to random scene
    public void randomButton(ActionEvent actionEvent) throws Exception{
        click.getMediaPlayer().stop();
        click.getMediaPlayer().play();
        try {
            ss=new ServerSocket(3333);
            socket = ss.accept();
            System.out.println("Connected");
            input = new DataInputStream(socket.getInputStream());
            output =new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
               connectionLabel.toFront(); return;}

        media.getMediaPlayer().stop();
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/RandomMode.fxml"));
        Parent root = fxmlLoader.load();

        RandomController randomController = fxmlLoader.getController();
        randomController.setData(eng, input, output, socket, ss);
        Scene scene = new Scene(root);

        window.setScene(scene);
        window.show();
    }
// Method to switch to normal scene
    public void normalButton(ActionEvent actionEvent) throws Exception{
        click.getMediaPlayer().stop();
        click.getMediaPlayer().play();
        try {
            ss=new ServerSocket(3334);
            socket = ss.accept();
            System.out.println("Connected");
            input = new DataInputStream(socket.getInputStream());
            output =new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            connectionLabel.toFront(); return;}

        media.getMediaPlayer().stop();
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/NormalMode.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        NormalController normalController = fxmlLoader.getController();
        normalController.setData(eng, input, output, socket, ss);

        window.setScene(scene);
        window.show();
    }
// Change language button
    public void EngVi(ActionEvent actionEvent) {
        if (eng) {
            eng = false;
            changeLanguage.setText("ENG");
            normal.setText("THƯỜNG");
            random.setText("NGẪU NHIÊN");
            connectionLabel.setText("KHÔNG TÌM THẤY PHÒNG");

        } else {
            eng = true;
            changeLanguage.setText("VI");
            normal.setText("NORMAL");
            random.setText("RANDOM");
            connectionLabel.setText("NO ROOM FOUND");
        }
    }
}
