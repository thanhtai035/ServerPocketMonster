package MoveList;

public class MudBomb extends Move {
    public MudBomb(){
        moveID = 13;
        moveName = "Mud Bomb";
        damage = 40;
        accuracy = 90;
        status ="None";
        type = "Ranged";
        element ="Ground";
        skillInfoEN = "Type: Ground. This skill has 90% chance to deal 40 damage.";
        skilInfoVN = "Hệ: Đất. Kĩ năng này có 90% tỉ lệ gây ra 40 sát thương.";
    }
}
