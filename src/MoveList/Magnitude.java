package MoveList;



public class Magnitude extends Move {
    public Magnitude(){
        moveID = 10;
        moveName = "Magnitude";
        damage = 20;
        accuracy = 50;
        status = "Stunned"; //skill nay co 80% gay stun 1 turn cho mon doi thu
        type = "Ranged";
        element = "Ground";
        //chieu nay animation chi la lac con pokemon doi thu thoi
        skillInfoEN = "Type: Ground. This skill has 50% chance to deal 20 damage and stun the opponent for 1 turn. This skill has a 1 turn cool down.";
        skilInfoVN = "Hệ: Đất. Kĩ năng này có 50% tỉ lệ gây ra 20 sát thương và làm choáng đối thủ trong 1 lượt. Kĩ năng này cần chờ 1 lượt để có thể tái sử dụng.";
    }
}
