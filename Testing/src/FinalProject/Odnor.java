package FinalProject;

/**
 * This class will act as the object Odnor, the final boss of the game
 * Odnor will have 3 states:
 *      -25 Health
 *      -9 Attack
 *      -10 Defense
 *Odnor will have a few methods which will just allow other parts of the program to 'get' those
 * values.
 * Odnor also has a function which affects his health. This will be used in the final battle.
 *
 * Matthew Zariwny, December 10th, 2020.
 */
public class Odnor {
    public static int odnorHP = 25;//Creating Odnor's stats
    public static int odnorDefense = 10;
    public static int odnorAttack = 9;

    //Ondor does not need to be an object, as we can use static methods to change his stats.
    //This means there is no constructor for him

    public static void changeOdnorHealth(int damage)
    {//This method affects Odnor's health
        if (odnorDefense>damage)
        {//If odnor's defense is greater than the players damage
            //Do nothing (no affect to his health)
        }
        else
        {//If odnor's defense is less than the players damage
            odnorHP = odnorHP - (damage-odnorDefense);//Remove damage-odnorDefense from Odnor's health
        }
    }

    public static int getOdnorHP()
    {//This gets Odnor's HP stat
        return odnorHP;
    }
    public static int getOdnorDefense()
    {//This gets Odnor's Defense stat
        return odnorDefense;
    }
    public static int getOdnorAttack()
    {//This gets Odnor's Attack stat
        return odnorAttack;
    }

}
