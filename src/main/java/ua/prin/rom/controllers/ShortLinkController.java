package ua.prin.rom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.prin.rom.repository.ShortLinkRepository;
import ua.prin.rom.entity.ShortLink;
import ua.prin.rom.repository.UserRepository;

import java.util.List;

@Controller
public class ShortLinkController {

    @Autowired
    private ShortLinkRepository shortLinkRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String general(Model model) {
        User user = getCurrentUser();
        ua.prin.rom.entity.User dbUser = userRepository.findByLogin(user.getUsername());
        List<ShortLink> listShortLink = dbUser.getShortLink();
        if (listShortLink.size() >= 1) {
            model.addAttribute("j_listShortLink", listShortLink);
        }
        return "shortLink";
    }

    @PostMapping("/")
    public String doLink(Model model, @RequestParam(name = "j_longLink") String j_longLink) {
        User user = getCurrentUser();
        ua.prin.rom.entity.User dbUser = userRepository.findByLogin(user.getUsername());
        List<ShortLink> listShortLink = dbUser.getShortLink();
        if(shortLinkRepository.existsByLongLinkAndUser(j_longLink, dbUser)){
            model.addAttribute("occupied", true);
            if(listShortLink.size() >= 1){
                model.addAttribute("j_listShortLink", listShortLink);
            }
            return "shortLink";
        }
        Integer shortLink = j_longLink.hashCode();
        ShortLink link = new ShortLink(j_longLink, shortLink, dbUser, 0L);
        shortLinkRepository.save(link);
        model.addAttribute("j_shortLink", shortLink);
        if(listShortLink.size() >= 1){
            model.addAttribute("j_listShortLink", listShortLink);
        }
        return "shortLink";
    }

    @GetMapping("/find")
    public String getLink(@RequestParam(name = "find") String find, Model model) {
        Integer shortLinkHashCode = Integer.parseInt(find.substring(22));
        ShortLink shortLink = shortLinkRepository.findByShortlink(shortLinkHashCode);
        String longLink = shortLink.getLongLink();
        Long countUse = shortLink.getCount() + 1;
        Long id = shortLink.getId();
        shortLinkRepository.updateCount(countUse, id);
        return "redirect:" + longLink;
    }

    private User getCurrentUser() {
        return (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }
}
