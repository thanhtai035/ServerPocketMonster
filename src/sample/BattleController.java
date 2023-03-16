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
import MoveList.Move;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Time;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static javafx.animation.PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT;

public class BattleController {
    public Pane waitingPane;
    public Label waitingText;
    public ImageView curMonster;
    public ImageView oppMonster;
    public ImageView BattleBackground;
    public TextArea ChatField;
    public Label curMonsterName;
    public ProgressBar oppHP;
    public ProgressBar curHP;
    public Label oppMonsterName;
    public Label ActionText;
    public Pane SkillPane;
    public Pane ActionPane;
    public Pane ChatPane;
    public Button AttackButton;
    public Button SwitchButton;
    public Button ItemButton;
    public Button ChatButton;
    public Pane UseSkillPane;
    public Label SkillInfo;
    public Pane SkillInfoPane;
    public Button Skill1;
    public Button Skill2;
    public Button Skill3;
    public Button Skill4;
    public Ellipse curChatBox;
    public Ellipse oppChatBox;
    public Label curChat;
    public Label oppChat;
    public Line attackPath;
    public Line oppPath;
    public Button chat1;
    public Button chat2;
    public Button chat3;
    public Button chat4;
    public Pane ItemPane;
    public Button Potion;
    public Button Antidode;
    public Pane ItemInfoPane;
    public Label ItemInfo;
    public Button UseItemButton;
    public Pane SwitchPane;
    public ImageView Switch1;
    public ImageView Switch2;
    public Button changeLanguage;
    public MediaView switchMedia;
    public MediaView media;
    public Button endField;
    public MediaView attackMedia;

    private Button curButton;
    private Move curMove;
    int moveNum = -1;
    private Timeline timeline;
    boolean eng;
    ActionEvent e;


    public DataOutputStream output;
    public DataInputStream input;
    public Socket socket;
    public ServerSocket ss;

    PocketMonster[] monsterList = {new Aagron(), new Bisharp(), new Stunfisk(), new Empoleon(), new Milotic(), new Swampert(), new MowRotom(), new Venusaur(), new Roserade(), new Charizard(), new Macargo(), new Darmanitan(), new Excadrill(), new Hyperior(), new Garchomp()};
    PocketMonster[] monsters = new PocketMonster[3];
    PocketMonster[] oppMonsterList = new PocketMonster[3];
    public Integer[] pos = new Integer[3];

    int oppStatus = 0;
    int curStatus = 0;
    int oppTurn = 0;
    int curTurn = 0;
    int deaths = 0;
    int oppDeaths = 0;
    int potions = 2;
    int antidodes = 2;
    int action = -3 ;
    int lastOpp = -3;

    public BattleController() {
    }
// initialize method
    @FXML
    public void initialize() {
        media.getMediaPlayer().setAutoPlay(true);

    }
// click skil button method
    public void Skill1Button(ActionEvent actionEvent) {
        SkillInfoPane.toFront();
        UseSkillPane.toFront();
        if (curButton != null)
            curButton.setStyle("-fx-background-color: white");
        curButton = Skill1;
        curButton.setStyle("-fx-background-color: yellow");
        curMove = monsters[0].getMove(0);
        if (!eng)
            SkillInfo.setText(curMove.getSkilInfoVN());
        else
            SkillInfo.setText(curMove.getSkillInfoEN());
        moveNum = 0;
    }

    public void Skill2Button(ActionEvent actionEvent) {
        SkillInfoPane.toFront();
        UseSkillPane.toFront();
        if (curButton != null)
            curButton.setStyle("-fx-background-color: white");
        curButton = Skill2;
        curButton.setStyle("-fx-background-color: yellow");
        curMove = monsters[0].getMove(1);
        if (!eng)
            SkillInfo.setText(curMove.getSkilInfoVN());
        else
            SkillInfo.setText(curMove.getSkillInfoEN());
        moveNum = 1;
    }

    public void Skill3Button(ActionEvent actionEvent) {
        SkillInfoPane.toFront();
        UseSkillPane.toFront();
        if (curButton != null)
            curButton.setStyle("-fx-background-color: white");
        curButton = Skill3;
        curButton.setStyle("-fx-background-color: yellow");
        curMove = monsters[0].getMove(2);
        if (!eng)
            SkillInfo.setText(curMove.getSkilInfoVN());
        else
            SkillInfo.setText(curMove.getSkillInfoEN());
        moveNum = 2;
    }

