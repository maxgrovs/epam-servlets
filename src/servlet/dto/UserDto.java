package servlet.dto;

import servlet.entity.Film;
import servlet.entity.Role;

public class UserDto {

    private Long id;
    private Role role;

    public UserDto(Long id, Role role) {
        this.id = id;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public static Film.Builder builder() {
        return new Film.Builder();
    }

    public static class Builder {
        private Long id;
        private Role role;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder role(Role role) {
            this.role = role;
            return this;
        }

        public UserDto build() {

            return new UserDto(
                    this.id,
                    this.role
            );
        }

    }


}
