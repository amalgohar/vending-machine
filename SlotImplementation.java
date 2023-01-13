/*
Description: This is the implementation class for the Slot object. This program mimics the use of a vending machine (w/a max of 30 slots).
The user is presented with a menu that has 5 options: add a slot, empty a slot, purchase an item, display items, and exit the program.
When adding a slot, the user is able to add an item to the vending machine. When emptying a slot, the user is able to remove an item from
the vending machine. When purchasing an item, the user is able to buy an item from the vending machine, which reduces its inventory and adds
to the total amount earned. When displaying items, the user is able to see all items in the vending machine and their information. And finally,
when exiting the program the user is able to stop entering in additional data and see a final report of the total amount of slots and total
amount earned.

Input - slotID, itemName, itemPrice, inventory
 
Output - slotID, itemName, itemPrice, inventory, numSlots, totalEarnings

*/
import javax.swing.JOptionPane;
import java.text.NumberFormat;
public class SlotImplementation{
   public static void main(String[] args){
   //Constant variable: variables who's value does not change (the max amount of slots or items allowed to be entered)
      final int MAX_SLOTS = 30;
   //Slot array initialization: intializes an array of the max possible amount (30)
      Slot[] slots = new Slot[MAX_SLOTS];
   //Menu options
      String menu = "";
      //Do-while loop: continuously prompts user until the user indicates they are finished (by clicking the 'Exit Program' option)
      do{
         menu = createMenu();
         switch(menu){ 
            case "Add Slot": 
               //validation: if the maximum number of slots is entered, the user is given an error message
               if(Slot.getNumSlots() >= MAX_SLOTS) 
                  JOptionPane.showMessageDialog(null,"Invalid, you have entered the max number of slots.");
               else
                  slots[Slot.getNumSlots()] = addSlot();             
               break;
            case "Empty Slot":  
               //validation: if there are no slots to empty, the user is given an error message
               if(Slot.getNumSlots() == 0) {
                  JOptionPane.showMessageDialog(null, "There are no slots to empty.");
               }else{
                  emptySlot(slots);
               }
               break;
            case "Purchase Item": purchaseItem(slots);
               break;   
            case "Display Items": displayItems(slots);  
               break;
               
            default: exit(slots);
         }
      } while(!menu.equalsIgnoreCase("Exit Program"));     
   }

   //Creating the menu: creates the menu with the 5 options that the user will be able to choose from
      //parameters: none, return type: String
   public static String createMenu() {
      String[] menu = {"Add Slot", "Empty Slot", "Purchase Item","Display Items","Exit Program"};
      return (String) JOptionPane.showInputDialog(null, "Select an option","Slot Options", JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);
   }

