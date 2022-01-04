package SpringSecurity.controller;

import SpringSecurity.model.GeekUser;
import SpringSecurity.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model,
                              @PageableDefault(size = 7) Pageable pageable) {
        Page<GeekUser> users = userService.findAll(pageable);
        int totalPages = users.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("users", users);

        return "user_list";
    }
}
