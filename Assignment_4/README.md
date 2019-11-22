# BINF4241_group29 -- Assignment 4

# Design choices

We decided to generalize behaviour that is common amongst appliances into a super-class called Appliance.
Behaviour unique to each appliance is implemented within each appliance class. Each appliance inherits from the Appliance class.
Specific to the Command Design Pattern, the unique appliances classes (Oven, Microwave, DishWasher, WashingMachine, CleaningRobot) are the receivers. The MainMenu is the Invoker and responsible to the lifecycles of each appliance. The MainMenu receives commands from the user by digesting userInput from a main while loop and invoking the command by passing it down to the respective receiving appliance that is responsible for performing the command.



# How to use

1. Start the program with Run.
2. Interact with the console dialog that request only digits betwenn 0-9.
3. Navigate around the main menu and sub menu as you wish.

# Challenges encountered
The Timer inner class which is common across all appliances necessarily needs to be powered by threads. However, once a thread is finished it's execution, the main program thread needs to know to update the state of an appliance, specifically cooking stopped, baking stopped etc. We found this undoable without blocking the main program thread or using Callables.
  

# Class diagram

![class diagram](https://github.com/naepre/BINF4241_group29/blob/master/Assignment_4/class_diagram_4.jpeg)
  
