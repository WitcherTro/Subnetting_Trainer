public class IPAdress {
    private int[] ipAdress;
    public IPAdress() {
        this.ipAdress = generateIPAdress();
    }
    public int[] getIPAdress() {
        return ipAdress;
    }
    public void setIPAdress(int[] ipAdress) {
        this.ipAdress = ipAdress;
    }
    public String toString() {
        return ipAdress[0] + "." + ipAdress[1] + "." + ipAdress[2] + "." + ipAdress[3];
    }
    public int[] generateIPAdress() {
        int[] ipAdress = new int[4];
        for (int i = 0; i < 4; i++) {
            ipAdress[i] = (int) (Math.random() * 255);
        }
        return ipAdress;
    }
    public void generateNewAdress() {
        this.ipAdress = generateIPAdress();
    }
}
