package pkm.characters;

import java.util.Random;

public abstract class Pokemon {
    public static final int GRASS = 1;
    public static final int WATER = 2;
    public static final int FIRE = 3;
    private String name;
    private int type;
    private float life;
    private int damage;
    private boolean ran_away = false;

    public Pokemon(String name, int type, float life, int damage) {
        this.name = name;
        this.type = type;
        this.life = life;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public float getLife() {
        return life;
    }

    protected void setLife(float life) {
        this.life = life;
    }

    public int getDamage() {
        return damage;
    }

    public boolean ranAway() {
        return ran_away;
    }

    public void runAway() {
        ran_away = true;
    }

    public boolean isAlive() {
        return life > 0;
    }

    private float damageCalc(float damage) {
        Random rand = new Random();
        return rand.nextFloat() * damage / 2 + damage / 2;
    }

    private void takeDamage(float damage) {
        life -= damage;
        if(life < 0) life = 0;
    }

    public void attack(Pokemon enemy) {
        switch(type) {
            case GRASS:
                switch(enemy.type) {
                    case GRASS:
                        enemy.takeDamage(damageCalc(damage));
                        break;

                    case WATER:
                        enemy.takeDamage(damageCalc(damage * 2));
                        break;

                    case FIRE:
                        enemy.takeDamage(damageCalc(damage / 2));
                        break;
                }
                break;
            case WATER:
                switch(enemy.type) {
                    case GRASS:
                        enemy.takeDamage(damageCalc(damage / 2));
                        break;

                    case WATER:
                        enemy.takeDamage(damageCalc(damage));
                        break;

                    case FIRE:
                        enemy.takeDamage(damageCalc(damage * 2));
                        break;
                }
                break;
            case FIRE:
                switch(enemy.type) {
                    case GRASS:
                        enemy.takeDamage(damageCalc(damage * 2));
                        break;

                    case WATER:
                        enemy.takeDamage(damageCalc(damage / 2));
                        break;

                    case FIRE:
                        enemy.takeDamage(damageCalc(damage));
                        break;
                }
                break;
        }
        
    }
}
