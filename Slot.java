/*
Description: This is the data definition class for a Slot object. A slot is identified by a slot identifier (must be two characters long 
with the first character as uppercase letter and the last character as a digit), item name, item price, amount in inventory, and the amount 
sold. Additionally, each slot should track how many slots are in use and the total cost earned (item price * amount sold). These consist of 
the static (numSlots, totalEarnings) and instance variables (slotId, itemName, itemPrice, inventory, sold) shown below.

Input - none (no direct input and output since this is a DDC)
 
Output - none 

*/
public class Slot {
   //Static Variables: a single copy of the variable is created and shared among all objects
   private static int numSlots;
   private static double totalEarnings;
   //Instance Variables: defined in class for which each instantiated object has a separate copy/instance
   public String slotId;
   private String itemName;
   private double itemPrice;
   private int inventory;
   private int sold;

   //Constructor: used to initialize objects
      //parameters: String slotId, String itemName, double itemPrice, int inventory, int sold
      //return type: none 
   public Slot(String slotId, String itemName, double itemPrice, int inventory, int sold) {    
      //validation (all validation is explained in mutators comments)
      if(itemName == null || itemName.equals("")) {
         throw new IllegalArgumentException("Invalid name.");
      }
      else if(itemPrice <= 0){
         throw new IllegalArgumentException("Invalid price.");
      }
      else if(inventory <= 0){
         throw new IllegalArgumentException("Invalid inventory amount.");
      }
      
      else if(slotId.length() != 2|| !Character.isLetter(slotId.charAt(0)) || !Character.isUpperCase(slotId.charAt(0)) || !Character.isDigit(slotId.charAt(1)) || slotId == null || slotId.equals("")){
         throw new IllegalArgumentException("Invalid ID, must be an upper case letter followed by a number.");
      }
      
      sold = 0;
      this.itemName = itemName;
      this.itemPrice = itemPrice;
      this.inventory = inventory;
      this.slotId = slotId;
   //Increment number of slots
      numSlots++;
   }
   
   //Accessors: used to get the value of instance variables
      //parameters: none
      //return type: String
   public String getSlotId() {
      return this.slotId;
   }
      //parameters: none
      //return type: String
   public String getName() {
      return this.itemName;
   }
      //parameters: none
      //return type: double
   public double getPrice() {
      return this.itemPrice;
   }
      //parameters: none
      //return type: int
   public int getInventory() {
      return this.inventory;
   }
      //parameters: none
      //return type: int
   public int getSold() {
      return this.sold;
   }
      //parameters: none
      //return type: int
   public static int getNumSlots() { 
      return numSlots;
   }
      //parameters: none
      //return type: double
   public static double getTotalEarnings() {
      return totalEarnings;
   }
   
   //Mutators: used to set the value of instance variables (with validation)
      //validation: if itemName is null or nothing is entered, value is not valid 
      //parameters: String itemName, return type: none
   public void setItemName(String itemName){
      if(itemName == null || itemName.equals("")) {
         throw new IllegalArgumentException("Invalid name,");
      }
      this.itemName = itemName; 
   }
      //validation: if slotId's length is not 2, the first character isn't an uppercase letter, and the second is not a number, or the value is null or nothing is entered, value is ot valid 
      //parameters: String slotId, return type: none
   public void setSlotId(String slotId){
      if(slotId.length() != 2 || !Character.isLetter(slotId.charAt(0)) || !Character.isUpperCase(slotId.charAt(0)) || !Character.isDigit(slotId.charAt(1)) || slotId == null || slotId.equals("")) {
         throw new IllegalArgumentException("Invalid ID, must be an uppercase letter followed by a number.");  
      }
      this.slotId = slotId;
   }
      //validation: if itemPrice is less than 0, value is not valid  
      //parameters: double itemPrice, return type: none
   public void setPrice(double itemPrice){
      if(itemPrice <= 0){
         throw new IllegalArgumentException("Invalid price.");
      }
      this.itemPrice = itemPrice;
   }
      //validation: if inventory is less than 0, value is not valid
      //parameters: int inventory, return type: none
   public void setInventory(int inventory){
      if(inventory <= 0){
         throw new IllegalArgumentException("Invalid inventory amount.");
      }
      this.inventory = inventory;
   }
   
   //Special Purpose Methods: have a specific job - to calculate some value  
      //returns the instance variables needed in a well formatted string
      //parameters: none, return type: String
   public String toString(){
      return "Item: " + this.getName()+ " \nSlot ID: "+ this.getSlotId()+ " \nPrice: " + this.getPrice()
         +"\nStock: "+ this.getInventory() + "\n";
   }
      //adds the current item's price * the amount that is sold (and rounds it) to the static variable totalEarnings
      //parameters: none, return type: double
   public double calcTotalEarnings() {
      return totalEarnings += (((itemPrice * sold) * 100) / 100);
   }
      //returns the instance variable sold and increments it by 1
      //parameters: none, return type: int
   public int incrementSold() {
      return sold++;
   }
      //returns the instance variabl inventory and increments it by 1
      //parameters: none, return type: int
   public int decrementInventory() {
      return inventory--;
   }
}