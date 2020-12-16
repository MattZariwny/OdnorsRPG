package FinalProject;

/**
 * This class will act as the main starting point of the game
 * This game will act as a simple text-based RPG game.
 * The player will have HP and the ability to explore the map using
 * left, right, up, and down options.
 * The player begins with 10 attack, and 5 defense with 25 health and 25 gold.
 * The boss of the game has 9 attack and 10 defense.
 * Throughout the map are some key items which will help the player defeat the boss.
 * Things like defense increasing items, attack increasing items and a special item which
 * allows the player to deal 3 strikes of damage before the boss gets a turn.
 * There is also a "shop" area in the map. In this area the user can spend their gold on defense
 * or attack points, 25 gold per point. The player can also find a gold satchel with 25 pieces
 * in the map.
 *
 * Matthew Zariwny, December 10th, 2020.
 */
import java.util.Scanner;//Import the scanner for user inputs
public class FinalProjectTestHarness {
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);
        String confirmation = "";
        //This array will act as our stage tracker. One value for each area of the map
        //This will allow us to track where the player is and to display the correct
        //information.
        int [] stage = {1,2,3,4,5,6,7,8,9};
        boolean gameOver=false;
        int stageSelect = 3;//This variable will be compared to the array to find which stage we're on
                            //Stage 3 is the starting Area

        while (confirmation.equals(""))
        {//While the user has not inputted anthing
            //Opening explanation to the user
            System.out.println("Hello, and welcome to the world's greatest text-based RPG!");
            System.out.println("Throughout this game, you will be able to explore a preset map.");
            System.out.println("You will be presented with several directions you can travel to from each area.");
            System.out.println("To travel in a direction, simply put the direction in the input field.");
            System.out.println("(You can also put just the first letter of the direction)");
            System.out.println("");
            System.out.println("You'll need to explore the map and acquire key items in order to defeat the game's boss:");
            System.out.println("ODNOR!!!!!!!!");
            System.out.println("");
            System.out.println("Odnor is no easy foe, so make sure you get some items before trying to fight!");
            System.out.println("Please enter anything to confirm your understanding.");
            confirmation = input.nextLine();//Getting confirmation user understands basics of the game.
        }

        //This for loop essentially just clears the screen, adding a bunch of lines until
        //the intro is gone
        for (int i=0; i<=15; i++)
        {
            System.out.println("");
        }

        //This switch statement exists to showcase it's functionality.
        switch (stageSelect) {
            case 3://If stageSelect is 3 (it is by default)
            while (gameOver == false)
            {//This code will loop forever until the game has completed (Player or Odnor dies)
                try {//Try to run the main code of the game

                    //These if statements are where most of the games code will run.
                    //The stageSelect will determine which stage the user is on, and the final returned value
                    //of that stage will become the next stage
                    //I.e if the user decides to go left, the return of that function would be the stage
                    //to the left of the current stage. This will then change StageSelect, sending them into
                    //the method which represents the stage they are going to.
                    if (stageSelect == stage[0])
                    {//If the stageSelect is equal to stage[0] (1)
                        stageSelect = Map.areaOne();//Make stage select equal to the return of Map.areaOne()
                    }
                    else if (stageSelect == stage[1])
                    {//If the stageSelect is 2
                        stageSelect = Map.areaTwo();//Make the next stage select equal to the reutn of areaTwo
                    }
                    else if (stageSelect == stage[2])
                    {//If the stageSelect is 3
                        stageSelect = Map.areaThree();//Make the next stage select equal to the return of areaThree
                    }
                    else if (stageSelect == stage[3])
                    {//If the stageSelect is 4
                        stageSelect = Map.areaFour();//Make the next stageSelect equal to the return of 4
                    }
                    else if (stageSelect == stage[4])
                    {//If stage select if 5
                        stageSelect = Map.areaFive();//Make the stage select equal to the return of 5
                    }
                    else if (stageSelect == stage[5])
                    {//If stage select is 6
                        stageSelect = Map.areaSix();//Make the next stageSelect equal to the return of 6
                    }
                    else if (stageSelect == stage[6])
                    {//If stage select is 7
                        stageSelect = Map.areaSeven();//Make the next stageSelect equal to the return of 7
                    }
                    else if (stageSelect == stage[7])
                    {//If stageSelect is 8
                        stageSelect = Map.areaEight();//Make the next stageSelect equal to the return of 8
                    }
                    else if (stageSelect == stage[8])
                    {//If stage select is 9 (only possible by completing the game)
                        gameOver = true;//Turn gameover to true (To end the loop)
                        System.out.println("Thanks for playing!");//Give the user a goodbye message
                    }
                } catch (ArrayIndexOutOfBoundsException e) {//If the program somehow tries to access an index out of bounds of the array, we go here.
                    System.out.println("Program Crashed, try again.");
                    gameOver = true;
                }
            }
            break;
            case 9:
                System.out.println("Game Over");
                break;
        }
    }
}
