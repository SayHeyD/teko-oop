package Game;

public class Player {
    private static int health = 100;
    private static int coin = 0;
    private static int damage = 1;

    public static int getHealth() {
        return health;
    }

    public static int getCoin() {
        return coin;
    }

    public static int getDamage() {
        return damage;
    }

    public static void setHealth(int health) {
        Player.health = health;
    }

    public static void setCoin(int coin) {
        Player.coin = coin;
    }

    public static void setDamage(int damage) {
        Player.damage = damage;
    }

    public static void heal(int damage) {
        health += damage;
    }

    public static boolean loseHealth(int damage) {
        if (wouldDie(damage)) {
            return false;
        }

        health -= damage;
        return true;
    }

    public static void gainCoin(int coin) {
        Player.coin += coin;
    }

    public static boolean payCoin(int coin) {
        if (wouldGoIntoDebt(coin)) {
            return false;
        }

        Player.coin -= coin;
        return true;
    }

    private static boolean wouldDie(int healthToLose) {
        return health - healthToLose < 0;
    }

    private static boolean wouldGoIntoDebt(int coinToLose) {
        return coin - coinToLose < 0;
    }

    public static void die() {
        setHealth(0);
    }
}
