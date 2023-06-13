public class ResultCalculator {
    private int[] ipAdress;
    private SubnetMasks subnetMask;
    private String networkAdress;

    public ResultCalculator(int[] ipAdress, SubnetMasks mask) {
        this.ipAdress = ipAdress;
        this.subnetMask = mask;
        this.networkAdress = calculateNetworkAdress();
    }

    public String calculateNetworkAdress() {
        int[] networkAdress = new int[4];
        for (int i = 0; i < 4; i++) {
            networkAdress[i] = this.ipAdress[i] & this.subnetMask.getSubnetMask()[i];
        }
        return networkAdress[0] + "." + networkAdress[1] + "." + networkAdress[2] + "." + networkAdress[3];
    }

    public int[] getNetworkAdress() {
        int[] networkAdress = new int[4];
        for (int i = 0; i < 4; i++) {
            networkAdress[i] = this.ipAdress[i] & this.subnetMask.getSubnetMask()[i];
        }
        return networkAdress;
    }

    public boolean compareNetworkAdress(String networkAdress) {
        String thisNetworkadress = this.calculateNetworkAdress();
        if (thisNetworkadress.equals(networkAdress)) {
            return true;
        } else {
            return false;
        }
    }


    public boolean compareBroadcastAdress(String broadcastAdress) {
        String thisBroadcastAdress = this.calculateBroadcastAdress();
        if (thisBroadcastAdress.equals(broadcastAdress)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean compareFirstHost(String firstHost) {
        String thisFirstHost = this.calculateFirstHost();
        if (thisFirstHost.equals(firstHost)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean compareLastHost(String lastHost) {
        String thisLastHost = this.calculateLastHost();
        if (thisLastHost.equals(lastHost)) {
            return true;
        } else {
            return false;
        }
    }


    public String calculateFirstHost() {
        int[] firstHost = this.getNetworkAdress();
        firstHost[3] += 1;
        return firstHost[0] + "." + firstHost[1] + "." + firstHost[2] + "." + firstHost[3];
    }
    public String calculateLastHost() {
        int[] lastHost = this.getNetworkAdress();
        int[] wildcardMask = this.subnetMask.getWildCard();
        for (int i = 0; i < 4; i++) {
            lastHost[i] = lastHost[i] | wildcardMask[i];
        }
        lastHost[3] -= 1;
        return lastHost[0] + "." + lastHost[1] + "." + lastHost[2] + "." + lastHost[3];
    }

    public String calculateBroadcastAdress() {
        int[] broadcastAdress = this.getNetworkAdress();
        int[] wildcardMask = this.subnetMask.getWildCard();
        for (int i = 0; i < 4; i++) {
            broadcastAdress[i] = broadcastAdress[i] | wildcardMask[i];
        }
        return broadcastAdress[0] + "." + broadcastAdress[1] + "." + broadcastAdress[2] + "." + broadcastAdress[3];
    }
}
