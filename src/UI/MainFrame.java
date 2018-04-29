package UI;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by SauravSaha on 4/29/18.
 */
public class MainFrame extends JFrame {

    private final int HEIGHT = 500;
    private final int WIDTH = 240;

    public MainFrame() {

        this.setSize(WIDTH, HEIGHT);

        Container cp = getContentPane();

        JPanel p = new JPanel();

        BoxLayout b = new BoxLayout(p, BoxLayout.Y_AXIS);

        p.setLayout(b);

        p.setBorder(new LineBorder(Color.black, 5, false));
        p.setLocation(0,0);
        p.setSize(WIDTH/3, HEIGHT);
        cp.add(p);

    }
}
