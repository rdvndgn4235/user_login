package com.ridvandogan.user_login.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Predicate;

/**
 * Created at 24.05.2022.
 *
 * @author Ridvan Dogan
 */

@Service
public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        //Todo regex validation
        return true;
    }
}
