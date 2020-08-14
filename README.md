# Kaffa - Pre-qualification Tests (tests 1, 2 and 8)

---

# Tests #1 and #2 - CNPJ format and digits Validation Program

- What does this program do?

  This program tells you if a number you enter is a valid Brazil CNPJ, if it is in the correct formats or if it's a valid number (according to the rules of the Brazil's Revenue Service).


- I wanna see the code! Where are they?

  The tests 1 and 2 are merged in the same exercise, divided each one in its own java class, the solution code for the Test 1 can be found in the class `/src/kaffa_test/CNPJ_Format_Validation.java` and the Test 2 is in the class `/src/kaffa_test/CNPJ_Digit_Validation.java`


- How can I get it?

  After downloading this repository, you can execute a .jar (executable Jar file) inside the `Kaffa_Test_1_2/dist/Kaffa_Test.jar` just by double clicking it. As shown in the gif bellow:
  
![dist](https://user-images.githubusercontent.com/68413884/90218514-5d87a080-ddda-11ea-84f4-2793c901707f.gif)


- Ok, now How do I use it?

  In short, you only have to type a CNPJ number in the input field and click `Confirm`. It will show two dialogue boxes explaining if the given number is in a valid CNPJ format and if its digits are valid. `Clear Field` erases the input field and `Exit` terminates the program.
  
  The following gifs illustrates how this program is used:
  
![cnpj1](https://user-images.githubusercontent.com/68413884/90218080-514f1380-ddd9-11ea-9a55-dbbf038b564b.gif)

---

![cnpj2](https://user-images.githubusercontent.com/68413884/90218092-54e29a80-ddd9-11ea-9c3f-50f4a2d6aa8d.gif)

---

# Test #8 - Entity Relationship Diagram - Simple Order Manager

- This simple Diagram has only two entities, Clients and Products that has one relationship between them: Orders, aswell as each one's attributes as shown in the picture below.

![MER](https://user-images.githubusercontent.com/68413884/90291286-f576a000-de55-11ea-9afa-2544636a9222.jpg)

- Clients can order none or n products, aswell as products can be ordered by none or n clients.

- The primary keys in the Orders relationship are three: ID_Client, ID_Order and ID_Product. With this is possible to have more than one product per ID_Order.

- For the SQL command to list orders with number of itens, this database was created using Wampserver. The series of pictures below show its population and the results of the Query.

![design](https://user-images.githubusercontent.com/68413884/90291287-f60f3680-de55-11ea-90e7-b5f91da797ee.jpg)
**-Table design**

![products](https://user-images.githubusercontent.com/68413884/90291280-f4457300-de55-11ea-87b9-f66a3f453dff.jpg)
**-Products Table**

![clients](https://user-images.githubusercontent.com/68413884/90291284-f4de0980-de55-11ea-9e92-47c99a9578b4.jpg)
**-Clients Table**

![order](https://user-images.githubusercontent.com/68413884/90291285-f576a000-de55-11ea-8134-483f4182d2a8.jpg)
**-Order Table**

- To list the orders with the total number of items of each order, you can use the following SQL command:
```
SELECT O.ID_Order, SUM(O.Quantity) AS Number_of_itens`
FROM orders O
JOIN clients C
ON O.ID_Client = C.ID
JOIN products P
ON O.ID_Product = P.ID
GROUP BY O.ID_Order
```

The result of this query is the table of the picture below, it shows every ID order and sum the quantities of the items of each diferent ID regarding each different order.

![sql](https://user-images.githubusercontent.com/68413884/90291288-f60f3680-de55-11ea-932f-adf8380e1fd5.jpg)
**-SQL Result**
