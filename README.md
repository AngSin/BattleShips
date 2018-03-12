Hi, this was a very fun task. To run simply `cd` into the folder and run `java BattleShips`.

This is a fully randomized and automated one player game of battleships, if you want to increase the grid size or increase the number of ships/lengths
of ships you can do so in `BattleShips.java`.

This is how I broke down the problem:

1. Placing of the board
    i) The ships should not cross over the board
    11) The ships should not overlap

2. Taking user co-ordinates and giving the right response

3. Checking when the game was over

How I solved these issues:

1. Created a two dimensional array to store characters.

i) Made sure that the starting index of the ship had one restricted co-ordinate (x or y depending on the ship's orientation)

ii) My initial thought was to create 4 quadrants and place the ships there. This is really easy to do but not scalable as      number of ships is limited to 4. I wanted to create a dynamic grid, where number of ships and their lengths could be           changed.
If a ship already existed there, I recalled the same function. This works really well for 2 destroyers and 1 ship
but if the number of ships was very large compared to the grid/board size the runtime would very high for such an approach
as the function would have to keep calling itself. A better approach would be to add or subtracting 1 to the x or y index (depending on the orientation) and trying to place the ship there but I wanted to complete this project in 2 hours as recommended and did not work on this approach as I was close to taking the full two hours.

2. This was easy to do for a simple hit or miss message for the user. For checking if a ship had sunk, I gave all the ships
    separate chars to represent themselves and on every hit checled if more units of the same ship (same char) lied within its
    vicinity. If not, then I outputted the 'ship sunk' message.

3. This was a simple case of summing up the lengths of all the ships/destroyers. If the total number of hits reached this sum of
    all lengths number then the game ended.
