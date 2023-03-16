package Monster;
import MoveList.*;
import javafx.scene.image.Image;
//Def Monster

public class Venusaur extends PocketMonster {
    public Venusaur(){
        curImage = new Image("/Select/Select8.png");
        myImage = new Image("/MyOppMon/My8.gif");
        oppImage = new Image("/MyOppMon/Opp8.gif");
        atk = 50;
        def = 70;
        speed = 64;
        maxHealth = 150;
        monID = 8;
        element = "Grass";
        curHealth = maxHealth;
        name = "Venusaur";
        movelist [0] = new Toxic();
        movelist [1] = new Tackle();
        movelist [2] = new GrassCut();
    }
}
