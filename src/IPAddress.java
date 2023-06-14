public class IPAddress {
    private int[] ipAddress;

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
        return ipAddress[0] + "." + ipAddress[1] + "." + ipAddress[2] + "." + ipAddress[3];
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
