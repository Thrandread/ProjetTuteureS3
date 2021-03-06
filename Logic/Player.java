/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author Flavien
 */


public class Player {
    
    private static final int MAXIMUM_INVENTORY = 5; //Number of items that you can have into your inventory
    private Item[] inventory; //contient tableau d'items dispos
    private Weapon weapon; //contient références vers weapons
    private Classe classePerso;
    private String name;
    private int gold;
    
    //Constructor
    public Player(){
        this.inventory = new Item[MAXIMUM_INVENTORY];
        this.weapon = new Weapon();
        this.classePerso = new Classe();
        this.name = "Unknown";
        this.gold = 0;
    }
    public String toString(){
        int i = 0;
        String returningString = "name : "+name+"\n"+
                                "amount of gold : "+gold+"\n"+
                                "class of character : "+classePerso.getName()+"\n"+
                                "Current weapon : "+weapon.getName()+"\n"+
                                "Inventory : - ";
        while (i<MAXIMUM_INVENTORY-1 && inventory[i+1]!=null){
            returningString = returningString+inventory[i].getName()+"\n            - "; 
            i++; 
        }
        if (inventory[i]!=null){
            returningString = returningString+inventory[i].getName()+"\n";
        }
        else if (i==0 && inventory[i]==null) {
            returningString = returningString+"Empty\n";
        }
        return returningString;
    }
    
    public void gainGolds(int amount){
        this.gold = gold+amount;
    }
    public void looseGolds(int amount){
        this.gold = gold-amount;
    }
    
    public void addItemToInventory(Item item){
        int i=0;
        while (i<MAXIMUM_INVENTORY && this.inventory[i] != null){
            i++;
        }
        if (i==MAXIMUM_INVENTORY){
            System.out.println("Inventaire plein");
        }
        else {
            inventory[i]=item;
        }
    }
    
    
    
    //getters
    public Item[] getInventory() {
        return this.inventory;
    }
    public Weapon getWeapon(){
        return this.weapon;
    }
    public Classe getClassePerso(){
        return this.classePerso;
    }
    public String getName() {
        return name;
    }
    public int getGold() {
        return gold;
    }
    
    //setters
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public void setClassePerso(Classe classePerso) {
        this.classePerso = classePerso;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }
    
    
}
