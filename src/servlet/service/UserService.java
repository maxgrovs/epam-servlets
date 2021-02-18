package servlet.service;

import servlet.dto.UserDto;
import servlet.entity.Film;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserService {

    private UserService() {
    }

    private static final UserService INSTANCE = new UserService();

    public static final Map<Pair<String, String>, UserDto> USER = new HashMap<>();

    public Optional<UserDto> login(String username, String password) {


        return null;
    }


    public static class Pair<F, S> {

        private F first;
        private S second;

        public Pair() {
        }

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        public F getFirst() {
            return first;
        }

        public void setFirst(F first) {
            this.first = first;
        }

        public S getSecond() {
            return second;
        }

        public void setSecond(S second) {
            this.second = second;
        }

        public Builder builder() {
            return new Builder();
        }

        public class Builder {

            private F first;
            private S second;

            public Builder first(F first) {
                this.first = first;
                return this;
            }

            public Builder second(S second) {
                this.second = second;
                return this;
            }

            public Pair<F, S> build(){
                return new Pair<>(
                        this.first,
                        this.second
                );
            }



        }

    }


    public static UserService getInstance() {
        return INSTANCE;
    }
}
