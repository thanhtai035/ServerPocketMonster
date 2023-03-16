//package Monster;
package Monster;
import MoveList.*;
import javafx.scene.image.Image;

//Def Monster
public class Milotic extends PocketMonster {
    public Milotic(){
        curImage = new Image("/Select/Select5.png");
        myImage = new Image("/MyOppMon/My5.gif");
        oppImage = new Image("/MyOppMon/Opp5.gif");
        atk = 50;
        def = 70;
        speed = 63;
        maxHealth = 170;
        curHealth = maxHealth;
        monID = 5;
        element = "Water";
        name = "Milotic";
        movelist [0] = new RainDance();
        movelist [1] = new Tackle();
        movelist [2] = new AquaTail();
    }
}
