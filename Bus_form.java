import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
public class Bus_form {
    private JPanel rootPanel;
    private JButton BUSESButton;
    private JButton ROUTEButton;
    private JButton BUSTIMINGButton;
    private JButton DRIVERButton;
    private JButton DIESELButton;
    private JButton DRIVERSALARYButton;
    private JButton REPAIRINGButton;
    private JButton SPAREPARTSButton;
    private JTable showTable;
    private JButton searchbtn;
    private JTextField textField1;
    private JScrollPane ShowTable;
    private JTextArea rowDataTextArea;

    Connection con;
    PreparedStatement pst;

    public Bus_form() {
        connect();

        BUSESButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buss();
            }
        });
        ROUTEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                routee();
            }
        });
        BUSTIMINGButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bustimingg();
            }
        });
        SPAREPARTSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sparep();
            }
        });
        REPAIRINGButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                busrepair();
            }
        });
        DRIVERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                driversetails();
            }
        });
        DIESELButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vindiesel();
            }
        });
        DRIVERSALARYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                driversalaryomfo();
            }
        });
        searchbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                srch();
            }
        });

    }
        public static void main (String[]args){
            JFrame frame = new JFrame("Bus_form");
            frame.setContentPane(new Bus_form().rootPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }

        public void connect() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection("jdbc:mySql://localhost:3306/ssism_bus", "root", "2223");
            } catch (Exception e) {
                System.out.println(e + "Error He..");
            }
        }

        // for buses details
        void buss () {
            try {
                String q = "Select * from buses";

                pst = con.prepareStatement(q);

                ResultSet set = pst.executeQuery();

                showTable.setModel((DbUtils.resultSetToTableModel(set)));
            } catch (Exception e) {
                System.out.println(e + "Error He..");
            }
        }

        // for bus route details
        void routee () {
            try {
                String q = "Select * from route";

                pst = con.prepareStatement(q);

                ResultSet set = pst.executeQuery();

                showTable.setModel((DbUtils.resultSetToTableModel(set)));
            } catch (Exception e) {
                System.out.println(e + "Error He..");
            }
        }

        // for bus timing details
        void bustimingg () {
            try {
                String q = "Select * from bustiming";

                pst = con.prepareStatement(q);

                ResultSet set = pst.executeQuery();

                showTable.setModel((DbUtils.resultSetToTableModel(set)));
            } catch (Exception e) {
                System.out.println(e + "Error He..");
            }
        }

        // for bus spareparts details
        void sparep () {
            try {
                String q = "Select * from spareparts";

                pst = con.prepareStatement(q);

                ResultSet set = pst.executeQuery();

                showTable.setModel((DbUtils.resultSetToTableModel(set)));
            } catch (Exception e) {
                System.out.println(e + "Error He..");
            }
        }

        // for bus repairing details
        void busrepair () {
            try {
                String q = "Select * from repairing";

                pst = con.prepareStatement(q);

                ResultSet set = pst.executeQuery();

                showTable.setModel((DbUtils.resultSetToTableModel(set)));
            } catch (Exception e) {
                System.out.println(e + "Error He..");
            }
        }

        // for driver details
        void driversetails () {
            try {
                String q = "Select * from driver";

                pst = con.prepareStatement(q);

                ResultSet set = pst.executeQuery();

                showTable.setModel((DbUtils.resultSetToTableModel(set)));
            } catch (Exception e) {
                System.out.println(e + "Error He..");
            }
        }

        // for diesel details
        void vindiesel () {
            try {
                String q = "Select * from diesel";

                pst = con.prepareStatement(q);

                ResultSet set = pst.executeQuery();

                showTable.setModel((DbUtils.resultSetToTableModel(set)));
            } catch (Exception e) {
                System.out.println(e + "Error He..");
            }
        }

        // for salary of drivers
        void driversalaryomfo () {
            try {
                String q = "Select * from driversalary";

                pst = con.prepareStatement(q);

                ResultSet set = pst.executeQuery();

                showTable.setModel((DbUtils.resultSetToTableModel(set)));
            } catch (Exception e) {
                System.out.println(e + "Error He..");
            }
        }

        // search ki ungli ki jaaye
        void srch () {
            try {
                String q = "SELECT name,b.bus_number, di.purchase_date, di.cost from driver d\n" +
                        "join buses b on b.bus_id=d.driver_id\n" +
                        "join diesel di on b.bus_id=di.bus_id \n" +
                        "order by cost desc;";

                pst = con.prepareStatement(q);

                ResultSet set = pst.executeQuery();

                showTable.setModel((DbUtils.resultSetToTableModel(set)));
            } catch (Exception e) {
                System.out.println(e + "Error He..");
            }
        }
    }

