package design.builder;

public abstract class AircraftBuilder {

    abstract public void buildCockpit();

    abstract public void buildEngine();

    abstract public void buildWings();

    abstract IAircraft buildAircraft();

    public void buildBathRoom() {
    }


}
