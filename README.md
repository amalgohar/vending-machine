# 🍬 Vending Machine

## ✍️ Description
This repository contains a Java program that mimics the use of a vending machine by collecting the number of sales and keeping track of inventory. A `Slot` object is defined for and has properties such as slot identifier, item name, item price, amount in inventory, and the amount sold. It also tracks the total number of slots and total earnings. 

## 📝 Breakdown & Usage
* There is the Slot.java Class (Data Definition Class) and the SlotImplementation.java Class (Implementation Class).
* It provides a simple menu-driven interface through JOptionPane with options to add slots, empty slots, purchase items, display items, and exit the program, and includes validation for user inputs.

## ⚙️ How to Run
1. Compile both Slot.java and SlotImplementation.java.
2. Run the SlotImplementation class.
3. Follow the menu prompts to interact with the vending machine simulation.

## 💻 Demo 
### Option 1: Add Slot
  The user can add a slot to the vending machine by specify values for the input required. This then becomes an item inside the vending machine that the user can purchase. 
  ![](https://github.com/amalgohar/vending-machine/blob/main/AddSlot.gif)

### Option 2: Empty Slot  
  The user can remove a slot from the vending machine by specifying the slot identifier of the item that they wish to remove from the inventory. 
  ![](https://github.com/amalgohar/vending-machine/blob/main/EmptySlot.gif)
  
### Option 3: Purchase Item
  The user can purchase an item from the vending machine by specifying the slot identifier of the item that they wish to purchase. This will in turn decrease the inventory for the selected item and add the amount that the items costs to the total earnings that the vending machine has made.
  ![](https://github.com/amalgohar/vending-machine/blob/main/PurchaseItem.gif)

### Option 4: Display Items
  The user can see a list of all the items that are in the vending machines inventory, with their name, slot ID, price, and stock shown. 
  ![](https://github.com/amalgohar/vending-machine/blob/main/DisplayItems.gif)
  
### Option 5: Exit
  The user can exit the program when finished and see a short summary that shows the total number of slot items entered during the duration of the program (including slots that may have been empties), as well as the total amount of money that the vending machine earned based on items purchased.
  ![](https://github.com/amalgohar/vending-machine/blob/main/Exit.gif)
