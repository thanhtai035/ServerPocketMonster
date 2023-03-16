//package Monster;
package Monster;
import MoveList.*;
import javafx.scene.image.Image;
//Atk Monster

public class MowRotom extends PocketMonster {
    public MowRotom(){
        curImage = new Image("/Select/Select7.png");
        myImage = new Image("/MyOppMon/My7.gif");
        oppImage = new Image("/MyOppMon/Opp7.gif");
        atk = 70;
        def = 50;
        speed = 103;
        maxHealth = 170;
        curHealth = maxHealth;
        monID = 7;
        element = "Grass";
        name = "Mow Rotom";
        movelist [0] = new Toxic();
        movelist [1] = new Tackle();
        movelist [2] = new SolarBeam();

    }
}
