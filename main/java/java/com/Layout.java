import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import javax.swing.text.JTextComponent;
import java.awt.*;

public class Layout extends JFrame {
    public void startGui() {
        JFrame window = new JFrame("System zarządzania turniejem");
        //oknoGłowne.setMinimumSize(new Dimension(10, 40));
        //oknoGłowne.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setJMenuBar(addMenuBar());
        // oknoGłowne.add(addMainPanel());
        window.setVisible(true);
        window.pack();
    }

    private JMenuBar addMenuBar() {
        JMenu groupMenu = new JMenu("Drużyna");
        JMenu judgeMenu = new JMenu("Sędziowie");
        JMenu tournamentMenu = new JMenu("Turniej");
        JMenu tabelMenu = new JMenu("Tablica wyników");

        JMenuBar menuBar = new JMenuBar();

        menuBar.add(groupMenu);
        menuBar.add(judgeMenu);
        menuBar.add(tournamentMenu);
        menuBar.add(tabelMenu);

        groupMenu.add(groupMenu());
        judgeMenu.add(judgeMenu());
        tabelMenu.add(tabelMenu());
        tournamentMenu.add(tournamentMenu());

        return menuBar;
    }

    private Component addMainPanel() {
        JPanel panel = new JPanel();
        GridBagLayout view = new GridBagLayout();
        panel.setLayout(view);
        GridBagConstraints constr = new GridBagConstraints();

        constr.fill = GridBagConstraints.HORIZONTAL;
        constr.gridx = 0;
        constr.gridy = 1;

        panel.add(groupMenu(), constr);
        panel.add(judgeMenu(), constr);
        panel.add(tabelMenu(), constr);
        panel.add(tournamentMenu(), constr);

        return panel;
    }

    private Component groupMenu() {
        JPanel window_group = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JButton new_group = new JButton("nowa drużyna");
        JButton delete_group = new JButton("usuń drużynę");
        JButton report_group = new JButton("zgłoś drużynę");
        JButton withdraw_group = new JButton("wycofaj drużynę");
        JButton debuguj_group = new JButton("debuguj");


        JFormattedTextField pole = new JFormattedTextField("pula drużyny");
        JFormattedTextField play = new JFormattedTextField("grające drużyny");


        JTextArea textArea = new JTextArea(20, 20);
        JScrollPane pole1_group = new JScrollPane(textArea);
        JScrollPane pole_2group = new JScrollPane(textArea);


        pole1_group.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pole1_group.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        pole_2group.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pole_2group.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        constraints.insets = new Insets(30, 100, 30, 100);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridy = 0;
        constraints.gridx = 0;
        window_group.add(new_group, constraints);

        constraints.gridy = 1;
        window_group.add(delete_group, constraints);

        constraints.gridy = 2;
        window_group.add(report_group, constraints);

        constraints.gridy = 3;
        window_group.add(withdraw_group, constraints);

        constraints.gridy = 4;
        window_group.add(debuguj_group, constraints);

        constraints.gridy = 1;
        constraints.gridx = 3;
        window_group.add(pole, constraints);

        constraints.gridy = 2;
        constraints.gridx = 3;
        window_group.add(play, constraints);

        constraints.gridx = 3;
        constraints.gridy = 2;
        window_group.add(pole1_group, constraints);

        constraints.gridx = 3;
        constraints.gridy = 2;
        window_group.add(pole_2group, constraints);

        return window_group;
    }

    private Component judgeMenu() {
        JPanel window_judge = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        JButton addJudge = new JButton("dodaj sędziego");
        JButton deleteJudge = new JButton("usuń sędziego");
        JButton modifyJudge = new JButton("modyfikuj sędziego");
        JButton debugujJudge= new JButton("debuguj");

        JFormattedTextField lista = new JFormattedTextField("lista dostepnych sędziów");

        JTextArea textArea = new JTextArea(20, 20);
        JScrollPane pole_1Judge = new JScrollPane(textArea);
        pole_1Judge.setSize(20, 30);

        gridBagConstraints.insets = new Insets(10, 100, 10, 100);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridx = 0;
        window_judge.add(addJudge, gridBagConstraints);

        gridBagConstraints.gridy = 1;
        window_judge.add(deleteJudge, gridBagConstraints);

        gridBagConstraints.gridy = 2;
        window_judge.add(modifyJudge, gridBagConstraints);

        gridBagConstraints.gridy = 3;
        window_judge.add(debugujJudge, gridBagConstraints);

        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridx = 3;
        window_judge.add(lista, gridBagConstraints);

        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        window_judge.add(pole_1Judge, gridBagConstraints);

        return window_judge;
    }

    private Component tabelMenu() {
        JPanel window_tabel = new JPanel();
        GridBagConstraints bagConstraints = new GridBagConstraints();

        JTextField score_board = new JTextField("tablica wyników");

        String[][] wiersze = {{"abc", "23"},{"cde", "111"}};
        String[] kolumny = {"drużyna", "punktacja"};

        JTable jtable = new JTable(wiersze, kolumny);
        jtable.setBounds(30, 40, 200, 300);

        JScrollPane sp = new JScrollPane(jtable);
        window_tabel.add(sp);

        window_tabel.setSize(500, 200);
        window_tabel.setVisible(true);

        bagConstraints.insets = new Insets(30, 100, 30, 100);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;

        bagConstraints.gridx = 1;
        bagConstraints.gridy = 0;
        window_tabel.add(score_board, bagConstraints);

        bagConstraints.gridx = 1;
        bagConstraints.gridy = 0;
        window_tabel.add(jtable, bagConstraints);

        return window_tabel;
    }

    private Component tournamentMenu() {

        JPanel window_tournament = new JPanel(new GridBagLayout());
        GridBagConstraints contrs = new GridBagConstraints();

        JRadioButton tournament = new JRadioButton("turniej siatkówki");
        tournament.setSelected(true);

        JButton modify_tournament = new JButton("modyfikuj mecz");
        JButton generate_tournament = new JButton("generuj mecz");
        JButton generate_finals = new JButton("generuj finały");

        JFormattedTextField lista_match = new JFormattedTextField("lista meczów");

        JTable tablica = new JTable();

        contrs.insets = new Insets(10, 100, 10, 100);
        contrs.fill = GridBagConstraints.HORIZONTAL;

        contrs.gridy = 0;
        contrs.gridx = 0;
        window_tournament.add(tournament, contrs);

        contrs.gridy = 1;
        window_tournament.add(modify_tournament, contrs);

        contrs.gridy = 2;
        window_tournament.add(generate_tournament, contrs);

        contrs.gridy = 3;
        window_tournament.add(generate_finals, contrs);

        contrs.gridy = 1;
        contrs.gridx = 3;
        window_tournament.add(lista_match, contrs);

        contrs.gridx = 4;
        contrs.gridy = 2;
        window_tournament.add(tablica, contrs);

        return window_tournament;
    }
}
