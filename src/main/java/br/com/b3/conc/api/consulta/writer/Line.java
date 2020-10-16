package br.com.b3.conc.api.consulta.writer;

public class Line {

	private String[] values;

	public Line() {
		super();
		values = new String[]{ 
				"--", ";--", ";--", ";--", ";--", 
				";--", ";--", ";--", ";--", ";--", 
				";--", ";--", ";--", ";--", ";--" };
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (String v : values) {
			builder.append(v);
		}

		return builder.toString();
	}

	public void addField(int i, String value) {
		if(value == null) {
			return;
		}
		if (i == 0) {
			values[i] = value;
		} else {
			values[i] = ";" + value;
		}

	}
}
