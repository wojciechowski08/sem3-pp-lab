import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ButtonClicks extends JFrame {

    private static String labelPrefix = "Button clicks ";
    private int numClicks = 0;
    private JLabel label = new JLabel(labelPrefix + 0);
    private  JButton button;

    public ButtonClicks() {
        super("Button Clicks");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        button = new JButton("Click me");
        button.setBackground(Color.CYAN);
        button.setMnemonic(KeyEvent.VK_C); // skrot klawiszowy alt c
        button.setToolTipText("Shortcut: Alt+C"); // wskazowka

        button.addActionListener((ActionEvent e) -> {numClicks++; label.setText(labelPrefix + numClicks);});
        /* przed wersją Java 8 trzeba było pisać tak:
        button.addActionListener(new ActionListener() { // zarejestruj słuchacza
        public void actionPerformed(ActionEvent e) {
        numClicks++;
        label.setText(labelPrefix + numClicks);
        }
        }); // koniec anonimowej klasy wewnętrznej
        */
        c.add(button); // dodaj do pulpitu
        c.add(label);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ButtonClicks frame = new ButtonClicks();
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.setSize(350, 90);
                frame.setVisible(true);
            }
        });
    }

}
