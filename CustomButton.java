import javax.swing.*;
import java.awt.*;

public class CustomButton extends JButton {
    public CustomButton(String text) {
        super(text);
        setFont(new Font("Arial", Font.PLAIN, 14));
        setBackground(new Color(0, 120, 215)); // Blue background
        setForeground(Color.WHITE); // White text
        setBorderPainted(false);
        setFocusPainted(false);
        setPreferredSize(new Dimension(120, 30));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setToolTipText("Click to " + text);
    }
}

