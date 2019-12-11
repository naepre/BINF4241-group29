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

# 1 Identify how the system should behave:
Note:

A. Which input it should accept which it should not.

  Accepted Inputs:
    
    I. Players: 
      a. Player:  
        - Enter a playername as an input string for each player. (It can contain symbols and numbers like: "H0Twheel!Boy4000")
      b. Age:     
        - Enter an age as an integer between 0 and 150 for each player. A player below 7 is not allowed to play.
          It should give a message for those players.
      c. Number of players: 
        - You have to declare between 2 and 10 players as an integer to start the game.
      
    II. Start:
      a. Dealer:
       - You must have exactly one dealer. 
       - Stays the same for one round.
       - 
      b. Score:
       - Each player needs to have a score. At start it has to be 0.
      c. Deck: 
        Consists of Cards: (1 x '0', 2 x '1' to '9', 2 x '+2 Draw', 2 x 'Skip', 2 x 'Reverse') per Color, 4 x 'Wild Card', 4 x '+4 Wild Card'  
        c.1. Cards: 
          Needs a Color and a Type
          c.1.a. Types: 
            Either a number from 0 - 9, Wild Card, +4 Wild Card, Reverse, Skip, +2 Draw
          c.1.b. Color: 
            blue, red, green, yellow, all
      
    III. 

  Declined Inputs:
  
    I. Players: 
       a. Player:  
        - The playername entered should not be empty.
        - You cannot give two players exactly the same name.
        - You cannot give one player two names.
       b. Age:     
        - The entered age cannot be a string, float or character and cannot be negative or empty. 
        - You cannot assign more than one age to one player.
       c. Amount of players:
        - You cannot declare more than 10 or less than 2 players and start the game. 
        - You cannot enter a float, string, character, empty, or negative integer.
        
B. What it should do with the inputs, and what it should not.



C. What are the expected outputs, which ones should not happen.



