Tic-Tac-Toe Golf
================

Solution to [Noughts and Crosses (aka Tic-Tac-Toe)](http://codegolf.stackexchange.com/questions/1054/noughts-and-crosses-aka-tic-tac-toe).

Trying to see how minimally I can make a playable Tic-Tac-Toe. In Java for now.

Building un-golfed version:

    javac TicTacToeGolf.java
    java TicTacToeGolf

Building equivalent golfed version (at time of writing, 1801 characters):

    javac T.java
    java T

**Some usage notes:**

* 50/50 chance for who takes first turn. 
* Move of "X" or "O" announced before displaying the game board. 
* Choice of cell is specified as column, then row, indexed from 0. 
* Entering something outside `[0,2]` will cause a index exception and end the game.
* If computer goes first, takes a random move (no preference for any board location).
* Computer will take one move wins, block one move losses, plays conservatively (prefers center if available), tries to set up a two-turn win (hope other player doesn't block), and if that fails? Picks a random spot. So doesn't play a perfect game, but plays a great game. I can force a win due to the random start possibilities, but computer will force a win as well if I start badly. 
* Wins are detected immediately. 
* Impossible-to-win is *not* detected; you must play every game to the end or let the other player win. 
* At the end of each game, a new game begins, again with a randomly chosen starting player.
* Use `Ctrl+c` to end.

There's definitely room for improvement. One place is likely replacing the multi-dimensional array with a one-dimensional array, and replacing the more complex decision logic with either a reduced form of the same, or a more concise best-choice solver.

Play around with it and let me know what you think. Feel free to fork, or recommend improvements via pull requests.
