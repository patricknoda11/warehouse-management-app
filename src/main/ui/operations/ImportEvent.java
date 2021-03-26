package ui.operations;

import model.Package;
import model.Warehouse;
import ui.WarehouseApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// This class handles the import portion of the warehouse application gui
public class ImportEvent implements ActionListener {
    private WarehouseApplication warehouseApplication;
    private Warehouse myWarehouse;
    private JDialog importDialog;
    private JLabel communicatorText;
    private Package newPackageToImport;
    private JLabel ownerName;
    private JTextField ownerNameField;
    private JLabel ownerAddress;
    private JTextField addressField;
    private JLabel ownerPhoneNumber;
    private JTextField phoneNumberField;
    private JLabel packageContent;
    private JTextField packageContentField;
    private JLabel packageSize;
    private JTextField packageSizeField;
    private JButton cancelButton;
    private JButton enterButton;

    // MODIFIES: this
    // EFFECTS: ImportEvent constructor
    public ImportEvent(WarehouseApplication app, Warehouse myWarehouse, JLabel communicatorText) {
        ownerName = new JLabel("Owner Name: ");
        ownerNameField = new JTextField();
        ownerAddress = new JLabel("Owner Address: ");
        addressField = new JTextField();
        ownerPhoneNumber = new JLabel("Owner Phone Number: ");
        phoneNumberField = new JTextField();
        packageContent = new JLabel("Package Content: ");
        packageContentField = new JTextField();
        packageSize = new JLabel("Package Size: \n Please enter one of large, medium or small");
        packageSizeField = new JTextField();
        cancelButton = new JButton("Cancel");
        enterButton = new JButton("Enter");

        this.warehouseApplication = app;
        this.myWarehouse = myWarehouse;
        this.communicatorText = communicatorText;
    }

    // MODIFIES: this
    // EFFECTS: if the number of packages in inventory is < to the max warehouse capacity,
    //          creates dialog for package import.
    //          otherwise, indicates to the user that inventory is full
    public void generateImportPackageDialog() {
        int numberOfPackagesInInventoryBeforeImport = this.myWarehouse.getNumberPackagesInInventory();
        if (numberOfPackagesInInventoryBeforeImport < Warehouse.MAX_WAREHOUSE_CAPACITY) {
            this.importDialog = new JDialog(this.warehouseApplication, "Import Package");
            importDialog.setLayout(new GridLayout(6,2));
            organizeImportPackageDialogContent();
            importDialog.setSize(750, 300);
            importDialog.setLocationRelativeTo(null);
            importDialog.setVisible(true);
        } else {
            communicatorText.setText("\nWarehouse inventory is full... Cannot import package\n");
        }
    }

    // MODIFIES: this
    // EFFECTS: organizes/structures the content found on the import package dialog
    private void organizeImportPackageDialogContent() {
        importDialog.add(ownerName);
        importDialog.add(ownerNameField);
        importDialog.add(ownerAddress);
        importDialog.add(addressField);
        importDialog.add(ownerPhoneNumber);
        importDialog.add(phoneNumberField);
        importDialog.add(packageContent);
        importDialog.add(packageContentField);
        importDialog.add(packageSize);
        importDialog.add(packageSizeField);
        importDialog.add(cancelButton);
        importDialog.add(enterButton);
        cancelButton.addActionListener(this);
        enterButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: directs user to correct operation given button clicked
    //          disposes dialog once finished and updates current inventory display on main JFrame window
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        Toolkit.getDefaultToolkit().beep();

        if (actionCommand.equals("Cancel")) {
            importDialog.dispose();
        }

        if (actionCommand.equals("Enter")) {
            generateNewPackageToImport();
            myWarehouse.importPackage(newPackageToImport);
            communicatorText.setText("Package " + newPackageToImport.getPackageID()
                    + " has been stored in the inventory."
                    + " The warehouse inventory now has: " + myWarehouse.getNumberPackagesInInventory() + " items");
            warehouseApplication.updateCurrentInventoryDisplay();
            importDialog.dispose();
        }
    }

    // MODIFIES: this
    // EFFECTS: creates new package to be imported into inventory
    private void generateNewPackageToImport() {
        int packageID = myWarehouse.getImportHistorySize() + 1;
        newPackageToImport = new Package(ownerNameField.getText(),
                addressField.getText(),
                phoneNumberField.getText(),
                packageContentField.getText(),
                packageSizeField.getText(),
                String.valueOf(packageID));
    }
}