    public void Skill4Button(ActionEvent actionEvent) {
    }
// attack button method
    public void onAttackButton(ActionEvent actionEvent) {
        e = actionEvent;
        SkillPane.toFront();
        ItemInfoPane.toBack();
        AttackButton.setStyle("-fx-background-color: yellow");
        ChatButton.setStyle("-fx-background-color: white");
        ItemButton.setStyle("-fx-background-color: white");
        SwitchButton.setStyle("-fx-background-color: white");
    }
// switch button method
    public void onSwitchButton(ActionEvent actionEvent) {
        if (deaths == 0) {
            Switch1.setImage(monsters[1].getCurImage());
            Switch2.setImage(monsters[2].getCurImage());
        } else if (deaths == 1) {
            Switch1.setImage(monsters[1].getCurImage());
            Switch2.setImage(null);
        } else {
            Switch1.setImage(null);
            Switch2.setImage(null);
        }

        SwitchPane.toFront();
        SwitchButton.setStyle("-fx-background-color: yellow");
        if (curButton != null)
            curButton.setStyle("-fx-background-color: white");
        AttackButton.setStyle("-fx-background-color: white");
        ChatButton.setStyle("-fx-background-color: white");
        ItemButton.setStyle("-fx-background-color: white");
        SkillInfoPane.toBack();
        UseSkillPane.toBack();
        ItemInfoPane.toBack();
        moveNum = -1;
    }
// item button method
    public void onItemButton(ActionEvent actionEvent) {
        ItemPane.toFront();
        ItemButton.setStyle("-fx-background-color: yellow");
        if (curButton != null)
            curButton.setStyle("-fx-background-color: white");
        AttackButton.setStyle("-fx-background-color: white");
        ChatButton.setStyle("-fx-background-color: white");
        SwitchButton.setStyle("-fx-background-color: white");
        SkillInfoPane.toBack();
        UseSkillPane.toBack();
        moveNum = -1;
        SwitchButton.setStyle("-fx-background-color: white");
    }
// chat button method
    public void onChatButton(ActionEvent actionEvent) {
        ChatPane.toFront();
        ChatButton.setStyle("-fx-background-color: yellow");
        if (curButton != null)
            curButton.setStyle("-fx-background-color: white");
        AttackButton.setStyle("-fx-background-color: white");
        ItemButton.setStyle("-fx-background-color: white");
        SwitchButton.setStyle("-fx-background-color: white");
        SkillInfoPane.toBack();
        UseSkillPane.toBack();
        ItemInfoPane.toBack();
        moveNum = -1;
        SwitchButton.setStyle("-fx-background-color: white");
    }
// choose chat method
    public void Chat1Button(ActionEvent actionEvent) {
        curChatBox.setOpacity(1);
        curChat.setText(chat1.getText());
        curChat.setOpacity(1);
        chatOff();
        try {
            output.writeUTF("chat");
            output.flush();
            output.writeUTF(chat1.getText());
            output.flush();
        } catch (Exception e) {}
    }

    public void Chat2Button(ActionEvent actionEvent) {
        curChatBox.setOpacity(1);
        curChat.setText(chat2.getText());
        curChat.setOpacity(1);
        chatOff();
        try {
            output.writeUTF("chat");
            output.flush();
            output.writeUTF(chat2.getText());
            output.flush();
        } catch (Exception e) {}
    }

    public void Chat3Button(ActionEvent actionEvent) {
        curChatBox.setOpacity(1);
        curChat.setText(chat3.getText());
        curChat.setOpacity(1);
        chatOff();
        try {
            output.writeUTF("chat");
            output.flush();
            output.writeUTF(chat3.getText());
            output.flush();
        } catch (Exception e) {}
    }

    public void Chat4Button(ActionEvent actionEvent) {
        curChatBox.setOpacity(1);
        curChat.setText(chat4.getText());
        curChat.setOpacity(1);
        chatOff();
        try {
            output.writeUTF("chat");
            output.flush();
            output.writeUTF(chat4.getText());
            output.flush();
        } catch (Exception e) {}
    }

