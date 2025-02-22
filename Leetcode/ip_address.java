public class ip_address {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
}
