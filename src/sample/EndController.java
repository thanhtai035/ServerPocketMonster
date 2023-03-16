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
package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.MediaView;

public class EndController {
    public Button changeLanguage;
    public Label result;
    public Button closeButton;
    public MediaView media;

    boolean eng;
    boolean win;
// close button method
    public void closeButtonOn(ActionEvent actionEvent) {
        Platform.exit();
    }
// change language method
    public void EngVI(ActionEvent actionEvent) {
        if (eng) {
            eng = false;
            changeLanguage.setText("ENG");
            if (win) {
                result.setText("THẮNG");
            } else
                result.setText("THUA");
            closeButton.setText("ĐÓNG");
        } else {
            eng = true;
            changeLanguage.setText("VI");
            if (win) {
                result.setText("WINNER");
            } else
                result.setText("LOSER");
            closeButton.setText("CLOSE");
        }

    }
// share data method
    public void setData(boolean win, boolean e) {
        media.getMediaPlayer().play();
        eng = e;
        this.win = win;
        if (!eng) {
            changeLanguage.setText("ENG");
            if (win) {
                result.setText("THẮNg");
            } else
                result.setText("THUA");
            closeButton.setText("ĐÓNG");
        } else {
            if (win) {
                result.setText("WINNER");
            } else
                result.setText("LOSER");
        }
    }
}
