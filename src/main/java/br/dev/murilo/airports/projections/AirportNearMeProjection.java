package br.dev.murilo.airports.projections;

public interface AirportNearMeProjection 
{
    long getId();
    String getName();
    String getCity();
    String getIataCode();
    double getLatitude();
    double getLongitude();
    double getAltitude();
    double getDistanciaKM();
}
