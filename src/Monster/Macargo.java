//package Monster;
package Monster;
import MoveList.*;
import javafx.scene.image.Image;
//Def Monster

public class Macargo extends PocketMonster {
    public Macargo(){
        curImage = new Image("/Select/Select11.png");
        myImage = new Image("/MyOppMon/My11.gif");
        oppImage = new Image("/MyOppMon/Opp11.gif");
        atk = 50;
        def = 70;
        speed = 60;
        maxHealth = 150;
        curHealth = maxHealth;
        monID = 11;
        element = "Fire";
        name = "Macargo";

        movelist[0] = new WillOWisp();
        movelist[1] = new Tackle();
        movelist[2] = new FlameThrower();

    }
}
