package umc.carrot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.carrot.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //사용할 Entity Product, 타입 Long
}
