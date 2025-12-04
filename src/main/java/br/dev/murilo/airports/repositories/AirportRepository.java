package br.dev.murilo.airports.repositories;

import br.dev.murilo.airports.entities.Airport;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository  extends JpaRepository<Airport, Long>
{
    List<Airport> findByCityIgnoreCase(String city); 
    List<Airport> findByCountryIgnoreCase(String country);
}
