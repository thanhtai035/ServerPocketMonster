package MoveList;


public class IronDefense extends Move {
    public IronDefense(){
        moveID = 8;
        moveName = "Iron Defense";
        damage = 0;
        accuracy = 100;
        status = "DefUp";
        type = "Buff"; //Skill nay buff 20 chi so Def hien co cua monster, maximum increase dc 40%
        element = "Steel";
        //skill nay animation ong cho mon uong sua nha
        skillInfoEN = "Type: Steel. This skill has 100% chance to increase your Def stat by 20%, maximum 40%.";
        skilInfoVN = "Hệ: Sắt. Kĩ năng này có 100% tỉ lệ tăng chỉ số Phòng thủ bản thân thêm 20%, tối đa 40%.";
    }
}
