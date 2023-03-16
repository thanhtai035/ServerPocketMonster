//package Monster;
package Monster;
import MoveList.*;
import javafx.scene.image.Image;
//Atk Monster

public class Excadrill extends PocketMonster {
    public Excadrill(){
        curImage = new Image("/Select/Select13.png");
        myImage = new Image("/MyOppMon/My13.gif");
        oppImage = new Image("/MyOppMon/Opp13.gif");
        atk = 70;
        def = 50;
        speed = 100;
        maxHealth = 150;
        curHealth = maxHealth;
        monID = 13;
        element = "Ground";
        name = "Excadrill";
        movelist [0] = new Magnitude();
        movelist [1] = new Tackle();
        movelist [2] = new LandWrath();

    }
}
