package org.mda.importer;

public class DefaultTextImporterConfig implements TextImporterConfigIF {




	private boolean firstLineHeader;
	private Integer tabulatorWidth = new Integer(4);



	@Override
	public boolean isFirstLineHeader() {
		return firstLineHeader;
	}

	public void setFirstLineHeader(boolean firstLineHeader) {
		this.firstLineHeader = firstLineHeader;
	}

	@Override
	public Integer getTabulatorWidth() {
	    return tabulatorWidth;
	}

	public void setTabulatorWidth(Integer tabulatorWidth) {
	    this.tabulatorWidth = tabulatorWidth;
	}




}
