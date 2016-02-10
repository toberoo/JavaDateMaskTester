import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateMaskGUI {
    private JTextField DateInput;
    private JTextField MaskInput;
    private JButton TestButton;
    private JLabel DateLabel;
    private JLabel MaskLabel;
    private JLabel ResultLabel;
    private JPanel dateMaskView;

    public DateMaskGUI() {
        TestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Get the inputs
                String date = DateInput.getText();
                String mask = MaskInput.getText();

                //Test Inputs
                if (date == null || date.isEmpty()) {
                    ResultLabel.setForeground(Color.RED);
                    ResultLabel.setText("Error: date Field is Empty");

                } else if (mask == null || mask.isEmpty()) {
                    ResultLabel.setForeground(Color.RED);
                    ResultLabel.setText("Error: mask Field is Empty");

                //If we have regular values
                } else {
                    SimpleDateFormat formatter = new SimpleDateFormat(mask);
                    try {
                        Date test = formatter.parse(date);
                        ResultLabel.setForeground(Color.getColor("00cc66"));
                        ResultLabel.setText("\u2713 Successful!");
                    } catch (Exception ex) {
                        ResultLabel.setForeground(Color.RED);
                        ResultLabel.setText("Error: mask does not work with date");
                    }
                }
            }
        });
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame("DateMaskGUI");
        frame.setContentPane(new DateMaskGUI().dateMaskView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
