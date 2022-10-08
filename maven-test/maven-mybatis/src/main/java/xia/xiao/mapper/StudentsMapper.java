package xia.xiao.mapper;

import org.apache.ibatis.annotations.Param;
import xia.xiao.Student;

import java.util.List;
import java.util.Map;

/*
* 实现mybatis的动态代理
* */
public interface StudentsMapper {

    List<Student> getAll();

    int update(Student student);

    Student getById(Integer id);

    List<Student> getByName(String name);

    // 优化后的模糊查询
    List<Student> getByNameGood(String name);

    // 模糊用户名和地址查询
    List<Student> getByNameOrAddress(@Param("columnName") String columnName, @Param("columnValue") String columnValue);

    // 插入返回结果值,通过实体类插入
    int insert(Student student);

    // 按指定的条件进行多条件查询
    List<Student> getByCondition(Student student);

    // 有选择的更新
    int updateSet(Student student);

    // 查询多个指定id用户信息
    List<Student> getByIds(Integer[] arr);

    // 查询指定年龄范围内的用户
    List<Student> getByAge(Integer begin, Integer end);

    // 传入参存储在map中
    List<Student> getByMap(Map map);

    // 返回值是map(一行)
    Map getReturnMap(Integer id);

    // 返回值是map(多行)
    List<Map> getReturnMaps(Map map);
}
