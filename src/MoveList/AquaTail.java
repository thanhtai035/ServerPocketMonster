package MoveList;

public class AquaTail extends Move {
    public AquaTail(){
        moveID = 1;
        moveName = "Aqua Tail";
        damage = 40;
        accuracy = 90;
        status = "None";
        type = "Ranged";
        element = "Water";
        skillInfoEN = "Type: Water.This skill has 90% chance to deal 40 damage.";
        skilInfoVN = "Hệ: Nước. Kĩ năng này có 90% tỉ lệ gây ra 40 sát thương.";
    }
}
