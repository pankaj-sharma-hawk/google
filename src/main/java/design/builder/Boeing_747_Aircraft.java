package design.builder;

public class Boeing_747_Aircraft extends AircraftBuilder implements IAircraft {

    private Boeing_747_Aircraft boeing_747_aircraft;

    @Override
    public void buildCockpit() {

    }

    @Override
    public void buildEngine() {

    }

    @Override
    public void buildWings() {

    }


    @Override
    IAircraft buildAircraft() {
        return boeing_747_aircraft;
    }

    @Override
    public void buildBathRoom() {

    }
}
