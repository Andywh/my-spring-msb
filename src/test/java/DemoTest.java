import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by Ai Lun on 2020-12-23.
 */

public class DemoTest {

    @Test
    public void testField() throws Exception {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();

        UserService userService = new UserService();
        Stream.of(clazz.getDeclaredFields()).forEach(field -> {
            String name = field.getName();
            Autowired annotation = field.getAnnotation(Autowired.class);
            if (annotation != null) {
                field.setAccessible(true);
                Class<?> type = field.getType();
                type.getConstructor().newInstance();
            }
        });


        Arrays.asList(declaredFields).stream().forEach(System.out::println);
        Field userServiceField = clazz.getDeclaredField("userService");
        userServiceField.setAccessible(true);
        String name = userServiceField.getName();
        name = name.substring(0,1).toUpperCase() + name.substring(1, name.length());
        String getMethodName = "get" + name;
        System.out.println("getMethodName: " + getMethodName);
        System.out.println("get " + name);

        // setMethodName
        name = name.substring(0,1).toUpperCase() + name.substring(1, name.length());
        String setMethodName = "set" + name;
        System.out.println("setMethodName: " + setMethodName);
        System.out.println("set " + name);

        UserService userService = new UserService();
        Method method = clazz.getMethod(setMethodName, UserService.class);
        method.invoke(userController, userService);

        //UserService userService = new UserService();
        //userServiceField.set(userController, userService);
        System.out.println(userController.getUserService());
    }

}