   //Option 1: Adding slot
      //parameters: none, return type: String
   public static Slot addSlot() {
      Slot slotAdded = null;
      //Do-while loop: prompts the user to enter the information (slotId, itemName, itemPrice, inventory) on the Slot until the user enters it
      do{
         try{
            slotAdded = new Slot(JOptionPane.showInputDialog("Please enter the SLOT ID (should be an uppercase letter then a number):"),
                           (JOptionPane.showInputDialog("Please enter the NAME of the item:")),
                           Double.parseDouble(JOptionPane.showInputDialog("Please enter the PRICE:")),
                           Integer.parseInt(JOptionPane.showInputDialog("Please enter the INVENTORY amount:")),
                           0);
                           
         } 
         catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
         }
      } while(slotAdded == null);
      return slotAdded;
   }
   
   //Option 2: Emptying slot
      //parameters: Slot object array, return type: void
   public static void emptySlot(Slot[] slots) {
      //first displays all items so that user is able to see which Slot they which to remove
      displayItems(slots);
      String emptySlot;
      int index = -1;
      emptySlot = JOptionPane.showInputDialog("Please enter the SLOT ID of the slot you would like to take out:");
     
      //For loop: finds the index in the array of the Slot that the user wishes to take out (and sets it to the variable index)
      for (int i = 0; i < slots.length; i++){
         if (slots[i] != null && slots[i].getSlotId().equals(emptySlot)){
            index = i;
         }   
      }
      //validation: checks to see if there is a Slot existing for the slotId that the user has entered 
      if(index == -1) {
         JOptionPane.showMessageDialog(null, "The SLOT ID you entered does not exist.");
      }else{
         slots[index] = null;
      }
   }
   
   //Option 3: Purchasing item
      //parameters: Slot object array, return type: void
   public static void purchaseItem(Slot[] slots){
      //first displays all items so that user is able to see which Slot item they which to purchase
      displayItems(slots);
      String purchaseSlot;
      if (Slot.getNumSlots() == 0){
         JOptionPane.showMessageDialog(null, "There are no slots available.");
      }else{
         purchaseSlot = JOptionPane.showInputDialog("Please enter the SLOT ID of the item you wish to buy");
         //validaton: checks to see that the user has entered a valid slotId (first character is an uppercase letter, and second is a number, and something is entered)
         if(purchaseSlot.length() !=2 || !Character.isLetter(purchaseSlot.charAt(0)) || !Character.isUpperCase(purchaseSlot.charAt(0)) || (!Character.isDigit(purchaseSlot.charAt(1))) || (purchaseSlot == null) || (purchaseSlot.equals(""))) {
            JOptionPane.showMessageDialog(null, "Invalid SLOT ID, enter a letter followed by a number.");
         }else{ 
            int index = -1;
         //For loop: finds the index in the array of the Slot that the user wishes to purchase (and sets it to the variable index)
            for(int i = 0; i < slots.length; i++) {
               if(slots[i] != null && slots[i].getSlotId().equals(purchaseSlot)) {
                  index = i;
                  break;       
               }
            }
            //validation: checks to see if there is a Slot existing for the slotId that the user has entered 
            if(index == -1) {
               JOptionPane.showMessageDialog(null, "The SLOT ID you entered does not exist.");
            }else if ((slots[index].inventory) > 0) {
            //increments the variable sold and decrements the variable inventory by calling the corresponding special purpose methods
               slots[index].incrementSold();
               slots[index].decrementInventory();
               slots[index].calcTotalEarnings();
               JOptionPane.showMessageDialog(null,"Your item has been dispensed.");
            }
         }
      }
   }
   
   //Option 4: Displaying items 
      //parameters: Slot object array, return type: none
   public static void displayItems(Slot[] slots){
      String print = "";
      //For loop: goes through all Slots available in the array and calls the toString method to out put the instance variables in a String
      for (int i = 0; i < slots.length; i++) {
         if(slots[i] != null)
            print += slots[i].toString() +"\n" ;
      }
      //formats the earnings
      NumberFormat formatter = NumberFormat.getCurrencyInstance();
      String formattedTotalEarnings = formatter.format(Slot.getTotalEarnings());
      //prints all items and their information/instance variables as well as the static variable totalEarnings in a well formatted report
      JOptionPane.showMessageDialog(null, "Items available: \n" + print
                                         +"Total money earned: " + formattedTotalEarnings);
   }
   
   //Option 5: Exit
      //parameters: Slot object array, return type: none
   public static void exit(Slot[] slots){
      int totalSlots = 0;
      //validation: if no Slots exist or have been created, the user is notified that no slots were entered 
      if (Slot.getNumSlots() == 0) {
         JOptionPane.showMessageDialog(null, "No slots were entered.");
      }else{
         totalSlots = Slot.getNumSlots();
      }
      //formats the earnings
      NumberFormat formatter = NumberFormat.getCurrencyInstance();
      String formattedTotalEarnings = formatter.format(Slot.getTotalEarnings());                
      //prints the static variable numSlots and totalEarnings in a well formatted report
      JOptionPane.showMessageDialog(null, "Number of slots entered: " + totalSlots
                                         + "\nTotal money earned: " + formattedTotalEarnings);
   }
}