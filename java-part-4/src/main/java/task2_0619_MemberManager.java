import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class task2_0619_MemberManager {

    private final int capacity;

    public task2_0619_MemberManager(int capacity) {
        this.capacity = capacity;
    }

    private Connection connection() {

        String url = "jdbc:mysql://localhost:3306/java_basic";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(
                    url,
                    "root",
                    "juhyung2001@"
            );

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isFull() {
        return size() >= capacity;
    }

    public int capacity() {
        return capacity;
    }

    public boolean existsEmail(String email) {

        String sql =
                "SELECT COUNT(*) FROM member WHERE email = ?";

        try (
                Connection conn = connection();
                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    public void add(task2_0619_Member m) {

        String sql =
                "INSERT INTO member (grade, name, email, phone) VALUES (?, ?, ?, ?)";

        try (
                Connection conn = connection();
                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setString(1, m.getGrade());
            ps.setString(2, m.getName());
            ps.setString(3, m.getEmail());
            ps.setString(4, m.getPhone());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int size() {

        String sql = "SELECT COUNT(*) FROM member";

        try (
                Connection conn = connection();
                PreparedStatement ps =
                        conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    private task2_0619_Member toMember(ResultSet rs)
            throws SQLException {

        String grade = rs.getString("grade");
        String name = rs.getString("name");
        String email = rs.getString("email");
        String phone = rs.getString("phone");

        if (grade.equals("VIP")) {
            return new task2_0619_VipMember(name, email, phone);
        } else {
            return new task2_0619_NormalMember(name, email, phone);
        }
    }

    public task2_0619_Member findByEmail(String email) {

        String sql =
                "SELECT grade, name, email, phone FROM member WHERE email = ?";

        try (
                Connection conn = connection();
                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return toMember(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public task2_0619_Member findByName(String name) {

        String sql =
                "SELECT grade, name, email, phone FROM member WHERE name = ?";

        try (
                Connection conn = connection();
                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setString(1, name);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return toMember(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public void printAll() {

        String sql =
                "SELECT grade, name, email, phone FROM member";

        try (
                Connection conn = connection();
                PreparedStatement ps =
                        conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            boolean empty = true;

            while (rs.next()) {
                toMember(rs).printInfo();
                empty = false;
            }

            if (empty) {
                System.out.println("등록된 회원이 없습니다.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(
            String email,
            String name,
            String newEmail,
            String phone
    ) {

        String sql =
                "UPDATE member SET name = ?, email = ?, phone = ? WHERE email = ?";

        try (
                Connection conn = connection();
                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setString(1, name);
            ps.setString(2, newEmail);
            ps.setString(3, phone);
            ps.setString(4, email);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delete(String email) {

        String sql =
                "DELETE FROM member WHERE email = ?";

        try (
                Connection conn = connection();
                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {

            ps.setString(1, email);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}