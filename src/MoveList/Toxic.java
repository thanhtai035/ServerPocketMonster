package MoveList;



public class Toxic extends Move {
    public Toxic(){
        moveID = 18;
        moveName = "Toxic";
        damage = 20;
        accuracy = 80;
        status = "Poisoned";
        type = "Ranged";
        element = "Grass";
        skillInfoEN = "Type: Grass. This skill has 80% chance to poison the opponent in 2 turns, dealing 50 damage each turn.";
        skilInfoVN = "Hệ: Cỏ. Kĩ năng này có 80% tỉ lệ chuốc độc đối thủ trong 2 lượt, gây ra 50 sát thương mỗi lượt.";
    }
}
