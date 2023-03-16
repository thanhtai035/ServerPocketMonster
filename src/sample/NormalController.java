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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class NormalController {

    public Button changeLanguage;
    public ImageView curPic;
    public Label NameField;
    public Label FactionField;
    public Label InforField;
    public ImageView Line1;
    public ImageView Line2;
    public ImageView Line3;
    public Label attackField;
    public Label defField;
    public Label ChooseButton;
    public Label OffButton;
    public Label StartButton;
    public MediaView media;
    public MediaView clickMedia;

    int count = 0;
    boolean eng;

    DataOutputStream output;
    DataInputStream input;
    Socket socket;
    ServerSocket ss;

    PocketMonster[] monsters = { new Aagron(), new Bisharp(), new Stunfisk(), new Empoleon(), new Milotic(), new Swampert(), new MowRotom(), new Venusaur(), new Roserade(), new Charizard(), new Macargo(), new Darmanitan(), new Excadrill(), new Hyperior(), new Garchomp()};
    PocketMonster[] monsterList = new PocketMonster[3];
    PocketMonster curMonster;
    Integer[] pos = new Integer[3];
    int i = 0;
// initialize method
    @FXML
    public void initialize() {
        media.getMediaPlayer().setAutoPlay(true);
        curMonster = monsters[0];
        curPic.setImage(monsters[0].getCurImage());
        NameField.setText(monsters[0].getName());
        InforField.setText(monsters[0].getAtk() + "\n" + monsters[0].getDef() + "\n" + monsters[0].getMaxHealth());
        FactionField.setText(monsters[0].getElement());
    }
// Click monster select images
    public void Pic1(MouseEvent mouseEvent) {
        clickMonster(0);
    }

    public void Pic2(MouseEvent mouseEvent) {
        clickMonster(1);
    }

    public void Pic3(MouseEvent mouseEvent) {
        clickMonster(2);
    }

    public void Pic4(MouseEvent mouseEvent) {
        clickMonster(3);
    }

    public void Pic5(MouseEvent mouseEvent) {
        clickMonster(4);
    }

    public void Pic6(MouseEvent mouseEvent) {
        clickMonster(5);
    }

    public void Pic7(MouseEvent mouseEvent) {
        clickMonster(6);
    }

    public void Pic8(MouseEvent mouseEvent) {
        clickMonster(7);
    }

    public void Pic9(MouseEvent mouseEvent) {
        clickMonster(8);
    }

    public void Pic10(MouseEvent mouseEvent) {
        clickMonster(9);
    }

    public void Pic11(MouseEvent mouseEvent) {
        clickMonster(10);
    }

    public void Pic12(MouseEvent mouseEvent) {
        clickMonster(11);
    }

    public void Pic13(MouseEvent mouseEvent) {
        clickMonster(12);
    }

    public void Pic14(MouseEvent mouseEvent) {
        clickMonster(13);
    }

    public void Pic15(MouseEvent mouseEvent) {
        clickMonster(14);
    }
// Click start button method
    public void StartClicked(MouseEvent mouseEvent) throws Exception{
        if (count == 3) {
            media.getMediaPlayer().stop();
            clickMedia.getMediaPlayer().stop();
            clickMedia.getMediaPlayer().play();
            Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            window.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/BattlePhase.fxml"));
            Parent root = fxmlLoader.load();

            BattleController battleController = fxmlLoader.getController();
            battleController.setData(eng, input, output, socket, monsterList, pos, ss);
            Scene scene = new Scene(root);

            window.setScene(scene);
            window.show();
        }
    }
// Choose monster button
    public void ChooseClicked(MouseEvent mouseEvent) {
        if (count <= 2) {
            monsterList[count] = curMonster;
            pos[count] = i;
            if (count == 0)
                Line1.setImage(monsterList[count].getCurImage());
            else if (count == 1)
                Line2.setImage(monsterList[count].getCurImage());
            else
                Line3.setImage(monsterList[count].getCurImage());
            count++;
        }
    }
// Take off monster button
    public void OffClicked(MouseEvent mouseEvent) {
        if (count != 0) {
            if (count == 1)
                Line1.setImage(null);
            else if (count == 2)
                Line2.setImage(null);
            else
                Line3.setImage(null);
            count--;
            monsterList[count] = null;
            pos[count] = 0;
        }
    }
// Change language button
    public void EngVi(ActionEvent actionEvent) {
        if (eng) {
            eng = false;
            changeLanguage.setText("Eng");
            attackField.setText("Tấn công:");
            defField.setText("Phòng thủ:");
            StartButton.setText("Bắt đầu");
            OffButton.setText("LẤY RA");
            ChooseButton.setText("CHỌN");
        } else {
            eng = true;
            changeLanguage.setText("VI");
            attackField.setText("Attack:");
            defField.setText("DEF:");
            StartButton.setText("START");
            OffButton.setText("OFF");
            ChooseButton.setText("CHOOSE");
        }
    }
// Set the data from previous scene
    public void setData(boolean lang, DataInputStream in, DataOutputStream out, Socket s, ServerSocket serverSocket) {
        eng = lang;
        ss = serverSocket;
        input = in;
        output = out;
        socket = s;
        if (!eng) {
            changeLanguage.setText("Eng");
            attackField.setText("Tấn công:");
            defField.setText("Phòng thủ:");
            StartButton.setText("Bắt đầu");
            OffButton.setText("LẤY RA");
            ChooseButton.setText("CHỌN");
        }
    }

    public void clickMonster(int num) {
        curPic.setImage(monsters[num].getCurImage());
        NameField.setText(monsters[num].getName());
        InforField.setText(monsters[num].getAtk() + "\n" + monsters[0].getDef() + "\n" + monsters[0].getMaxHealth());
        FactionField.setText(monsters[num].getElement());
        curMonster = monsters[num];
        i = num;
    }
}
