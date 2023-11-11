package hcmute.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Chat")
@NamedQuery(name="Chat.findAll", query = "select p from Chat p")
public class Chat {
	@Id
	private int chatID;
	private int boxChatID;
	
	// 1-nhiều giữa chat với chatbox
}
