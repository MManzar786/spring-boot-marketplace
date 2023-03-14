package app.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {

	@GetMapping("/signin")
    public String signin() {
        return "Signint";
    }
}
