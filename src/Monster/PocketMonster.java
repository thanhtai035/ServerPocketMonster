/*
  RMIT University Vietnam
  Course: INTE2512 Object-Oriented Programming
  Semester: 2020B
  Assessment: Final Project
  Created date: 23/09/2020
  By: Le Thanh Tai (s3760615)
  Last modified: 23/09/2020 (21:55)
  By: Le Hoang Cat (s3790029)
  Acknowledgement:
  1. Pokemon SFX Gen7: Sun, Moon, Ultra Sun, Ultra Moon – Attack Sound: https://www.youtube.com/watch?v=edWTFEZe0FY
The link above was used to trim out the sound effect of the monsters’ moves in the game.
2. Pokemon Sword and Shield – Pokemon Center Healing Theme Sound Effect [Free Ringtone Download]:
https://www.youtube.com/watch?v=jto28Ffl4sc&list=PLJK5OsJ44ut6V4F3ktt-AEq6i_UP2O3Gz
3. Sound Effects–Pokemon Anime(#8): Pokemon Return:
https://www.youtube.com/watch?v=OORDWT89XI8&list=PLJK5OsJ44ut6V4F3ktt-AEq6i_UP2O3Gz&index=6
4. Sound Effects-Pokemon Anime(#7): Pokemon Out:
https://www.youtube.com/watch?v=WVNDyQlJJXc&list=PLJK5OsJ44ut6V4F3ktt-AEq6i_UP2O3Gz&index=7
5. Pokemon Healing Sound(Sun/Moon)
https://www.youtube.com/watch?v=g33Rw8IFUZY&list=PLJK5OsJ44ut6V4F3ktt-AEq6i_UP2O3Gz&index=12
The link 2 to 5 was used to create other sound effects for the game.
6. Pokemon Database:
https://pokemondb.net/
This site was used for the image, gif of the monsters in the game. Furthermore, info about the monsters, elements system, items and skills from the game were inspired from this site.
7. Pokeli:
https://www.youtube.com/channel/UC2ccJMFWSbjklOQESSBP_dw
This is a link to a youtuber who extract sound tracks from the original games, we used music made by him on this channel.
8. WallpaperVortex.com
https://www.wallpapervortex.com/
The majority of the background image used in the game was found on this site.
9. Pokemon HD Wallpapers:
https://wallpaperaccess.com/pokemon-hd
	The background images used in the game was found on the websites in link 8 and 9.
10. PhoenixOfLight92:
https://www.deviantart.com/phoenixoflight92
The battle background images used in the game was found on this website.
11. DevianArt:
https://www.deviantart.com/
12. GoogleImage:
https://images.google.com/
The in-game move sprites and gifs were found on the 2 websites in link 11 and 12. They were mostly taken from open-sources links.
*/
package Monster;


import java.util.Random;
import MoveList.*;
import javafx.scene.image.Image;

public class PocketMonster {
    protected Integer monID;
    protected String name;
    protected String element;
    protected Integer atk;
    protected Integer def;
    protected Integer speed;
    protected double maxHealth;
    protected Move[] movelist = new Move[3];
    protected double curHealth;
    protected String status;
    public Integer lastDame = 0;
    private int defTurn = 0;
    private int HPTurn = 0;
    protected Image myImage;
    protected Image oppImage;
    protected Image curImage;
    String sendDame;

    public Integer getAtk() {
        return atk;
    }

    public String getName() {
        return name;
    }

    public Integer getDef() {
        return def;
    }

    public Integer getSpeed() {
        return speed;
    }

    public String getElement() {
        return element;
    }

    public Integer getMonID() {
        return monID;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public Move getMove(int num) {
        return movelist[num];
    }

    public Image getCurImage() {
        return curImage;
    }

    public Image getMyImage() {
        return myImage;
    }

    public Image getOppImage() {
        return oppImage;
    }

    public double getCurHealth() {
        return curHealth;
    }

    public Integer getAttacked(PocketMonster monster, int num) {
        int oppDamage = monster.getAtk();
        int skillDamage = monster.getMove(num).getDamage();
        String oppElement = monster.getMove(num).getElement();

        Random random = new Random();
        if (monster.getMove(num).getAccuracy() >= random.nextInt(100)) {
            lastDame = (int)((oppDamage * skillDamage) / def) * elementCounter(oppElement) / 100;
            curHealth = curHealth - lastDame;
            if (monster.getMove(num).getStatus().equals("Stunned")) {
                return 1;
            } else if (monster.getMove(num).getStatus().equals("Burnt")) {
                //mỗi turn trừ 40 máu
                return 2;
            } else if (monster.getMove(num).getStatus().equals("Poisoned")) {
                //mỗi turn trừ 40 máu
                return 3;
            } else if (monster.getMove(num).getStatus().equals("Heal")) {
                //tối đa xài dc 3 lần thôi nha
                if(HPTurn < 2) {
                    HPTurn++;
                    curHealth = curHealth + 50;
                    if (curHealth > maxHealth)
                        curHealth = maxHealth;
                }
                return 4;
            } else if (monster.getMove(num).getStatus().equals("DefUp")) {
                //tang chi so Def 15% 1 lần, tối đa 30% nha
                if(defTurn < 2) {
                    defTurn++;
                    def = def*120/100;
                    return 5;
                }
            }
        } else
            return 0;
        return -1;
    }

    public int elementCounter(String Element) {
        if (this.element.equals("Fire")) {
            if (Element.equals("Water"))
                return 50;
            else if (Element.equals("Steel"))
                return 200;
        }
        if (this.element.equals("Steel")) {
            if (Element.equals("Fire"))
                return 50;
            else if (Element.equals("Grass"))
                return 200;
        }
        if (this.element.equals("Grass")) {
            if (Element.equals("Steel"))
                return 50;
            else if (Element.equals("Ground"))
                return 200;
        }
        if (this.element.equals("Ground")) {
            if (Element.equals("Water"))
                return 200;
            else if (Element.equals("Grass"))
                return 50;
        }
        if (this.element.equals("Water")) {
            if (Element.equals("Fire"))
                return 200;
            else if (Element.equals("Ground"))
                return 50;
        }
        return 100;
    }

    public void setCurHealth(double curHealth) {
        this.curHealth = this.curHealth - curHealth;
    }

    public void upDef() {
        def = def * 120 /100;
    }

    public void potion() {
        curHealth = maxHealth;
    }
}


