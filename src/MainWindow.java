import javax.swing.*;
import java.awt.*;

public class MainWindow {
    private JPanel panel;
    private JFrame frame;
    private JButton buttonCheckAnswers;
    private JButton buttonNewAddress;
    private JTextField networkAddressField;
    private JLabel ipLabel;
    private JLabel maskLabel;
    private JLabel networkAddressLabel;
    private JLabel networkAddressResultLabel;
    private JTextField firstUsableField;
    private JTextField lastUsableField;
    private JTextField broadcastField;
    private JButton buttonShowAnswers;
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

        this.buttonCheckAnswers.addActionListener(e -> {
            String networkAddress = this.networkAddressField.getText();
            String firstUsable = this.firstUsableField.getText();
            String lastUsable = this.lastUsableField.getText();
            String broadcast = this.broadcastField.getText();

            compareAndSetResultLabel(networkAddressResultLabel, result.compareNetworkAddress(networkAddress), "Network address");
            compareAndSetResultLabel(firstUsableResultLabel, result.compareFirstHost(firstUsable), "First usable address");
            compareAndSetResultLabel(lastUsableResultLabel, result.compareLastHost(lastUsable), "Last usable address");
            compareAndSetResultLabel(broadcastResultLabel, result.compareBroadcastAddress(broadcast), "Broadcast address");
        });

        this.buttonNewAddress.addActionListener(e -> {
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

        this.buttonShowAnswers.addActionListener(e -> {
            this.networkAddressField.setText(this.result.getNetworkAddressString());
            this.firstUsableField.setText(this.result.getFirstHostString());
            this.lastUsableField.setText(this.result.getLastHostString());
            this.broadcastField.setText(this.result.getBroadcastAddressString());
        });

        this.frame = new JFrame("Subnetting");
        this.frame.setContentPane(this.panel);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.pack();
        this.frame.setVisible(true);
    }

    private static void compareAndSetResultLabel(JLabel resultLabel, boolean isMatch, String labelName) {
        if (isMatch) {
            setResultLabel(resultLabel, Color.GREEN, labelName + ": OK");
        } else {
            setResultLabel(resultLabel, Color.RED, labelName + ": BAD");
        }
    }

    private static void setResultLabel(JLabel resultLabel, Color color, String text) {
        resultLabel.setForeground(color);
        resultLabel.setText(text);
    }
}
