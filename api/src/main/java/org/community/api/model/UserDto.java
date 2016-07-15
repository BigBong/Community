package org.community.api.model;

import org.community.core.common.Privilege;
import org.community.core.model.pojo.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 2016/3/12
 *
 * @author Shengzhao Li
 */
public class UserDto implements Serializable {
    private static final long serialVersionUID = -2502329463915439215L;


    private String guid;

    private String username;

    private String phone;
    private String email;

    private String createTime;

    private List<Privilege> privileges = new ArrayList<>();


    public UserDto() {
    }


    public UserDto(User user) {
        this.guid = user.getUid();
        this.username = user.getUsername();
        this.phone = user.getPhone();
        this.email = user.getEmail();

        this.privileges = new ArrayList<>();
        this.createTime = user.getCreatedAt().toLocaleString();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }

    public static List<UserDto> toDtos(List<User> users) {
        List<UserDto> dtos = new ArrayList<>(users.size());
        for (User user : users) {
            dtos.add(new UserDto(user));
        }
        return dtos;
    }
}
