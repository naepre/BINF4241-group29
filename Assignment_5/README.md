# BINF4241_group29 -- Assignment 5

# PART 1

We created tests for methods which had the most functionality and impact on the code. Therefore for the most part we avoided testing some getters and setters. Moreover we placed  the Unit test for methods for a particular class inside a separate class in the Test folder. For each method we tested we tried to cover possible scenarios therby also considering corner cases.  

We noticed a bug in our code when we tested the "Player" Class which requires input from the user. We observed that when a user enters an input which is not requested that is, when the command line would ask the user to input an integer between 2-4 and the user would by mistake provide an input which isn't a number or an integer the program would crash.

In order to fix this issue we had to modify the method in “Player” class which takes user input.
We used “try” and “catch” statements in order to catch any wrong input and then throw and error message, then requiring the user to provide the program a correct input value.


....more


# PART 2
## GameBoardTest.java
### Test: markOnBoard()
The function mark() in GameBoard.java had an inverse logic relating to checking if a position is marked or not. When marked, it should return false and when not marked, place the player and return true.

### Test: getOpenPositionsAll()
The function getOpenPositions() in GameBoard.java should set the interation check on columns to 0 and not 1.

## TicTacToeGameStateTest.java
### Test: startingPlayerIsX()
The function getCurrentPlayer() in TicTacToeGameState.java the randomPlayer should be set to X not O.

### Test: hasWinRow()
The function hasWin(Player player) in TicTacToeGameState.java should return True when a player completes a row and not false.

### Test: hasWinCol()
The function hasWin(Player player) in TicTacToeGameState.java should return True when a player completes a column and not false.

### Test: hasWinDiagonal()
The completesDiagonal(Player player) function in TicTacToeGameState.java should verify the bottom right position to properly check the left-top to right-bottom diagonal to pass the test.

### Test: getAvailableStatesLastOne()
The getCurrentPlayer() function in TicTacToeGameState.java should only return the currentPlayer of the game and not set the current player to X.

### Test: switchPlayer()
The getCurrentPlayer() function in TicTacToeGameState.java should only return the currentPlayer of the game and not set the current player to X in order to switch players correctly.




# PART 3
