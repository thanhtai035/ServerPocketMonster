package MoveList;
public class SolarBeam extends Move {
    public SolarBeam(){
        moveID = 16;
        moveName = "Solar Beam";
        damage = 60;
        accuracy = 80;
        status = "None";
        type = "Ranged";
        element = "Grass";
        skillInfoEN = "Type: Grass. This skill has 80% chance to deal 60 damage.";
        skilInfoVN = "Hệ: Cỏ. Kĩ năng này có 80% tỉ lệ gây ra 60 sát thương.";
    }
}
