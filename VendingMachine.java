import java.util.HashMap;

public class VendingMachine {
  private class Slot {
    public String itemName;
    public int numberLeft;
    public double price;

    public Slot(String item, int quantity, double price) {
      itemName = item;
      numberLeft = quantity;
      this.price = price;
    }

    @Override
    public String toString() {
      return String.format("%s, $%.2f (%d left)", itemName, price, numberLeft);
    }

    public void dispense() {
      System.out.println("Dispensing " + itemName + ".");
      numberLeft -= 1;
    }
  }

  private double amountPaid = 0.00;
  private HashMap<String, Slot> slots = new HashMap<String, Slot>();

  public VendingMachine() {
    slots.put("A1", new Slot("Cool Ranch Doritos", 10, 1.25));
    slots.put("A2", new Slot("BBQ Fritos", 7, 0.75));
    slots.put("A3", new Slot("Cinnamon rolls", 0, 2.00));
  }

  public void inspect() {
    System.out.println("---------");

    System.out.printf("Amount paid: $%.2f\n", amountPaid);

    System.out.println("---------");

    slots.forEach((id, slot) ->
      System.out.println(id + ": " + slot.toString())
    );
  }

  public void pay(double amount) {
    amountPaid += amount;
  }

  public void press(String slotId) {
    if (!slots.containsKey(slotId)) {
      System.out.println("No such slot!");
      return;
    }

    Slot slot = slots.get(slotId);

    if (slot.numberLeft <= 0) {
      System.out.printf("Sorry, no %s left.", slot.itemName);
      System.out.flush();
      return;
    }

    if (slot.price > amountPaid) {
      if (amountPaid == 0) {
        System.out.printf( "%s cost $%.2f.", slot.itemName, slot.price);
        System.out.flush();
        return;
      }

      System.out.printf(
        "%s cost $%.2f, but you've only paid $%.2f.",
        slot.itemName,
        slot.price,
        amountPaid
      );
      System.out.flush();
      return;
    }

    amountPaid -= slot.price;

    slot.dispense();

    if (amountPaid > 0) {
      System.out.printf("Please take your change: $%.2f", amountPaid);
      System.out.flush();

      amountPaid = 0;
    }
  }
}
