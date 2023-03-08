package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBUtils;
import oracle.net.aso.p;
import vo.MemberVO;

public class MemberDao {

	public ArrayList<MemberVO> getMember() {

		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtils.getConnection();
		String sql = "Select custno, custname, joindate, \r\n "
				+ " decode(grade, 'A','VIP', 'B','일반', 'C','직원') grade, address \r\n" + "From member_tbl_02\r\n"
				+ "ORDER BY custno";

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setJoindate(rs.getDate("joindate"));
				vo.setGrade(rs.getString("grade"));
				vo.setAddress(rs.getString("address"));
				list.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("회원목록 조회중 오류");
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, ps, rs);
		}
		return list;
	}

	public int getMaxNo() {
		int nextCustNo = 0;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtils.getConnection();
		String sql = "Select max(custno)+1 nextCustno From member_tbl_02";

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				nextCustNo = rs.getInt("nextCustNO");
			}
		} catch (SQLException e) {
			System.out.println("회원번호조회중 오류");
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, ps, rs);
		}
		return nextCustNo;
	}
	
	public int insertMember(MemberVO vo) {
		
		int result = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtils.getConnection();
		String sql = "Insert into member_tbl_02 values(?, ?, ?, ?, ?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getCustno());
			ps.setString(2, vo.getCustname());
			ps.setDate(3, vo.getJoindate());
			ps.setString(4, vo.getGrade());
			ps.setString(5, vo.getAddress());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("회원목록추가중 오류");
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, ps);
		}
		return result;
		
	}

}
