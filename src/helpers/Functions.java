package helpers;

import javax.swing.*;
import java.awt.*;

public class Functions {
    static public void showPanel(JPanel contentPanel, String panelName) {
        CardLayout cl = (CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, panelName);
    }
}
