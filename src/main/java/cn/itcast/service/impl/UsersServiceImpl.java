package cn.itcast.service.impl;

import cn.itcast.dao.GoodsDao;
import cn.itcast.dao.UsersDao;
import cn.itcast.domain.Goods;
import cn.itcast.domain.Users;
import cn.itcast.service.GoodsService;
import cn.itcast.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UsersService")
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;


    //根据用户openId查询用户
    public Users findByopenId(Users users){
        System.out.println("业务层：根据用户的openId查询用户...");
        return usersDao.findByopenId(users.getOpenId());
    }

    //根据用户phone查询用户
    public Users findByphone(Users users){
        System.out.println("业务层：根据用户phone查询用户...");
        return usersDao.findByphone(users.getPhone());
    }

    //根据用户name查询用户list
    public List<Users> findBynickName(Users users){
        System.out.println("业务层：根据用户的nickName查询用户...");
        return usersDao.findBynickName(users.getNickName());
    }

    //更新用户信息
    public void updateUsers(Users users) {
        System.out.println("业务层：更新用户...");
        usersDao.updateUsers(users);

    }

    //添加新用户
    public void saveUsers(Users users) {
        System.out.println("业务层：保存新用户...");
        usersDao.saveUsers(users);
    }

    //删除用户
    public void deleteUsers(Users users) {
        System.out.println("业务层：删除用户...");
        usersDao.deleteUsers(users.getOpenId());
    }


}
