import com.study.api.UserService;
import com.study.dto.UserDTO;
import com.study.proxy.ProxyFactory;

public class App {

    public static void main(String[] args) {

        UserService userService = ProxyFactory.getServiceByClass(UserService.class);
        UserDTO userDTO = new UserDTO();
        userDTO.setAge(10);
        userDTO.setName("张三");
        System.out.println("---------"+userDTO);
        userDTO = userService.addUser(userDTO);
        System.out.println("========="+userDTO);
    }
}
