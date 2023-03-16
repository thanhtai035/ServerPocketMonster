package MoveList;


public class GrassCut extends Move {
    public GrassCut(){
        moveID = 5;
        moveName = "Grass Cut";
        damage = 40;
        accuracy = 90;
        status = "None";
        type = "Ranged";
        element = "Grass";
        //chieu nay animation la quang cay hanh vao mat doi thu
        skillInfoEN = "Type: Grass. This skill has 90% chance to deal 40 damage.";
        skilInfoVN = "Hệ: Cỏ. Kĩ năng này có 90% tỉ lệ gây ra 40 sát thương.";
    }
}
