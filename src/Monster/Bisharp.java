//package Monster;
package Monster;

import MoveList.*;
import javafx.scene.image.Image;
//Atk Monster

public class Bisharp extends PocketMonster {
    public Bisharp(){
        curImage = new Image("/Select/Select2.png");
        myImage = new Image("/MyOppMon/My2.gif");
        oppImage = new Image("/MyOppMon/Opp2.gif");
        atk = 70;
        def = 50;
        speed = 104;
        maxHealth = 150;
        curHealth = 150;
        monID = 2;
        name = "Bisharp";
        element = "Steel";
        movelist [0] = new IronDefense();
        movelist [1] = new Tackle();
        movelist [2] = new FlashCannon();
    }
}
