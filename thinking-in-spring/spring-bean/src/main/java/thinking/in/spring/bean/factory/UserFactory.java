package thinking.in.spring.bean.factory;

import thinking.in.spring.ioc.overview.domain.User;


/**
 * User工厂类
 */
public interface UserFactory {
    default User createUser(){
        return User.createUser();
    }
}
