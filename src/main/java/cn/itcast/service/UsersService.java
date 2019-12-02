package cn.itcast.service;

import cn.itcast.domain.Goods;
import cn.itcast.domain.Users;

import java.util.List;

public interface UsersService {


    //根据用户openId查询用户
    public Users findByopenId(Users users);

    //根据用户phone查询用户
    public Users findByphone(Users users);

    //根据用户nickName查询用户list
    public List<Users> findBynickName(Users users);

    //更新用户
    public  void updateUsers(Users users);

    //添加新用户
    public void saveUsers(Users users);

    //删除用户
    public  void deleteUsers(Users users);

}
