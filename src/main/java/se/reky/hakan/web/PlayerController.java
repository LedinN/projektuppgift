package se.reky.hakan.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import se.reky.hakan.service.PlayerService;

@Controller
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public String listPlayers(Model model) {
        model.addAttribute("players", playerService.findAllPlayersSortedByExperience());
        return "players"; // Name of the Thymeleaf template
    }

    @GetMapping("/players/{playerId}")
    public String showPlayerDetails(@PathVariable("playerId") long playerId, Model model) {
        model.addAttribute("player", playerService.findPlayerById(playerId));
        return "playerdetails";
    }
}
