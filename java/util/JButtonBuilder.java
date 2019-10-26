package util;

import javax.swing.*;
import java.awt.*;

public class JButtonBuilder {
    private final JButton button;

    public JButtonBuilder(String text) {
        button = new JButton(text);

        button.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(255, 153, 0));

        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.setPreferredSize(new Dimension(202, 113));
        button.setMinimumSize(new Dimension(202, 113));

        button.setBorder(null);
        button.setBorderPainted(false);
    }

    public JButtonBuilder fontSize(int size) {
        button.setFont(new Font("Segoe UI", Font.PLAIN, size));
        return this;
    }

    public JButtonBuilder foreground(Color color) {
        button.setForeground(color);
        return this;
    }

    public JButtonBuilder background(Color color) {
        button.setBackground(color);
        return this;
    }

    public JButtonBuilder cursor(Cursor cursor) {
        button.setCursor(cursor);
        return this;
    }

    /**
     * @param cursor a constant value from {@link java.awt.Cursor}
     * @return the builder itself
     */
    public JButtonBuilder cursor(int cursor) {
        button.setCursor(new Cursor(cursor));
        return this;
    }

    public JButton build() {
        return button;
    }
}
