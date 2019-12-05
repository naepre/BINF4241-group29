# BINF4241_group29 -- Assignment 5

# PART 1





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
