package textExcel;

public class PercentCell extends RealCell {
	public PercentCell(String v) {
		super(v);
	}
	public double getDoubleValue() {
		return Double.parseDouble(getValue().substring(0,getValue().length()-1));
	}
	public double makePercent(String value) {
		value = value.substring(0, value.length() - 1);//removes percent sign
        double valueDouble = Double.parseDouble(value) / 100;//converts into decimal
        return valueDouble;
    }
	
	public String abbreviatedCellText() 
    {
		String number = (int)(getDoubleValue())+"";//for example, getDoubleValue() converts 11.25% to 11, and this adds a percent sign at the end
        return Spreadsheet.adjust(number+"%");
    }
	public String fullCellText() {
		return""+makePercent(getValue());//decimal representation of input
	}

}
