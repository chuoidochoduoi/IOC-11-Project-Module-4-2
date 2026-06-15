package service.inventory_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import service.inventory_service.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
