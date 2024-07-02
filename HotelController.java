import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelJpaService hotelService;

    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @PostMapping
    public Hotel createHotel(@RequestBody Hotel hotel) {
        return hotelService.saveHotel(hotel);
    }

    @GetMapping("/{hotelId}")
    public Hotel getHotelById(@PathVariable int hotelId) {
        return hotelService.getHotelById(hotelId);
    }

    @PutMapping("/{hotelId}")
    public Hotel updateHotel(@PathVariable int hotelId, @RequestBody Hotel updatedHotel) {
        return hotelService.updateHotel(hotelId, updatedHotel);
    }

    @DeleteMapping("/{hotelId}")
    public void deleteHotel(@PathVariable int hotelId) {
        hotelService.deleteHotel(hotelId);
    }
}
