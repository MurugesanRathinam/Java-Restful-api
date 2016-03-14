package jersey.demo.dto;
/**
 * Date 14.Mar.2016
 * @version 1.0
 * @author Murugesan Rathinam
 * @since 1.0
 *
 * Email : murugesamkce@gmail.com
 */
public class EmployeeDTO {
	private int Id;
	private String name;
	private String email;
	private String address;
	
	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param address
	 */
	public EmployeeDTO(int id, String name, String email, String address) {
		super();
		Id = id;
		this.name = name;
		this.email = email;
		this.address = address;
	}
	/**
	 * Default constructor
	 */
	public EmployeeDTO(){
		
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
}
