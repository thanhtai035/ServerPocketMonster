package MoveList;



public class MetalBurst extends Move {
    public MetalBurst(){
        moveID = 12;
        moveName = "Metal Burst";
        damage = 50;
        accuracy = 90;
        status = "None";
        type = "Ranged";
        element = "Steel";
        //skill nay ong cho 3 cai MetalBurst1, 2 va 3 bay toi mon opp nha
        skillInfoEN = "Type: Steel. This skill has 90% chance to deal 50 damage.";
        skilInfoVN = "Hệ: Sắt. Kĩ năng này có 90% tỉ lệ gây ra 50 sát thương.";

    }
}
