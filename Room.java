import javax.persistence.*;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int roomId;

    @Column(name = "roomNumber")
    private String roomNumber;

    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "hotelId")
    private Hotel hotel;

    // Getters and setters
}
