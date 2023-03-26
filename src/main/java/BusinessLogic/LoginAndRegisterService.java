package BusinessLogic;

import Database.LoginAndRegisterDAO;

public class LoginAndRegisterService {
    public void registerValidate(User user) throws Exception {

        Integer count = LoginAndRegisterDAO.checkIfUsernameIsUnique(user.getUsername());
        if (count != 0) {
            throw new Exception("Username is already present!");
        }
        String password = user.getPassword();
        if (password.length() < 8 || password.length() > 15) {
            throw new Exception("Password should be between 8 to 15 characters!");
        }

        if (user.getAmount() < 0) {
            throw new Exception("The amount entered should not be negative!");
        }

        if (String.valueOf(user.getPincode()).length() == 6) {
            throw new Exception("Enter a valid pincode");
        }

        LoginAndRegisterDAO.insertUser(user);
    }

    public static User userValidate(String username, String password) throws Exception {
        Integer count = LoginAndRegisterDAO.checkValidUser(username, password);
        if (count == 0) {
            throw new Exception("Invalid username or password");
        } else {
            // user object fetch based on username
          User user=  LoginAndRegisterDAO.customerInfo(username);
            return user;
        }
    }
}
