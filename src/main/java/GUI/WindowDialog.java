package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowDialog extends JDialog {

    public WindowDialog(String message) {
        super((Window) null, "Exception");
        setSize(260, 160);

        JButton ok = new JButton("ok");
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                setVisible(false);
            }
        });
        JPanel panel = new JPanel();
        panel.add(ok);
        add(panel, BorderLayout.SOUTH);

        JLabel label = new JLabel(message);
        panel.add(label);
        add(panel, BorderLayout.CENTER);
    }
}