    public void pressChatField(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            curChatBox.setOpacity(1);
            curChat.setText(ChatField.getText());
            try {
                output.writeUTF("chat");
                output.flush();
                output.writeUTF(ChatField.getText());
                output.flush();
            } catch (Exception e) {}
            ChatField.setText("");
            curChat.setOpacity(1);

            chatOff();
        } else if (ChatField.getText().length() == 25 && keyEvent.getCode() != KeyCode.BACK_SPACE) {
            ChatField.deleteText(24, 25);
        }
    }
// choose to use skill method
    public void YesButtonAction(ActionEvent actionEvent) {
        try {
            attackAction();
            takeEffect();
        } catch (Exception e) {}
        waitSignal();
    }
// chat animation method
    private void chatOff() {
        KeyValue chatAnimation = new KeyValue(curChat.opacityProperty(), 0);
        KeyValue chatBoxAnimation = new KeyValue(curChatBox.opacityProperty(), 0);
        KeyFrame chatFrame = new KeyFrame(Duration.millis(1), chatAnimation, chatBoxAnimation);
        timeline = new Timeline(chatFrame);
        timeline.setCycleCount(1);
        timeline.setDelay(Duration.seconds(5));
        timeline.play();
    }

    private void oppChatOff() {
        KeyValue chatAnimation = new KeyValue(oppChat.opacityProperty(), 0);
        KeyValue chatBoxAnimation = new KeyValue(oppChatBox.opacityProperty(), 0);
        KeyFrame chatFrame = new KeyFrame(Duration.millis(1), chatAnimation, chatBoxAnimation);
        timeline = new Timeline(chatFrame);
        timeline.setCycleCount(1);
        timeline.setDelay(Duration.seconds(5));
        timeline.play();
    }
// share data method
    public void setData(boolean lang, DataInputStream in, DataOutputStream out, Socket s, PocketMonster[] pocketMonsters, Integer[] list, ServerSocket serverSocket) {
        eng = lang;
        if (!eng) {
            changeLanguage.setText("ENG");
            AttackButton.setText("Kĩ Năng");
            ItemButton.setText("Vật phẩm");
            SwitchButton.setText("Đổi");
            ActionText.setText("Hãy chọn hành động của mình");
        }

        ss = serverSocket;
        input = in;
        output = out;
        socket = s;
        monsters = pocketMonsters;
        pos = list;
        waitingPane.toFront();
        waitingText.toFront();
        new Thread(() -> {
            try {
                output.writeUTF(list[0].toString());
                output.writeUTF(list[1].toString());
                output.writeUTF(list[2].toString());
                oppMonsterList[0] = monsterList[Integer.parseInt(input.readUTF())];
                oppMonsterList[1] = monsterList[Integer.parseInt(input.readUTF())];
                oppMonsterList[2] = monsterList[Integer.parseInt(input.readUTF())];

            } catch (Exception e) {}
            Platform.runLater(()
                    -> {
                    oppMonster.setImage(oppMonsterList[0].getOppImage());
                    oppMonsterName.setText(oppMonsterList[0].getName());

            });
            if (oppMonsterList[0].getSpeed() > monsters[0].getSpeed()) {
                waitSignal();
            }
            else {
                Platform.runLater(()
                        -> {
                    waitingPane.toBack();
                    waitingText.toBack();

                });
            }
        }).start();
        curMonster.setImage(monsters[0].getMyImage());
        curMonsterName.setText(monsters[0].getName());
        Skill1.setText(monsters[0].getMove(0).getMoveName());
        Skill2.setText(monsters[0].getMove(1).getMoveName());
        Skill3.setText(monsters[0].getMove(2).getMoveName());
    }

    // execute opponent move
    public void oppMove(String opp) {
        if (opp.equals("0")) {
            lastOpp = 0;
        } else if (opp.equals("-2")) {
            lastOpp = -2;
        }
        else
            if (opp.equals("4")) {
                lastOpp = 4;
                oppMonsterList[0].setCurHealth(-50);
                oppHP.setProgress(oppMonsterList[0].getCurHealth() / oppMonsterList[0].getMaxHealth());
            } else if (opp.equals("5")) {
                lastOpp = 5;
                oppMonsterList[0].upDef();
            } else {
                lastOpp = -1;
                meleeAnimate(false);
                if (curStatus == 0) {
                    if (opp.equals("1")) {
                        curStatus = 1;
                        curTurn = 2;
                        lastOpp = 1;
                    } else if (opp.equals("2")) {
                        lastOpp = 2;
                        curStatus = 2;
                        curTurn = 3;
                    } else if (opp.equals("3")) {
                        lastOpp = 3;
                        curStatus = 2;
                        curTurn = 3;
                    }
                }
            }
        oppActionChange();
    }

    //fighting animate
    public void meleeAnimate(boolean us) {
        attackMedia.getMediaPlayer().stop();
        attackMedia.getMediaPlayer().play();
        if (us) {
            PathTransition melee = new PathTransition(Duration.seconds(1.5), attackPath, curMonster);
            melee.setCycleCount(2);
            melee.setAutoReverse(true);
            melee.play();
            FadeTransition attacked = new FadeTransition(Duration.millis(100), oppMonster);
            attacked.setAutoReverse(true);
            attacked.setCycleCount(8);
            attacked.setFromValue(1);
            attacked.setToValue(0);
            attacked.setDelay(Duration.seconds(1.5));
            attacked.play();
            melee.setOnFinished( e-> {
                if (monsters[0].getCurHealth() <= 0) {
                    replaceMonster();
                    endGame();
                }
                if (oppMonsterList[0].getCurHealth() <= 0) {
                    killMonster();
                    endGame();
                }
            });
        } else {
            PathTransition melee = new PathTransition(Duration.seconds(1.5), oppPath, oppMonster);
            melee.setInterpolator(Interpolator.EASE_OUT);
            melee.setCycleCount(2);
            melee.setAutoReverse(true);
            melee.play();
            FadeTransition attacked = new FadeTransition(Duration.millis(100), curMonster);
            attacked.setAutoReverse(true);
            attacked.setCycleCount(8);
            attacked.setFromValue(1);
            attacked.setToValue(0);
            attacked.setDelay(Duration.seconds(1.5));
            attacked.play();
            Platform.runLater(()
                    -> {
                waitingPane.toFront();
                waitingText.toFront();
            });
            melee.setOnFinished( e-> {
                if (monsters[0].getCurHealth() <= 0) {
                    replaceMonster();
                    endGame();
                }
                if (oppMonsterList[0].getCurHealth() <= 0) {
                    killMonster();
                    endGame();
                }
                Platform.runLater(()
                        -> {
                    waitingPane.toBack();
                    waitingText.toBack();
                });
            });
        }

    }
