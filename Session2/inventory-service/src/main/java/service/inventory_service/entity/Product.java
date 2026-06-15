package service.inventory_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products") // Sẽ được tạo tự động trong inventory_db
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private Integer stock;
}
