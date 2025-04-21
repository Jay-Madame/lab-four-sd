# Object-Oriented Programming with Java
## Spring 2025
### Jon Baarsch

## Lab Three
### Double Due Dates:
**Part One:** Due Sunday, March 9  
**Part Two:** Due Tuesday, March 18

## 1. Data Visualization Tool
Create an application that consumes and presents data. This project is more open-ended than prior projects because you will choose your own data. The way you present the data will depend on the dataset you select. Here are a couple of sources you might explore: [Harvard DataVerse](https://dataverse.harvard.edu/) and [WorldBank Databank](https://databank.worldbank.org/).

### Minimum Standards/Requirements:
#### **Data/Logic Layer:**
1. The data must be read from a file and should come from a legitimate data source.
2. You need to use Collections in some way.
3. You need to use Streams to consume/process the data.

#### **Visualization Layer (TablePanel, StatsPanel, ChartPanel, DetailsPanel):**
1. You should have a table showing discrete data elements. This might not show all the data related to each item, but should display the main points. A details panel (below) will show all the details for a selected item in the table.
2. You should be able to sort the table by selecting the column to sort on.
3. You should have toggleable filters (at least three) that allow changes to the displayed data.
4. You should have a stats table showing aggregate statistics for the data (at least three stats). You can calculate the stats yourself or use an external library such as [Apache Commons Math](https://commons.apache.org/proper/commons-math/).
5. You should have some sort of graphical depiction of the data—a chart of some sort. You can make the chart yourself or use an external library such as [JFreeChart](http://www.jfree.org/jfreechart/).
6. You should have a details panel that shows the details of any item selected in the table.

## **Part One:**
### **A. Console Test Application**
When the program is run in a console application:
1. Print out the attributes of the first data item in the file.
2. Print out the attributes of the 10th item in the file.
3. Display the total number of entries in the dataset.

### **B. GUI Test Application**
When the program is run as a GUI application, it should display the data in a table:
- **Start the Application** → Data appears in TablePanel.
- **Start the Application** → Application has a clear title.
- **Start the Application** → Columns in the table are clearly labeled.

## **Part Two:**
This phase adds the other GUI features: the detail panel, the stats panel, and the chart panel.

## **Test Cases:**
| Action | Expected Outcome |
|--------|-----------------|
| Start the Application | Data appears in TablePanel. |
| Start the Application | Data appears in StatsPanel. |
| Start the Application | Image appears in ChartPanel. |
| Start the Application | Application has a clear title. |
| Start the Application | Columns in the table are clearly labeled. |
| Start the Application | Chart is clear and clearly labeled. |
| Select a filter and filter some data out | Once filtered, the data in the TablePanel changes. |
| Select a filter and filter some data out | Once filtered, the data in the StatsPanel changes. |
| Select a filter and filter some data out | Once filtered, the image in the ChartPanel changes. |
| Remove all Filters | TablePanel, ChartPanel, and StatsPanel change back. |
| Re-Sort the items in the table | Table items change order, but Stats and Chart do not change. |
| Select a data point in the table | Data for that item appears in the DetailsPanel. |
| Select a different data point | Data for that item appears in the DetailsPanel. |
