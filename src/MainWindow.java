import javax.swing.*;
import java.awt.*;

public class MainWindow {
    private JPanel panel;
    private JFrame frame;
    private JButton button1;
    private JButton button2;
    private JTextField networkAdressField;
    private JLabel ipLabel;
    private JLabel maskLabel;
    private JLabel networkAdressLabel;
    private JLabel networkAdressResultLabel;
    private JTextField firstUsableField;
    private JTextField lastUsableField;
    private JTextField broadcastField;
    private JButton button3;
    private JLabel firstUsableResultLabel;
    private JLabel lastUsableResultLabel;
    private JLabel broadcastResultLabel;
    private IPAdress ipAdress;
    private SubnetMasks mask;
    private ResultCalculator result;

    public MainWindow() {
        this.ipAdress = new IPAdress();
        this.mask = SubnetMasks.values()[(int) (Math.random() * 22)];
        this.result = new ResultCalculator(ipAdress.getIPAdress(), mask);
        this.ipLabel.setText("IP: "+ipAdress.toString());
        this.maskLabel.setText("Maska: "+mask.toString() + "/" + mask.getPrefix());


        this.button1.addActionListener(e -> {
            String networkadress = this.networkAdressField.getText();
            String firstUsable = this.firstUsableField.getText();
            String lastUsable = this.lastUsableField.getText();
            String broadcast = this.broadcastField.getText();
            if (this.result.compareNetworkAdress(networkadress)) {
                this.networkAdressResultLabel.setForeground(Color.GREEN);
                this.networkAdressResultLabel.setText("Adresa siete: OK");
            } else {
                this.networkAdressResultLabel.setForeground(Color.RED);
                this.networkAdressResultLabel.setText("Adresa siete: ZLE");
            }
            if (this.result.compareFirstHost(firstUsable)) {
                this.firstUsableResultLabel.setForeground(Color.GREEN);
                this.firstUsableResultLabel.setText("Prvá použiteľná adresa: OK");
            } else {
                this.firstUsableResultLabel.setForeground(Color.RED);
                this.firstUsableResultLabel.setText("Prvá použiteľná adresa: ZLE");
            }
            if (this.result.compareLastHost(lastUsable)) {
                this.lastUsableResultLabel.setForeground(Color.GREEN);
                this.lastUsableResultLabel.setText("Posledná použiteľná adresa: OK");
            } else {
                this.lastUsableResultLabel.setForeground(Color.RED);
                this.lastUsableResultLabel.setText("Posledná použiteľná adresa: ZLE");
            }
            if (this.result.compareBroadcastAdress(broadcast)) {
                this.broadcastResultLabel.setForeground(Color.GREEN);
                this.broadcastResultLabel.setText("Broadcastová adresa: OK");
            } else {
                this.broadcastResultLabel.setForeground(Color.RED);
                this.broadcastResultLabel.setText("Broadcastová adresa: ZLE");
            }
        });

        this.button2.addActionListener(e -> {
            this.ipAdress.generateNewAdress();
            this.mask = SubnetMasks.values()[(int) (Math.random() * 22)];
            this.result = new ResultCalculator(ipAdress.getIPAdress(), mask);
            this.ipLabel.setText("IP: "+ipAdress.toString());
            this.maskLabel.setText("Maska: "+mask.toString() + "/" + mask.getPrefix());
            this.networkAdressField.setText("");
            this.networkAdressResultLabel.setText("");
            this.firstUsableField.setText("");
            this.firstUsableResultLabel.setText("");
            this.lastUsableField.setText("");
            this.lastUsableResultLabel.setText("");
            this.broadcastField.setText("");
            this.broadcastResultLabel.setText("");
        });
        this.button3.addActionListener(e -> {
            this.networkAdressField.setText(this.result.calculateNetworkAdress());
            this.firstUsableField.setText(this.result.calculateFirstHost());
            this.lastUsableField.setText(this.result.calculateLastHost());
            this.broadcastField.setText(this.result.calculateBroadcastAdress());
        });

        this.frame = new JFrame("Subnetting");
        this.frame.setContentPane(this.panel);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.pack();
        this.frame.setVisible(true);


    }
}
