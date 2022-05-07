package ui.components.inputpanel;

import model.Warehouse;
import ui.WarehouseApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public abstract class InputPanel extends JComponent implements ActionListener {
    private static final char[] ADMIN_PASSWORD = {'a', 'l', 'a', 'n', 'a'};
    public static final Color SUCCESS_TEXT_COLOR = new Color(58, 163, 64);
    public static final Color ERROR_TEXT_COLOR = new Color(187, 14, 8);
    protected Warehouse warehouse;
    protected WarehouseApplication warehouseApplication;

    public InputPanel(Warehouse warehouse, WarehouseApplication warehouseApplication) {
        this.warehouse = warehouse;
        this.warehouseApplication = warehouseApplication;
        addActionListeners();
    }

    public abstract void clearUserInputs();

    public abstract void addActionListeners();

    public abstract void submitInput();

    protected String refineText(String text) {
        return text.trim().toLowerCase();
    }

    // EFFECTS: converts a Date to an equivalent LocalDate and returns it
    protected LocalDate getLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZonedDateTime zoneDataTime = instant.atZone(ZoneId.systemDefault());
        return zoneDataTime.toLocalDate();
    }

    // EFFECTS: returns true if passwords equivalent, otherwise false
    protected boolean passwordEquivalent(char[] input) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] != ADMIN_PASSWORD[i]) {
                return false;
            }
        }
        return true;
    }
}
