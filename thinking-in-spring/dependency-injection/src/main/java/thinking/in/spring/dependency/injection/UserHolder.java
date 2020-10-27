package thinking.in.spring.dependency.injection;

import thinking.in.spring.ioc.overview.domain.User;

/**
 * User的Holder类
 */
public class UserHolder {
    private User user;

    public UserHolder() {
    }

    public UserHolder(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        int i = Integer.parseInt("2");
        return "UserHolder{" +
                "user=" + user +
                '}';
    }
}
