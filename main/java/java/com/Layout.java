import javax.swing.*;
import java.awt.*;

public class Layout extends JFrame {
    public void startGui() {
        JFrame oknoGłowne = new JFrame("System zarządzania turniejem");
        //oknoGłowne.setMinimumSize(new Dimension(10, 40));
        //oknoGłowne.setLocationRelativeTo(null);
        oknoGłowne.setDefaultCloseOperation(EXIT_ON_CLOSE);
        oknoGłowne.setJMenuBar(addMenuBar());
        // oknoGłowne.add(addMainPanel());
        oknoGłowne.setVisible(true);
        oknoGłowne.pack();
    }

    private JMenuBar addMenuBar() {
        JMenu druzynaMenu = new JMenu("Drużyna");
        JMenu sedziowieMenu = new JMenu("Sędziowie");
        JMenu turniejMenu = new JMenu("Turniej");
        JMenu tablicaMenu = new JMenu("Tablica wyników");

        JMenuBar menuBar = new JMenuBar();

        menuBar.add(druzynaMenu);
        menuBar.add(sedziowieMenu);
        menuBar.add(turniejMenu);
        menuBar.add(tablicaMenu);

        druzynaMenu.add(druzynaMenu());
        sedziowieMenu.add(sedziowieMenu());
        tablicaMenu.add(tablicaMenu());
        turniejMenu.add(turniejMenu());

        return menuBar;
    }

    private Component addMainPanel() {
        JPanel panel = new JPanel();
        GridBagLayout widok = new GridBagLayout();
        panel.setLayout(widok);
        GridBagConstraints constr = new GridBagConstraints();

        constr.fill = GridBagConstraints.HORIZONTAL;
        constr.gridx = 0;
        constr.gridy = 1;

        panel.add(druzynaMenu(), constr);
        panel.add(sedziowieMenu(), constr);
        panel.add(tablicaMenu(), constr);
        panel.add(turniejMenu(), constr);

        return panel;
    }

    private Component druzynaMenu() {
        JPanel okno_druzyna = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JButton nowaDruzyna = new JButton("nowa drużyna");
        JButton usunDruzyne = new JButton("usuń drużynę");
        JButton zglosDruzyne = new JButton("zgłoś drużynę");
        JButton wycofajDruzyne = new JButton("wycofaj drużynę");
        JButton debugujDruzyne = new JButton("debuguj");


        JFormattedTextField pula = new JFormattedTextField("pula drużyny");
        JFormattedTextField grajace = new JFormattedTextField("grające drużyny");


        JTextArea textArea = new JTextArea(20, 20);
        JScrollPane pole_1Druzyna = new JScrollPane(textArea);
        JScrollPane pole_2Druzyna = new JScrollPane(textArea);


        pole_1Druzyna.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pole_1Druzyna.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        pole_2Druzyna.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pole_2Druzyna.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        constraints.insets = new Insets(30, 100, 30, 100);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridy = 0;
        constraints.gridx = 0;
        okno_druzyna.add(nowaDruzyna, constraints);

        constraints.gridy = 1;
        okno_druzyna.add(usunDruzyne, constraints);

        constraints.gridy = 2;
        okno_druzyna.add(zglosDruzyne, constraints);

        constraints.gridy = 3;
        okno_druzyna.add(wycofajDruzyne, constraints);

        constraints.gridy = 4;
        okno_druzyna.add(debugujDruzyne, constraints);

        constraints.gridy = 1;
        constraints.gridx = 3;
        okno_druzyna.add(pula, constraints);

        constraints.gridy = 2;
        constraints.gridx = 3;
        okno_druzyna.add(grajace, constraints);

        constraints.gridx = 3;
        constraints.gridy = 2;
        okno_druzyna.add(pole_1Druzyna, constraints);

        constraints.gridx = 3;
        constraints.gridy = 2;
        okno_druzyna.add(pole_2Druzyna, constraints);

        return okno_druzyna;
    }

    private Component sedziowieMenu() {
        JPanel okno_sedziowie = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        JButton dodajSedziego = new JButton("dodaj sędziego");
        JButton usunSedziego = new JButton("usuń sędziego");
        JButton modyfikujSedziego = new JButton("modyfikuj sędziego");
        JButton debugujSedziego = new JButton("debuguj");

        JFormattedTextField lista = new JFormattedTextField("lista dostepnych sędziów");

        JScrollBar pole_1Sedzia = new JScrollBar();


        gridBagConstraints.insets = new Insets(10, 100, 10, 100);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridx = 0;
        okno_sedziowie.add(dodajSedziego, gridBagConstraints);

        gridBagConstraints.gridy = 1;
        okno_sedziowie.add(usunSedziego, gridBagConstraints);

        gridBagConstraints.gridy = 2;
        okno_sedziowie.add(modyfikujSedziego, gridBagConstraints);

        gridBagConstraints.gridy = 3;
        okno_sedziowie.add(debugujSedziego, gridBagConstraints);

        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridx = 3;
        okno_sedziowie.add(lista, gridBagConstraints);

        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        okno_sedziowie.add(pole_1Sedzia, gridBagConstraints);

        return okno_sedziowie;
    }

    private Component tablicaMenu() {
        JPanel okno_tablica = new JPanel(new GridBagLayout());
        GridBagConstraints bagConstraints = new GridBagConstraints();

        JFormattedTextField tablicaWynikow = new JFormattedTextField("tablica wyników");

        JTable jTable = new JTable();
        bagConstraints.gridy = 1;
        bagConstraints.gridx = 3;
        okno_tablica.add(tablicaWynikow, bagConstraints);

        bagConstraints.gridx = 4;
        bagConstraints.gridy = 2;
        okno_tablica.add(jTable, bagConstraints);

        return okno_tablica;

    }

    private Component turniejMenu() {

        JPanel okno_turniej = new JPanel(new GridBagLayout());
        GridBagConstraints contrs = new GridBagConstraints();


        JRadioButton turniej = new JRadioButton("turniej siatkówki");
        turniej.setSelected(true);


        JButton modyfikujTurniej = new JButton("modyfikuj mecz");
        JButton generujTurniej = new JButton("generuj mecz");
        JButton generujFinaly = new JButton("generuj finały");

        JFormattedTextField listaMeczow = new JFormattedTextField("lista meczów");

        JTable tablica = new JTable();


        contrs.insets = new Insets(10, 100, 10, 100);
        contrs.fill = GridBagConstraints.HORIZONTAL;

        contrs.gridy = 0;
        contrs.gridx = 0;
        okno_turniej.add(turniej, contrs);

        contrs.gridy = 1;
        okno_turniej.add(modyfikujTurniej, contrs);

        contrs.gridy = 2;
        okno_turniej.add(generujTurniej, contrs);

        contrs.gridy = 3;
        okno_turniej.add(generujFinaly, contrs);

        contrs.gridy = 1;
        contrs.gridx = 3;
        okno_turniej.add(listaMeczow, contrs);

        contrs.gridx = 4;
        contrs.gridy = 2;
        okno_turniej.add(tablica, contrs);

        return okno_turniej;
    }
}
