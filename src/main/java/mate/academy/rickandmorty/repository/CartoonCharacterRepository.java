package mate.academy.rickandmorty.repository;

import java.util.Optional;
import mate.academy.rickandmorty.model.CartoonCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CartoonCharacterRepository extends
        JpaRepository<CartoonCharacter, Long>,
        JpaSpecificationExecutor<CartoonCharacter> {
    Optional<CartoonCharacter> findByName(String name);

    Optional<CartoonCharacter> findByExternalId(Long externalId);
}