// change to begin scene
    public void backScene() {
        Platform.runLater(()
        -> {
            ActionPane.toFront();
            UseSkillPane.toBack();
            SkillInfoPane.toBack();
            ItemInfoPane.toBack();
        });
        if (curButton!=null)
            curButton.setStyle("-fx-background-color: white");
        curButton = null;
        curMove = null;
        AttackButton.setStyle("-fx-background-color: white");
        SwitchButton.setStyle("-fx-background-color: white");
        ItemButton.setStyle("-fx-background-color: white");
    }
// execute attack action
    public void attackAction() throws Exception{
        if (curStatus == 1) {
            output.writeUTF("0");
            output.writeUTF("-2");
            action = -2;
        } else {
            Integer result = oppMonsterList[0].getAttacked(monsters[0], moveNum);
            if (result != 0) {
                output.writeUTF(oppMonsterList[0].lastDame.toString());
                if (oppMonsterList[0].getCurHealth() <= 0) {
                    oppHP.setProgress(0);
                } else
                    oppHP.setProgress(oppMonsterList[0].getCurHealth() / oppMonsterList[0].getMaxHealth());
                if (result == -1) {
                    meleeAnimate(true);
                    action = -1;
                } else {
                    oppTurn = 2;
                    oppStatus = result;
                    if (result == 1) {
                        meleeAnimate(true);
                        action = 1;
                    } else if (result == 2) {
                        meleeAnimate(true);
                        action = 2;
                    } else if (result == 4) {
                        curHP.setProgress(monsters[0].getCurHealth() / monsters[0].getMaxHealth());
                        action = 4;
                    } else if (result == 3) {
                        meleeAnimate(true);
                        action = 3;
                    } else {
                        meleeAnimate(true);
                        action = 5;
                    }
                }
            } else {
                output.writeUTF("0");
                action = 0;
            }
            output.writeUTF(result.toString());
            changeVi();
        }
    }
