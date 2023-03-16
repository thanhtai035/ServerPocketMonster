package MoveList;


public class LandWrath extends Move {
    public LandWrath(){
        moveID = 9;
        moveName = "Land's Wrath";
        damage = 60;
        accuracy = 80;
        status ="None";
        type = "Ranged";
        element = "Ground";
        //animation la cho qua nui de len mon opp
        skillInfoEN = "Type: Ground. This skill has 80% chance to deal 60 damage.";
        skilInfoVN = "Hệ: Đất. Kĩ năng này có 80% tỉ lệ gây ra 60 sát thương.";
    }
}
