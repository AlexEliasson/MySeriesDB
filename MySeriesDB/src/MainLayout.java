import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alexander on 2016-03-21.
 */
public class MainLayout extends JFrame{
    private JPanel rootPanel;
    private JButton button1;
    private JTextArea textArea1;

    public MainLayout(){
        super("Main");
        setContentPane(rootPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(rootPanel.getPreferredSize());
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog( null, "Hello World!" );
            }
        });

        setVisible(true);
    }
}
