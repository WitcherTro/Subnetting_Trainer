public class ResultCalculator {
    private int[] ipAddress;
    private SubnetMasks subnetMask;
    private String networkAddress;

    public ResultCalculator(int[] ipAddress, SubnetMasks mask) {
        this.ipAddress = ipAddress;
        this.subnetMask = mask;
        this.networkAddress = calculateNetworkAddress();
    }

    public String calculateNetworkAddress() {
        int[] networkAddress = new int[4];
        for (int i = 0; i < 4; i++) {
            networkAddress[i] = this.ipAddress[i] & this.subnetMask.getSubnetMask()[i];
        }
        return IPAddress.formatAddress(networkAddress);
    }

    public int[] getNetworkAddress() {
        int[] networkAddress = new int[4];
        for (int i = 0; i < 4; i++) {
            networkAddress[i] = this.ipAddress[i] & this.subnetMask.getSubnetMask()[i];
        }
        return networkAddress;
    }

    public boolean compareNetworkAddress(String networkAddress) {
        return this.calculateNetworkAddress().equals(networkAddress);
    }

    public boolean compareBroadcastAddress(String broadcastAddress) {
        return this.calculateBroadcastAddress().equals(broadcastAddress);
    }
    public boolean compareFirstHost(String firstHost) {
        return this.calculateFirstHost().equals(firstHost);
    }
    public boolean compareLastHost(String lastHost) {
        return this.calculateLastHost().equals(lastHost);
    }

    public String calculateFirstHost() {
        int[] firstHost = this.getNetworkAddress();
        firstHost[3] += 1;
        return IPAddress.formatAddress(firstHost);
    }

    public String calculateLastHost() {
        int[] lastHost = this.getNetworkAddress();
        int[] wildcardMask = this.subnetMask.getWildcard();
        for (int i = 0; i < 4; i++) {
            lastHost[i] = lastHost[i] | wildcardMask[i];
        }
        lastHost[3] -= 1;
        return IPAddress.formatAddress(lastHost);
    }

    public String calculateBroadcastAddress() {
        int[] broadcastAddress = this.getNetworkAddress();
        int[] wildcardMask = this.subnetMask.getWildcard();
        for (int i = 0; i < 4; i++) {
            broadcastAddress[i] = broadcastAddress[i] | wildcardMask[i];
        }
        return IPAddress.formatAddress(broadcastAddress);
    }
}
