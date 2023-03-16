package MoveList;



public class WaterGun extends Move {
    public WaterGun(){
        moveID = 20;
        moveName ="Water Gun";
        damage = 50;
        accuracy = 90;
        status = "None";
        type = "Ranged";
        element = "Water";
        skillInfoEN = "Type: Water. This skill has 90% chance to deal 50 damage.";
        skilInfoVN = "Hệ: Nước. Kĩ năng này có 90% tỉ lệ gây ra 50 sát thương.";
    }
}
