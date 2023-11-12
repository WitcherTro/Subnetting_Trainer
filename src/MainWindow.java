import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

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
        this.ipLabel.setText("IP: " + ipAddress.toString());
        this.maskLabel.setText("Mask: " + mask.toString() + "/" + mask.getPrefix());

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
            this.ipLabel.setText("IP: " + ipAddress.toString());
            this.maskLabel.setText("Mask: " + mask.toString() + "/" + mask.getPrefix());
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

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel = new JPanel();
        panel.setLayout(new GridLayoutManager(10, 3, new Insets(0, 0, 0, 0), -1, -1));
        ipLabel = new JLabel();
        Font ipLabelFont = this.$$$getFont$$$(null, -1, 16, ipLabel.getFont());
        if (ipLabelFont != null) ipLabel.setFont(ipLabelFont);
        ipLabel.setText("Label");
        panel.add(ipLabel, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        maskLabel = new JLabel();
        Font maskLabelFont = this.$$$getFont$$$(null, -1, 16, maskLabel.getFont());
        if (maskLabelFont != null) maskLabel.setFont(maskLabelFont);
        maskLabel.setText("Label");
        panel.add(maskLabel, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel.add(panel1, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        networkAddressLabel = new JLabel();
        Font networkAddressLabelFont = this.$$$getFont$$$(null, -1, 16, networkAddressLabel.getFont());
        if (networkAddressLabelFont != null) networkAddressLabel.setFont(networkAddressLabelFont);
        networkAddressLabel.setText("Enter network address:");
        panel1.add(networkAddressLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        networkAddressField = new JTextField();
        Font networkAddressFieldFont = this.$$$getFont$$$(null, -1, 16, networkAddressField.getFont());
        if (networkAddressFieldFont != null) networkAddressField.setFont(networkAddressFieldFont);
        panel1.add(networkAddressField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$(null, -1, 16, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Enter first usable address:");
        panel1.add(label1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        firstUsableField = new JTextField();
        Font firstUsableFieldFont = this.$$$getFont$$$(null, -1, 16, firstUsableField.getFont());
        if (firstUsableFieldFont != null) firstUsableField.setFont(firstUsableFieldFont);
        panel1.add(firstUsableField, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$(null, -1, 16, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setText("Enter last usable address:");
        panel1.add(label2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lastUsableField = new JTextField();
        Font lastUsableFieldFont = this.$$$getFont$$$(null, -1, 16, lastUsableField.getFont());
        if (lastUsableFieldFont != null) lastUsableField.setFont(lastUsableFieldFont);
        panel1.add(lastUsableField, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$(null, -1, 16, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setText("Enter broadcast address:");
        panel1.add(label3, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        broadcastField = new JTextField();
        Font broadcastFieldFont = this.$$$getFont$$$(null, -1, 16, broadcastField.getFont());
        if (broadcastFieldFont != null) broadcastField.setFont(broadcastFieldFont);
        panel1.add(broadcastField, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel.add(panel2, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        buttonCheckAnswers = new JButton();
        Font buttonCheckAnswersFont = this.$$$getFont$$$(null, -1, 16, buttonCheckAnswers.getFont());
        if (buttonCheckAnswersFont != null) buttonCheckAnswers.setFont(buttonCheckAnswersFont);
        buttonCheckAnswers.setText("Check answers");
        panel2.add(buttonCheckAnswers, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(78, 22), null, 0, false));
        buttonNewAddress = new JButton();
        Font buttonNewAddressFont = this.$$$getFont$$$(null, -1, 16, buttonNewAddress.getFont());
        if (buttonNewAddressFont != null) buttonNewAddress.setFont(buttonNewAddressFont);
        buttonNewAddress.setText("New IP address");
        panel2.add(buttonNewAddress, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(78, 22), null, 0, false));
        buttonShowAnswers = new JButton();
        Font buttonShowAnswersFont = this.$$$getFont$$$(null, -1, 16, buttonShowAnswers.getFont());
        if (buttonShowAnswersFont != null) buttonShowAnswers.setFont(buttonShowAnswersFont);
        buttonShowAnswers.setText("Show answers");
        panel2.add(buttonShowAnswers, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel.add(spacer1, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, new Dimension(20, -1), null, 0, false));
        final Spacer spacer2 = new Spacer();
        panel.add(spacer2, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, new Dimension(20, -1), null, 0, false));
        final Spacer spacer3 = new Spacer();
        panel.add(spacer3, new GridConstraints(9, 1, 1, 1, GridConstraints.ANCHOR_SOUTH, GridConstraints.FILL_NONE, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(-1, 110), null, 0, false));
        final Spacer spacer4 = new Spacer();
        panel.add(spacer4, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(-1, 15), null, 0, false));
        networkAddressResultLabel = new JLabel();
        Font networkAddressResultLabelFont = this.$$$getFont$$$(null, -1, 20, networkAddressResultLabel.getFont());
        if (networkAddressResultLabelFont != null) networkAddressResultLabel.setFont(networkAddressResultLabelFont);
        networkAddressResultLabel.setHorizontalAlignment(0);
        networkAddressResultLabel.setText("");
        panel.add(networkAddressResultLabel, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        firstUsableResultLabel = new JLabel();
        Font firstUsableResultLabelFont = this.$$$getFont$$$(null, -1, 20, firstUsableResultLabel.getFont());
        if (firstUsableResultLabelFont != null) firstUsableResultLabel.setFont(firstUsableResultLabelFont);
        firstUsableResultLabel.setHorizontalAlignment(0);
        firstUsableResultLabel.setText("");
        panel.add(firstUsableResultLabel, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lastUsableResultLabel = new JLabel();
        Font lastUsableResultLabelFont = this.$$$getFont$$$(null, -1, 20, lastUsableResultLabel.getFont());
        if (lastUsableResultLabelFont != null) lastUsableResultLabel.setFont(lastUsableResultLabelFont);
        lastUsableResultLabel.setHorizontalAlignment(0);
        lastUsableResultLabel.setText("");
        panel.add(lastUsableResultLabel, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        broadcastResultLabel = new JLabel();
        Font broadcastResultLabelFont = this.$$$getFont$$$(null, -1, 20, broadcastResultLabel.getFont());
        if (broadcastResultLabelFont != null) broadcastResultLabel.setFont(broadcastResultLabelFont);
        broadcastResultLabel.setHorizontalAlignment(0);
        broadcastResultLabel.setText("");
        panel.add(broadcastResultLabel, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }

}
