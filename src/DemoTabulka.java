import javax.swing.*;

public class Menu extends JFrame {
    private JMenuBar menuBar = new JMenuBar();
    private JMenu akceMenu = new JMenu("Akce");
    private JMenuItem menuItem = new JMenuItem("Otevři");
    private JPanel panel1;
    private JFileChooser fileChooser = new JFileChooser(".");

    public Menu(){
        setContentPane(panel1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        akceMenu.add(menuItem);
        menuBar.add(akceMenu);
        setJMenuBar(menuBar);
        menuItem.addActionListener(e -> nactiAOtevri());
    }
    private void nactiAOtevri(){
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION){
            JOptionPane.showMessageDialog(this, fileChooser.getSelectedFile().getAbsolutePath());
        }
    }
}
