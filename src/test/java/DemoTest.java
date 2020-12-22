import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Created by Ai Lun on 2020-12-23.
 */

public class DemoTest {

    @Test
    public void testField() throws Exception {
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        Arrays.asList(declaredFields).stream().forEach(System.out::println);
        Field userServiceField = clazz.getDeclaredField("userService");
        UserService userService = new UserService();
        userServiceField.set(userController, userService);
        System.out.println(userController.getUserService());
    }

}
