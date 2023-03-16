//package Monster;
package Monster;
import MoveList.*;
import javafx.scene.image.Image;
//Balance Monster

public class Roserade  extends PocketMonster {
    public Roserade(){
        curImage = new Image("/Select/Select9.png");
        myImage = new Image("/MyOppMon/My9.gif");
        oppImage = new Image("/MyOppMon/Opp9.gif");
        atk = 60;
        def = 60;
        speed = 82;
        maxHealth = 170;
        curHealth = maxHealth;
        monID = 9;
        element = "Grass";
        name = "Roserade";

        movelist [0] = new Toxic();
        movelist [1] = new Tackle();
        movelist [2] = new VineWhip();
    }
}
