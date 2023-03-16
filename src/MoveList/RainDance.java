package MoveList;


public class RainDance extends Move {
    public RainDance(){
        moveID = 14;
        moveName = "Rain Dance";
        damage = 0;
        accuracy = 100;
        status = "Heal";
        type = "Buff";
        element = "Water";
        skillInfoEN = "Type: Water. This skill has 100% chance to heal 50 health point.";
        skilInfoVN = "Hệ: Nước. Kĩ năng này có 100% tỉ lệ hồi phục 50 máu.";

    }
}
