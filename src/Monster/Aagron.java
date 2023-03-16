//package Monster;
package Monster;
import MoveList.*;
import javafx.scene.image.Image;

//Def Monster
public class Aagron extends PocketMonster {
    public Aagron(){
        curImage= new Image("/Select/Select1.png") ;
        myImage = new Image("/MyOppMon/My1.gif");
        oppImage = new Image("/MyOppMon/Opp1.gif");
        atk = 50;
        def = 70;
        speed = 62;
        maxHealth = 150;
        curHealth = 150;
        monID = 1;
        name = "Aagron";
        element = "Steel";
        movelist [0] = new IronDefense();
        movelist [1] = new Tackle();
        movelist [2] = new HeavySlam();
    }
}
