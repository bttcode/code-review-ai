package vn.bow.petprj.codereview.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "pull_requests")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PullRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Long githubPrId;

    @Column(nullable = false)
    private String repositoryName;

    @Column(nullable = false)
    private String repositoryOwner;

    @Column(nullable = false)
    private Integer prNumber;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String branchName;

    @Column(nullable = false)
    private String baseBranch;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PullRequestStatus status;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime reviewedAt;

    @Column
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public enum PullRequestStatus {
        PENDING,
        REVIEWING,
        REVIEWED,
        COMMENTED,
        ERROR
    }
}
