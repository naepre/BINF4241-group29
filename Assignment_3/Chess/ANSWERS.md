#### Usage:
  1. To start the game, please run the program.
  
  2. First you are ordered to input the white chess player's name! (Any signs are allowed!) 
     Next you'll have to input the black chess player's name.
  
  3. To make a move you have to input any move in the algebraic notation. 
     - Specify the piecetype you are moving with its first letter in capital! (B = Bishop, K = King, Q = Queen, N = Knight, R = Rook, p = no name input)
     - Specify the targeted field, where you want to move to with writing the letters from 'a - h' for the columns
       and '1 - 8' for the rows. (The chessfield is labeled accordingly.)
     - For eating a piece please put in an 'x' before the specification of the targeted field. (Otherwise you are not allowed to do that.)
     - You input should contain 2 to 4 characters depending on the piecetype and movetype you want to move.


# PART 1

## Design pattern one: Observer

Definition:
An observer is used to notify subscribers when a certain object it is observing changes its state.

### Why did we choose to implement an observer?
We chose this type of design pattern for several reasons. 
1.	We already had a similar structure to this concept, so it is easy to implement.
2.	With this observer we can decrease the size of our main which had too many jobs and thus improving its structure.
3.	We may just have one subscriber for our observer right now, so one could argue it is a useless intermediate object, but this observer can be very useful for implementing other objects which need the updated board. I. e. If we wanted to implement a proper checkmate object we can also subscribe it to our channel to get the current state of the board and then look for a checkmate on it.

### How did we implement the observer?
An observer class called Channel is instanciated in the subject: Game.
When the the game class changes state, namely the board variable, it calls updateBoard in Channel, passing along the updated board variable. Channel subsequentially passes the new board variable to it's subscribers, currently PrintOutToTerminal.

**Please see Observer class diagram integrated with the Singleton class diagram down below!**


### Observer Sequence Diagram
![observer sequence diagram](https://github.com/naepre/BINF4241_group29/blob/master/Assignment_3/Chess/observer%20sequence%20diagram%20part1.jpeg)


## Design pattern two: Singleton

Definition:
The Singleton Pattern ensures a class has only one instance, and provides a global point of access to it. 


### Why did we choose to implement a singleton?
We chose this type of design pattern for several reasons. 
1.	We already had a similar structure to this concept, so it is easy to implement.
2.	We chose to make our game a singleton, since you only want to have one game running at the time. With a singleton we can ensure that there won’t be any second or third game initiated during the runtime of our program, especially considering that multiple objects may interact with the game class.


### How did we implement the singleton?
We created a **private static game object** called uniqueGame and then we created a **public static synchronized function call getInstance()**. This gives us a new game if uniqueGame is null or hands us back the actual uniqueGame.


### Observer and Singleton class diagram
![singleton and observer class diagram](https://github.com/naepre/BINF4241_group29/blob/master/Assignment_3/Chess/Observer_And_Singleton_Class_Diagram.jpg)


### Singleton sequence diagram
![singleton sequence diagram](https://github.com/naepre/BINF4241_group29/blob/master/Assignment_3/Chess/singleton%20sequence%20diagram.jpeg)




# PART 2
The parts highlighted in blue signify the main situations when the board is updated.
The board is a local variable of the game. (Even though this is probably not the canonical object-oriented principle)

### Board sequence diagram
![observer sequence diagram](https://github.com/naepre/BINF4241_group29/blob/master/Assignment_3/Chess/board%20sequence%20diagram.jpeg)





# PART 3
We decided to implement an observer pattern scoreboard as that easily extends from what we already can do after implementing part 1 of this assignment. Specifically, we implemented a class called Scoreboard that subscribes to the observer: Channel and receives updated hit lists for both white and black players. For each hit list, we iterate, identifying eaten pieces and increment a score integer accordingly. Finally, the scores are printed.
Hint: To quickly test this implementation try the following sequence of moves:
White begins:
1. e4
2. e5
3. Qf3
4. f6
5. Qxf6
6. xf6
