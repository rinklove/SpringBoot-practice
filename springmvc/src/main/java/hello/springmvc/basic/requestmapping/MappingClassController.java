package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/amapping/users")
public class MappingClassController {

    @GetMapping
    public String user() {
        return "get users";
    }


    @PostMapping
    public String addUser() {
        return "post users";
    }

    @GetMapping("/{userId}")
    public String findMember(@PathVariable String userId) {
        return "get users = " + userId;
    }

    @PatchMapping("/{userId}")
    public String updateMember(@PathVariable String userId) {
        return "update users = " + userId;
    }

    @DeleteMapping("{userId}")
    public String deleteMember(@PathVariable String userId) {
        return "delete users = " + userId;
    }
}
