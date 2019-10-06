package modal;

public class MacAddress {

    private String mac;
    private String adaptador;

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getAdaptador() {
        return adaptador;
    }

    public void setAdaptador(String adaptador) {
        this.adaptador = adaptador;
    }

    public MacAddress(String mac, String adaptador) {
        this.mac = mac;
        this.adaptador = adaptador;
    }

    public MacAddress() {
    }

}