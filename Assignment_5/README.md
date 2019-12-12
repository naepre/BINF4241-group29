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
    
        III. Inputs:
    Set-Up
      a. Set number of players
        - You have to declare between 2 and 10 players as an integer to start the game.
        - You cannot declare more than 10 or less than 2 players and start the game. 
        - You cannot enter a float, string, character, empty, or negative integer.
 
      b. Set Players
        b.1. Put in a playername
          - Enter a playername as an input string for each player. (It can contain symbols and numbers like: "H0Twheel!Boy4000")
          - The playername entered should not be empty.
          - You cannot give two players exactly the same name.
          - You cannot give one player two names.
          
        b.2. Put in a playerage
          - Enter an age as an integer between 0 and 150 for each player. A player below 7 is not allowed to play.
            It should give a message for those players.
          - The entered age cannot be a string, float or character and cannot be negative or empty. 
          - You cannot assign more than one age to one player.
      c. Set Score
        - You can set any number between 1 and 10000
        - You cannot enter a string, a character, empty or negative integer
        - You cannot set multiple scores
      d. Accept Score   
        - You can decline or accept the score
        - You cannot skip this input
    During Game
      a. Draw a Card
        - You can only draw a card once per turn and only before playing a card.
        - Only the player whose turn it is can draw a card.
        - You can only draw from the Draw Pile. You cannot draw from a player's hand or from the Discard Pile.
      b. Play a Card
        - You can only play one card per turn, no stacking allowed.
        - You can only play a card if it matches with the last card on the match pile.
        - Only the player whose turn it is can play a card.
        - After playing a card the effect of the played card is triggered and afterwards the turn enters automaticaly.
      c. Say "UNO"
        - You can only say it if you have two cards before playing a card.
        - You can only say it during your turn.
        - If you ignore it, other players have the possibility to point it out, but only until the next card is played.
        - If forgotten and pointed out you have to draw +2 cards.
      d. Point out someone forgot to say "UNO"
        - You can only say it after someone said UNO.
        - You can only say it until the next card is played.
        - You can say it during someone others turn.
      e. Challenge someone who played a '+4 Wild Card' 
        - You can only challenge someone until the next card is played.
        - You can say it during someone others turn.
        - If the player could play any other card matching the color, he has to draw four cards. Otherwise the challenger draws six cards.
      f. Declare the color of the next card
        - Only possible after playing a wild card.
        - You can only choose one of the four card colors.
        - You cannot skip this action.
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



Objects/Rules
  
    I. Players: 
      a. Player:  
        - Enter a playername as an input string for each player. (It can contain symbols and numbers like: "H0Twheel!Boy4000")
      b. Age:     
        - Enter an age as an integer between 0 and 150 for each player. A player below 7 is not allowed to play.
          It should give a message for those players.
      c. Number of players: 
        - You have to declare between 2 and 10 players as an integer to start the game.
      
    II. Game:
      a. Dealer:
       - You must have exactly one dealer. 
       - Stays the same for one round.
       - Deals 7 Cards to each player at the beginning.
       - The player to the left of the dealer is starting player.
       - Is Player 1 at the first round, changes then to Player 2 and iterates through the amount of players.
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
      d. Discard Pile: 
        - Contains always of at least 1 card.
        - At the start take one card of the deck after dealing the cards to the players and put it on the Discard Pile
        - All cards on it are face up and the cards are stacked on top of each other
        - Only action you can do with it is play a card onto it or shuffle it into the draw pile.
      e. Draw Pile: 
        - The rest of the deck after dealing and making the discard pile.
        - All cards on it are face down
        - Only action you can do with it is draw.
      f. Playerhand
        - Each player has exactly one playerhand with his cards in it.
        - The players can only look at their own playerhand face up, the other hands are face down for them. (So they can count the number of cards in other players hands.
      g. Direction
        - The direction is per default clockwise and can only be turned by the reverse card
      h. Start Card
        - The first card on the discard pile at the beginning of the round is called the start card.
        - If the start card is a '+4 Wild Card' reshuffle it.
        - If the start card is an action card, trigger its effect.
      i. Turn
        - You have to make at least one action per turn. (Either Draw a Card or Play a Card)
      j. Winnerscore
        - The winnerscore is per default 500, but can be changed.
        - All players have to agree to change the winnerscore.
        - Once the winnerscore is reached, the ranking according to the score is declared and the game ends.
      k. Action Card
        - An action card triggers an action only once when it is played.
        - 'Reverse': Change Direction to the other side.
        - 'Skip': The next player skips his turn.
        - '+2 Draw': The next player draws 2 cards at the beginning of his turn.
        - 'Wild Card': Choose a color. The next card played must be of this color or a 'Wild Card'.
        - '+4 Wild Card': Choose a color. The next player draws 4 cards at the beginning of his turn. The next card played must be of this color or a 'Wild Card'. Should only be played if you cannot play any other card matching the color. Other players can challenge the playing player.
