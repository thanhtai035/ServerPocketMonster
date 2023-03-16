package Monster;


import MoveList.*;
import javafx.scene.image.Image;

//Atk Monster
public class Charizard extends PocketMonster {
    public Charizard(){
        curImage = new Image("/Select/Select10.jpg");
        myImage = new Image("/MyOppMon/My10.gif");
        oppImage = new Image("/MyOppMon/Opp10.gif");
        atk = 70;
        def = 50;
        speed = 102;
        maxHealth = 140;
        curHealth =140;
        monID = 10;
        element = "Fire";
        name = "Charizard";
        movelist[0] = new WillOWisp();
        movelist[1] = new Tackle();
        movelist[2] = new MaxFlare();
    }
}
