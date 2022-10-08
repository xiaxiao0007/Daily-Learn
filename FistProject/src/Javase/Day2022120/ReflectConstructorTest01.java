package Javase.Day2022120;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/*

* */
public class ReflectConstructorTest01 {
    public static void main(String[] args) throws Exception{
        StringBuffer s = new StringBuffer();

        Class userServiceClass = Class.forName("Javase.Day2022120.UserService");
        s.append(Modifier.toString(userServiceClass.getModifiers()));
        s.append(" class ");
        s.append(userServiceClass.getSimpleName());
        s.append("{\n");
        Constructor[] constructors = userServiceClass.getConstructors();
        for (Constructor constructor:constructors){
            s.append("\t");
            s.append(Modifier.toString(constructor.getModifiers()));
            s.append(" ");
            s.append(userServiceClass.getSimpleName());
            s.append("(");
            Class[] parameterTypes = constructor.getParameterTypes();
            for (Class parameterType:parameterTypes){
                s.append(parameterType.getSimpleName());
                s.append(",");
            }
            if (parameterTypes.length > 0) {
                s.deleteCharAt(s.length() - 1);
            }
            s.append("){}\n");
        }
        s.append("}");
        System.out.println(s);
    }
}
