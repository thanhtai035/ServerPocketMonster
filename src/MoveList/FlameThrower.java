package MoveList;


public class FlameThrower extends Move {
    public FlameThrower(){
        moveID = 3;
        moveName = "Flame Thrower";
        damage = 40;
        accuracy = 90;
        status = "None";
        type = "Ranged";
        element = "Fire";
        skillInfoEN = "Type: Fire. This move has 90% chance to deal 40 damage.";
        skilInfoVN = "Hệ: Lửa. Kĩ năng này có 90% tỉ lệ gây ra 40 sát thương.";
    }
}
