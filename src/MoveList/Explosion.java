package MoveList;


public class Explosion extends Move {
    public Explosion(){
        moveID = 2;
        moveName = "Explosion";
        damage = 50;
        accuracy = 90;
        status = "None";
        type = "Ranged";
        element = "Fire";
        skillInfoEN = "Type: Fire. This skill has 90% chance to deal 50 damage.";
        skilInfoVN = "Hệ: Lửa. Kĩ năng này có 90% tỉ lệ gây ra 50 sát thương.";
    }
}
