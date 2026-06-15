package service.user_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users") // Sẽ được tạo tự động trong user_db
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
}