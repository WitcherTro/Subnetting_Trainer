import javax.swing.*;
import java.awt.*;

public class MainWindow {
    private JPanel panel;
    private JFrame frame;
    private JButton button1;
    private JButton button2;
    private JTextField networkAddressField;
    private JLabel ipLabel;
    private JLabel maskLabel;
    private JLabel networkAddressLabel;
    private JLabel networkAddressResultLabel;
    private JTextField firstUsableField;
    private JTextField lastUsableField;
    private JTextField broadcastField;
    private JButton button3;
    private JLabel firstUsableResultLabel;
    private JLabel lastUsableResultLabel;
    private JLabel broadcastResultLabel;
    private IPAddress ipAddress;
    private SubnetMasks mask;
    private ResultCalculator result;

    public MainWindow() {
        this.ipAddress = new IPAddress();
        this.mask = SubnetMasks.values()[(int) (Math.random() * 22)];
        this.result = new ResultCalculator(ipAddress.getIPAddress(), mask);
        this.ipLabel.setText("IP: "+ ipAddress.toString());
        this.maskLabel.setText("Mask: "+mask.toString() + "/" + mask.getPrefix());


        this.button1.addActionListener(e -> {
            String networkAddress = this.networkAddressField.getText();
            String firstUsable = this.firstUsableField.getText();
            String lastUsable = this.lastUsableField.getText();
            String broadcast = this.broadcastField.getText();
            if (this.result.compareNetworkAddress(networkAddress)) {
                this.networkAddressResultLabel.setForeground(Color.GREEN);
                this.networkAddressResultLabel.setText("Network address: OK");
            } else {
                this.networkAddressResultLabel.setForeground(Color.RED);
                this.networkAddressResultLabel.setText("Network address: BAD");
            }
            if (this.result.compareFirstHost(firstUsable)) {
                this.firstUsableResultLabel.setForeground(Color.GREEN);
                this.firstUsableResultLabel.setText("First usable address: OK");
            } else {
                this.firstUsableResultLabel.setForeground(Color.RED);
                this.firstUsableResultLabel.setText("First usable address: BAD");
            }
            if (this.result.compareLastHost(lastUsable)) {
                this.lastUsableResultLabel.setForeground(Color.GREEN);
                this.lastUsableResultLabel.setText("Last usable address: OK");
            } else {
                this.lastUsableResultLabel.setForeground(Color.RED);
                this.lastUsableResultLabel.setText("Last usable address: BAD");
            }
            if (this.result.compareBroadcastAddress(broadcast)) {
                this.broadcastResultLabel.setForeground(Color.GREEN);
                this.broadcastResultLabel.setText("Broadcast address: OK");
            } else {
                this.broadcastResultLabel.setForeground(Color.RED);
                this.broadcastResultLabel.setText("Broadcast address: BAD");
            }
        });

        this.button2.addActionListener(e -> {
            this.ipAddress.generateNewAddress();
            this.mask = SubnetMasks.values()[(int) (Math.random() * 22)];
            this.result = new ResultCalculator(ipAddress.getIPAddress(), mask);
            this.ipLabel.setText("IP: "+ ipAddress.toString());
            this.maskLabel.setText("Mask: "+mask.toString() + "/" + mask.getPrefix());
            this.networkAddressField.setText("");
            this.networkAddressResultLabel.setText("");
            this.firstUsableField.setText("");
            this.firstUsableResultLabel.setText("");
            this.lastUsableField.setText("");
            this.lastUsableResultLabel.setText("");
            this.broadcastField.setText("");
            this.broadcastResultLabel.setText("");
        });
        this.button3.addActionListener(e -> {
            this.networkAddressField.setText(this.result.calculateNetworkAddress());
            this.firstUsableField.setText(this.result.calculateFirstHost());
            this.lastUsableField.setText(this.result.calculateLastHost());
            this.broadcastField.setText(this.result.calculateBroadcastAddress());
        });

        this.frame = new JFrame("Subnetting");
        this.frame.setContentPane(this.panel);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.pack();
        this.frame.setVisible(true);
    }
}
