package MoveList;

public class RockThrow extends Move {
    public RockThrow(){
        moveID = 15;
        moveName = "Rock Throw";
        damage = 50;
        accuracy = 90;
        status = "None";
        type = "Ranged";
        element = "Ground";
        //chieu nay quang con malphite nha
        skillInfoEN = "Type: Ground. This skill has 90% chance to deal 50 damage.";
        skilInfoVN = "Hệ: Đất. Kĩ năng này có 90% tỉ lệ gây ra 50 sát thương.";
    }
}
