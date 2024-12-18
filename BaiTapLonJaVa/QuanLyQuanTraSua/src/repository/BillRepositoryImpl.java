package repository;

import model.Bill;
import repository.IRepository.IBillRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BillRepositoryImpl implements IBillRepository {
    private static final String FILE_PATH = "bills.txt";
    private List<Bill> bills = new ArrayList<>();

    public BillRepositoryImpl() {
        loadBillsFromFile();
        initializeSampleBills();  // Thêm phương thức này
    }

    private void loadBillsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            Object obj = ois.readObject();

            if (obj instanceof List<?>) {
                List<?> list = (List<?>) obj;
                if (!list.isEmpty() && list.get(0) instanceof Bill) {
                    bills = new ArrayList<>();
                    for (Object item : list) {
                        bills.add((Bill) item);
                    }
                    System.out.println("Danh sách hóa đơn đã được đọc từ file thành công.");
                } else {
                    throw new IOException("Dữ liệu trong file không phải là List<Bill>");
                }
            } else {
                throw new IOException("Dữ liệu trong file không phải là List<?>");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Chưa Có Hóa Đơn Nào");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void saveBillsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(bills);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeSampleBills() {
        if (bills.isEmpty()) {
            bills.add(new Bill(1, "Nguyễn Văn A", 123456789, "a.nguyen@gmail.com", "2024-12-01", 200000.0));
            bills.add(new Bill(2, "Trần Thị B", 987654321, "b.tran@gmail.com", "2024-12-02", 150000.0));
            bills.add(new Bill(3, "Lê Văn C", 456789123, "c.le@gmail.com", "2024-12-03", 300000.0));
            bills.add(new Bill(4, "Phạm Thị D", 789123456, "d.pham@gmail.com", "2024-12-04", 250000.0));
            bills.add(new Bill(5, "Hoàng Văn E", 321654987, "e.hoang@gmail.com", "2024-12-05", 100000.0));
            bills.add(new Bill(6, "Hoàng Văn D", 321654986, "d.hoang@gmail.com", "2024-12-05", 120000.0));
            bills.add(new Bill(7, "Hoàng Văn F", 321654985, "f.hoang@gmail.com", "2024-12-05", 400000.0));
            bills.add(new Bill(8, "Hoàng Văn G", 321654984, "g.hoang@gmail.com", "2024-12-06", 300000.0));
            bills.add(new Bill(9, "Hoàng Văn H", 321654983, "h.hoang@gmail.com", "2024-12-07", 2000000.0));
            bills.add(new Bill(10, "Hoàng Văn I", 321654982, "i.hoang@gmail.com", "2024-12-08", 45000.0));   
            saveBillsToFile();  // Lưu các hóa đơn mẫu vào file
        }
    }

    @Override
    public Bill save(Bill bill) {
        bills.add(bill);
        saveBillsToFile();
        return bill;
    }

    @Override
    public List<Bill> findAll() {
        return new ArrayList<>(bills);
    }

    @Override
    public void clear() {
        bills.clear();
        saveBillsToFile();
    }
}
