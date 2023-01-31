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
  
  -----------------------------------------------------
  After much trying over the weekend, I was unable to find a way to get the old code working. Whether it was problems with my old computer and one drive, old problems in
  the code, or problems within eclipse and creating the right runtime enviornment, I could not solve it. Instead I created the solution in a seperate java file. This
  feature would normally be easily implemented as well, as it is somewhat isolated with no features depending on it. I added 2 files named 
  'ScoreT.java' and 'Highscore.txt'. However the .txt file only for show, as the 'ScoreT.java' file will create a file to save data within. Below is a screenshot of the 
  code working within eclipse. 
  
  ![image](https://user-images.githubusercontent.com/72995425/215685833-dfefe0e0-d17a-410d-81b3-71816c9a4c62.png)

