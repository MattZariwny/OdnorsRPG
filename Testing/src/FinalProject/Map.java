package FinalProject;

import java.util.Scanner;
/**
 * This class will act as a 'Map' object.
 * The map object will primarily decide what options are available to the user
 * at any given point on the map.
 * It will give the user information on where they are, where they can go, and if they found any new items
 * in the area.
 *
 * Matthew Zariwny, December 10th, 2020.
 */
public class Map{
    //These variables will be changed once the user interacts with an area
    //in a certain way.
    //This allows us to have multiple outputs depending on what the user has done in this area
    //For example, area one will display the opening text for the game, but will not do the same
    //if the user re-enters the area.
    //This also applies to user picking up items, meaning they can only take an
    //item once.
    //All stages except the boss stage(7) and training stage(6) contain things that can only be interacted with once
    //The special case is stage #6, which involves transactions with a non-player character.
    //The boolean for stage 6 allows the user to decide whether or not to continue shopping.
    public static boolean stageOne = false;
    public static boolean stageTwo = false;
    public static boolean stageThree = false;
    public static boolean stageFour = false;
    public static boolean stageFive = false;
    public static boolean stageSix = false;
    public static boolean stageEight = false;
    public static String selector="";//This acts as the users input for most of these methods
    public static int nextStage;//This will be the return of most of these methods. It determines which stage the user
    //wants to go to next.
    public static Scanner input = new Scanner(System.in);//Getting player input

    public static Player mainPlayer = new Player();//Creating a new player object

