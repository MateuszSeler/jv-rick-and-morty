package mate.academy.rickandmorty.repository;

import mate.academy.rickandmorty.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends
        JpaRepository<Location, Long>,
        JpaSpecificationExecutor<Location> {
    Optional<Location> findByName(String name);
}
