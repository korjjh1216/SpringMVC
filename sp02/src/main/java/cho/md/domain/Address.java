package cho.md.domain;

import java.sql.Date;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	private long seq;
	private String name;
	private String addr;
	private Date rdate;
	
}