    //Each method in this class will display certain lines to the user dependant
    //on which area they have moved to.
    public static int areaOne()
    {//If user has moved to areaOne (Riverbed)
        if (stageOne==false)
        {//If stageOne=false (user has not been here)
            mainPlayer.addAttack(1);//Print the first time text and add the attack from the item found
            System.out.println("You manage to wade the muck, finding yourself on a riverbed.");
            System.out.println("You take a moment to collect your thoughts and bask in the beauty of the rising sun.");
            System.out.println("Just before dosing off, you notice a small glint of light from the river bank.");
            System.out.println("The mysterious item turns out to be a small yet charming dagger.");
            System.out.println("Congratulations! You have increased your attack by 1 point.");
            System.out.println("Your current Attack is: "+mainPlayer.getPlayerAttack());//Display new attack stat to player
            stageOne=true;
        }
        else if (stageOne==true)
        {//if the player has been here before
            System.out.println("You find yourself back at the riverbed.");//Give a brief reminder of where this is
        }
        System.out.println("Man, this riverbed truly is gorgeous.");//This text will display whenever the user enters this
        System.out.println("But there is no time to waste, time to move on.");//stage, regardless of whether or not
        System.out.println("From here, you can only move to the right.");//they've been here before.
        System.out.println("Where do you choose to move?");//Ask user where they wanna go
        while (selector.equals(""))
        {//While user has not entered anything.
            selector=input.nextLine();//Get user input
            if (selector.toUpperCase().equals("RIGHT")||selector.toUpperCase().equals("R"))
            {//If user input is Right or R
                System.out.println("You move Right");//Tell the user where we're going
                nextStage=2;//Change the nextStage value to the equivilent stage
            }
            else
            {//If the user enters an impossible value
                System.out.println("Sorry, you've entered an invalid option. Please try again.");//Tell them to try again
                selector="";//Reset this variable so the loop repeats
            }
        }
        selector="";//Reset selector variable for next method
        System.out.println("----------------");//Print a line for visual appeal
        return nextStage;//Return the next stage variable

    }
    public static int areaTwo()
    {//If user has moved to areaTwo (Swamp area)
        if (stageTwo==false)
        {//If this is the players first time here
            mainPlayer.addDefense(1);//Add defense from found item
            System.out.println("You find yourself caught in a deep and thick mud.");//Tell user about the item
            System.out.println("You try to keep walking, which forces you to fall over into the muck.");
            System.out.println("As you are shoulder deep in the mud, you notice a piece of metal brush against your hand.");
            System.out.println("You pull it out to discover that you have found an iron chestplate.");
            System.out.println("Congratulations! You have increased your defense by 1 point.");
            System.out.println("");
            System.out.println("Your current Defense is: "+mainPlayer.getDefense());//Show user new defense stat
            stageTwo=true;//Change this to true so they wont see this again/acquire the item again.
        }
        else if (stageTwo==true)
        {//If user has been here before
            System.out.println("You find yourself back in the mud.");//Remind them where they are
        }
        System.out.println("Jeeze, it really it muddy around here.");//This text displays everytime user comes here
        System.out.println("You can currently move left, right or upwards.");//Inform user where they can go
        System.out.println("Where do you choose to move?");//Ask user where they want to go
        while (selector.equals(""))
        {//While no user input is detected
            selector=input.nextLine();//Get user input
            if (selector.toUpperCase().equals("LEFT")||selector.toUpperCase().equals("L"))
            {//if user says Left
                nextStage=1;//Set nextStage to corresponding stage
                System.out.println("You move Left");//Tell user they are moving
            }
            else if (selector.toUpperCase().equals("RIGHT")||selector.toUpperCase().equals("R"))
            {//If user wants to go right
                nextStage=3;//Set nextStage to corresponding stage
                System.out.println("You move Right");//Tell user
            }
            else if (selector.toUpperCase().equals("UP")||selector.toUpperCase().equals("U"))
            {//If user wants to go up
                nextStage=6;//Set nextStage to corresponding stage
                System.out.println("You move Up");//Tell user
            }
            else
            {//If user enters invalid option
                System.out.println("Sorry, you've entered an invalid option. Please try again.");//Tell them
                selector="";//Reset so loop continues
            }
        }
        selector="";//Reset variable for next method
        System.out.println("----------------");
        return nextStage;//Move onto next stage

    }
    public static int areaThree()
    {//If user has moved to areaThree (Starting area)
        if (stageThree==false)
        {//if user has never been here (this is the first stage the user will enter)
            System.out.println("PREPARE THYNSELF FOR A MOST PERILOUS JOURNEY!");//Display welcome text
            System.out.println("Your task in this game is to defeat Odnor.");//And give user idea of whats
            System.out.println("In order to defeat him, you must first collect");//happening
            System.out.println("some items from around the map in order to become stronger.");
            System.out.println("You currently have 10 Attack points, 5 Defense points, and 25 Health");
            System.out.println("------------------");
            stageThree=true;//Change this variable so it wont show these lines again
        }
        else if (stageThree==true)
        {//If user has been here before
            System.out.println("You find yourself back at the shack you started at.");//Remind them
        }
        System.out.println("You find yourself in a small shack. It smells of rotten eggs and the stench of death.");
        System.out.println("You can currently move Left, Right or Up");//Tell user where they can go
        System.out.println("Where do you choose to move?");//Ask them where they want to go
        while (selector.equals(""))
        {//While no user input detected
            selector = input.nextLine();//Get user input
            if (selector.toUpperCase().equals("LEFT")||selector.toUpperCase().equals("L"))
            {//If they want to go left
                nextStage=2;//Set nextStage to corresponding stage
                System.out.println("You move Left");//Tell user
            }
            else if (selector.toUpperCase().equals("RIGHT")||selector.toUpperCase().equals("R"))
            {//If they want to go right
                nextStage=4;//Set nextStage to corresponding stage
                System.out.println("You move Right");//Tell user
            }
            else if (selector.toUpperCase().equals("UP")||selector.toUpperCase().equals("U"))
            {//If they want to go up
                nextStage=5;//Set nextStage to corresponding stage
                System.out.println("You move Up");//Tell user
            }
            else
            {//If they enter invalid option
                System.out.println("Sorry, you've entered an invalid option. Please try again");//tell user
                selector="";//Reset variables
            }
        }
        selector="";//Reset selector for next method
        System.out.println("----------------");
        return nextStage;//Return the next stage value

    }
    public static int areaFour()
    {//If user has moved to areaFour (Burnt village)
        if (stageFour==false)
        {//If user is in area four
            mainPlayer.addAttack(2);//Add two to the players attack stat
            System.out.println("You move your way into a long forgotten village.");//Explain what they found
            System.out.println("You notice much of the buildings have been destroyed and charred.");
            System.out.println("You look around and notice a still standing blacksmith. You enter.");
            System.out.println("Almost everything is missing, yet one steel broadsword still remains.");
            System.out.println("You decide to take the broadsword");
            System.out.println("Congratulations! You have increased your attack by 2 points.");
            System.out.println("Your current attack is: "+mainPlayer.getPlayerAttack());//Display new attack stat
            stageFour=true;//Change this so it wont happen again
        }
        else if (stageFour==true)
        {//If they've been here before
            System.out.println("You find yourself back in the burnt village.");//Remind them
        }
        System.out.println("You take a moment to reminisce on the loss of life that occured in this village.");
        System.out.println("You are reminded of your quest, and how Odnor must be stopped before he destroys the earth.");
        System.out.println("From here, you can move up or left.");//Tell user where they can go
        System.out.println("Where do you choose to go?");//Ask them where they want to go
        while (selector.equals(""))
        {//While no user input detected
            selector=input.nextLine();//Get user input
            if(selector.toUpperCase().equals("LEFT")||selector.toUpperCase().equals("L"))
            {//If they want to go left
                System.out.println("You move left");//Tell them
                nextStage=3;//Set nextStage to corresponding stage
            }
            else if (selector.toUpperCase().equals("UP")||selector.toUpperCase().equals("U"))
            {//If they want to go up
                System.out.println("You move up");//Tell them
                nextStage=8;//Set nextStage to corresponding stage
            }
            else
            {//If they entered an invalid direction
                System.out.println("Sorry, you've entered an invalid option. Please try again.");//Tell user
                selector="";//Reset selector to keep loop running
            }
        }
        selector="";//Reset selector for next method
        System.out.println("----------------");
        return nextStage;//Return next stage
    }
    public static int areaFive()
    {//If user has moved into area five
        if (stageFive==false)
        {//If its the first time they've been here
            mainPlayer.addCoins(25);//Add 25 gold to users inventory
            System.out.println("You keep walking to find a small wishing well.");//Explain why
            System.out.println("Your coins are much too valuable to throw into the well,");
            System.out.println("so you choose to throw in a pebble.");
            System.out.println("The well begins to glow a gold color and vibrate softly.");
            System.out.println("A voice from the well begins speaking.");
            System.out.println("'Jeeze man, you must really be broke to toss in a pebble...' the voice says.");
            System.out.println("'It's your lucky day, for I feel generous.'");
            System.out.println("'I bestow upon you 25 gold pieces, don't spend them all in one place okay?'");
            System.out.println("The voice throws up a small satchel filled with coins.");
            System.out.println("Congratulations! You have just acquired 25 gold coins.");
            System.out.println("You currently have "+mainPlayer.getGold()+" coins.");//Show new gold count
            stageFive=true;//Change this so it wont happen again
        }
        else if (stageFive==true)
        {//If the user has been here before
            System.out.println("You find yourself back at the well.");//remind them
        }
        System.out.println("You debate fighting this mysterious well spectre, but choose not to.");
        System.out.println("From here you can move up or down.");//Tell user where they can go
        System.out.println("What do you choose to do?");//Get their input
        while (selector.equals(""))
        {//While no user input is detected
            selector=input.nextLine();//Get input
            if (selector.toUpperCase().equals("UP")||selector.toUpperCase().equals("U"))
            {//If user selects Up
                System.out.println("You move up");//Tell them
                nextStage=7;//Set nextStage to corresponding stage
            }
            else if (selector.toUpperCase().equals("DOWN")||selector.toUpperCase().equals("D"))
            {//if user selects down
                System.out.println("You move down");//Tell them
                nextStage=3;//Set nextStage to corresponding stage
            }
            else {//if user enters invalid direction
                System.out.println("Sorry, invalid direction. Please try again.");//Tell them
                selector="";//Reset variable
            }
        }
        selector="";//Reset variable for next method
        System.out.println("----------------");
        return nextStage;//Return nextStage
    }
    public static int areaSix()
    {//If the user enters areaSix (This area has a transaction, which requires a lot more code than the other areas)
        stageSix=false;//Make stageSix=false by default
        if (mainPlayer.getGold()<=24)
        {//If they player has no gold to spend
            System.out.println("The orc notices how light your pockets are");//Tell them theres nothing here for them
            System.out.println("and decides not to speak with you.");
        }
        else if (mainPlayer.getGold()>=25)
        {//if user has enough gold to spend
            while (stageSix==false)
            {//While stageSix==false
                selector="";//Reset selector
                System.out.println("You continue walking upwards, seeing a large orc sitting in a field.");
                System.out.println("You approach the orc.");//Display the message introducing the orc's shop
                System.out.println("'Hello!' you say.");//feature
                System.out.println("'Huh? Oh, Hello?' replies the orc.");
                System.out.println("You inform the orc of your quest to kill Odnor.");
                System.out.println("'You're going to need some extra skills for this one kid, ");
                System.out.println("would you like me to train you?'");
                System.out.println("The orc offers to increase your defense or attack by one level for 25 gold.");
                System.out.println("Would you like to take his offer? (Y/N)");//Ask the user if they want to spend gold
                while (selector == "")
                {//While no user input
                    System.out.println("(Gold: " + mainPlayer.getGold() + ". Attack: " + mainPlayer.getPlayerAttack() + ". Defense: " + mainPlayer.getDefense() + ".)");
                    //Line above displays user's gold, attack, and defense stats.
                    selector = input.nextLine();//Get user input
                    if (selector.toUpperCase().equals("Y"))
                    {//If user says yes
                        System.out.println("You decide to take the orc's offer.");//Tell them they accepted
                        System.out.println("Would you like to level up Attack or Defense? (A/D)");//Ask them is they want Attack of defense
                        selector = "";//Reset selector
                        while (selector.equals(""))
                        {//While no user input
                            selector = input.nextLine();//Get user input
                            if (selector.toUpperCase().equals("A"))
                            {//If they choose attack
                                mainPlayer.addCoins(-25);//Take away coins
                                mainPlayer.addAttack(1);//Add 1 to their attack stat
                                System.out.println("You chose to upgrade your attack.");//Remind them of their choice
                                System.out.println("Your new attack is: " + mainPlayer.getPlayerAttack());//Show new attack
                                System.out.println("You currently have " + mainPlayer.getGold() + " coins.");//Show new gold
                            }
                            else if (selector.toUpperCase().equals("D"))
                            {//If they chose Defense
                                mainPlayer.addCoins(-25);//Take 25 gold
                                mainPlayer.addDefense(1);//Add 1 defense point
                                System.out.println("You chose to upgrade your defense.");//Remind them of their choice
                                System.out.println("Your new defense is: " + mainPlayer.getDefense());//Show new defense
                                System.out.println("You currently have " + mainPlayer.getGold() + " coins.");//Show new gold
                            }
                            else
                                {//If they try to upgrade anything that isnt A or D
                                System.out.println("Invalid Selection, please try again.");//Invalid selection
                                selector = "";//Reset variable
                            }
                        }
                        stageSix=true;//once they finish their transaction set this to true to exit the loop
                    }
                    else if (selector.toUpperCase().equals("N"))
                    {//If user says no to transaction
                        System.out.println("You choose to decline the orcs offer.");//Tell them
                        System.out.println("'Come back if you change your mind' the orc says.");//Notify them they can come back
                        stageSix=true;//Set this to exit the loop

                    }
                    else
                        {//If they enter anything other than Y/N
                        System.out.println("Sorry, invalid choice. Please try again.");//Invalid choice
                        selector = "";//Reset selector
                    }
                }
                if (mainPlayer.getGold()>=25)
                {//If the player has more than 25 gold after talking to the orc
                    System.out.println("'Would you like to make another purchase?' the orc says. (Y/N)");
                    //Ask if they want to make another purchase
                    selector = "";//Reset selector
                    while (selector.equals(""))
                    {//Wait till user inputs
                        selector = input.nextLine();//Get user input
                        if (selector.toUpperCase().equals("Y"))
                        {//If its Y
                            System.out.println("You choose to make another purchase");//Inform user of their choice
                            stageSix=false;//Reset this to go back to the top of the loop
                        }
                    }
                }
            }
        }
        selector="";//Reset selector
        System.out.println("From here you can move only downwards.");//inform user where they can go
        System.out.println("Where do you choose to go?");//Ask for their input
        while(selector.equals(""))
        {//While no input
            selector=input.nextLine();//get input
            if (selector.toUpperCase().equals("DOWN")||selector.toUpperCase().equals("D"))
            {//If they choose Down
                System.out.println("You go down.");//inform them
                nextStage=2;//Set nextStage to corresponding stage
            }
            else
            {//If they choose anything else
                System.out.println("Sorry, invalid selection. Please try again.");//Invalid
                selector="";//Reset variable
            }
        }
        selector="";//Reset selector
        System.out.println("----------------");
        return nextStage;//Return nextStage
    }
    public static int areaSeven()
    {//If the user enters area seven (Boss fight)
        System.out.println("As you walk forward, you notice an eerie chill run down your spine.");
        System.out.println("You keep walking, and Odnor is laying in a pool of lava, asleep.");
        System.out.println("Would you like to attack Odnor? (Y/N)");
        while (selector.equals(""))
        {//While no user input has been selected
            selector=input.nextLine();//Get user input
            if (selector.toUpperCase().equals("Y"))
            {//If they say yes
                System.out.println("YOU HAVE CHOSEN TO FIGHT ODNOR!!!!");//Inform them they have chosen to figh
                System.out.println("Odnor has : "+Odnor.getOdnorHP()+"HP, "+Odnor.getOdnorAttack()+" Attack, "+ Odnor.getOdnorDefense()+" Defense.");
                //Display Odnor's health, attack, and defense
                System.out.println("You have :"+mainPlayer.getPlayerHP()+"HP, "+mainPlayer.getPlayerAttack()+" Attack, "+mainPlayer.getDefense()+" Defense.");
                //Display users health, attack and defense
                if (mainPlayer.getScroll()==true)
                {//If the user collected the scroll
                    System.out.println("Since you have the scroll, you get 3 hits before Odnor wakes up.");//Inform them of the benefits again
                    Odnor.changeOdnorHealth(mainPlayer.getPlayerAttack());//Allow the user 3 hits before entering
                    Odnor.changeOdnorHealth(mainPlayer.getPlayerAttack());//the main fight
                    Odnor.changeOdnorHealth(mainPlayer.getPlayerAttack());
                    System.out.println("After these attacks, Odnor's HP is: " + Odnor.getOdnorHP());//Show his new HP

                }
                System.out.println("Odnor wakes up quickly from his drunken stuper.");//Create some drama
                System.out.println("'You dare challenge me mere mortal! I WILL CRUSH YOU!' Odnor bellows");
                System.out.println("LET THE FIGHT BEGIN!!!!");
                while (Odnor.getOdnorHP()>=1 || mainPlayer.getPlayerHP()>=1)
                {//This loop will keep going until either the player or Odnor has an HP of 0
                    Odnor.changeOdnorHealth(mainPlayer.getPlayerAttack());//Change odnor's health based on the attack
                    //of the player and his defense
                    mainPlayer.changePlayerHealth(Odnor.getOdnorAttack());//Change user's health based on Ondor's attack
                    //and the user's defense.
                    System.out.println("Your HP after damage: "+mainPlayer.getPlayerHP());//Display users new HP
                    System.out.println("Odnor HP after damage: "+Odnor.getOdnorHP());//Display Ondor's new HP
                    System.out.println("--------------");//Formatting
                    if (Odnor.getOdnorHP()<=0)
                    {//If Ondor dies first
                        System.out.println("Odnor has been defeated.");//Tell the user he has been defeated
                        System.out.println("Congratulations, you have banished evil from the land!");
                        System.out.println("-------------------------");
                        nextStage=9;//Move to stage 9 (gameOver)
                        break;//Break out of the loop
                    }
                    else if (mainPlayer.getPlayerHP()<=0)
                    {//if player dies
                        System.out.println("You have been defeated...");//Tell the user
                        System.out.println("Odnor goes on to destroy the earth.");
                        System.out.println("You have failed...");
                        System.out.println("-------------------------");
                        nextStage=9;//move to stage 9
                        break;//Exit the loop
                    }
                }
            }
            else if (selector.toUpperCase().equals("N"))
            {//If user does not want to fight yet
                System.out.println("You choose not to attack Odnor.");//Tell them
                System.out.println("From here you can move Right or Down.");//Tell them where they can go
                System.out.println("Which do you choose?");//Ask for input
                selector="";//Reset input
                while(selector.equals(""))
                {//While input is empty
                    selector=input.nextLine();//Get input
                    if (selector.toUpperCase().equals("RIGHT")||selector.toUpperCase().equals("R"))
                    {//If user says right
                        System.out.println("You move right.");//Tell them
                        nextStage=8;//Move to corresponding stage
                    }
                    else if (selector.toUpperCase().equals("DOWN")||selector.toUpperCase().equals("D"))
                    {//If user enters down
                        System.out.println("You move down");//Tell them
                        nextStage=5;//Move to corresponding stage
                    }
                }
            }
        }
        selector="";//Reset selector for next method
        System.out.println("----------------");
        return nextStage;//Return nextStage
    }
    public static int areaEight()
    {//If the user enters area eight (Sneak Attack scroll)
        if (stageEight==false)
        {//If this is users first time here
            System.out.println("As you walk, you notice a home hidden withing fallen tree branches. You approach.");
            System.out.println("Once you get to the door, it violently swings open revealing a short wizard.");
            System.out.println("The wizard stares at you for a few minutes, before asking why you're here.");
            System.out.println("You inform the wizard of your quest.");//Tell them about the scroll
            System.out.println("'Oh that Odnor, always getting into trouble. Let me give you");
            System.out.println("something that may help' he says.");
            System.out.println("The wizard hands you a scroll with the words 'Sneak Attack' written on them.");
            System.out.println("Beyond this, you cannot understand the language written.");
            System.out.println("The wizard informs you that it is a sneak attack scroll.");
            System.out.println("This scroll will allow you to get 3 hits on Odnor before he can react.");
            System.out.println("The wizard wishes you well and promptly flies into the sun.");
            stageEight = true;//Change this so it wont happen again
            mainPlayer.addScroll();//Add the scroll to the users inventory
        }
        else if (stageEight==true)
        {//If they've been here before
            System.out.println("You arrive back to the wizards home.");//Remind them
        }
        System.out.println("From here you can move down or left.");//Tell the user their options
        System.out.println("Where do you choose to move.");//Request input
        while (selector.equals(""))
        {//While no input is detected
            selector=input.nextLine();//Get input
            if (selector.toUpperCase().equals("DOWN")||selector.toUpperCase().equals("D"))
            {//If user enters Down
                System.out.println("You choose to go Down.");//Tell them
                nextStage=4;//Go to corresponding stage
            }
            else if (selector.toUpperCase().equals("LEFT")||selector.toUpperCase().equals("L"))
            {//if user enters left
                System.out.println("You choose to go Left");//Tell them
                nextStage=7;//Move to corresponding stage
            }
        }
        selector="";//Reset selector for next method
        System.out.println("----------------");
        return nextStage;//Return nextStage
    }
}
