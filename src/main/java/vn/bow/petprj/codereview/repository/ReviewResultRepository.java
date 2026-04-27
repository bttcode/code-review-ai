package vn.bow.petprj.codereview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.bow.petprj.codereview.model.PullRequest;
import vn.bow.petprj.codereview.model.ReviewResult;

import java.util.List;

@Repository
public interface ReviewResultRepository extends JpaRepository<ReviewResult, Long> {

    List<ReviewResult> findByPullRequest(PullRequest pullRequest);

    List<ReviewResult> findByPullRequestAndPostedFalse(PullRequest pullRequest);
}