// take effect action
    public void effectAction() {
        if (oppStatus == 2 || oppStatus == 3) {
            oppMonsterList[0].setCurHealth(20);
            if (oppMonsterList[0].getCurHealth() <= 0) {
                oppHP.setProgress(0);
            } else {
                oppHP.setProgress(oppMonsterList[0].getCurHealth() / oppMonsterList[0].getMaxHealth());
                oppTurn--;
                if (oppTurn == 0)
                    oppStatus = 0;
            }
        }
    }

    public void takeEffect() {
        if (curStatus == 0) { }
        else
            if (curStatus != 1) {
            monsters[0].setCurHealth(20);
            if (monsters[0].getCurHealth() < 0) {
                curHP.setProgress(0);
               // replaceMonster();
            } else
                curHP.setProgress(monsters[0].getCurHealth() / monsters[0].getMaxHealth());
        }
        if (curTurn == 0) {
            curStatus = 0;
        } else
            curTurn--;
    }
// change monsters when die
    public void replaceMonster() {
        curTurn = 0;
        curStatus = 0;
        if (deaths == 0) {
            if (monsters[1] != null) {
                monsters[0] = monsters[1];

            }
            if (monsters[2] != null)
                monsters[1] = monsters[2];
            monsters[2] = null;
            curHP.setProgress(monsters[0].getCurHealth() / monsters[0].getMaxHealth());
        } else if (deaths == 1) {
            monsters[0] = monsters[1];
            curHP.setProgress(monsters[0].getCurHealth() / monsters[0].getMaxHealth());
        }

        Platform.runLater(()
                ->
        {
            curMonster.setImage(monsters[0].getMyImage());
            curMonsterName.setText(monsters[0].getName());
            Skill1.setText(monsters[0].getMove(0).getMoveName());
            Skill2.setText(monsters[0].getMove(1).getMoveName());
            Skill3.setText(monsters[0].getMove(2).getMoveName());
        });
        deaths++;
    }

    public void killMonster() {
        oppStatus = 0;
        oppTurn = 0;
        if (oppDeaths == 0) {
            oppMonsterList[0] = oppMonsterList[1];
            oppMonsterList[1] = oppMonsterList[2];
            oppMonsterList[2] = null;
            oppHP.setProgress(oppMonsterList[0].getCurHealth() / oppMonsterList[0].getMaxHealth());
        } else if (oppDeaths == 1) {
            oppMonsterList[0] = oppMonsterList[1];
            oppHP.setProgress(oppMonsterList[0].getCurHealth() / oppMonsterList[0].getMaxHealth());
        }
        oppDeaths++;
        Platform.runLater(()
                ->
        {
            oppMonster.setImage(oppMonsterList[0].getOppImage());
            oppMonsterName.setText(oppMonsterList[0].getName());
        });
    }
// potion button method
    public void PotionButton(ActionEvent actionEvent) {
        ItemInfoPane.toFront();
        if (curButton != null)
            curButton.setStyle("-fx-background-color: white");
        curButton = Potion;
        curButton.setStyle("-fx-background-color: yellow");
        if (!eng) {
            ItemInfo.setText("Hồi phục cho quái thú X " + potions);
        } else
          ItemInfo.setText("Heal the current monster X " + potions);
        moveNum = 5;
    }
// antidode button method
    public void AntidodeButton(ActionEvent actionEvent) {
        ItemInfoPane.toFront();
        if (curButton != null)
            curButton.setStyle("-fx-background-color: white");
        curButton = Antidode;
        curButton.setStyle("-fx-background-color: yellow");
        if (!eng) {
            ItemInfo.setText("Hóa giải hiệu ứng X " + antidodes);
        } else
            ItemInfo.setText("Cure the effect X " + antidodes);
        moveNum = 6;
    }
// item button method
    public void ItemUse(ActionEvent actionEvent) throws Exception{
        if (moveNum == 5) {
            if (potions != 0) {
                monsters[0].potion();
                potions--;
                output.writeUTF("item");
                output.flush();
                monsters[0].potion();
                curHP.setProgress(monsters[0].getCurHealth()/monsters[0].getMaxHealth());
            }
        } else if (moveNum == 6){
            if (antidodes != 0) {
                curStatus = 0;
                curTurn = 0;
                potions--;
            }
        }
        backScene();
    }
