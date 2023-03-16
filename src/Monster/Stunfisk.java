package Monster;
import MoveList.*;
import javafx.scene.image.Image;
//Balance Monster

public class Stunfisk extends PocketMonster {
    public Stunfisk(){
        curImage = new Image("/Select/Select3.png");
        myImage = new Image("/MyOppMon/My3.gif");
        oppImage = new Image("/MyOppMon/Opp3.gif");
        atk = 60;
        def = 60;
        speed = 80;
        maxHealth = 150;
        curHealth = maxHealth;
        monID = 3;
        name = "Stunfisk";
        element = "Steel";
        movelist [0] = new IronDefense();
        movelist [1] = new Tackle();
        movelist [2] = new MetalBurst();
    }
}
