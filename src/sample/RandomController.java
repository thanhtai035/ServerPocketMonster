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

import Monster.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class RandomController {
    public ImageView Pic1;
    public ImageView Pic3;
    public ImageView Pic2;
    public ImageView curPic;
    public Label NameField;
    public Label FactionField;
    public Label InforField;
    public Label StartButton;
    public Button changeLanguage;
    public Label attackField;
    public Label defField;
    public Label hpFIeld;
    public MediaView media;
    public MediaView startMedia;

    boolean eng;

    DataOutputStream output;
    DataInputStream input;
    Socket socket;
    ServerSocket ss;

    PocketMonster[] monsterList = { new Aagron(), new Bisharp(), new Stunfisk(), new Empoleon(), new Milotic(), new Swampert(), new MowRotom(), new Venusaur(), new Roserade(), new Charizard(), new Macargo(), new Darmanitan(), new Excadrill(), new Hyperior(), new Garchomp()};
    PocketMonster[] monsters = new PocketMonster[3];
    Integer[] pos = new Integer[3];

// initialize method
    @FXML
    public void initialize() {
        media.getMediaPlayer().setAutoPlay(true);
        random();

        curPic.setImage(monsters[0].getCurImage());
        NameField.setText(monsters[0].getName());
        InforField.setText(monsters[0].getAtk() + "\n" + monsters[0].getDef() + "\n" + monsters[0].getMaxHealth());
        FactionField.setText(monsters[0].getElement());
        Pic1.setImage(monsters[0].getCurImage());
        Pic2.setImage(monsters[1].getCurImage());
        Pic3.setImage(monsters[2].getCurImage());
    }
// Click monster image method
    public void clickPick1(MouseEvent mouseEvent) {
        curPic.setImage(monsters[0].getCurImage());
        NameField.setText(monsters[0].getName());
        InforField.setText(monsters[0].getAtk() + "\n" + monsters[0].getDef() + "\n" + monsters[0].getMaxHealth());
        FactionField.setText(monsters[0].getElement());
    }

    public void clickPic3(MouseEvent mouseEvent) throws Exception {
        curPic.setImage(monsters[2].getCurImage());
        NameField.setText(monsters[2].getName());
        InforField.setText(monsters[2].getAtk() + "\n" + monsters[2].getDef() + "\n" + monsters[2].getMaxHealth());
        FactionField.setText(monsters[2].getElement());
    }

    public void clickPic2(MouseEvent mouseEvent) {
        curPic.setImage(monsters[1].getCurImage());
        NameField.setText(monsters[1].getName());
        InforField.setText(monsters[1].getAtk() + "\n" + monsters[0].getDef() + "\n" + monsters[0].getMaxHealth());
        FactionField.setText(monsters[1].getElement());
    }
// click start method
    public void onStartClicked(MouseEvent mouseEvent) throws Exception {
        media.getMediaPlayer().stop();
        startMedia.getMediaPlayer().play();
        Stage window = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        window.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/BattlePhase.fxml"));
        Parent root = fxmlLoader.load();

        BattleController battleController = fxmlLoader.getController();
        battleController.setData(eng, input, output, socket, monsters, pos, ss);
        Scene scene = new Scene(root);

        window.setScene(scene);
        window.show();
    }
// change language method
    public void EngVi(ActionEvent actionEvent) {
        if (eng) {
            eng = false;
            changeLanguage.setText("Eng");
            attackField.setText("Tấn công:");
            defField.setText("Phòng thủ:");
            StartButton.setText("Bắt đầu");
        } else {
            eng = true;
            changeLanguage.setText("VI");
            attackField.setText("Attack:");
            defField.setText("DEF:");
            StartButton.setText("START");
        }
    }
// share data method
  public void setData(boolean lang, DataInputStream in, DataOutputStream out, Socket s, ServerSocket serverSocket) {
        eng = lang;
      if (!eng) {
          changeLanguage.setText("Eng");
          attackField.setText("Tấn công:");
          defField.setText("Phòng thủ:");
          StartButton.setText("Bắt đầu");
      }
        ss = serverSocket;
        input = in;
        output = out;
        socket = s;
    }

    public void random() {
        Random randi = new Random();
        for (int i = 0; i < 3; i++) {
            int num =randi.nextInt(14);
            monsters[i] = monsterList[num];
            pos[i] = num;
        }
    }
}
