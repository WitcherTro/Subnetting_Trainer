public class ResultCalculator {
    private int[] ipAddress;
    private SubnetMasks subnetMask;

    public ResultCalculator(int[] ipAddress, SubnetMasks mask) {
        this.ipAddress = ipAddress;
        this.subnetMask = mask;
    }

    public int[] calculateNetworkAddress() {
        int[] networkAddress = new int[4];
        int[] subnetMask = this.subnetMask.getSubnetMask();
        for (int i = 0; i < 4; i++) {
            networkAddress[i] = this.ipAddress[i] & subnetMask[i];
        }
        return networkAddress;
    }

    public String getNetworkAddressString() {
        return IPAddress.formatAddress(this.calculateNetworkAddress());
    }

    public int[] calculateFirstHost() {
        int[] firstHost = this.calculateNetworkAddress();
        firstHost[3] += 1;
        return firstHost;
    }

    public String getFirstHostString() {
        return IPAddress.formatAddress(this.calculateFirstHost());
    }

    public int[] calculateLastHost() {
        int[] lastHost = this.calculateBroadcastAddress();
        lastHost[3] -= 1;
        return lastHost;
    }

    public String getLastHostString() {
        return IPAddress.formatAddress(this.calculateLastHost());
    }

    private int[] calculateBroadcastAddress() {
        int[] broadcastAddress = this.calculateNetworkAddress();
        int[] wildcardMask = this.subnetMask.getWildcard();
        for (int i = 0; i < 4; i++) {
            broadcastAddress[i] = broadcastAddress[i] | wildcardMask[i];
        }
        return broadcastAddress;
    }

    public String getBroadcastAddressString() {
        return IPAddress.formatAddress(this.calculateBroadcastAddress());
    }

    public boolean compareNetworkAddress(String networkAddress) {
        return this.getNetworkAddressString().equals(networkAddress);
    }

    public boolean compareBroadcastAddress(String broadcastAddress) {
        return this.getBroadcastAddressString().equals(broadcastAddress);
    }

    public boolean compareFirstHost(String firstHost) {
        return this.getFirstHostString().equals(firstHost);
    }

    public boolean compareLastHost(String lastHost) {
        return this.getLastHostString().equals(lastHost);
    }
}
