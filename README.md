# MaxwellS-Demon
Maxwell’s Demon is a computer game in Java  that lets the user play as Maxwell's demon.  It utilses suitable data model to store the state of the game); a GUI view to display this state to the user; and controllers that respond to player inputs and requests as they try to win.  

When a player begins a game of Maxwell's Demon, they are presented with a graphical display
that includes all of the following components:
- A rectangular "play area" which is divided into two halves by a wall through the middle.
   - The wallcontaisn a "door" which spans (roughly) the middle third of the wall; 
   should *not* take up the entire height/length of the wall.
   - The wall (and door) are vertical (producing a left chamber and right chamber) o
- Two "temperature" displays; one for each chamber of the play area
- Two buttons to control gameplay
   - A "reset" button which, when pressed, returns the game to its initial state (that is, as if
     the game was being opened and started for the first time)
   - An "add particles" button which, when pressed, introduces new particles into the game

The player controls the door (in the wall separating the chambers) using the mouse. When the mouse
button is *pressed* (that is, pushed and held), the door should be open; when the button is
*released* (that is, not pushed), the door should be closed. The player areable to operate
the door by pressing or releasing anywhere in the play area.
