RMIT University Vietnam
Course: INTE2512 Object-Oriented Programming
Semester: 2020b
Assessment name: Project Proposal
Project topic: Pocket Monster
Team name: Pocket Monster
Project manager: Le Thanh Tai (s3760615)
Technical Lead: Le Hoang Cat(s3790029)
Team members: Le Thanh Tai(s376015), Chu Anh Minh(s3758870), Le Hoang Cat(s3790029)

1. INTRODUCTION
This project is about a game called Pocket Monster which is played between two players control their monsters to fight each other. The objective of this game is to defeat 
all monsters of the opponent. This monster game is based on turn-based RPG games like the famous Pokemon game. However, the normal Pokemon games are only for one player but
this one is an one-on-one game with different gameplay and new features like chat system, monster options or random line up. Player has to pick 3 out of 15 monsters which 
means there are up to 455 ways to pick a team. And each monster will have different stats, skills, faction so the player wants to master this game need a good strategy and
also experience and calculation..
 
2. FEATURES
. The main language of the game is English but it can change to Vietnamese at anytime without crashing.
. Players can play with each other via Lan network or even WLAN.
. Player can choose between Normal Mode and Random Mode. Random mode will have the players get 3 random monsters which is more challenging and interesting.
. Monster in first slot has to fight first so the order system requires good mindset. 
. The battle screen shows the current monster in both side with HP bar, status, effects with animation and sound effect.
. The task bar beneath the battle screen give option which player can easily choose between actions like use skill, switch monster, use item or even chat. 
. Each monster has up to 4 skills so the player can choose suitable skill when fight with the opponent.
. Switching help player to change the current monster in the battlefield.
. Gameplay calculates monsters's stats like attack, defense or even speed so each different team will lead to a different battle style. 
. The faction system helps the gameplay fair when every team has weekness (water faction deals more damage to fire but less to grass). 
. Item system can help the current monster to heal or deactivate negative effect.
. Chat system help players to interact with each other. User can choose given text like "Hi" or send their own line.
. Players can play again with each other if both side agree to continue.

3. DESIGN
. The fmxls files were built by Scene Builer and each file has a controller
. The controller can share data by call other contruster and call a function to transfer data so every controller can use same model.
. The controller changes to other scene by get the running stage and change the scene
. The network type is Serversocket so there are two project for the client and the server
. After sending a message, a pane will appear and cover the action and wait for input to close the pane. Therefore, two sides can work back and forth.
. Create many variables, each of them can work for each case like effect and action indepently so we can check the stage easily.
. The calculating and translating is put in functions for better view
. Create two ports for two types of gameplay.

4. INSTALLATION
. The server will choose the mode first, then the client can join the room.
. User can change the language when click to button on top-right.
. Each of user will choose their team and press start when their ready
. When both of users are ready, the user's monster has higher speed will go first
. They can choose actions between attack, item, chat and switch.
. When 3 monsters from one side died first, the game will send end button to change to end scene.
. End scene will inform the winner and loser, the user will quit when click the close button

5. KNOWN BUGS
. The naming and put space is not good. Some may not follow the naming rules.
. The translating design is bad when not using ResourceBundle and have to handle in many functions.
. Someplace not handle the translating
. The message may not be meaningful.
. The writing font and size may not good-looking
. The package diagram may not follow the concept.
. Submit two projects for the server and the client may not be a good idea
. Some unused variables and resources. Unnessecary directories may caused annoying.
. Place the files and directories are not meaningfull.

6. ACKNOWLEDGEMENT
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
