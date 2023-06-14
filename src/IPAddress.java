public class IPAddress {
    private int[] ipAddress;

    public static String formatAddress(int[] address) {
        if (address.length != 4) {
            return "";
        }
        return "%d.%d.%d.%d".formatted(address[0],address[1],address[2],address[3]);
    }

    public IPAddress() {
        this.ipAddress = generateIPAddress();
    }

    public int[] getIPAddress() {
        return ipAddress;
    }

    public void setIPAddress(int[] ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String toString() {
        return formatAddress(this.ipAddress);
    }

    public int[] generateIPAddress() {
        int[] ipAddress = new int[4];
        for (int i = 0; i < 4; i++) {
            ipAddress[i] = (int) (Math.random() * 255);
        }
        return ipAddress;
    }

    public void generateNewAddress() {
        this.ipAddress = generateIPAddress();
    }
}
