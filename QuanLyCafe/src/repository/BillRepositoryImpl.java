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