// switch monster method
    public void Switch1On(MouseEvent mouseEvent) {
        if (Switch1.getImage()!=null) {
            PocketMonster bufMonster = monsters[0];
            monsters[0] = monsters[1];
            monsters[1] = bufMonster;
            Platform.runLater(()
                    ->
            {
                curMonster.setImage(monsters[0].getMyImage());
                curMonsterName.setText(monsters[0].getName());
                curHP.setProgress(monsters[0].getCurHealth() / monsters[0].getMaxHealth());
            });
            action = 6;
            backScene();
            waitingText.setText("You just changed your monster");
            switchMedia.getMediaPlayer().stop();
            switchMedia.getMediaPlayer().play();
            try {
                output.writeUTF("switch");
                output.flush();
                output.writeUTF("1");
                output.flush();
            } catch (Exception e) {}
            waitSignal();
        }

    }

    public void Switch2On(MouseEvent mouseEvent) {
        if (Switch2.getImage() != null) {
            PocketMonster bufMonster = monsters[0];
            monsters[0] = monsters[2];
            monsters[2] = bufMonster;
            Platform.runLater(()
                    ->
            {
                curMonster.setImage(monsters[0].getMyImage());
                curMonsterName.setText(monsters[0].getName());
                curHP.setProgress(monsters[0].getCurHealth() / monsters[0].getMaxHealth());
            });
            action = 6;
            backScene();
            waitingText.setText("You just changed your monster");
            switchMedia.getMediaPlayer().stop();
            switchMedia.getMediaPlayer().play();
            try {
                output.writeUTF("switch");
                output.flush();
                output.writeUTF("2");
                output.flush();
            } catch (Exception e) {}
            waitSignal();
        }

    }
// wait for opponent signal
    public void waitSignal () {
        endGame();
        backScene();
        Platform.runLater(()
            -> {
                    waitingPane.toFront();
                    waitingText.toFront();
                });
        Platform.runLater(()
            -> changeVi());
        new Thread(() -> {
            while (true) {
                try {
                    String type = input.readUTF();
                    if (type.equals("chat")) {
                        String str = input.readUTF();
                        Platform.runLater(()
                                -> {
                            try {
                                oppChat.setText(str);
                                oppChatBox.setOpacity(1);
                                oppChat.setOpacity(1);
                                oppChatOff();
                            } catch (Exception e) {}
                        });
                        continue;
                    } else if (type.equals("switch")) {
                        String str = input.readUTF();
                        if (str.equals("1")) {
                            PocketMonster bufMonster = oppMonsterList[0];
                            oppMonsterList[0] = oppMonsterList[1];
                            oppMonsterList[1] = bufMonster;
                            Platform.runLater(()
                                    ->
                            {
                                oppMonster.setImage(oppMonsterList[0].getOppImage());
                                oppMonsterName.setText(oppMonsterList[0].getName());
                                oppHP.setProgress(oppMonsterList[0].getCurHealth() / oppMonsterList[0].getMaxHealth());
                            });
                        } else if (str.equals("2")) {
                            PocketMonster bufMonster = oppMonsterList[0];
                            oppMonsterList[0] = oppMonsterList[2];
                            oppMonsterList[2] = bufMonster;
                            Platform.runLater(()
                                    ->
                            {
                                oppMonster.setImage(oppMonsterList[0].getOppImage());
                                oppMonsterName.setText(oppMonsterList[0].getName());
                                oppHP.setProgress(oppMonsterList[0].getCurHealth() / oppMonsterList[0].getMaxHealth());
                            });
                        }
                        switchMedia.getMediaPlayer().stop();
                        switchMedia.getMediaPlayer().play();
                        Platform.runLater(()
                                -> {
                            waitingPane.toBack();
                            waitingText.toBack();
                            ActionPane.toFront();
                            lastOpp = 6;
                            if (!eng) {
                                ActionText.setText("Đối phương vừa đổi quái thủ");
                            } else
                                ActionText.setText("Opponent just changed the monster");
                        });

                        break;
                    } else if (type.equals("item")) {
                        oppMonsterList[0].potion();
                        oppHP.setProgress(oppMonsterList[0].getCurHealth() / oppMonsterList[0].getMaxHealth());
                        continue;
                    }
                    else {
                        monsters[0].setCurHealth(Integer.parseInt(type));
                        monsters[0].lastDame = Integer.parseInt(type);
                        if (monsters[0].getCurHealth() <= 0) {
                            curHP.setProgress(0);
                        } else {
                            curHP.setProgress(monsters[0].getCurHealth() / monsters[0].getMaxHealth());
                        }
                        effectAction();
                        oppMove(input.readUTF());
                        endGame();
                        Platform.runLater(()
                                -> {
                            waitingPane.toBack();
                            waitingText.toBack();
                            ActionPane.toFront();

                        });
                        break;
                    }
                } catch (Exception e) {}
            }
        }).start();
    }
