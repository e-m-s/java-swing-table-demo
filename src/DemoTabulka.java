import cz.oauh.model.Zakaznik;
import cz.oauh.model.ZakaznikTableModel;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DemoTabulka extends JFrame {
    private JMenuBar menuBar = new JMenuBar();
    private JMenu akceMenu = new JMenu("Akce");
    private JMenuItem menuItem = new JMenuItem("Otevři");
    private JPanel panelMain;
    private List<Zakaznik> data = new ArrayList<>();
    private JTable tbZakaznici;

    private JFileChooser fileChooser = new JFileChooser(".");

    public DemoTabulka(){
        setContentPane(panelMain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initMenu();
        setSize(600, 400);
        naplnData();
        tbZakaznici.setModel(new ZakaznikTableModel(data));
    }

    private void naplnData() {
        data.addAll(
                List.of(
                        new Zakaznik("Karel", LocalDate.of(2000,1,1)),
                        new Zakaznik("Jana", LocalDate.of(2003,12,15)),
                        new Zakaznik("Ivana", LocalDate.of(1998,11,1))
                )
        );
    }

    private void initMenu() {
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
    public static void main(String[] args) {
        DemoTabulka menu = new DemoTabulka();
        menu.setVisible(true);
    }

}
