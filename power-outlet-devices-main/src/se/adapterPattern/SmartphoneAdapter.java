package softeng.adapterPattern;

public class SmartphoneAdapter implements PowerOutlet{

    private SmartphoneCharger charger;

    public SmartphoneAdapter(SmartphoneCharger charger) {
        this.charger = charger;
    }

    @Override
    public void plugIn() {
        charger.chargePhone();
    }
}
