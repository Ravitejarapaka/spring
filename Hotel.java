import javax.persistence.*;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int hotelId;

    @Column(name = "name")
    private String hotelName;

    @Column(name = "location")
    private String location;

    @Column(name = "rating")
    private int rating;

    // Getters and setters
}
