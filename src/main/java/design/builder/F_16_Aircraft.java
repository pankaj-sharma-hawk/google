package design.builder;

public class F_16_Aircraft extends AircraftBuilder implements IAircraft {
    private F_16_Aircraft aircraft;

    @Override
    public void buildEngine() {
    }

    @Override
    public void buildWings() {
    }

    @Override
    IAircraft buildAircraft() {
        return aircraft;
    }

    @Override
    public void buildCockpit() {

    }


}
