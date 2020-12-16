package FinalProject;

/**
 * This class will act as a player object
 * The player will have 8 state values:
 *      -25 Health
 *      -5 Defense
 *      -10 Attack
 *      -25 Gold
 *      -SneakAttack Item
 *      -Chestplate Item
 *      -Sword Item
 *      -Dagger Item
 *Each item will by default be 'false' meaning the player does
 * not have that item.
 *
 * The players state will change based on how they play. They can increase
 * damage and defense in a few ways across the map.
 * They can also acquire the "SneakAttack" item which will allow them to
 * perform 3 strikes before the boss can attack, giving them a big advantage
 *
 * The Player will have a few methods, which mainly affect
 * the players stats and inventory.
 *
 * Matthew Zariwny, December 10th, 2020.
 */
public class Player {
    //These first four variables are the default player's stats
    private int playerHP=25;
    private int playerDefense=5;
    private int playerAttack=10;
    private int gold = 25;
    //This last variable will represent whether or not the user
    //has collected the sneakAttack scroll.
    private boolean sneakAttack=false;

    //Lets create the constructor for the player
    //Once again, the player's state is set to a default, so we do not need
    //to have a custom constructor
    public Player()
    {

    }

    public void addDefense(int amount)
    {//This method adds 'amount' to the players defense. This will be called by a few areas and the
        //amount of defense increase is different.
        playerDefense=playerDefense+amount;
    }
    public void addDefense(double amount)
    {//This method exists to showcase method overloading
        //This method also showcases casting from a double to an int.
        playerDefense=playerDefense+(int)amount;
    }
    public int getDefense()
    {//This gets the players defense so it can be used
        return playerDefense;
    }

    public int getPlayerHP()
    {//This gets the players HP
        return playerHP;
    }

    public void addAttack(int amount)
    {//This adds attack points to the players attack stat.
        playerAttack=playerAttack+amount;
    }
    public int getPlayerAttack()
    {//This gets the players attack stat
        return playerAttack;
    }

    public void addCoins(int amount)
    {//This adds coins to the players inventory
        gold=gold+amount;
    }
    public int getGold()
    {//This gets the players gold count
        return gold;
    }

    public void addScroll()
    {//This changed the players scroll value from false to true.
        //This means that the player has found the scroll on the map to use.
        sneakAttack=true;
    }
    public boolean getScroll()
    {//This gets whether or not the player has a scroll
        return sneakAttack;
    }

    public int changePlayerHealth(int damage)
    {//This method affects the players damage in the final battle.
        if (playerDefense>damage)
        {//If the damage done is less than the players defense
            //Do nothing (no affect to health)
        }
        else
        {//If the players defense is not greater than the damage received
            playerHP = playerHP - (damage-playerDefense);//Remove that damage-playerDefense from the players health
        }
        return playerHP;//Return the players HP.
    }

}
