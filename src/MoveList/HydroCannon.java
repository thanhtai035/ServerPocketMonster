package MoveList;



public class HydroCannon extends Move {
    public HydroCannon(){
        moveID = 7;
        moveName = "Hydro Cannon";
        damage = 60;
        accuracy = 80;
        status = "None";
        type = "Ranged";
        element = "Water";
        //cai nay ong lam gium toi 1 hình chu nhat màu xanh bay toi mon opp dc roi
        skillInfoEN = "Type: Water. This skill has 80% chance to deal 60 damage.";
        skilInfoVN = "Hệ: Nước. Kĩ năng này có 80% tỉ lệ gây ra 60 sát thương.";
    }
}