// change opponent message method
    private void changeVi() {
        if (!eng) {
            if (action == -2) {
                waitingText.setText("Quái thú của bạn bị choáng.");
            } else if (action == -1) {
                waitingText.setText("Quái thú của bạn gây: " + oppMonsterList[0].lastDame + " sát thương");
            } else if (action == 0) {
                waitingText.setText("Quái thụ của bạn trượt kĩ năng");
            } else if (action == 1) {
                waitingText.setText("Quái thú của bạn gây " + oppMonsterList[0].lastDame + " sát thương và làm choáng");
            } else if (action == 2) {
                waitingText.setText("Quái thú của bạn gây " + oppMonsterList[0].lastDame + " sát thương và gây đốt");
            } else if (action == 3) {
                waitingText.setText("Quái thú của bạn gây " + oppMonsterList[0].lastDame + " sát thương và phun độc");
            } else if (action == 4) {
                waitingText.setText("Quái thú của bạn hồi phục 50hp");
            } else if (action == 5) {
                waitingText.setText("Quái thú của bạn tăng khả năng phòng thủ");
            } else if (action == 6) {
                waitingText.setText("Bạn vừa đổi quái thú");
            } else if(action == -3) {
                waitingText.setText("Chờ đối thủ");
            }
        }  else {
            if (action == -2) {
                Platform.runLater(()
                        -> {
                    waitingText.setText(monsters[0].getName() + " got stunned");});
            } else if (action == -1) {
                Platform.runLater(()
                        -> {
                    waitingText.setText(monsters[0].getName() + " deals " + oppMonsterList[0].lastDame + " hp");
                    action = -1;
                });
            } else if (action == 0) {
                Platform.runLater(()
                        ->
                        waitingText.setText(monsters[0].getName() + " missed the attack"));
            } else if (action == 1) {
                Platform.runLater(()
                        -> {
                    waitingText.setText(monsters[0].getName() + " deals " + oppMonsterList[0].lastDame + " hp and applies stun effect");
                });
            } else if (action == 2) {
                Platform.runLater(()
                        ->
                        waitingText.setText(monsters[0].getName() + " deals " + oppMonsterList[0].lastDame + " hp and applies burn effect"));
            } else if (action == 3) {
                Platform.runLater(()
                        ->
                        waitingText.setText(monsters[0].getName() + " deals " + oppMonsterList[0].lastDame + " hp and applies poison effect"));
            } else if (action == 4) {
                Platform.runLater(()
                        ->
                        waitingText.setText(monsters[0].getName() + " heals itself 50hp"));
            } else if (action == 5) {
                Platform.runLater(()
                        ->
                        waitingText.setText(monsters[0].getName() + " increases its def by 20"));
            } else if (action == 6) {
                waitingText.setText("You just changed your monster");
            } else if (action == -3) {
                waitingText.setText("Waiting for opponent.");
            }
        }
    }
//change language methoad
    public void EngVi(ActionEvent actionEvent) {
        if (eng) {
            eng = false;
            changeLanguage.setText("Eng");
            AttackButton.setText("Kĩ Năng");
            ItemButton.setText("Vật phẩm");
            SwitchButton.setText("Đổi");
            chat1.setText("Chào!!!");
            chat2.setText("Bạn Khỏe Không?");
            chat3.setText("Quái thú của tớ rát mạnh !!!");
            chat4.setText("Chơi hay lắm");
            UseItemButton.setText("Dùng");
            changeVi();
            oppActionChange();
            if (moveNum == 1 || moveNum == 2 || moveNum == 3) {
                Platform.runLater(()
                        -> {
                    SkillInfo.setText(monsters[0].getMove(moveNum).getSkilInfoVN());})  ;
            } else if (moveNum == 5) {
                Platform.runLater(()
                        -> {
                    ItemInfo.setText("Hồi phục cho quái thú X " + potions); });
            } else if (moveNum == 6) {
                Platform.runLater(()
                        -> {
                    ItemInfo.setText("Hóa giải hiệu ứng X " + antidodes);});
            }
        } else {
            eng = true;
            changeLanguage.setText("VI");
            AttackButton.setText("SKILL");
            ItemButton.setText("ITEM");
            SwitchButton.setText("SWITCH");
            chat1.setText("Hello!");
            chat2.setText("How are you ?");
            chat3.setText("My monsters are stronger than yours!!!");
            chat4.setText("GG well-played!!!");
            UseItemButton.setText("USE");
            changeVi();
            oppActionChange();
            if (moveNum == 1 || moveNum == 2 || moveNum == 3) {
                Platform.runLater(()
                        -> {
                    SkillInfo.setText(monsters[0].getMove(moveNum).getSkillInfoEN()); });
            } else if (moveNum == 5) {
                Platform.runLater(()
                        -> {
                    ItemInfo.setText("Heal the current monster X " + potions); });
            } else if (moveNum == 6) {
                Platform.runLater(()
                        -> {
                    ItemInfo.setText("Cure the effect X " + antidodes); });
            }
        }
    }
