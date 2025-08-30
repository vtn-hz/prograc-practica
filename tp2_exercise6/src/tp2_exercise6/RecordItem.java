package tp2_exercise6;

import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class RecordItem {

	private SimpleDateFormat sdf;
	
	private GregorianCalendar timestamp;
	
	private int soldAmount;
	
	private String type;

	public RecordItem(int soldAmount, String type) {
		super();
		this.sdf = new SimpleDateFormat("dd/MM/yyyy  kk:mm:ss");
		this.timestamp = new GregorianCalendar();
		this.soldAmount = soldAmount;
		this.type = type;
	}

	public String getTimestamp() {
		return this.sdf.format(this.timestamp.getTime());
	}

	public int getSoldAmount() {
		return soldAmount;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "["+ getTimestamp() + ", soldAmountx=" + soldAmount + ", type=" + type + "]";
	}
}
