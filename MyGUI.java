import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MyGUI extends JFrame {
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
    private String nama;

    public MyGUI() {
        this.setLayout(new BorderLayout(100,0));
        this.setTitle("INSTITUT TEKNOLOGI KONOHAGAKURE");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400); 
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("konohagakure.jpg")));

        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.Y_AXIS));
        panelSouth.setBackground(Color.WHITE);
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));

        titleLabel = new JLabel();
        titleLabel.setText("HASIL SELEKSI MANDIRI");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Goblin One", Font.BOLD, 30));
        panelCenter.add(titleLabel);
        panelCenter.add(Box.createRigidArea(new Dimension(0, 5)));

        userName = new JLabel();
        userName.setText("Nama Anda");
        userName.setAlignmentX(Component.CENTER_ALIGNMENT);
        userName.setFont(new Font("Goblin One", Font.PLAIN, 25));
        panelCenter.add(userName);
        panelCenter.add(Box.createRigidArea(new Dimension(0, 15)));

        name = new JTextField();
        name.setFont(new Font("Goblin One", Font.PLAIN, 20));
        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        name.setMaximumSize(new Dimension(250, 30));
        panelCenter.add(name);
        panelCenter.add(Box.createRigidArea(new Dimension(0, 15)));

        nim = new JLabel();
        nim.setText("NIM Anda");
        nim.setAlignmentX(Component.CENTER_ALIGNMENT);
        nim.setFont(new Font("Goblin One", Font.PLAIN, 25));
        panelCenter.add(nim);
        panelCenter.add(Box.createRigidArea(new Dimension(0, 15)));

        isianNIM = new JTextField();
        isianNIM.setFont(new Font("Goblin One", Font.PLAIN, 20));
        isianNIM.setAlignmentX(Component.CENTER_ALIGNMENT);
        isianNIM.setMaximumSize(new Dimension(130, 30));
        panelCenter.add(isianNIM);
        panelCenter.add(Box.createRigidArea(new Dimension(0, 15)));

        okButton = new JButton("OK");
        okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        okButton.setMaximumSize(new Dimension(70,35));
        panelCenter.add(okButton);
        panelCenter.add(Box.createRigidArea(new Dimension(0, 10)));

        panelSouth.add(Box.createRigidArea(new Dimension(0, 7)));
        result = new JLabel();
        result.setText("HASIL SELEKSI");
        result.setAlignmentX(Component.CENTER_ALIGNMENT);
        result.setFont(new Font("Goblin One", Font.BOLD, 20));
        result.setForeground(Color.BLACK);
        panelSouth.add(result);
    
        result2 = new JLabel();
        result2.setText("AKAN TERLETAK DI SINI");
        result2.setFont(new Font("Goblin One", Font.BOLD, 20));
        result2.setAlignmentX(Component.CENTER_ALIGNMENT);
        result2.setForeground(Color.BLACK);
        panelSouth.add(result2);
        panelSouth.add(Box.createRigidArea(new Dimension(0, 7)));

        okButton.setFont(new Font("Oswald", Font.BOLD, 25));
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
                                    nama = name.getText().toString();
                                    result.setText("SELAMAT, " + nama + " DINYATAKAN SEBAGAI CALON");
                                    result2.setText("MAHASISWA BARU INSTITUT TEKNOLOGI KONOHAGAKURE");
                                    panelSouth.setBackground(Color.GREEN);

                                } else {
                                    nama = name.getText().toString();
                                    result.setText("MOHON MAAF " + nama + " TIDAK LULUS SELEKSI");
                                    result2.setText(" ");
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