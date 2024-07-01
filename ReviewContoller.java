import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/reviews")
public class ReviewController {

    @Autowired
    private ReviewJpaService reviewJpaService;

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewJpaService.getAllReviews();
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable int reviewId) {
        return reviewJpaService.getReviewById(reviewId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review createdReview = reviewJpaService.saveReview(review);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReview);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<Review> updateReview(@PathVariable int reviewId, @RequestBody Review reviewDetails) {
        return reviewJpaService.getReviewById(reviewId)
                .map(existingReview -> {
                    existingReview.setReviewContent(reviewDetails.getReviewContent());
                    existingReview.setRating(reviewDetails.getRating());
                    existingReview.setProduct(reviewDetails.getProduct());
                    return ResponseEntity.ok(reviewJpaService.saveReview(existingReview));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable int reviewId) {
        reviewJpaService.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{reviewId}/product")
    public ResponseEntity<Product> getProductByReviewId(@PathVariable int reviewId) {
        return reviewJpaService.getReviewById(reviewId)
                .map(review -> ResponseEntity.ok(review.getProduct()))
                .orElse(ResponseEntity.notFound().build());
    }
}
