//package Monster;
package Monster;
import MoveList.*;
import javafx.scene.image.Image;
//Balance Monster

public class Garchomp extends PocketMonster {
    public Garchomp(){
        curImage = new Image("/Select/Select15.png");
        myImage = new Image("/MyOppMon/My15.gif");
        oppImage = new Image ("/MyOppMon/Opp15.gif");
        atk = 60;
        def = 60;
        speed = 84;
        maxHealth = 170;
        curHealth = maxHealth;
        monID = 15;
        element = "Ground";
        name = "Garchomp";
        movelist [0] = new Magnitude();
        movelist [1] = new Tackle();
        movelist [2] = new RockThrow();
    }
}
