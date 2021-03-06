# Warehouse Management Application
|![warehouseapp](https://user-images.githubusercontent.com/82549471/167297442-4b55203e-a464-4b70-a8e5-f29fbf85f9c6.png)|
|:--:|
|Warehouse management application GUI designed using Java Swing|

### About
Many professional-grade warehouse applications are packed with complex features and analytical tools that have the potential to be extremely helpful. But it can often times be over-complicated and difficult to use/understand. Commercial warehouse applications are also generalized to suit the needs of a general Warehouse business and may fall short to a company's unique needs. The design of this app was inspired and tailored to resolve some of the problems my co-workers and I had experienced, during my time as a book keeper at a warehouse/transportation company.  

The application logic was developed via Test-Driven-Development (TDD) using Java and Junit 5, while the graphical user-interface was constructed using Java Swing and Intellij GUI Designer with the intent of keeping things simple.

Some key features that the application supports are:
- Import/Export Orders
- Partial Exports
- Adding/Deleting Clients
- Editing/Deleting existing Orders
- Add Monthly Charge Records
- Save Data as a JSON file
- Load Data from JSON file
- View Current Inventory
- View Historical Transactions
- Filter/Search Current Inventory and Historical Transactions

---

<!-- USAGE EXAMPLES -->

## Demonstration

### Importing products
|![importing](https://user-images.githubusercontent.com/82549471/167299324-5d336689-63c9-48fd-bab9-5e44f0b5a538.gif)|
|:--:|
|Products can be imported by specifying details in the import panel that can be selected on the left hand side. Any invalid inputs were handled using exceptions.|
### Exporting Products
|![ezgif com-gif-maker (3)](https://user-images.githubusercontent.com/82549471/167300217-31fceac1-efa6-47ad-881e-c2b02c8cedd6.gif)|
|:--:|
|The application supports partial and full export of inventory products. Every partial removal is recorded under the export column for each product. Fully exported products will be removed from current inventory and have records kept under the history display panel.|
### Filtering through Current Inventory & Past Transactions
|![ezgif com-gif-maker (2)](https://user-images.githubusercontent.com/82549471/167299939-55287385-5ebf-483f-9c16-ec1823cc82fe.gif)|
|:--:|
|The entries in current inventory and History can be filtered by adding a keyword and clicking the "Filter" button. To return back to original inventory, click "Clear".|
### Loading Data From File
|![ezgif com-gif-maker (2)](https://user-images.githubusercontent.com/82549471/167299694-136b7f4f-cb07-4db6-a27c-0275022f499b.gif)|
|:--:|
|Previously saved data can be opened by clicking the "Load" button, located on the top-left of the GUI, and selecting the file and pressing open. |
### Saving Data to File
|![ezgif com-gif-maker (2)](https://user-images.githubusercontent.com/82549471/167299849-aec725b8-0384-4bb8-b89c-f930ba117060.gif)|
|:--:|
|Current warehouse state can be saved by clicking the "Save" button, located on the top-right of the GUI, and specifying the file and destination to save to|

---

## Technologies

- [Java](https://www.oracle.com/ca-en/java/)
- [Java Swing](https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html)
- [Intellij GUI Designer](https://www.jetbrains.com/help/idea/gui-designer-basics.html)
- [JUnit 5](https://junit.org/junit5/)

---

## Getting Started

1. Clone the repository
   ```sh
   git clone https://github.com/patricknoda11/warehouse-management-app.git
   ```
2. Run main using an IDE that supports Java (e.g. IntelliJ, Eclipse)
![ezgif com-gif-maker](https://user-images.githubusercontent.com/82549471/167298659-d79f6673-503b-4398-b385-53d952ce85d8.gif)

---
