package design.builder;

public class AircraftFactory {

    private AircraftBuilder aircraftBuilder;

    public AircraftFactory(AircraftBuilder aircraftBuilder) {
        this.aircraftBuilder = aircraftBuilder;
    }

    //Business Logic:---------------
    public IAircraft getAircraft(boolean isPassengerAircraft) {
        aircraftBuilder.buildCockpit();;
        aircraftBuilder.buildEngine();
        aircraftBuilder.buildWings();
        if(isPassengerAircraft)
            aircraftBuilder.buildBathRoom();
        return aircraftBuilder.buildAircraft();
    }
}
