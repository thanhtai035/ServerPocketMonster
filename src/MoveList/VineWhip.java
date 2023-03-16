package MoveList;



public class VineWhip extends Move {
    public VineWhip(){
        moveID = 19;
        moveName = "Vine Whip";
        damage = 50;
        accuracy = 90;
        status = "None";
        type = "Ranged";
        element = "Grass";
        //animation skill nay la cho con chuot hoac WHip(KOF) danh mon opp
        skillInfoEN = "Type: Grass. This skill has 90% chance to deal 50 damage.";
        skilInfoVN = "Hệ: Cỏ. Kĩ năng này có 90% tỉ lệ gây ra 50 sát thương.";

    }
}
