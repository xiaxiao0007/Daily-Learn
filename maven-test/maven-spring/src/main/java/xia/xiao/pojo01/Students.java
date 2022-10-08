package xia.xiao.pojo01;

public class Students {

    private String name;
    private int age;

    private School school = null;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Students() {
        System.out.println("学生的无参构造方法.....");
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
