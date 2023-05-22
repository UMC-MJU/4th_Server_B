package github.trackerpractice.controller;

import github.trackerpractice.Follower;
import github.trackerpractice.GithubApi;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {

    @GetMapping("/follower/{username}")
    public String followers(@PathVariable String username, Model model) throws IOException {
        GithubApi githubApi = new GithubApi();
        List<Follower> followers = githubApi.getFollowers(username);
        model.addAttribute("followers", followers);
        model.addAttribute("username", username);
        model.addAttribute("size", followers.size());
        return "check";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
