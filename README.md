Tic-Tac-Toe Golf
================

Solution to [Noughts and Crosses (aka Tic-Tac-Toe)](http://codegolf.stackexchange.com/questions/1054/noughts-and-crosses-aka-tic-tac-toe).

Trying to see how minimally I can make a playable Tic-Tac-Toe. In Java for now.

Usage notes on un-fully golfed version:

    javac TicTacToeGolf.java
	java TicTacToeGolf

Computer plays first, choosing a random placement.

User is prompted next. Enter values between 0 and 2. First pick the row (x), then the column (y).

If User wins, outcome is immediate.

Computer will then choose a placement.

If Computer wins, outcome is immediate.

If out of moves (no spaces) and no winner, game ends.
