package shopProject.Shop.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String itemId;

    private String name;

    private BigDecimal price;

    private String description;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    private  CategoryEntity category;
}
