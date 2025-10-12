package softeng.adapterPattern;

public class Main {
    public static void main(String[] args) {

        Laptop lp = new Laptop();
        Refrigerator ref = new Refrigerator();
        SmartphoneCharger spc = new SmartphoneCharger();

        LaptopAdapter lpADAPTER = new LaptopAdapter(lp);
        RefrigeratorAdapter rpADAPTER = new RefrigeratorAdapter(ref);
        SmartphoneAdapter spcADAPTER = new SmartphoneAdapter(spc);

        lpADAPTER.plugIn();
        rpADAPTER.plugIn();
        spcADAPTER.plugIn();

    }
}
