package MoveList;

public class WillOWisp extends Move {
    public WillOWisp(){
        moveID = 21;
        moveName = "Will-O-Wisp";
        damage = 20;
        accuracy = 80;
        status = "Burnt";
        type = "Ranged";
        element = "Fire";
        skillInfoEN = "Type: Fire. This skill has 80% chance to burn the opponent in 2 turns, dealing 50 damage each turn.";
        skilInfoVN = "Hệ: Lửa. Kĩ năng này có 80% tỉ lệ thiêu đốt dối thủ trong 2 lượt, gây ra 50 sát thương mỗi lượt.";
    }
}
