package repository;

import model.User;
import repository.IRepository.IUserRepository;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements IUserRepository {
    private static final String FILE_PATH = "users.txt";
    private List<User> users = new ArrayList<>();

    public UserRepositoryImpl() {
        loadUsersFromFile();
        if (users.isEmpty()) {
            initializeUsers();
            saveUsersToFile();
        }
    }

    // Ghi danh sách User vào file
    private void saveUsersToFile() {
        File file = new File(FILE_PATH);
        

        try (OutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(users);
            System.out.println("Danh sách User đã được ghi vào file thành công.");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Đọc danh sách User từ file
    private void loadUsersFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("File không tồn tại. Trả về danh sách rỗng.");
            return; // Nếu file không tồn tại, trả về danh sách rỗng
        }

        try (InputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object obj = ois.readObject();

            if (obj instanceof List<?>) {
                List<?> list = (List<?>) obj;
                if (!list.isEmpty() && list.get(0) instanceof User) {
                    users = new ArrayList<>();
                    for (Object item : list) {
                        users.add((User) item);
                    }
                    System.out.println("Danh sách User đã được đọc từ file thành công.");
                } else {
                    throw new IOException("Dữ liệu trong file không phải là List<User>");
                }
            } else {
                throw new IOException("Dữ liệu trong file không phải là List<?>");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private void initializeUsers() {
        // Tạo tài khoản quản trị viên
        users.add(new User("Nguyễn Lê Hoài Nam", "namngyenhoai21@gmail.com", 123456789, "Address1", "123", "ADMIN"));
        users.add(new User("Nguyễn Văn Hậu", "nguyenvanhau@gmail.com", 123456789, "Address2", "123", "ADMIN"));
        users.add(new User("Nguyễn Hồng Diễn", "nguyenhongdien@gmail.com", 123456789, "Address3", "123", "ADMIN"));

        // Tạo tài khoản người dùng với vai trò "USER"
        users.add(new User("Nguyễn Văn A", "nguyenvana@gmail.com", 987654321, "Address4", "123", "USER"));
        users.add(new User("Nguyễn Văn B", "nguyenvanb@gmail.com", 987654321, "Address5", "123", "USER"));
        users.add(new User("User3", "123123", 987654321, "Address6", "123", "USER"));
    }

    @Override
    public User save(User user) {
        users.add(user);
        saveUsersToFile();
        return user;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getMatKhau().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User update(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(user.getEmail())) {
                users.set(i, user);
                saveUsersToFile();
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public void clear() {
        users.clear();
        saveUsersToFile();
    }

    @Override
    public void delete(User user) {
        users.remove(user);
        saveUsersToFile();
    }
}
