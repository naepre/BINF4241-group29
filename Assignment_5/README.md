# BINF4241_group29 -- Assignment 5

# PART 1

We created tests for methods which had the most functionality and impact on the code. Therefore for the most part we avoided testing the getters and setters. Moreover we placed the Unit tests for methods for a particular class inside a separate class in the Test folder. For each method we tested we tried to cover possible scenarios therby also considering corner cases. Since our test methods do not have any return statements or parameters we decided not to use the @param or @return when creating the auto-generated Javadoc 

We noticed a bug in our code when we tested the "Player" Class which requires input from the user. We observed that when a user enters an input which is not requested that is, when the command line would ask the user to input an integer between 2-4 and the user would by mistake provide an input which isn't a number or an integer the program would crash.

In order to fix this issue we had to modify the method in “getPlayerCounter” in class "Player" which takes the user input.
We used “try” and “catch” statements in order to catch any wrong inputs and throw an error message, then requiring the user to provide the program with a correct input value.



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

### Note:

We assumed that the player can give the following inputs to the system. We will go through them according to the structure of the assignment. So for each input we say what the game should accept and what not. Then we say what it should do with the inputs and what not. Finally we say what should be the outputs and what not. The Inputs are split into the set-up inputs and the inputs happening during the game. All noninput functions/methods are assumed to be working correct. Like for example dealing cards to the players just once or correctly and automaticaly reshuffle the Discard Pile into the Draw Pile. We will mention which functions/methods we assumed to be automated.
  
   Inputs:
    
    Set-Up:
    
      - Set Number of Players: Obligatory
      - Set Players: Obligatory
        - Put in a Playername
        - Put in a Playerage
      - Set Score: Facultatively
      - Accept Score: Dependent on Set Score
      - Selecting a dealer is assumed to be automated, so no input is needed.
      
    During Game
    
      - Dealing the cards, selecting the starting player and triggering the action of an action card is assumed to be automated, so no input is needed and it is working correctly.
      - Draw a Card
      - Play a Card
      - Say "UNO"
      - Point out Someone forgot to say "UNO"
      - Challenge Someone who played a '+4 Wild Card'
      - Declare the Color of the Next Card after playing some Type of Wild Card.
      - End your turn
      - Ending the round, counting the points, starting a new round, ending the game and showing the winner is assumed to be automated and working correctly.


### A. Which input it should accept which it should not.

Note: For accepted behaviour/input we denoted it with a '+' for declined behaviour/input with a '-'
    
    Set-Up

      a. Set Number of Players
        + An integer number between '2' and '10' to represent the number of players.
        - An integer number bigger than '10', smaller than '2' or negative. 
        - A different type of input like: 'String', 'Character', 'Boolean', 'Float' or an empty input.
 
      b. Set Players
                
        b.1. Put in a Playername
          + A string input to represent the name of the player. (It can contain symbols and numbers like: "H0Twheel!Boy4000")
          + Each player needs to have a name.
          - An empty string input as the playername.
          - You cannot give two players exactly the same name.
          
        b.2. Put in a Playerage
          + An integer number between '1' and '150' to represent the age of the player.
          + Each player needs to have an age.
          + Two players can have to same age.
          - An integer number bigger than '150', smaller than '1' or negative. 
          - A different type of input like: 'String', 'Character', 'Boolean', 'Float' or an empty input.
          - You cannot assign more than one age to one player.
          
      c. Set Score
        + An integer number between '1' and '10000' to represent the score to win the game.
        + Two players can have to same age.
        + Per default 500.
        - An integer number bigger than '10000', smaller than '1' or negative. 
        - A different type of input like: 'String', 'Character', 'Boolean', 'Float' or an empty input.
        - You cannot assign more than one score at a time.
        
      d. Accept Score  
        + Only possibly after setting a score
        + Each player has to accept the score before starting the game, if the score was set.
        + You can decline or accept the score
        - You cannot skip this input, if it is triggered.
        - You cannot do something else than accepting/delining.
        
    During Game
    
      a. Draw a Card
        + You can only draw a card once per turn and only before playing a card.
        + Only the player whose turn it is can draw a card.
        + You can only draw from the Draw Pile. 
        - You cannot draw from a player's hand or from the Discard Pile.
        
      b. Play a Card
        + You can only play one card per turn, no stacking allowed.
        + You can only play a card if it matches with the last card on the match pile.
        + Only the player whose turn it is can play a card.
        - You cannot play a card onto a player's hand or onto the Draw Pile.
        Note: After playing a card the effect of the played card is triggered and afterwards the turn enters automaticaly.
        
      c. Say "UNO"
        + You can only say it if you have two cards before playing a card or one card after playing a card.
        + You can only say it during your turn.
        - The player cannot say several times "UNO" to stack the times he said "UNO" beforehand.
        Note: 
        If you ignore it, other players have the possibility to point it out, but only until the next card is played. If they do you have to draw 2 cards.
        If you draw cards again and get down to one card again, you still have to declare "UNO".

      d. Point out Someone forgot to say "UNO"
        + You can only say it after someone said UNO.
        + You can only say it until the next card is played.
        + You can say it during someone others turn.
        - You cannot say it after another card was played.
        - You cannot say it without a reason.
        
      e. Challenge Someone who played a '+4 Wild Card' 
        + You can only challenge someone until the next card is played.
        + You can say it during someone others turn.
        
        Note: If the challenged player could play any other card matching the color, he has to draw four cards. Otherwise the challenger draws six cards.
        
      f. Declare the Color of the Next Card after playing some Type of Wild Card
        + Only possible after playing a wild card.
        + You can only choose one of the four card colors.
        + You cannot skip this action.
      
      g. End your Turn
        + The player can end his turn after drawing a card or playing a card.
        - No player except the current player can end the turn.
        - The player cannot end his turn without playing or drawing a card. (Except if he is being skipped. But then he does not actively do his turn.)
        
