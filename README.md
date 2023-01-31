# groupproject-team-4-namco-Galaga
groupproject-team-4-namco created by GitHub Classroom

I am implementing a feature to save the highscore in our Galaga game even after the game/program is closed. To do this, each time a game is played, the score achieved
will be compared with the score documented in a seperate txt file. If the new score is higher than that of the text file, the old score is replaced by the new highest
one. The score within the text file at the end will be displayed instead. 

----------------------------------------------------------

When game starts:
  Text file is opened
  Text file is read
  Number is saved as integer "High score"
  Number is displayed

When player's number of lives reach 0:
  Current score is saved as integer "New score"
  Is New score > High score
  if true:
    clear text file
    write in new score
  text file is closed
  
