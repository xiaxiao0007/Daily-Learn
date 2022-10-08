package xia.xiao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xia.xiao.mapper.AccountsMapper;
import xia.xiao.pojo.Accounts;
import xia.xiao.service.AccountsService;

@Service
/* 事务注解
@Transactional(propagation = Propagation.REQUIRED // 事务的传播特性
        ,noRollbackForClassName = "ArithmeticException", // 指定发生什么异常不回滚，使用的异常的名称
        noRollbackFor = ArithmeticException.class,// 指定发生什么异常不回滚，使用的是异常的类型
        rollbackForClassName = "",// 指定发生什么异常必须回滚
        rollbackFor = ArithmeticException.class, // 指定发生什么异常必须回滚
        timeout = -1, // 连接超时设置，默认值是-1，表示永不超时
        readOnly = false, // 默认是false，如果是查询操作，必须设置为true
        isolation = Isolation.DEFAULT // 是数据库自己的隔离级别
 )
 */

public class AccountsServiceImpl implements AccountsService {

    // 一定会有数据访问层的对象
    @Autowired // 依赖注入值
    AccountsMapper accountsMapper;

    @Override
    public int insert(Accounts account) {
        int num = 0;
        num = accountsMapper.insert(account);
        System.out.println("增加账户成功="+num);
        // 手动抛异常
        System.out.println(1/0);

        return num;
    }
}
