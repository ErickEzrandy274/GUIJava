import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new MyGUI();
    }
}

class MyGUI extends JFrame {
    private JPanel panelNorth;
    private JPanel panelCenter;
    private JPanel panelSouth;
    private JLabel titleLabel;
    private JLabel nim;
    private JTextField isianNIM;
    private JLabel result;
    private JLabel result2;
    private JLabel userName;
    private JTextField name;
    private JButton okButton;
    private int score;

    public MyGUI() {
        this.setTitle("INSTITUT TEKNOLOGI KONOHAGAKURE");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true); 
        this.setSize(598, 290); 
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("konohagakure.jpg")));

        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelNorth.setLayout(new GridLayout(1, 1));
        panelCenter.setLayout(new GridLayout(2, 2, 10, 10));
        panelSouth.setLayout(new GridLayout(3, 1));
        this.setLayout(new BorderLayout());

        titleLabel = new JLabel();
        titleLabel.setText("HASIL SELEKSI MANDIRI");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Goblin One", Font.BOLD, 30));
        panelNorth.add(titleLabel, BorderLayout.NORTH);

        userName = new JLabel();
        userName.setText("Nama Anda");
        userName.setHorizontalAlignment(JLabel.CENTER);
        userName.setFont(new Font("Goblin One", Font.PLAIN, 25));
        panelCenter.add(userName);

        name = new JTextField();
        name.setFont(new Font("Goblin One", Font.PLAIN, 20));
        panelCenter.add(name);

        nim = new JLabel();
        nim.setText("NIM Anda");
        nim.setHorizontalAlignment(JLabel.CENTER);
        nim.setFont(new Font("Goblin One", Font.PLAIN, 25));
        panelCenter.add(nim);

        isianNIM = new JTextField();
        isianNIM.setFont(new Font("Goblin One", Font.PLAIN, 20));
        panelCenter.add(isianNIM);

        okButton = new JButton("OK");
        panelSouth.add(okButton);

        result = new JLabel();
        result.setText("HASIL SELEKSI AKAN TERLETAK DI SINI");
        result.setHorizontalAlignment(JLabel.CENTER);
        result.setFont(new Font("Goblin One", Font.BOLD, 20));
        result.setForeground(Color.BLACK);
        panelSouth.setBackground(Color.WHITE);
        panelSouth.add(result);

        result2 = new JLabel();
        result2.setFont(new Font("Goblin One", Font.BOLD, 20));
        result2.setForeground(Color.BLACK);
        panelSouth.add(result2);

        okButton.setFont(new Font("Oswald", Font.PLAIN, 25));
        okButton.setForeground(Color.RED);
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Random scoreRandom = new Random();
                score = scoreRandom.nextInt(1000);
                try {
                    if(name.getText().toString().trim().equals("")) {
                        result.setText("Anda belum memasukkan username!");
                        result2.setText("");
                        panelSouth.setBackground(Color.WHITE);

                    } else {
                        if(isString(name.getText().toString().trim())) {
                            if(isianNIM.getText().toString().trim().equals("")) {
                                result.setText("Anda belum memasukkan NIM!");
                                result2.setText("");
                                panelSouth.setBackground(Color.WHITE);
                            } else {
                                Long.parseLong(isianNIM.getText().toString());
                                if (score > 700) {
                                    result.setText("SELAMAT, ANDA DINYATAKAN SEBAGAI CALON");
                                    result2.setText("MAHASISWA BARU INSTITUT TEKNOLOGI KONOHAGAKURE");
                                    panelSouth.setBackground(Color.GREEN);

                                } else {
                                    result.setText("MOHON MAAF ANDA TIDAK LULUS SELEKSI");
                                    panelSouth.setBackground(Color.RED);
                                }
                            }

                        } else {
                            result.setText("Username Anda tidak valid!");
                            result2.setText("");
                            panelSouth.setBackground(Color.WHITE);
                        }
                    }
                } catch (NumberFormatException error) {
                    result.setText("NIM Anda tidak valid!");
                    result2.setText("");
                    panelSouth.setBackground(Color.WHITE);
                }
            }    
        });

        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public boolean isString(String name) {
        for(int i = 0; i < name.length(); i++) {
            if(!(Character.isLetter(name.charAt(i)) || name.charAt(i) == ' ')) {
                return false;
            }
        }
        return true;
    }
}
