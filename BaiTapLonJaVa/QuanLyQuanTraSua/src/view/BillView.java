package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Bill;
import java.util.List;

public class BillView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel tableModel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BillView frame = new BillView(null); // Pass null for testing
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @SuppressWarnings("serial")
	public BillView(List<Bill> bills) {
        setTitle("Bill List");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 900, 600);

        // Set up content pane with custom background handling
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load and scale the background image to fit the frame
                ImageIcon icon = new ImageIcon(getClass().getResource("BillView.jpg"));
                Image img = icon.getImage();
                Image imgScale = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
                g.drawImage(imgScale, 0, 0, null); // Draw image to fill the whole panel
            }
        };
        contentPane.setLayout(new BorderLayout(0, 0)); // Use BorderLayout for easy placement of components
        setContentPane(contentPane);

        // Title Label for Bill List
        JLabel lblBillList = new JLabel("Bill List");
        lblBillList.setFont(new Font("Tahoma", Font.BOLD, 24));
        contentPane.add(lblBillList, BorderLayout.NORTH); // Place the title label at the top

        // Set up the table inside a JScrollPane
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER); // Place the table in the center

        // DefaultTableModel with column headers
        tableModel = new DefaultTableModel(new Object[] { "ID", "Name", "Email", "Phone", "Date", "Total" }, 0);
        table = new JTable(tableModel);
        scrollPane.setViewportView(table);

        // If there are bills, populate the table
        if (bills != null) {
            for (Bill bill : bills) {
                tableModel.addRow(new Object[] { bill.getMaHD(), bill.getTen(), bill.getEmail(), bill.getSDT(),
                        bill.getNgayDat(), bill.getTongTien() });
            }
        }
    }
}