// change opponent message
    private void oppActionChange() {
        if (lastOpp == -2) {
            Platform.runLater(()
                    -> {
                if (!eng) {
                    ActionText.setText("Đối thủ đang bị choáng");
                } else
                    ActionText.setText("Opponent monster got stunned");
            });
        } else if (lastOpp == 0) {
            Platform.runLater(()
                    -> {
                if (!eng) {
                    ActionText.setText("Đối thủ đánh trượt");
                } else
                    ActionText.setText("Opponent monster just missed");
            });
        } else if (lastOpp == 4) {
            Platform.runLater(()
                    -> {
                if (!eng) {
                    ActionText.setText("Đối thủ dùng hòi máu");
                } else
                    ActionText.setText("Opponent monster used heal");
            });
        } else if (lastOpp == -1) {
            Platform.runLater(()
                    -> {
                if (!eng) {
                    ActionText.setText("Đối thủ gây " + monsters[0].lastDame + " sát thương");
                } else
                    ActionText.setText("Opponent monster deals " + monsters[0].lastDame+ " HP");
            });
        } else if (lastOpp == 5) {
            Platform.runLater(()
                    -> {
                if (!eng) {
                    ActionText.setText("Đối thủ vừa tăng khả năng phòng thủ");
                } else
                    ActionText.setText("Opponent monster raised his defend");
            });
        } else if (lastOpp == 2) {
            Platform.runLater(()
                    -> {
                if (!eng) {
                    ActionText.setText("Đối thủ gây " + monsters[0].lastDame+ " sát thương và hiệu ứng đót");
                } else
                    ActionText.setText("Opponent monster deals " + monsters[0].lastDame + " HP and burnt effect");
            });
        } else if (lastOpp == 3) {
            Platform.runLater(()
                    -> {
                if (!eng) {
                    ActionText.setText("Đối thủ gây " + monsters[0].lastDame + " sát thương và hiệu ứng độc");
                } else
                    ActionText.setText("Opponent monster deals" + monsters[0].lastDame + "HP và hiệu ứng độc");
            });
        } else if (lastOpp == 6) {
            Platform.runLater(()
                    -> {
                if (!eng) {
                    ActionText.setText("Đối thủ vừa đổi quái thú");
                } else
                    ActionText.setText("Opponent changed the monster");
            });
        } else {
            Platform.runLater(()
                    -> {
                if (!eng) {
                    ActionText.setText("Lựa chọn hành động của bạn");
                } else
                    ActionText.setText("Decide your move");
            });
        }
    }
// check end game
    private void endGame() {
        if (deaths == 3 || oppDeaths == 3) {
            BattleBackground.toFront();
            endField.toFront();
            media.getMediaPlayer().stop();
            switchMedia.getMediaPlayer().stop();
            switchMedia.getMediaPlayer().play();
        }
    }
// end game button
    public void EndButton(ActionEvent actionEvent) throws Exception{
        output.close();
        input.close();
        socket.close();
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/EndScene.fxml"));
        Parent root = fxmlLoader.load();
        EndController endController = fxmlLoader.getController();
        if (oppDeaths == 3) {
            endController.setData(true, eng);
        } else
            endController.setData(false, eng);


        Scene scene = new Scene(root);

        window.setScene(scene);
        window.show();
    }
}