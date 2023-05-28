package github.trackerpractice;

import org.kohsuke.github.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GithubApi {
    GitHub github;
    String token = "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";

    private void connectToGithub(String token) throws IOException {
        github = new GitHubBuilder().withOAuthToken(token).build();
        github.checkApiUrlValidity();
    }

    public List<Follower> getFollowers(String username) throws IOException {
        connectToGithub(token);

        List<Follower> followList = new ArrayList<>();

        GHUser user = github.getUser(username);
        GHPersonSet<GHUser> followers = user.getFollowers();

        for (GHUser f : followers) {
            Follower follower = new Follower(f.getLogin(), String.valueOf(f.getHtmlUrl()), f.getAvatarUrl());
            followList.add(follower);
        }

        return followList;
    }
}
