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
package MoveList;

import java.awt.*;
import java.util.ArrayList;

import java.util.Locale;
import java.util.ResourceBundle;
public class Move {
    protected Integer moveID;
    protected String moveName;
    protected Integer damage;
    protected Integer accuracy;
    //protected String Move_description;
    protected String status;
    protected String type;
    protected String element;
    protected  String skillInfoEN;
    protected String skilInfoVN;
    protected Image moveSprite1;
    protected Image moveSprite2;



    public String getElement() {
        return element;
    }
    public Integer getMoveID(){
        return moveID;
    }

    public Integer getDamage() {
        return damage;
    }

    public Integer getAccuracy() {
        return accuracy;
    }

    public String getMoveName() {
        return moveName;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getSkilInfoVN() {
        return skilInfoVN;
    }

    public String getSkillInfoEN() {
        return skillInfoEN;
    }
}

