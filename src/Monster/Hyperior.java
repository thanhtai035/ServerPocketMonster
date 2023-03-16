//package Monster;
package Monster;
import MoveList.*;
import javafx.scene.image.Image;
//Def Monster

public class Hyperior extends PocketMonster {
    public Hyperior(){
        curImage = new Image("/Select/Select14.png");
        myImage = new Image("/MyOppMon/My14.gif");
        oppImage = new Image("/MyOppMon/Opp14.gif");
        atk = 50;
        def = 70;
        speed = 61;
        maxHealth = 170;
        curHealth = maxHealth;
        monID = 14;
        element = "Ground";
        name = "Rhyperior";
        movelist [0] = new Magnitude();
        movelist [1] = new Tackle();
        movelist [2] = new MudBomb();
    }
}
