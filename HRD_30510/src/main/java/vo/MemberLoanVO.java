package vo;

import java.sql.Date;

public class MemberLoanVO {
	private int custno;
	private int bookno;
	public int getCustno() {
		return custno;
	}
	public void setCustno(int custno) {
		this.custno = custno;
	}
	public int getBookno() {
		return bookno;
	}
	public void setBookno(int bookno) {
		this.bookno = bookno;
	}
	public Date getRentdate() {
		return rentdate;
	}
	public void setRentdate(Date rentdate) {
		this.rentdate = rentdate;
	}
	public Date getReturndate() {
		return returndate;
	}
	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}
	private Date rentdate;
	private Date returndate;
}
