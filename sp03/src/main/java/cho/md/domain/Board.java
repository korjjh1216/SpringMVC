package cho.md.domain;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Board {
	private long seq;
	private String name;
	private String email;
	private String subject;
	private String content;
	private Date rdate;
	
}
