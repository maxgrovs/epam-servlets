package servlet.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import servlet.dao.UserDao;
import servlet.dto.UserDto;
import servlet.entity.Role;
import servlet.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserService {

    private UserService() {
    }

    private static final UserService INSTANCE = new UserService();

    public static final Map<Pair<String, String>, UserDto> USERS = new HashMap<Pair<String, String>, UserDto>(){

        {
            put(Pair.of("Maksyusha", "123"), UserDto.builder()
                    .id(1L)
                    .role(Role.ADMIN)
                    .build());
            put(Pair.of("Tanusha", "777"), UserDto.builder()
                    .id(2L)
                    .role(Role.USER )
                    .build());

        }

    };

    public Optional<UserDto> login(String username, String password) {

        return Optional.ofNullable(USERS.get(Pair.of(username, password)));
    }

    public User save(User user){

        return UserDao.getInstance().save(user);
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
