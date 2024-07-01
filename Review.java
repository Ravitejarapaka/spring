import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    @Column(nullable = false)
    private String reviewContent;

    @Column(nullable = false)
    private int rating;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    // Constructors, getters, and setters
}