### B. What it should do with the inputs, and what it should not.

Note: For accepted behaviour/input we denoted it with a '+' for declined behaviour/input with a '-'

    Set-Up
      
      a. Set Number of Players
        + The program should generate as many players as it was told.
        - It should not generate any different number of players and it should not generate them more than once per game.
        - You should not be able to start the game without setting the number of players.
      
      b. Set Players
      
        - You should not be able to start the game without setting the players.
      
        b.1. Put in a Playername
          + The program should assign the given String to the chosen player as its name.
          - The program should only assign one name to one player. Not one name to multiple players or multiple names to one player.
          
        b.2. Put in a Playerage
          + The program should assign the given integer to the chosen player as its age.
          + If the age of the player is below 7, the program does not allow him to play the game.
          - The program should only assign one age to one player. Not one input age to multiple players or multiple ages to one player. 
            Note: The age of the players can be the same.
            
      c. Set Score
          + The program should assign the given integer to the total score needed for a win.
          - The program should not generate multiple total scores. (I.e. For each player a different maximum score to be needed.)
          
      d. Accept Score
          + The program should only safe the proposed total score as the total score after every player accepted it.
          - The program should not allow just one or some players to accept the proposed total score.
      
    During Game
      
      a. Draw a Card
          + After getting the input the program should verify if he is allowed to draw if yes it will proceed.
          - The program will not allow the player to draw if it is not his turn or if he already drew a card or if he already played a card.
          
      b. Play a Card
          + The program verifies if the card the player wants to play is matching and if he is allowed to still play a card.
          + The program should not allow other players to play a card if its not their turn.      
          
      c. Say "UNO"
          + The program will remember that the player declared "UNO" as long as he has one card in his hand.
          + If the player has two or more cards at the end of his turn, the program has to reset the "UNO".
          - The player is not allowed to say "UNO" if he has more than two cards in his hand before playing or if he has more than one card after playing.
          - The program should not assign the "UNO" to a wrong player. 
          
      d. Point out Someone forgot to say "UNO"
          + The program should check if the player did really not said "UNO" and proceed accordingly.
          - It should not give any cards to a wrong player or make similar mistakes as pointed out in 'Draw a Card'.
          
      e. Challenge Someone who played a '+4 Wild Card'
          + The program should check/know if the player playing the card has a different card with matching color to the top card on the discard pile. 
          + It should remember which player challenged whom correctly.
               
      f. Declare the Color of the Next Card after playing some Type of Wild Card
          + It should remeber the input color as the only matching color for the wild card.
          - It should not assign the wrong color or let player disregard the required color.
       
      g. End you Turn
          + It should end the turn of the current player and start the turn of the next player accordingly to the direction.
          - It should not allow several players to take their turn simultaneously.
      

### C. What are the expected outputs, which ones should not happen.

Note: For accepted behaviour/input we denoted it with a '+' for declined behaviour/input with a '-'

    Set-Up
      
      a. Set Number of Players
          + It should give back a message showing the correct number of players.
          + It should return a message if the input is wrong.
          - Anything else.
          
      b. Set Players
        b.1. Put in a Playername
          + It should give back a message showing the playername and its playernumber.
          + It should return a message if the input is wrong.
          
        b.2. Put in a Playerage
          + It return a message showing the playername, its age and its playernumber.
          + It should return a message if the input is wrong.
          
      c. Set Score
          + It should return a message showing the score needed to win the game as a proposal.
          + It should return a message if the input is wrong.
          
      d. Accept Score
          + It should return a message showing that the score was accepted or declined.
          + It should return a message if the input is wrong.
          - Anything else.
      
    During Game
      
      a. Draw a Card
          + It shows the player who drew the card face up. The other players can only see the card face down.
          - It should not show any other player the card face up.
          - The program will not put the card directly onto the discard pile or draw from the discard pile or from some other players hand.
          
      b. Play a Card
          + It puts the card played face up onto the discard pile.
          - It does not put the card anywhere else. (I.e. Other players hand, onto the draw pile,....)
          
      c. Say "UNO"
          + It shows a message which confirms you said "UNO" to all players.
          - Any other or no output.
          
      d. Point out Someone forgot to say "UNO"
          + It gives the player who forgot to say "UNO" two cards from the top of the draw pile.
          - It should not give the wrong amont of cards and not to the wrong player.
          
      e. Challenge Someone who played a '+4 Wild Card'
          + It gives the challenged player 4 cards if he did 'cheat'. If not it gives the challenger 6 cards.
          - The program should not give the wrong player the wrong amount of cards.

      f. Declare the Color of the Next Card after playing some Type of Wild Card
          + It shows the color declared. 
          - Anything else.
       
      g. End your Turn
          + Show a message that you ended your turn sucessfully and whose turn it is next.
          + If you have not played anything and did not draw a card, it should show you that you cannot end your turn.
          - Anything else.

# 2. Class Diagram of the Design.
![class diagram](https://github.com/naepre/BINF4241_group29/blob/master/Assignment_5/class_diagram_assignment_5.jpg)
