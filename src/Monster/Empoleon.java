//package Monster;
package Monster;
import MoveList.*;
import javafx.scene.image.Image;

//Atk Monster
public class Empoleon extends PocketMonster {
    public Empoleon(){
        curImage = new Image("/Select/Select4.png");
        myImage = new Image("/MyOppMon/My4.gif");
        oppImage = new Image("/MyOppMon/Opp4.gif");
        atk = 70;
        def = 50;
        speed = 101;
        maxHealth = 150;
        curHealth = maxHealth;
        monID = 4;
        element = "Water";
        name = "Empoleon";
        movelist [0] = new RainDance();
        movelist [1] = new Tackle();
        movelist [2] = new HydroCannon();
    }
}
