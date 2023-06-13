public enum SubnetMasks {
    prefix8(255, 0, 0, 0, 8, 0, 255, 255, 255),
    prefix9(255, 128, 0, 0, 9, 0, 127, 255, 255),
    prefix10(255, 192, 0, 0, 10, 0, 63, 255, 255),
    prefix11(255, 224, 0, 0, 11, 0, 31, 255, 255),
    prefix12(255, 240, 0, 0, 12, 0, 15, 255, 255),
    prefix13(255, 248, 0, 0, 13, 0, 7, 255, 255),
    prefix14(255, 252, 0, 0, 14, 0, 3, 255, 255),
    prefix15(255, 254, 0, 0, 15, 0, 1, 255, 255),
    prefix16(255, 255, 0, 0, 16, 0, 0, 255, 255),
    prefix17(255, 255, 128, 0, 17, 0, 0, 127, 255),
    prefix18(255, 255, 192, 0, 18, 0, 0, 63, 255),
    prefix19(255, 255, 224, 0, 19, 0, 0, 31, 255),
    prefix20(255, 255, 240, 0, 20, 0, 0, 15, 255),
    prefix21(255, 255, 248, 0, 21, 0, 0, 7, 255),
    prefix22(255, 255, 252, 0, 22, 0, 0, 3, 255),
    prefix23(255, 255, 254, 0, 23, 0, 0, 1, 255),
    prefix24(255, 255, 255, 0, 24, 0, 0, 0, 255),
    prefix25(255, 255, 255, 128, 25, 0, 0, 0, 127),
    prefix26(255, 255, 255, 192, 26, 0, 0, 0, 63),
    prefix27(255, 255, 255, 224, 27, 0, 0, 0, 31),
    prefix28(255, 255, 255, 240, 28, 0, 0, 0, 15),
    prefix29(255, 255, 255, 248, 29, 0, 0, 0, 7),
    prefix30(255, 255, 255, 252, 30, 0, 0, 0, 3);


    private int[] subnetMask;
    private int prefix;
    private int[] wildCard;
    SubnetMasks(int a, int b, int c, int d, int prefix, int e, int f, int g, int h) {
        this.subnetMask = new int[]{a, b, c, d};
        this.prefix = prefix;
        this.wildCard = new int[]{e, f, g, h};
    }
    public int[] getSubnetMask() {
        return this.subnetMask;
    }
    public int getPrefix() {
        return this.prefix;
    }
    public int[] getWildCard() {
        return this.wildCard;
    }
    public String toString() {
        return this.subnetMask[0] + "." + this.subnetMask[1] + "." + this.subnetMask[2] + "." + this.subnetMask[3];
    }

}
