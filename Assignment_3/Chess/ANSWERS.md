#PART 1

##Design pattern one: Observer

Definition:
An observer is used to notify subscribers when a certain object it is observing changes its state.

###Why did we choose to implement an observer?
We chose this type of design pattern for several reasons. 
1.	We already had a similar structure to this concept, so it is easy to implement.
2.	With this observer we can decrease the size of our main which had too many jobs and thus improving its structure.
3.	We may just have one subscriber for our observer right now, so one could argue it is a useless intermediate object, but this observer can be very useful for implementing other objects which need the updated board. I. e. If we wanted to implement a proper checkmate object we can also subscribe it to our channel to get the current state of the board and then look for a checkmate on it.

###How did we implement the observer?
An observer class called Channel is instanciated in the subject: Game.
When the the game class changes state, namely the board variable, it calls updateBoard in Channel, passing along the updated board variable. Channel subsequentially passes the new board variable to it's subscribers, currently PrintOutToTerminal.


![observer class diagram](url)


![observer sequence diagram](url)


##Design pattern two: Singleton

Definition:
The Singleton Pattern ensures a class has only one instance, and provides a global point of access to it. 


###Why did we choose to implement a singleton?
We chose this type of design pattern for several reasons. 
1.	We already had a similar structure to this concept, so it is easy to implement.
2.	We chose to make our game a singleton, since you only want to have one game running at the time. With a singleton we can ensure that there won’t be any second or third game initiated during the runtime of our program, especially considering that multiple objects may interact with the game class.


###How did we implement the singleton?
We created a **private static game object** called uniqueGame and then we created a **public static synchronized function call getInstance()**. This gives us a new game if uniqueGame is null or hands us back the actual uniqueGame.



![singleton class diagram](url)


![singleton sequence diagram](url)




#PART 2

![board sequence diagram](url)





#PART 3
We decided to implement an observer pattern scoreboard as that easily extends from what we already can do after implementing part 1 of this assignment. Specifically, we implemented a class called Scoreboard that subscribes to the observer: Channel and receives updated hit lists for both white and black players. For each hit list, we iterate, identifying eaten pieces and increment a score integer accordingly. Finally, the scores are printed.
Hint: To quickly test this implementation try the following sequence of moves:
White begins:
1. e4
2. e5
3. Qf3
4. f6
5. Qxf6
6. xf6
