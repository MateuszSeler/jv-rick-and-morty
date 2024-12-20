package mate.academy.rickandmorty.repository;

import mate.academy.rickandmorty.model.CartoonCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartoonCharacterRepository extends
        JpaRepository<CartoonCharacter, Long>,
        JpaSpecificationExecutor<CartoonCharacter> {
    Optional<CartoonCharacter> findByName(String name);

    Optional<CartoonCharacter> findByExternalId(Long externalId);
}
