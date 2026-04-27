package vn.bow.petprj.codereview.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "review_results")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pull_request_id", nullable = false)
    private PullRequest pullRequest;

    @Column(nullable = false)
    private String fileName;

    @Column(columnDefinition = "TEXT")
    private String codeDiff;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String aiReview;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReviewSeverity severity;

    @Column(nullable = false)
    private Double confidenceScore;

    @Column
    private Integer lineNumber;

    @Column
    private String category; // e.g., "performance", "security", "style", "bug"

    @Column(nullable = false)
    private Boolean posted;

    @Column
    private Long githubCommentId;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        posted = false;
    }

    public enum ReviewSeverity {
        INFO,
        MINOR,
        MAJOR,
        CRITICAL
    }
}
