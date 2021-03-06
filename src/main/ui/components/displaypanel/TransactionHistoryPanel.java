package ui.components.displaypanel;

import model.Warehouse;

import javax.swing.*;
import javax.swing.table.TableRowSorter;

/**
 * Displays the Transaction History
 */
public class TransactionHistoryPanel extends DisplayPanel {
    private JPanel transactionHistoryPanel;
    private JTextField filterInput;
    private JButton clearButton;
    private JButton filterButton;
    private JTable transactionHistoryTable;
    private TableRowSorter<MyTableModel> historyInventorySorter;

    public TransactionHistoryPanel() {
        // NOTE: cannot call addActionListener in supertype DisplayPanel as $$$SetupUI$$$ gets called after call to
        // super type constructor
        addActionListeners();
    }

    @Override
    public void addActionListeners() {
        this.clearButton.addActionListener(this);
        this.filterButton.addActionListener(this);
    }

    @Override
    public void clearUserInputs() {
        this.filterInput.setText("");
    }

    @Override
    public JTextField getFilterInput() {
        return this.filterInput;
    }

    @Override
    public TableRowSorter<MyTableModel> getTableRowSorter() {
        return this.historyInventorySorter;
    }

    @Override
    protected MyTableModel createTableModel() {
        Warehouse warehouse = this.warehouseApplication.getWarehouse();
        return new MyTableModel(warehouse.getOrders(false), DISPLAY_COLUMN_NAMES);
    }

    @Override
    protected void setSorter(TableRowSorter<MyTableModel> sorter) {
       this.historyInventorySorter = sorter;
    }

    @Override
    protected JTable getTable() {
        return this.transactionHistoryTable;
    }
}
