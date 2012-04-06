/**
 * Copyright (C) 2012 Bertrand Florat
 */


/**
 * Tag DTO object used between layers.
 * 
 * @author Bertrand Florat <bertrand@florat.net>
 */
public class TagDTO {

	private final String text;

	TagDTO(final String text) {
		this.text = text;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

}
