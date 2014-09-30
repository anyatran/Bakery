RUN THE PROGRAM:
 Go to program's directory and type these commands:
 	- javac Run.java
 	- java Run

The Bakery software uses a console-based menu system for navigation.
The main menu is divided into three main sections: client management,
order management and inventory management. There is also an option to dump
the bakery state to a file.

Each submenu provides procedures for adding and updating data, as well as
special functionality depending on the section type.

By default, when the interface is launched it will load data from two
files "bakeryItems.txt" and "orders.txt" which contain the inventory
and order data respectively. To load an empty bakery, simply do not supply
these files in the program directory.

In the customers submenu (item 1 on the main menu), one can add and
update customers, as well as view customer loyalty status and contact
information.

In the orders submenu (item 2 on the main menu), one can add and update
orders as well as view orders by customer, item, order date, pickup date
and unpaid orders.

In the inventory submenu (item 3 on the main menu), one can add and update
inventory items as well as view a menu of items available.

One can also export all store data to "orders1.txt" and "bakeryItems1.txt"
by selecting item 4 on the main menu, "Export data".
