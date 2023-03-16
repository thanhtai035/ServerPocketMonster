//package Monster;
package Monster;
import MoveList.*;
import javafx.scene.image.Image;
//Balance Monster

public class Swampert extends PocketMonster {
    public Swampert(){
        curImage = new Image("/Select/Select6.png");
        myImage = new Image("/MyOppMon/My6.gif");
        oppImage = new Image("/MyOppMon/Opp6.gif");
        atk = 60;
        def = 60;
        speed = 81;
        maxHealth = 150;
        curHealth = maxHealth;
        monID = 6;
        element = "Water";
        name = "Milotic";
        movelist [0] = new RainDance();
        movelist [1] = new Tackle();
        movelist [2] = new WaterGun();
    }
}
