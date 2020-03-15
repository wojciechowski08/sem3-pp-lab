import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Coin  extends JFrame {

    private JButton button;
    private JTextField outHeads, outTails;
    private int headsCount = 0, tailsCount = 0;
    private JLabel headsLabel = new JLabel("heads");
    private JLabel tailsLabel = new JLabel("tails");
    private Random toss = new Random();

    public Coin() {

        super("Coin");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        button = new JButton("Toss a coin");
        outHeads = new JTextField(10);
        outTails = new JTextField(10);
        button.setBackground(Color.CYAN);
        button.addActionListener((ActionEvent e) -> {
            if (toss.nextBoolean()) {headsCount++; outHeads.setText(String.valueOf(headsCount));}
            else {tailsCount++; outTails.setText(String.valueOf(tailsCount));}
        });
        outHeads.setEditable(false); outHeads.setText(String.valueOf(headsCount));
        outTails.setEditable(false); outTails.setText(String.valueOf(tailsCount));
        c.add(button);
        c.add(headsLabel); c.add(outHeads);
        c.add(tailsLabel); c.add(outTails);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Coin frame = new Coin();
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.setSize(500,100);
                frame.setVisible(true);
            }
        });
    }

}
