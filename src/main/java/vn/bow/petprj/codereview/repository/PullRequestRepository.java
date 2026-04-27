package vn.bow.petprj.codereview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.bow.petprj.codereview.model.PullRequest;

import java.util.Optional;

@Repository
public interface PullRequestRepository extends JpaRepository<PullRequest, Long> {

    Optional<PullRequest> findByGithubPrId(Long githubPrId);

    Optional<PullRequest> findByRepositoryOwnerAndRepositoryNameAndPrNumber(
            String repositoryOwner,
            String repositoryName,
            Integer prNumber
    );
}
