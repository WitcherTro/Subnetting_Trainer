public class ResultCalculator {
    private int[] ipAdress;
    private SubnetMasks subnetMask;
    private String networkAddress;

    public ResultCalculator(int[] ipAddress, SubnetMasks mask) {
        this.ipAdress = ipAddress;
        this.subnetMask = mask;
        this.networkAddress = calculateNetworkAddress();
    }

    public String calculateNetworkAddress() {
        int[] networkAddress = new int[4];
        for (int i = 0; i < 4; i++) {
            networkAddress[i] = this.ipAdress[i] & this.subnetMask.getSubnetMask()[i];
        }
        return networkAddress[0] + "." + networkAddress[1] + "." + networkAddress[2] + "." + networkAddress[3];
    }

    public int[] getNetworkAddress() {
        int[] networkAddress = new int[4];
        for (int i = 0; i < 4; i++) {
            networkAddress[i] = this.ipAdress[i] & this.subnetMask.getSubnetMask()[i];
        }
        return networkAddress;
    }

    public boolean compareNetworkAddress(String networkAddress) {
        return this.calculateNetworkAddress().equals(networkAddress);
    }

    public boolean compareBroadcastAdress(String broadcastAddress) {
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
        return firstHost[0] + "." + firstHost[1] + "." + firstHost[2] + "." + firstHost[3];
    }

    public String calculateLastHost() {
        int[] lastHost = this.getNetworkAddress();
        int[] wildcardMask = this.subnetMask.getWildcard();
        for (int i = 0; i < 4; i++) {
            lastHost[i] = lastHost[i] | wildcardMask[i];
        }
        lastHost[3] -= 1;
        return lastHost[0] + "." + lastHost[1] + "." + lastHost[2] + "." + lastHost[3];
    }

    public String calculateBroadcastAddress() {
        int[] broadcastAdress = this.getNetworkAddress();
        int[] wildcardMask = this.subnetMask.getWildcard();
        for (int i = 0; i < 4; i++) {
            broadcastAdress[i] = broadcastAdress[i] | wildcardMask[i];
        }
        return broadcastAdress[0] + "." + broadcastAdress[1] + "." + broadcastAdress[2] + "." + broadcastAdress[3];
    }
}
