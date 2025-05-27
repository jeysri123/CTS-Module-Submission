import java.sql.*;

public class TransactionDemo {
    private static final String DB_URL = "jdbc:sqlite:bank.db";

    public void initializeDatabase() {
        String createTable = "CREATE TABLE IF NOT EXISTS accounts (id INTEGER PRIMARY KEY, name TEXT, balance REAL)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(createTable);
            
            String insertData = "INSERT OR IGNORE INTO accounts (id, name, balance) VALUES " +
                              "(1, 'John', 1000.0), " +
                              "(2, 'Alice', 500.0)";
            stmt.execute(insertData);
        } catch (SQLException e) {
            System.out.println("Database initialization error: " + e.getMessage());
        }
    }

    public void transferMoney(int fromAccount, int toAccount, double amount) {
        String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE id = ? AND balance >= ?";
        String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            conn.setAutoCommit(false);
            
            try (PreparedStatement debitStmt = conn.prepareStatement(debitSQL);
                 PreparedStatement creditStmt = conn.prepareStatement(creditSQL)) {
                
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromAccount);
                debitStmt.setDouble(3, amount);
                
                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toAccount);
                
                int debitResult = debitStmt.executeUpdate();
                if (debitResult == 0) {
                    throw new SQLException("Insufficient funds or invalid account");
                }
                
                int creditResult = creditStmt.executeUpdate();
                if (creditResult == 0) {
                    throw new SQLException("Invalid recipient account");
                }
                
                conn.commit();
                System.out.println("Transfer successful!");
                
            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Transfer failed: " + e.getMessage());
            }
            
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public void displayAccounts() {
        String sql = "SELECT * FROM accounts";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double balance = rs.getDouble("balance");
                System.out.printf("Account %d: %s - $%.2f%n", id, name, balance);
            }
            
        } catch (SQLException e) {
            System.out.println("Error displaying accounts: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        TransactionDemo demo = new TransactionDemo();
        demo.initializeDatabase();
        
        System.out.println("Initial balances:");
        demo.displayAccounts();
        
        demo.transferMoney(1, 2, 200.0);
        
        System.out.println("\nBalances after transfer:");
        demo.displayAccounts();
        
        System.out.println("\nAttempting invalid transfer:");
        demo.transferMoney(2, 1, 1000.0);
        
        System.out.println("\nFinal balances:");
        demo.displayAccounts();
    }
} 