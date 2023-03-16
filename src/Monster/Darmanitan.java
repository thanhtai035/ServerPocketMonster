//package Monster;
package Monster;

import MoveList.*;
import javafx.scene.image.Image;
//Balance Monster

public class Darmanitan extends PocketMonster {
    public Darmanitan(){
        curImage = new Image("/Select/Select12.png");
        myImage = new Image("/MyOppMon/My12.gif");
        oppImage = new Image("/MyOppMon/Opp12.gif");
        atk = 60;
        def = 60;
        speed = 83;
        maxHealth = 150;
        curHealth = maxHealth;
        monID = 12;
        element = "Fire";
        name = "Darmanitan";
        movelist[0] = new WillOWisp();
        movelist[1]= new Tackle();
        movelist[2] = new Explosion();
    }
}
