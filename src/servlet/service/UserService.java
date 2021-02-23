package servlet.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import servlet.dto.UserDto;
import servlet.entity.Role;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserService {

    private UserService() {
    }

    private static final UserService INSTANCE = new UserService();

    public static final Map<Pair<String, String>, UserDto> USERS = new HashMap<Pair<String, String>, UserDto>(){

        {
            put(Pair.of("Ivan", "123"), UserDto.builder()
                    .id(1L)
                    .role(Role.ADMIN)
                    .build());
            put(Pair.of("Sveta", "111"), UserDto.builder()
                    .id(2L)
                    .role(Role.USER )
                    .build());

        }

    };

    public Optional<UserDto> login(String username, String password) {

        return Optional.ofNullable(USERS.get(Pair.of(username, password)));

    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor(staticName = "of")
    @Builder
    public static class Pair<F, S> {
        private F first;
        private S second;
    }


    public static UserService getInstance() {
        return INSTANCE;
    }
}
