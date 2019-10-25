# BINF4241_group29

Description: A java chess game for 2 players! 

Usage:
  1. To start the game, please run the program.
  
  2. First you are ordered to input the white chess player's name! (Any signs are allowed!) 
     Next you'll have to input the black chess player's name.
  
  3. To make a move you have to input any move in the algebraic notation. 
     - Specify the piecetype you are moving with its first letter in capital! (B = Bishop, K = King, Q = Queen, N = Knight, R = Rook, p = no name input)
     - Specify the targeted field, where you want to move to with writing the letters from 'a - h' for the columns
       and '1 - 8' for the rows. (The chessfield is labeled accordingly.)
     - For eating a piece please put in an 'x' before the specification of the targeted field. (Otherwise you are not allowed to do that.)
     - You input should contain 2 to 4 characters depending on the piecetype and movetype you want to move.
  
  4. The following rules are implemented:
     - Moving all pieces according to the chess rules!
     - Being able to make a Kingside and Queenside castling. In the Form: O-O (for Kingside), O-O-O (for Queenside) [don't use zeros, use big o's]
       (At the moment we are not sure, if it works! The last push was troublesome and probably deleted a crucial part of the code.)
     - Being prevented to make a move which puts your King into check.
     - Being able to put the opposing king into check and forcing him to move!
     - Being able to promote your pawn.
     - Being able to propose a draw!
  
  5. The following rules are missing:
     - Hitting an opposite pawn according to the "en passant" rule. 
       (This move was left out because of lack of time. Due to the complexity of the move and it's rare occurence, 
        we decided to try to implement it last, when everything else is working. We did not manage to start with the implementation.
        In theory the function would need to be an exception for the eat functions. Where you have to be able to eat diagonally an "empty" field with your pawn.
        It also needs an "allow_enpassant" counter which only is not zero when the opposite player, moved his pawn two steps forward from its starting position.
        So if the "allow_enpassant" counter is not zero, you can eat diagonally if the field above (for white) or below (for black) is occupied by a pawn.)
     - The Checkmate statement is missing too. We were programming on this checkmate function, but due to a missuse of git, 
       we accidentally deleted our checkmate function on friday 25.10.19 at around 17:00 and we were not able to restore or reproduce it until the deadline.
       If you get into an checkmate, you will still be allowed to input a move as a player, but none of your possible input movements will be accepted by the game,
       because all of them would set your King check. You will be trapped in an infinite loop of getting asked where you want to move and giving your input. 
       Except if you offer a draw!
       (The checkmate move is rather big to programm, but in theory easy.
       It contains of 3 parts! 
       If the opposite King is checked we check:
       A. If he can move to any empty space around him and won't be in check
          or if he can eat the piece checking him without being in check!
       B. If any of his piece can eat the piece which is checking him and prevent him for being checked anymore.
       C. If any of his piece can move between the King and it's checker to protect him.
       If none of this holds, he is a checkmate!) 
       
   6. Enjoy the game!
  
  
  
  
